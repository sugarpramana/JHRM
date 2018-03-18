package org.module.hr.dao;

import java.util.HashMap;
import java.util.List;

import org.module.hr.model.MstEmployementStatus;

/**
*
* @author formulateko@admin.com
*/
public interface MstEmployementStatusDAO {
	public void save(MstEmployementStatus mstEmployementStatus);
    public void update(MstEmployementStatus mstEmployementStatus);
    public void saveOrUpdate(MstEmployementStatus mstEmployementStatus);
    public void delete(MstEmployementStatus mstEmployementStatus);
    public List<MstEmployementStatus> getAllMstEmployementStatus();
    public List<MstEmployementStatus> getByRequestMap(HashMap<String, Object> hashMap);
    public List<MstEmployementStatus> getMstEmployementStatusPaging(HashMap<String, Object> hashMap);
    public int getCountAllMstEmployementStatus();
}