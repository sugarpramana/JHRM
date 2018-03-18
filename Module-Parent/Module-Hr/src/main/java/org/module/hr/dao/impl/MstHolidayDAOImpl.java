package org.module.hr.dao.impl;

import java.util.HashMap;
import java.util.List;

import org.module.api.common.dao.base.BasisDAO;
import org.module.hr.dao.MstHolidayDAO;
import org.module.hr.model.MstHoliday;
import org.springframework.dao.support.DataAccessUtils;

/**
*
* @author formulateko@admin.com
*/
@SuppressWarnings("unchecked")
public class MstHolidayDAOImpl extends BasisDAO<MstHoliday> implements MstHolidayDAO{

	@Override
	public List<MstHoliday> getAllMstHolidays() {
		List<MstHoliday>list = (List<MstHoliday>) getHibernateTemplate().find("FROM MstHoliday");
		return list;
	}

	@Override
	public List<MstHoliday> getMstHolidayPaging(HashMap<String, Object> hashMap) {
		List<MstHoliday>list = (List<MstHoliday>) getHibernateTemplate().findByExample(new MstHoliday(), (Integer)hashMap.get("firstResult"), (Integer)hashMap.get("maxResults"));
		return list;
	}

	@Override
	public int getCountMstHolidays() {
		return DataAccessUtils.intResult(getHibernateTemplate().find("SELECT COUNT(*) FROM MstHoliday"));
	}
}