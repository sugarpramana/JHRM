package org.module.hr.dao.impl;

import java.util.HashMap;
import java.util.List;

import org.module.api.common.dao.base.BasisDAO;
import org.module.hr.dao.MstProjectDAO;
import org.module.hr.model.MstProject;
import org.springframework.dao.support.DataAccessUtils;

@SuppressWarnings("unchecked")
public class MstProjectDAOImpl extends BasisDAO<MstProject> implements MstProjectDAO{

	@Override
	public List<MstProject> getAllMstProjects() {
		List<MstProject>list = (List<MstProject>) getHibernateTemplate().find("FROM MstProject");
		return list;
	}

	@Override
	public List<MstProject> getMstProjectPaging(HashMap<String, Object> hashMap) {
		List<MstProject>list = (List<MstProject>) getHibernateTemplate().findByExample(new MstProject(), (Integer)hashMap.get("firstResult"), (Integer)hashMap.get("maxResults"));
		return list;
	}

	@Override
	public int getCountMstProjects() {
		return DataAccessUtils.intResult(getHibernateTemplate().find("SELECT COUNT(*) FROM MstProject"));
	}
}