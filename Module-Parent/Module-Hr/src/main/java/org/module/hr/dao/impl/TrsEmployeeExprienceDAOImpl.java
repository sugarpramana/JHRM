package org.module.hr.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.module.api.common.dao.base.BasisDAO;
import org.module.hr.dao.TrsEmployeeExprienceDAO;
import org.module.hr.model.TrsEmployeeExprience;

/**
*
* @author formulateko@admin.com
*/
@SuppressWarnings("unchecked")
public class TrsEmployeeExprienceDAOImpl extends BasisDAO<TrsEmployeeExprience> implements TrsEmployeeExprienceDAO{

	@Override
	public List<TrsEmployeeExprience> getAllTrsEmployeeExprience() {
		List<TrsEmployeeExprience> list = (List<TrsEmployeeExprience>) getHibernateTemplate().find("FROM TrsEmployeeExprience");
		return list;
	}

	@Override
	public List<TrsEmployeeExprience> getTrsEmployeeExprienceByTrsEmployeeExprienceRequestMap(Map<String, Object> requestMap) {
		return (List<TrsEmployeeExprience>) getHibernateTemplate().findByNamedParam("FROM TrsEmployeeExprience where idEmployee=:trsEmployee" , "trsEmployee", requestMap.get("trsEmployee"));
	}

	@Override
	public List<TrsEmployeeExprience> getTrsEmployeeExpriencePaging(HashMap<String, Object> hashMap) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getCountTrsEmployeeExpriences() {
		// TODO Auto-generated method stub
		return 0;
	}
}