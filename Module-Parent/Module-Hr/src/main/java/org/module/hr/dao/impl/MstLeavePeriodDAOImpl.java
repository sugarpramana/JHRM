package org.module.hr.dao.impl;

import java.util.HashMap;
import java.util.List;

import org.module.api.common.dao.base.BasisDAO;
import org.module.hr.model.MstLeavePeriod;
import org.module.hr.dao.MstLeavePeriodDAO;

@SuppressWarnings("unchecked")
public class MstLeavePeriodDAOImpl extends BasisDAO<MstLeavePeriod> implements MstLeavePeriodDAO {

	@Override
	public List<MstLeavePeriod> getAllMstLeavePeriods() {
		return (List<MstLeavePeriod>) getHibernateTemplate().find("FROM MstLeavePeriod");
	}

	@Override
	public List<MstLeavePeriod> getMstLeavePeriodPaging(HashMap<String, Object> hashMap) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getCountMstLeavePeriods() {
		// TODO Auto-generated method stub
		return 0;
	}
}