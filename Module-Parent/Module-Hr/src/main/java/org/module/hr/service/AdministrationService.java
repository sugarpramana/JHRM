package org.module.hr.service;

import java.util.HashMap;
import java.util.List;

import org.module.hr.model.MstSetting;

/**
*
* @author formulateko@admin.com
*/
public interface AdministrationService {
	public List<MstSetting> getAllSettings();
	public HashMap<String, Object> getAllSettingsAsHash();
	public void saveAll(List<MstSetting> settings) throws Exception;
}