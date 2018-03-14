package org.module.hr.service.impl;

import java.util.HashMap;
import java.util.List;

import org.module.hr.dao.MstLocationDAO;
import org.module.hr.model.MstLocation;
import org.module.hr.service.OrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrganizationServiceImpl implements OrganizationService{

	@Autowired
	private MstLocationDAO mstLocationDAO;

	/*- Location +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
	@Override
	public void save(MstLocation mstLocation) {
		mstLocationDAO.save(mstLocation);
	}

	@Override
	public void update(MstLocation mstLocation) {
		mstLocationDAO.update(mstLocation);
	}

	@Override
	public void saveOrUpdate(MstLocation mstLocation) {
		mstLocationDAO.saveOrUpdate(mstLocation);
	}

	@Override
	public void delete(MstLocation mstLocation) {
		mstLocationDAO.delete(mstLocation);
	}

	@Override
	public List<MstLocation> getAllMstLocation() {
		return mstLocationDAO.getAllMstLocation();
	}

	@Override
	public List<MstLocation> getOrganizationByRequestMap(HashMap<String, Object> hashMap) {
		return mstLocationDAO.getByRequestMap(hashMap);
	}

	@Override
	public List<MstLocation> getMstLocationPaging(HashMap<String, Object> hashMap) {
		return mstLocationDAO.getMstLocationPaging(hashMap);
	}

	@Override
	public int getCountMstLocations() {
		return mstLocationDAO.getCountMstLocations();
	}

	/*++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 * Getter Setter
	 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
	public MstLocationDAO getMstLocationDAO() {
		return mstLocationDAO;
	}

	public void setMstLocationDAO(MstLocationDAO mstLocationDAO) {
		this.mstLocationDAO = mstLocationDAO;
	}
}