package org.module.hr.dao.impl;

import java.util.HashMap;
import java.util.List;

import org.module.api.common.dao.base.BasisDAO;
import org.module.hr.dao.MstSkillDAO;
import org.module.hr.model.MstSkill;
import org.springframework.dao.support.DataAccessUtils;

/**
*
* @author formulateko@admin.com
*/
@SuppressWarnings("unchecked")
public class MstSkillDAOImpl extends BasisDAO<MstSkill> implements MstSkillDAO{

	@Override
	public List<MstSkill> getAllMstSkill() {
		List<MstSkill>list = (List<MstSkill>) getHibernateTemplate().find("FROM MstSkill");
		return list;
	}
	
	@Override
	public MstSkill getMstSkillById(Integer id) {
		MstSkill mstSkill = getHibernateTemplate().get(MstSkill.class, id);
		return mstSkill;
	}

	@Override
	public List<MstSkill> getMstSkillPaging(HashMap<String, Object> hashMap) {
		List<MstSkill>list = (List<MstSkill>) getHibernateTemplate().findByExample(new MstSkill(), (Integer)hashMap.get("firstResult"), (Integer)hashMap.get("maxResults"));
		return list;
	}

	@Override
	public int getCountMstSkills() {
		return DataAccessUtils.intResult(getHibernateTemplate().find("SELECT COUNT(*) FROM MstSkill"));
	}
}