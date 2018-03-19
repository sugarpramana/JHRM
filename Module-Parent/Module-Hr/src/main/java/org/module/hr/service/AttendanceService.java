package org.module.hr.service;

import java.util.HashMap;
import java.util.List;

import org.module.hr.model.MstCustomer;
import org.module.hr.model.MstProject;

/**
*
* @author formulateko@admin.com
*/
public interface AttendanceService {
	/*- Customer +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
	public void save(MstCustomer mstCustomer);
    public void update(MstCustomer mstCustomer);
    public void saveOrUpdate(MstCustomer mstCustomer);
    public void delete(MstCustomer mstCustomer);
    public List<MstCustomer> getAllMstCustomers();
    public List<MstCustomer> getByMstCustomerRequestMap(HashMap<String, Object> hashMap);
    public List<MstCustomer> getMstCustomerPaging(HashMap<String, Object> hashMap);
    public int getCountMstCustomers();
    
	/*- Project +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
    public void save(MstProject mstProject);
    public void update(MstProject mstProject);
    public void saveOrUpdate(MstProject mstProject);
    public void delete(MstProject mstProject);
    public List<MstProject> getAllMstProjects();
    public List<MstProject> getByMstProjectRequestMap(HashMap<String, Object> hashMap);
    public List<MstProject> getMstProjectPaging(HashMap<String, Object> hashMap);
    public int getCountMstProjects();
}