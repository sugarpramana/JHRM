package org.module.hr.dao;

import java.util.HashMap;
import java.util.List;

import org.module.hr.model.MstUploadFile;

public interface MstUploadFileDAO {

	public void save(MstUploadFile mstUploadFile);
	
	public List<MstUploadFile> getByRequestMap(HashMap<String, Object> hashMap);
}
