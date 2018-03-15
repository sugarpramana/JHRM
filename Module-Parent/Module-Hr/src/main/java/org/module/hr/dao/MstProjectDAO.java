package org.module.hr.dao;

import java.util.HashMap;
import java.util.List;

import org.module.hr.model.MstProject;

public interface MstProjectDAO {
	public void save(MstProject mstProject);
    public void update(MstProject mstProject);
    public void saveOrUpdate(MstProject mstProject);
    public void delete(MstProject mstProject);
    public List<MstProject> getAllMstProjects();
    public List<MstProject> getByRequestMap(HashMap<String, Object> hashMap);
    public List<MstProject> getMstProjectPaging(HashMap<String, Object> hashMap);
    public int getCountMstProjects();
}
