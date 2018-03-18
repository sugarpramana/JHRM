package org.module.hr.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.module.api.common.dao.base.BasisDAO;
import org.module.hr.dao.TrsEmployeeLanguageDAO;
import org.module.hr.model.TrsEmployeeLanguage;

/**
*
* @author formulateko@admin.com
*/
@SuppressWarnings("unchecked")
public class TrsEmployeeLanguageDAOImpl extends BasisDAO<TrsEmployeeLanguage> implements TrsEmployeeLanguageDAO{

	@Override
	public List<TrsEmployeeLanguage> getAllTrsEmployeeLanguage() {
		List<TrsEmployeeLanguage> list = (List<TrsEmployeeLanguage>) getHibernateTemplate().find("FROM TrsEmployeeLanguage");
		return list;
	}

	@Override
	public List<TrsEmployeeLanguage> getTrsEmployeeLanguageByTrsEmployeeLanguageRequestMap(Map<String, Object> requestMap) {
		return (List<TrsEmployeeLanguage>) getHibernateTemplate().findByNamedParam("FROM TrsEmployeeLanguage where idEmployee=:trsEmployee" , "trsEmployee", requestMap.get("trsEmployee"));
	}

	@Override
	public List<TrsEmployeeLanguage> getTrsEmployeeLanguagePaging(HashMap<String, Object> hashMap) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getCountTrsEmployeeLanguages() {
		// TODO Auto-generated method stub
		return 0;
	}
}