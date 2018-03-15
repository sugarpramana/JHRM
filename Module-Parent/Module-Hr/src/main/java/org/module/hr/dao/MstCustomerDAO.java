package org.module.hr.dao;

import java.util.HashMap;
import java.util.List;

import org.module.hr.model.MstCustomer;

public interface MstCustomerDAO {
	public void save(MstCustomer mstCustomer);
    public void update(MstCustomer mstCustomer);
    public void saveOrUpdate(MstCustomer mstCustomer);
    public void delete(MstCustomer mstCustomer);
    public List<MstCustomer> getAllMstCustomers();
    public List<MstCustomer> getByRequestMap(HashMap<String, Object> hashMap);
    public List<MstCustomer> getMstCustomerPaging(HashMap<String, Object> hashMap);
    public int getCountMstCustomers();
}
