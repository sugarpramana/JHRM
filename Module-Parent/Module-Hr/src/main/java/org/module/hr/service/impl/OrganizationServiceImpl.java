package org.module.hr.service.impl;

import java.util.HashMap;
import java.util.List;

import org.module.hr.dao.MstGeneralInformationDAO;
import org.module.hr.dao.MstLocationDAO;
import org.module.hr.dao.MstSubUnitDAO;
import org.module.hr.model.MstGeneralInformation;
import org.module.hr.model.MstLocation;
import org.module.hr.model.MstSubUnit;
import org.module.hr.service.OrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
*
* @author formulateko@admin.com
*/
@Service
public class OrganizationServiceImpl implements OrganizationService{

	@Autowired
	private MstGeneralInformationDAO mstGeneralInformationDAO;
	
	@Autowired
	private MstLocationDAO mstLocationDAO;
	
	@Autowired
	private MstSubUnitDAO mstSubUnitDAO;

	/*- General Information +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
	@Override
	public void save(MstGeneralInformation mstGeneralInformation) {
		mstGeneralInformationDAO.save(mstGeneralInformation);	
	}

	@Override
	public void update(MstGeneralInformation mstGeneralInformation) {
		mstGeneralInformationDAO.update(mstGeneralInformation);
	}

	@Override
	public void saveOrUpdate(MstGeneralInformation mstGeneralInformation) {
		mstGeneralInformationDAO.saveOrUpdate(mstGeneralInformation);
	}

	@Override
	public void delete(MstGeneralInformation mstGeneralInformation) {
		mstGeneralInformationDAO.delete(mstGeneralInformation);
	}

	@Override
	public List<MstGeneralInformation> getAllMstGeneralInformations() {
		return mstGeneralInformationDAO.getAllMstGeneralInformations();
	}

	@Override
	public List<MstGeneralInformation> getByMstGeneralInformation(HashMap<String, Object> hashMap) {
		return mstGeneralInformationDAO.getByRequestMap(hashMap);
	}

	@Override
	public List<MstGeneralInformation> getMstGeneralInformationPaging(HashMap<String, Object> hashMap) {
		return mstGeneralInformationDAO.getMstGeneralInformationPaging(hashMap);
	}

	@Override
	public int getCountMstGeneralInformations() {
		return mstGeneralInformationDAO.getCountMstGeneralInformations();
	}
	
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
	public List<MstLocation> getByMstLocationRequestMap(HashMap<String, Object> hashMap) {
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
	
	/*- Structure +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
	@Override
	public void save(MstSubUnit mstSubUnit) {
		mstSubUnitDAO.save(mstSubUnit);
	}

	@Override
	public void update(MstSubUnit mstSubUnit) {
		mstSubUnitDAO.update(mstSubUnit);
	}

	@Override
	public void saveOrUpdate(MstSubUnit mstSubUnit) {
		mstSubUnitDAO.saveOrUpdate(mstSubUnit);
	}

	@Override
	public void delete(MstSubUnit mstSubUnit) {
		mstSubUnitDAO.delete(mstSubUnit);
	}

	@Override
	public List<MstSubUnit> getAllMstSubUnitts() {
		return mstSubUnitDAO.getAllMstSubUnitts();
	}

	@Override
	public List<MstSubUnit> getByMstSubUnitRequestMap(HashMap<String, Object> hashMap) {
		return mstSubUnitDAO.getByRequestMap(hashMap);
	}

	@Override
	public List<MstSubUnit> getMstSubUnitPaging(HashMap<String, Object> hashMap) {
		return mstSubUnitDAO.getMstSubUnitPaging(hashMap);
	}

	@Override
	public int getCountMstSubUnits() {
		return mstSubUnitDAO.getCountMstSubUnits();
	}

	/*++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 * Getter Setter
	 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
	public MstGeneralInformationDAO getMstGeneralInformationDAO() {
		return mstGeneralInformationDAO;
	}

	public void setMstGeneralInformationDAO(MstGeneralInformationDAO mstGeneralInformationDAO) {
		this.mstGeneralInformationDAO = mstGeneralInformationDAO;
	}

	public MstLocationDAO getMstLocationDAO() {
		return mstLocationDAO;
	}

	public void setMstLocationDAO(MstLocationDAO mstLocationDAO) {
		this.mstLocationDAO = mstLocationDAO;
	}

	public MstSubUnitDAO getMstSubUnitDAO() {
		return mstSubUnitDAO;
	}

	public void setMstSubUnitDAO(MstSubUnitDAO mstSubUnitDAO) {
		this.mstSubUnitDAO = mstSubUnitDAO;
	}
}