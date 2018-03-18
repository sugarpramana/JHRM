package org.module.hr.dao.impl;

import java.util.HashMap;
import java.util.List;

import org.module.api.common.dao.base.BasisDAO;
import org.module.hr.dao.MstSubUnitDAO;
import org.module.hr.model.MstSubUnit;

/**
*
* @author formulateko@admin.com
*/
@SuppressWarnings("unchecked")
public class MstSubUnitDAOImpl extends BasisDAO<MstSubUnit> implements MstSubUnitDAO{

	@Override
	public List<MstSubUnit> getAllMstSubUnitts() {
		List<MstSubUnit>list = (List<MstSubUnit>) getHibernateTemplate().find("FROM MstSubUnit");
		return list;
	}

	@Override
	public List<MstSubUnit> getMstSubUnitPaging(HashMap<String, Object> hashMap) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getCountMstSubUnits() {
		// TODO Auto-generated method stub
		return 0;
	}
}