package org.module.hr.dao.impl;

import java.util.HashMap;
import java.util.List;

import org.module.api.common.dao.base.BasisDAO;
import org.module.hr.dao.MstLeaveTypeDAO;
import org.module.hr.model.MstLeaveType;
import org.springframework.dao.support.DataAccessUtils;

/**
*
* @author formulateko@admin.com
*/
@SuppressWarnings("unchecked")
public class MstLeaveTypeDAOImpl extends BasisDAO<MstLeaveType> implements MstLeaveTypeDAO {

	@Override
	public List<MstLeaveType> getAllMstLeaveTypes() {
		List<MstLeaveType>list = (List<MstLeaveType>) getHibernateTemplate().find("FROM MstLeaveType");
		return list;
	}

	@Override
	public List<MstLeaveType> getMstLeaveTypePaging(HashMap<String, Object> hashMap) {
		List<MstLeaveType>list = (List<MstLeaveType>) getHibernateTemplate().findByExample(new MstLeaveType(), (Integer)hashMap.get("firstResult"), (Integer)hashMap.get("maxResults"));
		return list;
	}

	@Override
	public int getCountMstLeaveTypes() {
		return DataAccessUtils.intResult(getHibernateTemplate().find("SELECT COUNT(*) FROM MstLeaveType"));
	}
}