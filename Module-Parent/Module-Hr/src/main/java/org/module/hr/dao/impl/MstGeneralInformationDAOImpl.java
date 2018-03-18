package org.module.hr.dao.impl;

import java.util.HashMap;
import java.util.List;

import org.module.api.common.dao.base.BasisDAO;
import org.module.hr.dao.MstGeneralInformationDAO;
import org.module.hr.model.MstGeneralInformation;

/**
*
* @author formulateko@admin.com
*/
@SuppressWarnings("unchecked")
public class MstGeneralInformationDAOImpl extends BasisDAO<MstGeneralInformation> implements MstGeneralInformationDAO{

	@Override
	public List<MstGeneralInformation> getAllMstGeneralInformations() {
		List<MstGeneralInformation>list = (List<MstGeneralInformation>) getHibernateTemplate().find("FROM MstGeneralInformation");
		return list;
	}

	@Override
	public List<MstGeneralInformation> getMstGeneralInformationPaging(
			HashMap<String, Object> hashMap) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getCountMstGeneralInformations() {
		// TODO Auto-generated method stub
		return 0;
	}
}