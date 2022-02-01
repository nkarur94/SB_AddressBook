package com.addressbook.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.addressbook.entity.AddressBookEntity;

public interface AddressBookRepo extends JpaRepository<AddressBookEntity, Integer>{
	
	@Query(value="select * from contact_details where city = :city", nativeQuery=true)
	List <AddressBookEntity> findAddressbookByCity(@Param(value = "city") String city);

}
