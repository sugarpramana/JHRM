package org.module.hr.dao.impl;

import java.util.HashMap;
import java.util.List;

import org.module.api.common.dao.base.BasisDAO;
import org.module.hr.dao.MstMembershipDAO;
import org.module.hr.model.MstMembership;
import org.springframework.dao.support.DataAccessUtils;

/**
*
* @author formulateko@admin.com
*/
@SuppressWarnings("unchecked")
public class MstMembershipDAOImpl extends BasisDAO<MstMembership> implements MstMembershipDAO{

	@Override
	public List<MstMembership> getAllMstMembership() {
		List<MstMembership>list = (List<MstMembership>) getHibernateTemplate().find("FROM MstMembership");
		return list;
	}

	@Override
	public List<MstMembership> getMstMembershipPaging(HashMap<String, Object> hashMap) {
		List<MstMembership>list = (List<MstMembership>) getHibernateTemplate().findByExample(new MstMembership(), (Integer)hashMap.get("firstResult"), (Integer)hashMap.get("maxResults"));
		return list;
	}

	@Override
	public int getCountMstMemberships() {
		return DataAccessUtils.intResult(getHibernateTemplate().find("SELECT COUNT(*) FROM MstMembership"));
	}
}