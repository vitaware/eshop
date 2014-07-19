package com.shop.dao;

import java.util.List;

import com.shop.domain.Address;

public interface AddressDao {
	
	public List<Address> getAllAddress(String parentid);
}
