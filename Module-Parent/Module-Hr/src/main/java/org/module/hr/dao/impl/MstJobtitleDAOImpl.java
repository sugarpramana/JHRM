package org.module.hr.dao.impl;

import java.util.HashMap;
import java.util.List;

import org.module.api.common.dao.base.BasisDAO;
import org.module.hr.dao.MstJobtitleDAO;
import org.module.hr.model.MstJobtitle;
import org.springframework.dao.support.DataAccessUtils;

/**
*
* @author formulateko@admin.com
*/
@SuppressWarnings("unchecked")
public class MstJobtitleDAOImpl extends BasisDAO<MstJobtitle> implements MstJobtitleDAO{

	@Override
	public List<MstJobtitle> getAllMstJobtitles() {
		List<MstJobtitle>list = (List<MstJobtitle>) getHibernateTemplate().find("FROM MstJobtitle");
		return list;
	}
	
	@Override
	public List<MstJobtitle> getMstJobtitlePaging(HashMap<String, Object> hashMap) {
		List<MstJobtitle>list = (List<MstJobtitle>) getHibernateTemplate().findByExample(new MstJobtitle(), (Integer)hashMap.get("firstResult"), (Integer)hashMap.get("maxResults"));
		return list;
	}

	@Override
	public int getCountMstJobtitles() {
		return DataAccessUtils.intResult(getHibernateTemplate().find("SELECT COUNT(*) FROM MstJobtitle"));
	}
}