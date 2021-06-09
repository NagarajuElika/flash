package com.slokam.healthcare.entity; 
 import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne; 
@Entity 
public class Patient implements Serializable { 

@Id 
 @GeneratedValue 
  private Integer  id;
  private String  name;
  private Integer  age;
   @ManyToOne() 
@JoinColumn(name="fkid17") 
   private Gender  gender;
  private Long  phone;
  private String  email;
  private Date regDate;
  
public Date getRegDate() {
	return regDate;
}
public void setRegDate(Date regDate) {
	this.regDate = regDate;
}
public Integer getId() {
		return id;
	}
public void setId(Integer id) {
		this.id = id;
	}
public String getName() {
		return name;
	}
public void setName(String name) {
		this.name = name;
	}
public Integer getAge() {
		return age;
	}
public void setAge(Integer age) {
		this.age = age;
	}
public Gender getGender() {
		return gender;
	}
public void setGender(Gender gender) {
		this.gender = gender;
	}
public Long getPhone() {
		return phone;
	}
public void setPhone(Long phone) {
		this.phone = phone;
	}
public String getEmail() {
		return email;
	}
public void setEmail(String email) {
		this.email = email;
	}
}