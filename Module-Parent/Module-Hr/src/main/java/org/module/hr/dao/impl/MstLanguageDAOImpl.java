package org.module.hr.dao.impl;

import java.util.HashMap;
import java.util.List;

import org.module.api.common.dao.base.BasisDAO;
import org.module.hr.dao.MstLanguageDAO;
import org.module.hr.model.MstLanguage;
import org.springframework.dao.support.DataAccessUtils;

/**
*
* @author formulateko@admin.com
*/
@SuppressWarnings("unchecked")
public class MstLanguageDAOImpl extends BasisDAO<MstLanguage> implements MstLanguageDAO{

	@Override
	public List<MstLanguage> getAllMstLanguage() {
		List<MstLanguage>list = (List<MstLanguage>) getHibernateTemplate().find("FROM MstLanguage");
		return list;
	}

	@Override
	public List<MstLanguage> getMstLanguagePaging(HashMap<String, Object> hashMap) {
		List<MstLanguage>list = (List<MstLanguage>) getHibernateTemplate().findByExample(new MstLanguage(), (Integer)hashMap.get("firstResult"), (Integer)hashMap.get("maxResults"));
		return list;
	}

	@Override
	public int getCountMstLanguages() {
		return DataAccessUtils.intResult(getHibernateTemplate().find("SELECT COUNT(*) FROM MstLanguage"));
	}
}