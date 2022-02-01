package com.addressbook.service;

import java.util.List;

import com.addressbook.DTO.DetailsDTO;
import com.addressbook.entity.AddressBookEntity;

public interface IAddressBookService {
	
	AddressBookEntity createAddressBookInService(DetailsDTO detailsDTO);
	List<AddressBookEntity> getAddressBookInService();
	AddressBookEntity getAddressBookById(int id);
	AddressBookEntity updateAddressBookInService(int id, DetailsDTO detailsDTO);
	void deleteAddressBookInService(int slNo);
	List<AddressBookEntity> getAddressBookByCity(String city);

}
