package org.module.hr.service.impl;

import java.util.HashMap;
import java.util.List;

import org.module.hr.dao.MstNationalityDAO;
import org.module.hr.model.MstNationality;
import org.module.hr.service.NationalityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NationalityServiceImpl implements NationalityService{

	@Autowired
	private MstNationalityDAO mstNationalityDAO;
	
	@Override
	public void save(MstNationality mstNationality) {
		mstNationalityDAO.save(mstNationality);
	}

	@Override
	public void update(MstNationality mstNationality) {
		mstNationalityDAO.update(mstNationality);
	}

	@Override
	public void saveOrUpdate(MstNationality mstNationality) {
		mstNationalityDAO.saveOrUpdate(mstNationality);
	}

	@Override
	public void delete(MstNationality mstNationality) {
		mstNationalityDAO.delete(mstNationality);
	}

	@Override
	public List<MstNationality> getAllMstNationality() {
		return mstNationalityDAO.getAllMstNationality();
	}

	@Override
	public List<MstNationality> getByRequestMap(HashMap<String, Object> hashMap) {
		return mstNationalityDAO.getByRequestMap(hashMap);
	}

	@Override
	public List<MstNationality> getMstNationalityPaging(HashMap<String, Object> hashMap) {
		return mstNationalityDAO.getMstNationalityPaging(hashMap);
	}

	@Override
	public int getCountMstNationalities() {
		return mstNationalityDAO.getCountMstNationalities();
	}

	public MstNationalityDAO getMstNationalityDAO() {
		return mstNationalityDAO;
	}

	public void setMstNationalityDAO(MstNationalityDAO mstNationalityDAO) {
		this.mstNationalityDAO = mstNationalityDAO;
	}
}