package org.module.hr.dao;

import java.util.HashMap;
import java.util.List;

import org.module.hr.model.MstNationality;

public interface MstNationalityDAO {
	public void save(MstNationality mstNationality);
    public void update(MstNationality mstNationality);
    public void saveOrUpdate(MstNationality mstNationality);
    public void delete(MstNationality mstNationality);
    public List<MstNationality> getAllMstNationality();
    public List<MstNationality> getByRequestMap(HashMap<String, Object> hashMap);
    public List<MstNationality> getMstNationalityPaging(HashMap<String, Object> hashMap);
    public int getCountMstNationalities();
}