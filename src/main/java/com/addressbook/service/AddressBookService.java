package com.addressbook.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.addressbook.DTO.DetailsDTO;
import com.addressbook.entity.AddressBookEntity;
import com.addressbook.exception.AddressBookException;
import com.addressbook.repository.AddressBookRepo;

@Service
public class AddressBookService implements IAddressBookService {
	

	@Autowired
	AddressBookRepo addressBookRepoInService;
	
	@Override
	public AddressBookEntity createAddressBookInService(DetailsDTO detailsDTO) {
		AddressBookEntity addressEntity = new AddressBookEntity (detailsDTO);
		addressBookRepoInService.save(addressEntity);
		return addressEntity;
	}

	@Override
	public List <AddressBookEntity> getAddressBookInService() {
		return addressBookRepoInService.findAll();
	}

	@Override
	public AddressBookEntity getAddressBookById(int slNo) {
		return addressBookRepoInService.
				findById(slNo).
				orElseThrow( () -> new AddressBookException("address with slno "+ slNo +" does not exist!!"));
	
	}

	@Override
	public AddressBookEntity updateAddressBookInService(int slNo, DetailsDTO detailsDTO) {
		AddressBookEntity addressEntity = new AddressBookEntity(detailsDTO);
		addressEntity.setSlNo(slNo);
		getAddressBookById(slNo);
		return addressBookRepoInService.save(addressEntity);

		}

	@Override
	public void deleteAddressBookInService(int slNo) {
		AddressBookEntity addressEntity = this.getAddressBookById(slNo);
		addressBookRepoInService.delete(addressEntity);
	}

	@Override
	public List<AddressBookEntity> getAddressBookByCity(String city) {
		
		return addressBookRepoInService.findAddressbookByCity(city);
	}

}
