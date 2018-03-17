package org.module.hr.dao.impl;

import java.util.HashMap;
import java.util.List;

import org.module.api.common.dao.base.BasisDAO;
import org.module.hr.dao.TrsEntitlementDAO;
import org.module.hr.model.TrsEntitlement;
import org.springframework.dao.support.DataAccessUtils;

@SuppressWarnings("unchecked")
public class TrsEntitlementDAOImpl extends BasisDAO<TrsEntitlement> implements TrsEntitlementDAO{

	@Override
	public List<TrsEntitlement> getAllTrsEntitlements() {
		List<TrsEntitlement>list = (List<TrsEntitlement>) getHibernateTemplate().find("FROM TrsEntitlement");
		return list;
	}

	@Override
	public List<TrsEntitlement> getTrsEntitlementPaging(HashMap<String, Object> hashMap) {
		List<TrsEntitlement>list = (List<TrsEntitlement>) getHibernateTemplate().findByExample(new TrsEntitlement(), (Integer)hashMap.get("firstResult"), (Integer)hashMap.get("maxResults"));
		return list;
	}

	@Override
	public int getCountTrsEntitlements() {
		return DataAccessUtils.intResult(getHibernateTemplate().find("SELECT COUNT(*) FROM TrsEntitlement"));
	}
}