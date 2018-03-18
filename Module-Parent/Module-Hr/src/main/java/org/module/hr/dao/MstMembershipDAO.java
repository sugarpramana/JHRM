package org.module.hr.dao;

import java.util.HashMap;
import java.util.List;

import org.module.hr.model.MstMembership;

/**
*
* @author formulateko@admin.com
*/
public interface MstMembershipDAO {
	public void save(MstMembership mstMembership);
    public void update(MstMembership mstMembership);
    public void saveOrUpdate(MstMembership mstMembership);
    public void delete(MstMembership mstMembership);
    public List<MstMembership> getAllMstMembership();
    public List<MstMembership> getByRequestMap(HashMap<String, Object> hashMap);
    public List<MstMembership> getMstMembershipPaging(HashMap<String, Object> hashMap);
    public int getCountMstMemberships();
}