package org.module.hr.dao.impl;

import java.util.HashMap;
import java.util.List;

import org.hibernate.Query;
import org.module.api.common.dao.base.BasisDAO;
import org.module.hr.dao.TrsEmployeeEmergencyContactDAO;
import org.module.hr.model.TrsEmployeeEmergencyContact;
import org.springframework.dao.support.DataAccessUtils;

/**
*
* @author formulateko@admin.com
*/
@SuppressWarnings("unchecked")
public class TrsEmployeeEmergencyContactDAOImpl extends BasisDAO<TrsEmployeeEmergencyContact>implements TrsEmployeeEmergencyContactDAO {

	@Override
	public List<TrsEmployeeEmergencyContact> getAllTrsEmployeeEmergencyContact() {
		List<TrsEmployeeEmergencyContact> list = (List<TrsEmployeeEmergencyContact>) getHibernateTemplate().find("FROM TrsEmployeeEmergencyContact");
		return list;
	}

	@Override
	public List<TrsEmployeeEmergencyContact> getTrsEmployeeEmergencyContactPaging(HashMap<String, Object> hashMap) {
		/*List<TrsEmployeeEmergencyContact>list = (List<TrsEmployeeEmergencyContact>) getHibernateTemplate().findByExample(new TrsEmployeeEmergencyContact(), (Integer)hashMap.get("firstResult"), (Integer)hashMap.get("maxResults"));
		return list;*/
		
		/*DetachedCriteria detachedCriteria = DetachedCriteria.forClass(TrsEmployeeEmergencyContact.class);
		List<TrsEmployeeEmergencyContact>list = (List<TrsEmployeeEmergencyContact>) getHibernateTemplate().findByCriteria(detachedCriteria, (Integer)hashMap.get("firstResult"), (Integer)hashMap.get("maxResults"));
		return list;*/
		
        /*int PRE_MAX_RESULT = getHibernateTemplate().getMaxResults(); 
        int PRE_LIMIT = getHibernateTemplate().getFetchSize(); 
        
        getHibernateTemplate().setMaxResults((Integer)hashMap.get("maxResults")); 
        getHibernateTemplate().setFetchSize((Integer)hashMap.get("firstResult")); 
        
        String queryString = "FROM TrsEmployeeEmergencyContact trsEmployeeEmergencyContact WHERE trsEmployeeEmergencyContact.idEmployee = '"+hashMap.get("idEmployee")+"'";
        
        List<TrsEmployeeEmergencyContact>list = (List<TrsEmployeeEmergencyContact>) getHibernateTemplate().find(queryString); 
        getHibernateTemplate().setMaxResults(PRE_MAX_RESULT); 
        getHibernateTemplate().setFetchSize(PRE_LIMIT); 
        
        return list;*/ 
		
		String queryString = "FROM TrsEmployeeEmergencyContact trsEmployeeEmergencyContact WHERE trsEmployeeEmergencyContact.idEmployee = '"+hashMap.get("idEmployee")+"'";
  
		Query query = getSessionFactory().getCurrentSession().createQuery(queryString.toString());
        query.setFirstResult((Integer)hashMap.get("firstResult"));
        query.setMaxResults((Integer)hashMap.get("maxResults"));
        
		return (List<TrsEmployeeEmergencyContact>) query.list();
	}

	@Override
	public int getCountTrsEmployeeEmergencyContacts(HashMap<String, Object> hashMap) {
		return DataAccessUtils.intResult(getHibernateTemplate().find("SELECT COUNT(*) FROM TrsEmployeeEmergencyContact trsEmployeeEmergencyContact WHERE trsEmployeeEmergencyContact.idEmployee = '"+hashMap.get("count")+"'"));
	}
}