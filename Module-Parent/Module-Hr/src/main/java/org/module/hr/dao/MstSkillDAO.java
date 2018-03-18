package org.module.hr.dao;

import java.util.HashMap;
import java.util.List;

import org.module.hr.model.MstSkill;

/**
*
* @author formulateko@admin.com
*/
public interface MstSkillDAO {
	public void save(MstSkill mstSkill);
    public void update(MstSkill mstSkill);
    public void saveOrUpdate(MstSkill mstSkill);
    public void delete(MstSkill mstSkill);
    public List<MstSkill> getAllMstSkill();
    public MstSkill getMstSkillById(Integer id);
    public List<MstSkill> getByRequestMap(HashMap<String, Object> hashMap);
    public List<MstSkill> getMstSkillPaging(HashMap<String, Object> hashMap);
    public int getCountMstSkills();
}