package org.module.hr.dao.impl;

import java.util.HashMap;
import java.util.List;

import org.module.api.common.dao.base.BasisDAO;
import org.module.hr.dao.MstJobCategoryDAO;
import org.module.hr.model.MstJobCategory;
import org.springframework.dao.support.DataAccessUtils;

/**
*
* @author formulateko@admin.com
*/
@SuppressWarnings("unchecked")
public class MstJobCategoryDAOImpl extends BasisDAO<MstJobCategory> implements MstJobCategoryDAO{

	@Override
	public List<MstJobCategory> getAllMstJobCategories() {
		List<MstJobCategory>list = (List<MstJobCategory>) getHibernateTemplate().find("FROM MstJobCategory");
		
		return list;
	}

	@Override
	public List<MstJobCategory> getMstJobCategoryPaging(HashMap<String, Object> hashMap) {
		List<MstJobCategory>list = (List<MstJobCategory>) getHibernateTemplate().findByExample(new MstJobCategory(), (Integer)hashMap.get("firstResult"), (Integer)hashMap.get("maxResults"));
		return list;
	}

	@Override
	public int getCountAllMstJobCategory() {
		return DataAccessUtils.intResult(getHibernateTemplate().find("SELECT COUNT(*) FROM MstJobCategory"));
	}
}