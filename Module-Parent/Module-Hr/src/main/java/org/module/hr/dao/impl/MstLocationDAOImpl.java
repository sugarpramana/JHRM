package org.module.hr.dao.impl;

import java.util.HashMap;
import java.util.List;

import org.module.api.common.dao.base.BasisDAO;
import org.module.hr.dao.MstLocationDAO;
import org.module.hr.model.MstLocation;
import org.springframework.dao.support.DataAccessUtils;

/**
*
* @author formulateko@admin.com
*/
@SuppressWarnings("unchecked")
public class MstLocationDAOImpl extends BasisDAO<MstLocation> implements MstLocationDAO{

	@Override
	public List<MstLocation> getAllMstLocation() {
		List<MstLocation>list = (List<MstLocation>) getHibernateTemplate().find("FROM MstLocation");
		return list;
	}

	@Override
	public List<MstLocation> getMstLocationPaging(HashMap<String, Object> hashMap) {
		List<MstLocation>list = (List<MstLocation>) getHibernateTemplate().findByExample(new MstLocation(), (Integer)hashMap.get("firstResult"), (Integer)hashMap.get("maxResults"));
		return list;
	}

	@Override
	public int getCountMstLocations() {
		return DataAccessUtils.intResult(getHibernateTemplate().find("SELECT COUNT(*) FROM MstLocation"));
	}
}