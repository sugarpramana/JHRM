package org.module.hr.dao.impl;

import java.util.HashMap;
import java.util.List;

import org.module.api.common.dao.base.BasisDAO;
import org.module.hr.dao.MstNationalityDAO;
import org.module.hr.model.MstNationality;
import org.springframework.dao.support.DataAccessUtils;

/**
*
* @author formulateko@admin.com
*/
@SuppressWarnings("unchecked")
public class MstNationalityDAOImpl extends BasisDAO<MstNationality> implements MstNationalityDAO{

	@Override
	public List<MstNationality> getAllMstNationality() {
		List<MstNationality>list = (List<MstNationality>) getHibernateTemplate().find("FROM MstNationality");
		return list;
	}

	@Override
	public List<MstNationality> getMstNationalityPaging(HashMap<String, Object> hashMap) {
		List<MstNationality>list = (List<MstNationality>) getHibernateTemplate().findByExample(new MstNationality(), (Integer)hashMap.get("firstResult"), (Integer)hashMap.get("maxResults"));
		return list;
	}

	@Override
	public int getCountMstNationalities() {
		return DataAccessUtils.intResult(getHibernateTemplate().find("SELECT COUNT(*) FROM MstNationality"));
	}
}