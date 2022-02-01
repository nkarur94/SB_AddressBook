package com.addressbook.controller;


import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.addressbook.DTO.DetailsDTO;
import com.addressbook.DTO.ResponseDTO;
import com.addressbook.entity.AddressBookEntity;
import com.addressbook.service.IAddressBookService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/addressbook")
@Slf4j
public class AddressBookController {
	
	@Autowired
	IAddressBookService addressBookService;
	
	@PostMapping("/createAB")
	public ResponseEntity<ResponseDTO> createAddressBook(@Valid @RequestBody DetailsDTO detailsDTO) {
		AddressBookEntity addressEntity  = addressBookService.createAddressBookInService(detailsDTO);
		log.debug("created address book");
		ResponseDTO response = new ResponseDTO("created address book", addressEntity);
		return new ResponseEntity<ResponseDTO>(response,HttpStatus.OK);
		}
	
	@GetMapping("/get")
	public ResponseEntity<ResponseDTO> getAddressBook() {
		List<AddressBookEntity> addressList= null;
		addressList = addressBookService.getAddressBookInService();
		ResponseDTO response = new ResponseDTO("view address book", addressList);
		return new ResponseEntity<ResponseDTO>(response, HttpStatus.OK);
	}
	
	@GetMapping("/get/{slNo}")
	public ResponseEntity<ResponseDTO> getByFirstName(@PathVariable int slNo) {
		AddressBookEntity addressEntity=addressBookService.getAddressBookById(slNo);
		ResponseDTO response = new ResponseDTO("view by slno", addressEntity);
		return new ResponseEntity<ResponseDTO>(response, HttpStatus.OK);
	}
	
	@GetMapping("/getC/{city}")
	public ResponseEntity<ResponseDTO> getAddressBookByCity(@PathVariable String city){
		List<AddressBookEntity> addressBookEntity= addressBookService.getAddressBookByCity(city);
		ResponseDTO response = new ResponseDTO("view by city",addressBookEntity);
		return new ResponseEntity<ResponseDTO>(response, HttpStatus.OK);
	}
	
	
	@PutMapping("/update/{slNo}")
	public ResponseEntity<ResponseDTO> updateAddressBookByName(@PathVariable int slNo, @Valid @RequestBody DetailsDTO deatilsDTO){
		AddressBookEntity addressEntity= addressBookService.updateAddressBookInService(slNo, deatilsDTO);
		ResponseDTO response = new ResponseDTO("updated", addressEntity);
		return new ResponseEntity<ResponseDTO>(response, HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{slNo}")
	public ResponseEntity<ResponseDTO> deleteAddressBookByName(@PathVariable int slNo) {
		addressBookService.deleteAddressBookInService(slNo);
		ResponseDTO response = new ResponseDTO("address book of "+ slNo + "has been deleted");
		return new ResponseEntity<ResponseDTO>(response, HttpStatus.OK);
	}
	
}
