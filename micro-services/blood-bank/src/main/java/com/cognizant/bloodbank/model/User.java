package com.cognizant.bloodbank.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Entity
@Table(name = "user")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "us_id")
	private int id;

	@NotNull
	@Size(min = 2, message = "Atleast 2 characters are required")
	@Column(name = "us_username")
	String username;

	@NotNull
	@Size(min = 2, message = "Atleast 2 characters are required")
	@Column(name = "us_firstname")
	String firstname;

	@NotNull
	@Size(min = 2, message = "Atleast 2 characters are required")
	@Column(name = "us_lastname")
	String lastname;

	@NotNull
	@Column(name = "us_password")
	String password;
	
	@NotNull
	@Column(name = "us_age")
	int age;
	
	@NotNull
	@Column(name = "us_gender")
	String gender;
	
	@NotNull
	@Column(name = "us_contact_no")
	Long contactNo;
	
	@NotNull
	@Column(name = "us_email")
	String email;
	
	@NotNull
	@Column(name = "us_weight")
	int weight;
	
	@NotNull
	@Column(name = "us_state")
	String state;
	
	@NotNull
	@Column(name = "us_area")
	String area;
	
	@NotNull
	@Column(name = "us_pin_code")
	int pinCode;
	
	@NotNull
	@Column(name = "us_blood_group")
	String bloodGroup;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "ur_us_id"), 
		inverseJoinColumns = @JoinColumn(name = "ur_ro_id"))
	private Set<Role> roleList;

	private static final Logger LOGGER = LoggerFactory.getLogger(User.class);

	public User() {
		LOGGER.info("START");
	}

	public User(int id, @NotNull @Size(min = 2, message = "Atleast 2 characters are required") String username,
			@NotNull @Size(min = 2, message = "Atleast 2 characters are required") String firstname,
			@NotNull @Size(min = 2, message = "Atleast 2 characters are required") String lastname,
			@NotNull String password, @NotNull int age, @NotNull String gender, @NotNull Long contactNo,
			@NotNull String email, @NotNull int weight, @NotNull String state, @NotNull String area,
			@NotNull int pinCode, @NotNull String bloodGroup, Set<Role> roleList) {
		super();
		this.id = id;
		this.username = username;
		this.firstname = firstname;
		this.lastname = lastname;
		this.password = password;
		this.age = age;
		this.gender = gender;
		this.contactNo = contactNo;
		this.email = email;
		this.weight = weight;
		this.state = state;
		this.area = area;
		this.pinCode = pinCode;
		this.bloodGroup = bloodGroup;
		this.roleList = roleList;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Long getContactNo() {
		return contactNo;
	}

	public void setContactNo(Long contactNo) {
		this.contactNo = contactNo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public int getPinCode() {
		return pinCode;
	}

	public void setPinCode(int pinCode) {
		this.pinCode = pinCode;
	}

	public String getBloodGroup() {
		return bloodGroup;
	}

	public void setBloodGroup(String bloodGroup) {
		this.bloodGroup = bloodGroup;
	}

	public Set<Role> getRoleList() {
		return roleList;
	}

	public void setRoleList(Set<Role> roleList) {
		this.roleList = roleList;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", firstname=" + firstname + ", lastname=" + lastname
				+ ", password=" + password + ", age=" + age + ", gender=" + gender + ", contactNo=" + contactNo
				+ ", email=" + email + ", weight=" + weight + ", state=" + state + ", area=" + area + ", pinCode="
				+ pinCode + ", bloodGroup=" + bloodGroup + "]";
	}

}