package org.module.hr.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.module.api.common.dao.base.BasisDAO;
import org.module.hr.dao.TrsEmployeeDependentDAO;
import org.module.hr.model.TrsEmployeeDependent;

/**
*
* @author formulateko@admin.com
*/
@SuppressWarnings("unchecked")
public class TrsEmployeeDependentDAOImpl extends BasisDAO<TrsEmployeeDependent> implements TrsEmployeeDependentDAO{

	@Override
	public List<TrsEmployeeDependent> getAllTrsEmployeeDependent() {
		List<TrsEmployeeDependent> list = (List<TrsEmployeeDependent>) getHibernateTemplate().find("FROM TrsEmployeeDependent");
		return list;
	}
	
	@Override
	public List<TrsEmployeeDependent> getTrsEmployeeDependentByTrsEmployeeDependentRequestMap(Map<String, Object> requestMap) {
		return (List<TrsEmployeeDependent>) getHibernateTemplate().findByNamedParam("FROM TrsEmployeeDependent where idEmployee=:trsEmployee" , "trsEmployee", requestMap.get("trsEmployee"));
	}

	@Override
	public List<TrsEmployeeDependent> getTrsEmployeeDependentPaging(HashMap<String, Object> hashMap) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getCountTrsEmployeeDependents() {
		// TODO Auto-generated method stub
		return 0;
	}
}