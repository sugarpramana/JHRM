package org.module.hr.dao;

import java.util.List;
import java.util.Map;

import org.module.hr.model.TrsEmployeeSkill;

public interface TrsEmployeeSkillDAO {
	public void save(TrsEmployeeSkill trsEmployeeSkill);
	public void update(TrsEmployeeSkill trsEmployeeSkill);
	public void saveOrUpdate(TrsEmployeeSkill trsEmployeeSkill);
	public void delete(TrsEmployeeSkill trsEmployeeSkill);
	public List<TrsEmployeeSkill> getAllTrsEmployeeSkill();
	public List<TrsEmployeeSkill> getTrsEmployeeSkillByTrsEmployeeSkillRequestMap(Map<String, Object> requestMap);
}
