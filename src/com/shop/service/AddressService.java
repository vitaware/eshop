package com.shop.service;

import java.util.List;

import com.shop.domain.Address;

public interface AddressService {

	public List<Address> getAllAddress(String parentid);
}
