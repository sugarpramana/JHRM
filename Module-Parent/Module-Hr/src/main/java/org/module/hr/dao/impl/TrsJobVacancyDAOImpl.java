package org.module.hr.dao.impl;

import java.util.HashMap;
import java.util.List;

import org.module.api.common.dao.base.BasisDAO;
import org.module.hr.dao.TrsJobVacancyDAO;
import org.module.hr.model.TrsJobVacancy;

/**
*
* @author formulateko@admin.com
*/
@SuppressWarnings("unchecked")
public class TrsJobVacancyDAOImpl extends BasisDAO<TrsJobVacancy> implements TrsJobVacancyDAO{
	
	@Override
	public List<TrsJobVacancy> getAllTrsJobVacancy() {
		List<TrsJobVacancy> list = (List<TrsJobVacancy>) getHibernateTemplate().find("FROM TrsJobVacancy t");
		return list;
	}

	@Override
	public TrsJobVacancy getTrsJobVacancyById(Integer id) {
		return getHibernateTemplate().get(TrsJobVacancy.class, id);
	}
	
	@Override
	public List<TrsJobVacancy> getByRequest(HashMap<String, Object> params) {
		return getByRequestMap(params);
	}

	@Override
	public List<TrsJobVacancy> getTrsJobVacancyPaging(HashMap<String, Object> hashMap) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getCountTrsJobVacancys() {
		// TODO Auto-generated method stub
		return 0;
	}
}