package org.module.hr.dao.impl;

import java.util.HashMap;
import java.util.List;

import org.module.api.common.dao.base.BasisDAO;
import org.module.hr.dao.TrsJobCandidateDAO;
import org.module.hr.model.TrsJobCandidate;

/**
*
* @author formulateko@admin.com
*/
@SuppressWarnings("unchecked")
public class TrsJobCandidateDAOImpl extends BasisDAO<TrsJobCandidate> implements TrsJobCandidateDAO {

	@Override
	public List<TrsJobCandidate> getAllTrsJobCandidate() {
		List<TrsJobCandidate> list = (List<TrsJobCandidate>) getHibernateTemplate().find("FROM TrsJobCandidate");
		return list;
	}

	@Override
	public TrsJobCandidate getTrsJobCandidateById(Integer id) {
		return getHibernateTemplate().get(TrsJobCandidate.class, id);
	}

	@Override
	public List<TrsJobCandidate> getByRequest(HashMap<String, Object> params) {
		return getByRequestMap(params);
	}

	@Override
	public List<TrsJobCandidate> getTrsJobCandidatePaging(HashMap<String, Object> hashMap) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getCountTrsJobCandidates() {
		// TODO Auto-generated method stub
		return 0;
	}
}