package org.module.hr.dao.impl;

import java.util.HashMap;
import java.util.List;

import org.module.api.common.dao.base.BasisDAO;
import org.module.hr.dao.TrsLeaveDAO;
import org.module.hr.model.TrsLeave;
import org.springframework.dao.support.DataAccessUtils;

@SuppressWarnings("unchecked")
public class TrsLeaveDAOImpl extends BasisDAO<TrsLeave> implements TrsLeaveDAO{

	@Override
	public List<TrsLeave> getAllTrsLeaves() {
		List<TrsLeave>list = (List<TrsLeave>) getHibernateTemplate().find("FROM TrsLeave");
		return list;
	}

	@Override
	public List<TrsLeave> getTrsLeavePaging(HashMap<String, Object> hashMap) {
		List<TrsLeave>list = (List<TrsLeave>) getHibernateTemplate().findByExample(new TrsLeave(), (Integer)hashMap.get("firstResult"), (Integer)hashMap.get("maxResults"));
		return list;
	}

	@Override
	public int getCountTrsLeaves() {
		return DataAccessUtils.intResult(getHibernateTemplate().find("SELECT COUNT(*) FROM TrsLeave"));
	}
}