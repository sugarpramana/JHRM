package org.module.hr.dao.impl;

import java.util.HashMap;
import java.util.List;

import org.module.api.common.dao.base.BasisDAO;
import org.module.hr.dao.TrsEmployeeDAO;
import org.module.hr.model.TrsEmployee;
import org.springframework.dao.support.DataAccessUtils;

/**
*
* @author formulateko@admin.com
*/
@SuppressWarnings("unchecked")
public class TrsEmployeeDAOImpl extends BasisDAO<TrsEmployee> implements TrsEmployeeDAO{

	@Override
	public List<TrsEmployee> getAllTrsEmployees() {
		List<TrsEmployee> list = (List<TrsEmployee>) getHibernateTemplate().find("FROM TrsEmployee");
		return list;
	}

	@Override
	public List<TrsEmployee> getMstTrsEmployeePaging(HashMap<String, Object> hashMap) {
		List<TrsEmployee>list = (List<TrsEmployee>) getHibernateTemplate().findByExample(new TrsEmployee(), (Integer)hashMap.get("firstResult"), (Integer)hashMap.get("maxResults"));
		return list;
	}

	@Override
	public int getCountTrsEmployees() {
		return DataAccessUtils.intResult(getHibernateTemplate().find("SELECT COUNT(*) FROM TrsEmployee"));
	}
}