package org.module.hr.dao.impl;

import java.util.HashMap;
import java.util.List;

import org.module.api.common.dao.base.BasisDAO;
import org.module.hr.dao.MstWorkWeekDAO;
import org.module.hr.model.MstWorkWeek;
import org.springframework.dao.support.DataAccessUtils;

/**
*
* @author formulateko@admin.com
*/
@SuppressWarnings("unchecked")
public class MstWorkWeekDAOImpl extends BasisDAO<MstWorkWeek> implements MstWorkWeekDAO {

	@Override
	public List<MstWorkWeek> getAllMstWorkWeeks() {
		List<MstWorkWeek>list = (List<MstWorkWeek>) getHibernateTemplate().find("FROM MstWorkWeek");
		return list;
	}

	@Override
	public List<MstWorkWeek> getMstWorkWeekPaging(HashMap<String, Object> hashMap) {
		List<MstWorkWeek>list = (List<MstWorkWeek>) getHibernateTemplate().findByExample(new MstWorkWeek(), (Integer)hashMap.get("firstResult"), (Integer)hashMap.get("maxResults"));
		return list;
	}

	@Override
	public int getCountMstWorkWeeks() {
		return DataAccessUtils.intResult(getHibernateTemplate().find("SELECT COUNT(*) FROM MstWorkWeek"));
	}
}