package org.module.hr.service;

import java.util.HashMap;
import java.util.List;

import org.module.hr.model.TrsJobCandidate;
import org.module.hr.model.TrsJobVacancy;

/**
*
* @author formulateko@admin.com
*/
public interface RecruitmentService {
	/*- Vacancy +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
	public void save(TrsJobVacancy trsJobVacancy);
    public void update(TrsJobVacancy trsJobVacancy);
    public void saveOrUpdate(TrsJobVacancy trsJobVacancy);
    public void delete(TrsJobVacancy trsJobVacancy);
    public List<TrsJobVacancy> getAllTrsJobVacancy();
    public TrsJobVacancy getTrsJobVacancyById(Integer id);
    public List<TrsJobVacancy> getTrsJobVacancyByRequest(HashMap<String, Object> params);
    
    /*- Candidate +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
	public void save(TrsJobCandidate trsJobCandidate);
    public void update(TrsJobCandidate trsJobCandidate);
    public void saveOrUpdate(TrsJobCandidate trsJobCandidate);
    public void delete(TrsJobCandidate trsJobCandidate);
    public List<TrsJobCandidate> getAllTrsJobCandidate();
    public TrsJobCandidate getTrsJobCandidateById(Integer id);
    public List<TrsJobCandidate> getTrsJobCandidateByRequest(HashMap<String, Object> params);
}