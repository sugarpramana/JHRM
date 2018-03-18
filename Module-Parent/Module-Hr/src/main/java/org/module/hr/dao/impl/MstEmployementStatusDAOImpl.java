package org.module.hr.dao.impl;

import java.util.HashMap;
import java.util.List;

import org.module.api.common.dao.base.BasisDAO;
import org.module.hr.dao.MstEmployementStatusDAO;
import org.module.hr.model.MstEmployementStatus;
import org.springframework.dao.support.DataAccessUtils;

/**
*
* @author formulateko@admin.com
*/
@SuppressWarnings("unchecked")
public class MstEmployementStatusDAOImpl extends BasisDAO<MstEmployementStatus> implements MstEmployementStatusDAO{

	@Override
	public List<MstEmployementStatus> getAllMstEmployementStatus() {
		List<MstEmployementStatus> list = (List<MstEmployementStatus>) getHibernateTemplate().find("FROM MstEmployementStatus");
		return list;
	}

	@Override
	public List<MstEmployementStatus> getMstEmployementStatusPaging(HashMap<String, Object> hashMap) {
		List<MstEmployementStatus>list = (List<MstEmployementStatus>) getHibernateTemplate().findByExample(new MstEmployementStatus(), (Integer)hashMap.get("firstResult"), (Integer)hashMap.get("maxResults"));
		return list;
	}

	@Override
	public int getCountAllMstEmployementStatus() {
		return DataAccessUtils.intResult(getHibernateTemplate().find("SELECT COUNT(*) FROM MstEmployementStatus"));
	}
}