package org.module.hr.dao.impl;

import java.util.HashMap;
import java.util.List;

import org.module.api.common.dao.base.BasisDAO;
import org.module.hr.dao.MstCustomerDAO;
import org.module.hr.model.MstCustomer;
import org.springframework.dao.support.DataAccessUtils;

/**
*
* @author formulateko@admin.com
*/
@SuppressWarnings("unchecked")
public class MstCustomerDAOImpl extends BasisDAO<MstCustomer> implements MstCustomerDAO{

	@Override
	public List<MstCustomer> getAllMstCustomers() {
		List<MstCustomer>list = (List<MstCustomer>) getHibernateTemplate().find("FROM MstCustomer");
		return list;
	}

	@Override
	public List<MstCustomer> getMstCustomerPaging(HashMap<String, Object> hashMap) {
		List<MstCustomer>list = (List<MstCustomer>) getHibernateTemplate().findByExample(new MstCustomer(), (Integer)hashMap.get("firstResult"), (Integer)hashMap.get("maxResults"));
		return list;
	}

	@Override
	public int getCountMstCustomers() {
		return DataAccessUtils.intResult(getHibernateTemplate().find("SELECT COUNT(*) FROM MstCustomer"));
	}
}