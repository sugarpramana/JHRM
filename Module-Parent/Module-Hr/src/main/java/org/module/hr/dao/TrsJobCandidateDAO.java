package org.module.hr.dao;

import java.util.HashMap;
import java.util.List;

import org.module.hr.model.TrsJobCandidate;

/**
*
* @author formulateko@admin.com
*/
public interface TrsJobCandidateDAO {
	public TrsJobCandidate getTrsJobCandidateById(Integer id);
	public void save(TrsJobCandidate trsJobCandidate);
    public void update(TrsJobCandidate trsJobCandidate);
    public void saveOrUpdate(TrsJobCandidate trsJobCandidate);
    public void delete(TrsJobCandidate trsJobCandidate);
    public List<TrsJobCandidate> getAllTrsJobCandidate();
	public List<TrsJobCandidate> getByRequest(HashMap<String, Object> params);
	public List<TrsJobCandidate> getTrsJobCandidatePaging(HashMap<String, Object> hashMap);
    public int getCountTrsJobCandidates();
}