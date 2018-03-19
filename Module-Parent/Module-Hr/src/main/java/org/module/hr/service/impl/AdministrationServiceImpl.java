package org.module.hr.service.impl;

import java.util.HashMap;
import java.util.List;

import org.module.hr.dao.MstSettingDAO;
import org.module.hr.model.MstSetting;
import org.module.hr.service.AdministrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
*
* @author formulateko@admin.com
*/
@Service
public class AdministrationServiceImpl implements AdministrationService {
	
	@Autowired
	private MstSettingDAO mstSettingDAO;
	
	@Override
	public List<MstSetting> getAllSettings() { 
		return mstSettingDAO.getAllMstSetting();
	}
	
	@Override
	public HashMap<String, Object> getAllSettingsAsHash() {
		HashMap<String, Object> settings = new HashMap<>();
		for (MstSetting setting : getAllSettings()) {
			settings.put(setting.getKeySet(), setting.getValueSet());
		}
		return settings;
	}

	@Override
	public void saveAll(List<MstSetting> settings) throws Exception {
		mstSettingDAO.saveOrUpdateAll(settings);
	}
	
	
	/* ----------- GETTER - SETTER -----------*/
	public void setMstSettingDAO(MstSettingDAO mstSettingDAO) {
		this.mstSettingDAO = mstSettingDAO;
	}
}