package org.module.hr.dao;

import java.util.HashMap;
import java.util.List;

import org.module.hr.model.MstJobtitle;

/**
*
* @author formulateko@admin.com
*/
public interface MstJobtitleDAO {
	public void save(MstJobtitle mstJobtitle);
    public void update(MstJobtitle mstJobtitle);
    public void saveOrUpdate(MstJobtitle mstJobtitle);
    public void delete(MstJobtitle mstJobtitle);
    public List<MstJobtitle> getAllMstJobtitles();
    public List<MstJobtitle> getByRequestMap(HashMap<String, Object> hashMap);
    public List<MstJobtitle> getMstJobtitlePaging(HashMap<String, Object> hashMap);
    public int getCountMstJobtitles();
}