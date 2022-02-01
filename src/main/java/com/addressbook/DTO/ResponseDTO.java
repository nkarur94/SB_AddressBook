package com.addressbook.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;


@AllArgsConstructor
public @Data class ResponseDTO {
	
	public String message;
	public Object data;
	
	public ResponseDTO(String message) {
		super();
		this.message = message;
	}
	
	
	
}

