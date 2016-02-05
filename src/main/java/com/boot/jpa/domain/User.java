package com.boot.jpa.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "user")
@Data
public class User {

	@Id
	@GeneratedValue
	@Column(name = "uno")
	private Long userNo;

	@Column(name = "user_type")
	@Enumerated(EnumType.STRING)
	private USER_TYPE type;
	
	@OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
	private UserInfo userInfo;
	
	public enum USER_TYPE {USER, ADMIN};
}
