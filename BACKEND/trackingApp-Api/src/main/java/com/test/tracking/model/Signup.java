package com.test.tracking.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "users")
public class Signup {
	
	@Id
    private String email;//m
	private String userName;//m
	private String occupation;//m
	private String companyName;
	private String contactNo;
	private String password;//m
	
	//tenantId-m(backend will generate)
	//createdTime(system time)
	//createdBy(backend assigned)
	//updateTime(backend assigned)
	//updatedBy(not given by use then backend assigned)
	//lastLoginTime(system time)
	//lastLogoutTime(system time)
	//userIpAddress(http session)
	
	
}
