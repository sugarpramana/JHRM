package org.module.hr.service.impl;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;


//import org.module.api.common.ParameterKey;
import org.module.api.common.utilities.BusinessCaseUtilities;
import org.module.hr.dao.MstUploadFileDAO;
import org.module.hr.model.MstUploadFile;
import org.module.hr.model.TrsEmployee;
import org.module.hr.model.TrsJobCandidate;
import org.module.hr.service.UploadFileService;
import org.springframework.stereotype.Service;

/**
*
* @author formulateko@admin.com
*/
@Service
public class UploadFileServiceImpl implements UploadFileService{

	private MstUploadFileDAO mstUploadFileDAO;
	
	@Override
	public void uploadResume(InputStream inputStream, String path, TrsJobCandidate trsJobCandidate) throws Exception {
		Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
		
        String fileName = "RESUME-" + calendar.get(Calendar.YEAR) + "" +calendar.get(Calendar.MONTH) + "" +calendar.get(Calendar.DATE) + "" + 
				calendar.get(Calendar.HOUR) + "" +calendar.get(Calendar.MINUTE)+ "" +calendar.get(Calendar.SECOND)+ "" +
				trsJobCandidate.getFullName().trim() + ".pdf";
        
		uploadFile(inputStream, path + "\\resume\\", fileName);
		
		MstUploadFile mstUploadFile = new MstUploadFile();
		mstUploadFile.setIdTrsJobCandidate(trsJobCandidate);
		mstUploadFile.setPathFile(path + fileName);
		mstUploadFile.setTypeFile(UploadFileService.RESUME_FILE);
		save(mstUploadFile);
	}
	
	@Override
	public void uploadPhoto(InputStream inputStream, String path, TrsEmployee trsEmployee) throws Exception {
		Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
		
        String fileName = "PHOTO-" + calendar.get(Calendar.YEAR) + "" +calendar.get(Calendar.MONTH) + "" +calendar.get(Calendar.DATE) + "" + 
				calendar.get(Calendar.HOUR) + "" +calendar.get(Calendar.MINUTE)+ "" +calendar.get(Calendar.SECOND)+ "" +
				BusinessCaseUtilities.composeFullName(trsEmployee.getFirstName(), trsEmployee.getMiddleName(), trsEmployee.getLastName()).trim();
        
		uploadFile(inputStream, path + "\\photo\\", fileName);
		
		MstUploadFile mstUploadFile = new MstUploadFile();
		mstUploadFile.setIdEmployee(trsEmployee);
		mstUploadFile.setPathFile(path + fileName);
		mstUploadFile.setTypeFile(UploadFileService.PHOTO_FILE);
		save(mstUploadFile);
	}
	
	/**
	 * 
	 * @param inputStream
	 * @param path
	 * @param fileName
	 * @throws Exception
	 */
	private void uploadFile(InputStream inputStream, String path, String fileName) throws Exception {
		BufferedInputStream in = null;
		BufferedOutputStream out = null;
		try {
			in = new BufferedInputStream(inputStream);
			
			File baseDir = new File(path);

			if (!baseDir.exists()) {
				baseDir.mkdirs();
			}

			File file = new File(path + fileName );
			
			OutputStream fout = new FileOutputStream(file);
			out = new BufferedOutputStream(fout);
			byte buffer[] = new byte[1024];
			int ch = in.read(buffer);
			while (ch != -1) {
				out.write(buffer, 0, ch);
				ch = in.read(buffer);
			}
		} catch (IOException e) {
			throw new RuntimeException(e);
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			try {
				if (out != null) 
					out.close();	
				if (in != null)
					in.close();
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}
	}
	
	@Override
	public void save(MstUploadFile mstUploadFile) {
		this.mstUploadFileDAO.save(mstUploadFile);
	}

	@Override
	public MstUploadFile getByTrsEmployee(TrsEmployee trsEmployee) {
		HashMap<String, Object> parameter = new HashMap<>();
		//parameter.put(ParameterKey.KEY_TRS_EMPLOYEE, trsEmployee);
		
		List<MstUploadFile> listResult = mstUploadFileDAO.getByRequestMap(parameter);
		
		return listResult.size() > 0 ? listResult.get(0) : null;
	}

	@Override
	public File getResumeFile(TrsJobCandidate trsJobCandidate) {
		HashMap<String, Object> parameter = new HashMap<>();
		//parameter.put(ParameterKey.KEY_TRS_JOB_CANDIDATE, trsJobCandidate);
		
		List<MstUploadFile> listResult = mstUploadFileDAO.getByRequestMap(parameter);
		
		MstUploadFile mstUploadFile = listResult.size() > 0 ? listResult.get(0) : null;
		
		if (mstUploadFile != null) {
			
		}
		
		File file = new File(mstUploadFile.getPathFile());
		
		return file;
	}
	
	/*------------- SETTER ---------------*/
	public void setMstUploadFileDAO(MstUploadFileDAO mstUploadFileDAO) {
		this.mstUploadFileDAO = mstUploadFileDAO;
	}
}