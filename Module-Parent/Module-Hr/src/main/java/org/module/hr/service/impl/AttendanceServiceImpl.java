package org.module.hr.service.impl;

import java.util.HashMap;
import java.util.List;

import org.module.hr.dao.MstCustomerDAO;
import org.module.hr.dao.MstProjectDAO;
import org.module.hr.model.MstCustomer;
import org.module.hr.model.MstProject;
import org.module.hr.service.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
*
* @author formulateko@admin.com
*/
@Service
public class AttendanceServiceImpl implements AttendanceService{

	@Autowired
	private MstCustomerDAO mstCustomerDAO;
	
	@Autowired
	private MstProjectDAO mstProjectDAO;

	@Override
	public void save(MstCustomer mstCustomer) {
		mstCustomerDAO.save(mstCustomer);
	}

	@Override
	public void update(MstCustomer mstCustomer) {
		mstCustomerDAO.update(mstCustomer);
	}

	@Override
	public void saveOrUpdate(MstCustomer mstCustomer) {
		mstCustomerDAO.saveOrUpdate(mstCustomer);
	}

	@Override
	public void delete(MstCustomer mstCustomer) {
		mstCustomerDAO.delete(mstCustomer);
	}

	@Override
	public List<MstCustomer> getAllMstCustomers() {
		return mstCustomerDAO.getAllMstCustomers();
	}

	@Override
	public List<MstCustomer> getByMstCustomerRequestMap(HashMap<String, Object> hashMap) {
		return mstCustomerDAO.getByRequestMap(hashMap);
	}

	@Override
	public List<MstCustomer> getMstCustomerPaging(HashMap<String, Object> hashMap) {
		return mstCustomerDAO.getMstCustomerPaging(hashMap);
	}

	@Override
	public int getCountMstCustomers() {
		return mstCustomerDAO.getCountMstCustomers();
	}

	@Override
	public void save(MstProject mstProject) {
		mstProjectDAO.save(mstProject);
	}

	@Override
	public void update(MstProject mstProject) {
		mstProjectDAO.update(mstProject);
	}

	@Override
	public void saveOrUpdate(MstProject mstProject) {
		mstProjectDAO.saveOrUpdate(mstProject);
	}

	@Override
	public void delete(MstProject mstProject) {
		mstProjectDAO.delete(mstProject);
	}

	@Override
	public List<MstProject> getAllMstProjects() {
		return mstProjectDAO.getAllMstProjects();
	}

	@Override
	public List<MstProject> getByMstProjectRequestMap(HashMap<String, Object> hashMap) {
		return mstProjectDAO.getByRequestMap(hashMap);
	}

	@Override
	public List<MstProject> getMstProjectPaging(HashMap<String, Object> hashMap) {
		return mstProjectDAO.getMstProjectPaging(hashMap);
	}

	@Override
	public int getCountMstProjects() {
		return mstProjectDAO.getCountMstProjects();
	}
	
	/*++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 * Getter Setter
	 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
	public MstCustomerDAO getMstCustomerDAO() {
		return mstCustomerDAO;
	}

	public void setMstCustomerDAO(MstCustomerDAO mstCustomerDAO) {
		this.mstCustomerDAO = mstCustomerDAO;
	}

	public MstProjectDAO getMstProjectDAO() {
		return mstProjectDAO;
	}

	public void setMstProjectDAO(MstProjectDAO mstProjectDAO) {
		this.mstProjectDAO = mstProjectDAO;
	}
}