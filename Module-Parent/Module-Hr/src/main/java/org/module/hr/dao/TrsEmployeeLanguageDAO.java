package org.module.hr.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.module.hr.model.TrsEmployeeLanguage;

/**
*
* @author formulateko@admin.com
*/
public interface TrsEmployeeLanguageDAO {
	public void save(TrsEmployeeLanguage trsEmployeeLanguage);
	public void update(TrsEmployeeLanguage trsEmployeeLanguage);
	public void saveOrUpdate(TrsEmployeeLanguage trsEmployeeLanguage);
	public void delete(TrsEmployeeLanguage trsEmployeeLanguage);
	public List<TrsEmployeeLanguage> getAllTrsEmployeeLanguage();
	public List<TrsEmployeeLanguage> getTrsEmployeeLanguageByTrsEmployeeLanguageRequestMap(Map<String, Object> requestMap);
	public List<TrsEmployeeLanguage> getTrsEmployeeLanguagePaging(HashMap<String, Object> hashMap);
    public int getCountTrsEmployeeLanguages();
}