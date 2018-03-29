package org.module.api.common.dao.base;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.GenericTypeResolver;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

/**
*
* @author formulateko@admin.com
*/
@Repository
@SuppressWarnings("unchecked")
public abstract class BasisDAO<T> {
    
	final static Logger logger = Logger.getLogger("Logger : " + BasisDAO.class);
	
    @Autowired
    private SessionFactory sessionFactory;
    
    @Autowired
    private HibernateTemplate hibernateTemplate;
    
    private Class<T> genericType;
    
	protected BasisDAO() {
    	this.setGenericType((Class<T>) GenericTypeResolver.resolveTypeArgument(getClass(), BasisDAO.class));
    }
    
    /*++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 * Hibernate
	 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
    public void save(T entity) throws DataAccessException {
        hibernateTemplate.save(entity);
    }

    public void saveOrUpdate(T entity) throws DataAccessException {
        hibernateTemplate.saveOrUpdate(entity);
    }

    public void saveOrUpdateAll(Collection<T> entities) throws DataAccessException {
        for (T entity : entities) {
            saveOrUpdate(entity);
        }
    }

    public void update(T entity) throws DataAccessException {
        hibernateTemplate.update(entity);
    }

    public void delete(T entity) throws DataAccessException {
        hibernateTemplate.delete(entity);
    }

    protected void deleteAll(Collection<T> entities) throws DataAccessException {
        hibernateTemplate.deleteAll(entities);
    }
    
	/*public List<T> getByRequestMap(HashMap<String, Object> hashMap) {
		
    	final StringBuffer queryString = new StringBuffer();
		queryString.append(" FROM "+ genericType.getSimpleName());

		Object params[] = new Object[hashMap.size()];
		int a = 0;
		
    	if ((hashMap != null) && !hashMap.isEmpty()){
    		queryString.append(" WHERE ");
            
            for (final Iterator<Map.Entry<String, Object>> it = hashMap.entrySet().iterator(); it.hasNext();){
                
            	final Map.Entry<String,Object> entry = it.next(); 
                
            	if (entry.getValue() instanceof Class) {
            		queryString.append(entry.getKey()).append(" = ").append("?");
            		params[a] = entry.getValue();
				} else 
            	if (entry.getKey() instanceof String) {
            		if(entry.getKey() == ""){
            			System.out.println("String GetALL");
            		}else if(entry.getKey() == "a"){
            			System.out.println("String a GetALL");
            		}
            		
            		
					//queryString.append(entry.getKey()).append(" like ").append("'%"+entry.getValue()+"%'");
				} else if (entry.getValue() instanceof Boolean) {
					queryString.append(entry.getKey()).append(" = ").append(entry.getValue());
				}
				
				if (it.hasNext()) {
					queryString.append(" AND ");
				}
            }
        }
        
    	logger.info("Query Map : "+queryString);
		return (List<T>) hibernateTemplate.find(queryString.toString());
    }*/
    
    public List<T> getByRequestMap(HashMap<String, Object> hashMap) {
    	final StringBuffer queryString = new StringBuffer();
		queryString.append("SELECT o FROM "+genericType.getSimpleName()+" o");

    	if ((hashMap != null) && !hashMap.isEmpty()){

            for (final Iterator<Map.Entry<String, Object>> it = hashMap.entrySet().iterator(); it.hasNext();){
                
            	final Map.Entry<String,Object> entry = it.next(); 
             
            	if (entry.getKey() instanceof String) {
            		queryString.append(" WHERE o.").append(entry.getKey()).append(" = ").append("'"+entry.getValue()+"'");
					//queryString.append(entry.getKey()).append(" like ").append("'%"+entry.getValue()+"%'");
				} 
            }
        }
        
    	logger.info("Query Map : "+queryString);
    	
		return (List<T>) hibernateTemplate.find(queryString.toString());
    }
    
    public List<T> getByRequestMapWithSortingForPaging(HashMap<String, Object> hashMap, LinkedHashMap<String, Object> orderByList, int offset, int limit) {
        final StringBuffer queryString = new StringBuffer();

        queryString.append(" FROM " + genericType.getSimpleName());

        Object params[] = new Object[hashMap.size()];

        int a = 0;

        if ((hashMap != null) && !hashMap.isEmpty()) {
            queryString.append(" WHERE ");
            Date dateFrom = new Date();
            Date dateTo = new Date();

            for (final Iterator<Map.Entry<String, Object>> it = hashMap.entrySet().iterator(); it.hasNext();) {

                final Map.Entry<String, Object> entry = it.next();

                if (entry.getValue() instanceof Class) {
                    queryString.append(entry.getKey()).append(" = ").append("?");
                    params[a] = entry.getValue();

                } else if (entry.getValue() instanceof String) {
                    queryString.append(entry.getKey()).append(" like ").append("'%" + entry.getValue() + "%'");
                } else if (entry.getValue() instanceof Boolean) {
                    queryString.append(entry.getKey()).append(" = ").append(entry.getValue());
                } else if (entry.getValue() instanceof Map && entry.getKey().toLowerCase().contains("date")) {
                    for(String obj : ((Map<String, Date>) entry.getValue()).keySet()){
                        if(obj.toLowerCase().contains("from")){
                            dateFrom = ((Map<String, Date>) entry.getValue()).get(obj);
                        } else if(obj.toLowerCase().contains("to")){
                            dateTo = ((Map<String, Date>) entry.getValue()).get(obj);
                        }
                    }
                    
                    queryString.append(entry.getKey()).append(" between ").append(dateFrom).append(" and ").append(dateTo);
                }

                if (it.hasNext()) {
                    queryString.append(" AND ");
                }
            }
        }

        if ((orderByList != null) && !orderByList.isEmpty()) {
            queryString.append(" ORDER BY ");

            for (final Iterator<String> is = orderByList.keySet().iterator(); is.hasNext();) {
                String column = is.next();
                queryString.append(column + " " +orderByList.get(is));
                
                if (is.hasNext()) {
                    queryString.append(", ");
                }
            }
        }
        
        Query query = sessionFactory.getCurrentSession().createQuery(queryString.toString());
        query.setFirstResult(offset);
        query.setMaxResults(limit);
        
        logger.info("Query Paging : "+queryString);
        return (List<T>) query.list();
    }

    public List<T> getByRequestMapCount(HashMap<String, Object> hashMap) {
        final StringBuffer queryString = new StringBuffer();

        queryString.append("SELECT COUNT(*) FROM " + genericType.getSimpleName());

        Object params[] = new Object[hashMap.size()];

        int a = 0;

        if ((hashMap != null) && !hashMap.isEmpty()) {
            queryString.append(" WHERE ");

            for (final Iterator<Map.Entry<String, Object>> it = hashMap.entrySet().iterator(); it.hasNext();) {

                final Map.Entry<String, Object> entry = it.next();

                if (entry.getValue() instanceof Class) {
                    queryString.append(entry.getKey()).append(" = ").append("?");
                    params[a] = entry.getValue();

                } else if (entry.getValue() instanceof String) {
                    queryString.append(entry.getKey()).append(" like ").append("'%" + entry.getValue() + "%'");
                } else if (entry.getValue() instanceof Boolean) {
                    queryString.append(entry.getKey()).append(" = ").append(entry.getValue());
                }

                if (it.hasNext()) {
                    queryString.append(" AND ");
                }
            }
        }

        logger.info("Query Count Paging : "+queryString);
        return (List<T>) hibernateTemplate.find(queryString.toString());
    }

    /*++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 * Persistence
	 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
    protected void persist(T entity) throws DataAccessException {
        hibernateTemplate.persist(entity);
    }
    
    protected T merge(T entity) throws DataAccessException {
        return (T) hibernateTemplate.merge(entity);
    }

    public void refresh(T entity) throws DataAccessException {
        hibernateTemplate.refresh(entity);
    }
    
    /*++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 * Other
	 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
    protected void initialize(final Object proxy) throws DataAccessException {
        hibernateTemplate.initialize(proxy);
    }

    protected T get(Class<T> entityClass, Serializable id) throws DataAccessException {
        return (T) hibernateTemplate.get(entityClass, id);
    }
    
    /*++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 * Getter Setter
	 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public HibernateTemplate getHibernateTemplate() {
        return hibernateTemplate;
    }

    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }

	public Class<T> getGenericType() {
		return genericType;
	}

	public void setGenericType(Class<T> genericType) {
		this.genericType = genericType;
	}
}