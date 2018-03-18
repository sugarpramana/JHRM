package org.module.hr.dao.impl;

import java.util.HashMap;
import java.util.List;

import org.module.api.common.dao.base.BasisDAO;
import org.module.hr.dao.MstEducationDAO;
import org.module.hr.model.MstEducation;
import org.springframework.dao.support.DataAccessUtils;

/**
*
* @author formulateko@admin.com
*/
@SuppressWarnings("unchecked")
public class MstEducationDAOImpl extends BasisDAO<MstEducation> implements MstEducationDAO{

	@Override
	public List<MstEducation> getAllMstEducation() {
		List<MstEducation>list = (List<MstEducation>) getHibernateTemplate().find("FROM MstEducation");
		return list;
	}

	@Override
	public List<MstEducation> getMstEducationPaging(HashMap<String, Object> hashMap) {
		List<MstEducation>list = (List<MstEducation>) getHibernateTemplate().findByExample(new MstEducation(), (Integer)hashMap.get("firstResult"), (Integer)hashMap.get("maxResults"));
		return list;
	}

	@Override
	public int getCountMstEducations() {
		return DataAccessUtils.intResult(getHibernateTemplate().find("SELECT COUNT(*) FROM MstEducation"));
	}
}