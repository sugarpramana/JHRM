package org.module.hr.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.module.api.common.dao.base.BasisDAO;
import org.module.hr.dao.TrsEmployeeMembershipDAO;
import org.module.hr.model.TrsEmployeeMembership;

/**
*
* @author formulateko@admin.com
*/
@SuppressWarnings("unchecked")
public class TrsEmployeeMembershipDAOImpl extends BasisDAO<TrsEmployeeMembership> implements TrsEmployeeMembershipDAO{

	@Override
	public List<TrsEmployeeMembership> getAllTrsEmployeeMembership() {
		List<TrsEmployeeMembership>list = (List<TrsEmployeeMembership>) getHibernateTemplate().find("FROM TrsEmployeeMembership");
		return list;
	}

	@Override
	public List<TrsEmployeeMembership> getTrsEmployeeMembershipByTrsEmployeeMembershipRequestMap(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TrsEmployeeMembership> getTrsEmployeeMembershipPaging(HashMap<String, Object> hashMap) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getCountTrsEmployeeMemberships() {
		// TODO Auto-generated method stub
		return 0;
	}
}