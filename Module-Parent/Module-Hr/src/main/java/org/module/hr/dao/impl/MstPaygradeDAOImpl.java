package org.module.hr.dao.impl;

import java.util.HashMap;
import java.util.List;

import org.module.api.common.dao.base.BasisDAO;
import org.module.hr.dao.MstPaygradeDAO;
import org.module.hr.model.MstPaygrade;
import org.springframework.dao.support.DataAccessUtils;

@SuppressWarnings("unchecked")
public class MstPaygradeDAOImpl extends BasisDAO<MstPaygrade> implements MstPaygradeDAO{

	@Override
	public List<MstPaygrade> getAllMstPaygrades() {
		List<MstPaygrade>list = (List<MstPaygrade>) getHibernateTemplate().find("FROM MstPaygrade");
		
		return list;
	}

	@Override
	public List<MstPaygrade> getMstPaygradePaging(HashMap<String, Object> hashMap) {
		List<MstPaygrade>list = (List<MstPaygrade>) getHibernateTemplate().findByExample(new MstPaygrade(), (Integer)hashMap.get("firstResult"), (Integer)hashMap.get("maxResults"));
		System.out.println("List Size Backend >>>"+list.size());
		return list;
	}

	@Override
	public int getCountMstPaygrades() {
		return DataAccessUtils.intResult(getHibernateTemplate().find("SELECT COUNT(*) FROM MstPaygrade"));
	}
}