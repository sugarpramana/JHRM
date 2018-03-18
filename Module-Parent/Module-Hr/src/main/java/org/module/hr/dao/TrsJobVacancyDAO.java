package org.module.hr.dao;

import java.util.HashMap;
import java.util.List;

import org.module.hr.model.TrsJobVacancy;

/**
*
* @author formulateko@admin.com
*/
public interface TrsJobVacancyDAO {
	public TrsJobVacancy getTrsJobVacancyById(Integer id);
	public void save(TrsJobVacancy trsJobVacancy);
    public void update(TrsJobVacancy trsJobVacancy);
    public void saveOrUpdate(TrsJobVacancy trsJobVacancy);
    public void delete(TrsJobVacancy trsJobVacancy);
    public List<TrsJobVacancy> getAllTrsJobVacancy();
    public List<TrsJobVacancy> getByRequest(HashMap<String, Object> params);
    public List<TrsJobVacancy> getTrsJobVacancyPaging(HashMap<String, Object> hashMap);
    public int getCountTrsJobVacancys();
}