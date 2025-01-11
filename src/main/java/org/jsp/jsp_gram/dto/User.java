package org.jsp.jsp_gram.dto;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Entity
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Size(min = 3, max = 10, message="It should be between 3 and 10 charecters")
	private String firstname;
	@Size(min = 1, max = 15, message="It should be between 3 and 10 charecters")
	private String lastname;
	@Size(min = 5, max = 15,message="It should be between 5 and 15 charecters")
	private String username;
	@Email(message="It should be proper Email format")
	@NotNull(message="It is required field")
	private String email;
	@DecimalMin(value = "6000000000",message = "It should be proper mobile number")
	@DecimalMax(value = "9999999999",message = "It should be proper mobile number")
	private long mobile;
	@NotNull(message="It is required field")
	private String gender;
	@Pattern(regexp = "^.*(?=.{8,})(?=..*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=]).*$",message = "It should contain atleast 8 charecter, one uppercase, one lowercase, one number and one speacial charecter")
	private String password;
	@Pattern(regexp = "^.*(?=.{8,})(?=..*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=]).*$",message = "It should contain atleast 8 charecter, one uppercase, one lowercase, one number and one speacial charecter")
	@Transient
	private String confirmpassword;
	private int otp;
	private boolean verified;
	private String bio;
	private String imageUrl;
}
