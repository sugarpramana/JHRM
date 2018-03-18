package org.module.hr.service;

import java.io.File;
import java.io.InputStream;

import org.module.hr.model.MstUploadFile;
import org.module.hr.model.TrsEmployee;
import org.module.hr.model.TrsJobCandidate;

/**
*
* @author formulateko@admin.com
*/
public interface UploadFileService {
	public static final String RESUME_FILE ="resume";
	public static final String PHOTO_FILE ="photo";
	
	public void save(MstUploadFile mstUploadFile);
	public MstUploadFile getByTrsEmployee(TrsEmployee trsEmployee);
	public File getResumeFile(TrsJobCandidate trsJobCandidate);
	void uploadResume(InputStream inputStream, String path, TrsJobCandidate trsJobCandidate) throws Exception;
	void uploadPhoto(InputStream inputStream, String path, TrsEmployee trsEmployee) throws Exception;
}