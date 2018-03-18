package org.module.hr.dao.impl;

import java.util.List;

import org.module.api.common.dao.base.BasisDAO;
import org.module.hr.dao.MstSettingDAO;
import org.module.hr.model.MstSetting;
import org.springframework.dao.DataAccessException;

/**
*
* @author formulateko@admin.com
*/
@SuppressWarnings("unchecked")
public class MstSettingDAOImpl extends BasisDAO<MstSetting> implements MstSettingDAO{

	@Override
	public List<MstSetting> getAllMstSetting() {
		List<MstSetting>list = (List<MstSetting>) getHibernateTemplate().find("FROM MstSetting");
		return list;
	}

	@Override
	public void saveOrUpdateAll(List<MstSetting> settings) throws DataAccessException {
		super.saveOrUpdateAll(settings);
	}

}