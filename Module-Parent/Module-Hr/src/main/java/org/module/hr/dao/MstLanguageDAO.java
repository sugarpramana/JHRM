package org.module.hr.dao;

import java.util.HashMap;
import java.util.List;

import org.module.hr.model.MstLanguage;

/**
*
* @author formulateko@admin.com
*/
public interface MstLanguageDAO {
	public void save(MstLanguage mstLanguage);
    public void update(MstLanguage mstLanguage);
    public void saveOrUpdate(MstLanguage mstLanguage);
    public void delete(MstLanguage mstLanguage);
    public List<MstLanguage> getAllMstLanguage();
    public List<MstLanguage> getByRequestMap(HashMap<String, Object> hashMap);
    public List<MstLanguage> getMstLanguagePaging(HashMap<String, Object> hashMap);
    public int getCountMstLanguages();
}