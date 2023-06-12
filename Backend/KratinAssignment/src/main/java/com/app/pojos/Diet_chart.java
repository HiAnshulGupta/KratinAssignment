package com.app.pojos;



import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Entity
@Table(name = "Diet")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString

public class Diet_chart extends BaseEntity {

	@JsonBackReference
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="User_Id")
	private User userDetail ;
	
	private String meals;

}
