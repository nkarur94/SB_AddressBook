package com.addressbook.entity;

import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;


import com.addressbook.DTO.DetailsDTO;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "contact_details")
public class AddressBookEntity {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="sl_no")
	private int slNo;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private  String lastName;
	
	@Column(name="address")
	private String address;
	
	@Column(name="city")
	private String city;
	
	@Column(name="state")
	private String state;
	
	@Column(name="zip_code")
	private String zipCode;
	
	@Column(name="e_mail")
	private String eMail;
	
	@ElementCollection
	@CollectionTable(name="phone_number",joinColumns = @JoinColumn(name="contact_no"))
	@Column(name="phone_no")
	private List<String> phoneNo;
	
	
	public AddressBookEntity(DetailsDTO detailsDTO) {
		this.updatedAddressBookDTO(detailsDTO);
	}
	
	public void updatedAddressBookDTO(DetailsDTO addresBookDTO) {
		this.firstName = addresBookDTO.firstName;
		this.lastName = addresBookDTO.lastName;
		this.address= addresBookDTO.address;
		this.city=addresBookDTO.city;
		this.state=addresBookDTO.state;
		this.zipCode=addresBookDTO.zipCode;
		this.eMail=addresBookDTO.eMail;
		this.phoneNo=addresBookDTO.phoneNo;
	}

}
