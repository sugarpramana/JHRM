package org.module.hr.dao.impl;

import java.util.HashMap;
import java.util.List;

import org.module.api.common.dao.base.BasisDAO;
import org.module.hr.dao.MstLicenseDAO;
import org.module.hr.model.MstLicense;
import org.springframework.dao.support.DataAccessUtils;

/**
*
* @author formulateko@admin.com
*/
@SuppressWarnings("unchecked")
public class MstLicenseDAOImpl extends BasisDAO<MstLicense> implements MstLicenseDAO{

	@Override
	public List<MstLicense> getAllMstLicense() {
		List<MstLicense>list = (List<MstLicense>) getHibernateTemplate().find("FROM MstLicense");
		return list;
	}

	@Override
	public List<MstLicense> getMstLicensePaging(HashMap<String, Object> hashMap) {
		List<MstLicense>list = (List<MstLicense>) getHibernateTemplate().findByExample(new MstLicense(), (Integer)hashMap.get("firstResult"), (Integer)hashMap.get("maxResults"));
		return list;
	}

	@Override
	public int getCountMstLicenses() {
		return DataAccessUtils.intResult(getHibernateTemplate().find("SELECT COUNT(*) FROM MstLicense"));
	}
}