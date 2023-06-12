package com.app.pojos;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="UserDetails")


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString(exclude = "password")
public class User extends BaseEntity{
	
	@Column(length = 20)
	private String name;
	
	
	
	@Column(length = 100)
	private int age;
	
	@Column(length = 100)
	private String address;
	
	@Column(length = 20,unique = true)
	private String email;
	
	@Column(length = 20,nullable = false)
	private String password;
	
	private boolean check_age;
	
	public void cal_age() {
		this.check_age=this.age>65;
	}
	
	@JsonManagedReference
	@OneToOne(mappedBy = "userDetail",cascade = CascadeType.ALL,orphanRemoval = true,fetch = FetchType.EAGER)
	private Diet_chart diet;
	
}
