package org.module.hr.service.impl;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.module.hr.dao.TrsJobCandidateDAO;
import org.module.hr.dao.TrsJobVacancyDAO;
import org.module.hr.model.TrsJobCandidate;
import org.module.hr.model.TrsJobVacancy;
import org.module.hr.service.RecruitmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RecruitmentServiceImpl implements RecruitmentService{

	@Autowired
	private TrsJobVacancyDAO trsJobVacancyDAO;
	
	@Autowired
	private TrsJobCandidateDAO trsJobCandidateDAO;

	/* ------- Vacancy ---------*/
	@Override
	public void save(TrsJobVacancy trsJobVacancy) {
		trsJobVacancy.setDefinedTime(new Timestamp(new Date().getTime()));
		trsJobVacancy.setActive(Boolean.TRUE);
		trsJobVacancyDAO.save(trsJobVacancy);
	}

	@Override
	public void update(TrsJobVacancy trsJobVacancy) {
		trsJobVacancy.setUpdatedTime(new Timestamp(new Date().getTime()));
		trsJobVacancyDAO.update(trsJobVacancy);
	}

	@Override
	public void saveOrUpdate(TrsJobVacancy trsJobVacancy) {
		if (trsJobVacancy.getIdEmployee() == null) {
			trsJobVacancy.setDefinedTime(new Timestamp(new Date().getTime()));
		} else {
			trsJobVacancy.setUpdatedTime(new Timestamp(new Date().getTime()));
		}
		trsJobVacancyDAO.saveOrUpdate(trsJobVacancy);
	}

	@Override
	public void delete(TrsJobVacancy trsJobVacancy) {
		trsJobVacancy.setUpdatedTime(new Timestamp(new Date().getTime()));
		trsJobVacancy.setActive(Boolean.FALSE);
		trsJobVacancyDAO.update(trsJobVacancy);
	}

	@Override
	public List<TrsJobVacancy> getAllTrsJobVacancy() {
		return trsJobVacancyDAO.getAllTrsJobVacancy();
	}

	@Override
	public TrsJobVacancy getTrsJobVacancyById(Integer id) {
		return trsJobVacancyDAO.getTrsJobVacancyById(id);
	}

	@Override
	public List<TrsJobVacancy> getTrsJobVacancyByRequest(HashMap<String, Object> params) {
		return trsJobVacancyDAO.getByRequest(params);
	}
	
	public void setTrsJobVacancyDAO(TrsJobVacancyDAO trsJobVacancyDAO) {
		this.trsJobVacancyDAO = trsJobVacancyDAO;
	}
	
	
	/* ------- Candidate --------*/
	@Override
	public void save(TrsJobCandidate trsJobCandidate) {
		if (trsJobCandidate.getId() == null) {
			trsJobCandidate.setCreatedAt(new Date());
		}
		trsJobCandidateDAO.save(trsJobCandidate);
	}

	@Override
	public void update(TrsJobCandidate trsJobCandidate) {
		trsJobCandidate.setUpdatedAt(new Date());
		trsJobCandidateDAO.update(trsJobCandidate);
	}

	@Override
	public void saveOrUpdate(TrsJobCandidate trsJobCandidate) {
		trsJobCandidateDAO.saveOrUpdate(trsJobCandidate);
	}

	@Override
	public void delete(TrsJobCandidate trsJobCandidate) {
		trsJobCandidateDAO.delete(trsJobCandidate);
	}

	@Override
	public List<TrsJobCandidate> getAllTrsJobCandidate() {
		return trsJobCandidateDAO.getAllTrsJobCandidate();
	}

	@Override
	public TrsJobCandidate getTrsJobCandidateById(Integer id) {
		return trsJobCandidateDAO.getTrsJobCandidateById(id);
	}

	@Override
	public List<TrsJobCandidate> getTrsJobCandidateByRequest(HashMap<String, Object> params) {
		return trsJobCandidateDAO.getByRequest(params);
	}
	
	public void setTrsJobCandidateDAO(TrsJobCandidateDAO trsJobCandidateDAO) {
		this.trsJobCandidateDAO = trsJobCandidateDAO;
	}
	
}
