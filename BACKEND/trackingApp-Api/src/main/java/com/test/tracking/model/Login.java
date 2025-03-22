package com.test.tracking.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "Login")
public class Login {
	
	@Id
	private String tenantId;
	private String userId;
	private String password;
	private String occupation;
	private Integer status;
}
