package com.shop.service.impl;

import java.util.List;

import com.shop.domain.Address;
import com.shop.dao.AddressDao;
import com.shop.dao.impl.AddressDaoImpl;
import com.shop.service.AddressService;

public class AddressServiceImpl implements AddressService {

	AddressDao dao = new AddressDaoImpl();
	public List<Address> getAllAddress(String parentid) {
		
		return dao.getAllAddress(parentid);
	}

}
