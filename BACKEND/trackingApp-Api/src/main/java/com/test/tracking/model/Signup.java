package com.test.tracking.model;

import java.time.LocalDateTime;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
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
    @Email(message = "Invalid email format")
    @NotNull(message = "Email is required")
    private String email;

    @NotNull(message = "Username cannot be null")
    @Size(min = 3, message = "Username must be at least 3 characters long")
    private String userName;

    @NotNull(message = "Occupation cannot be null")
    private String occupation;

    private String companyName;

    @Pattern(regexp = "^[0-9]{10}$", message = "Contact number must be a valid 10-digit number")
    private String contactNo;

    @NotNull(message = "Password cannot be null")
    @Size(min = 8, max = 16, message = "Password must be between 8 to 16 characters")
    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,16}$", 
             message = "Password must contain at least one letter, one number, and one special character")
    private String password;

    private LocalDateTime createdTime;
    private String createdBy;
    private LocalDateTime updateTime;
    private String updateBy;
    private LocalDateTime lastLoginTime;
    private LocalDateTime lastLogoutTime;
    private String userIpAddress;
}



//tenantId-m(backend will generate)
	//createdTime(system time)
	//createdBy(backend assigned)
	//updateTime(backend assigned)
	//updatedBy(not given by use then backend assigned)
	//lastLoginTime(system time)
	//lastLogoutTime(system time)
	//userIpAddress(http session)
