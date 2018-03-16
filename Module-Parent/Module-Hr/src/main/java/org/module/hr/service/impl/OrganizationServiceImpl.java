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
		// TODO Auto-generated method stub	
	}

	@Override
	public void update(MstGeneralInformation mstGeneralInformation) {
		// TODO Auto-generated method stub
	}

	@Override
	public void saveOrUpdate(MstGeneralInformation mstGeneralInformation) {
		// TODO Auto-generated method stub
	}

	@Override
	public void delete(MstGeneralInformation mstGeneralInformation) {
		// TODO Auto-generated method stub
	}

	@Override
	public List<MstGeneralInformation> getAllMstGeneralInformations() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MstGeneralInformation> getByMstGeneralInformation(HashMap<String, Object> hashMap) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MstGeneralInformation> getMstGeneralInformationPaging(HashMap<String, Object> hashMap) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getCountMstGeneralInformations() {
		// TODO Auto-generated method stub
		return 0;
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
		// TODO Auto-generated method stub
	}

	@Override
	public void update(MstSubUnit mstSubUnit) {
		// TODO Auto-generated method stub
	}

	@Override
	public void saveOrUpdate(MstSubUnit mstSubUnit) {
		// TODO Auto-generated method stub
	}

	@Override
	public void delete(MstSubUnit mstSubUnit) {
		// TODO Auto-generated method stub
	}

	@Override
	public List<MstSubUnit> getAllMstSubUnitts() {
		return mstSubUnitDAO.getAllMstSubUnitts();
	}

	@Override
	public List<MstSubUnit> getByMstSubUnitRequestMap(HashMap<String, Object> hashMap) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MstSubUnit> getMstSubUnitPaging(HashMap<String, Object> hashMap) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getCountMstSubUnits() {
		// TODO Auto-generated method stub
		return 0;
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