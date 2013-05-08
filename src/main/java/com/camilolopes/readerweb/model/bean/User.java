package com.camilolopes.readerweb.model.bean;

// default package
// Generated 03/03/2013 11:57:14 by Hibernate Tools 4.0.0

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

import com.camilolopes.readerweb.enums.StatusUser;

/**
 * User generated by hbm2java
 */
@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = "EMAIL"))
public class User implements java.io.Serializable {

	private static final long serialVersionUID = -4033798753655592643L;
	private long id;
	private String name;
	private String lastname;
	private String email;
	private String password;
	private StatusUser status;
	private Date registerDate;
	private Set<Type> types = new HashSet<Type>();
	
	private Date expirationDate;

	public User() {
	}

	public User(int id) {
		this.id = id;
	}

	public User(int id, String name, String lastname, String email,
			String password, StatusUser status, Date registerDate, Set<Type> types, Date expirationDate) {
		this.id = id;
		this.name = name;
		this.lastname = lastname;
		this.email = email;
		this.password = password;
		this.status = status;
		this.registerDate = registerDate;
		this.types = types;
		this.expirationDate = expirationDate;
	}

	@Id
	@Column(name = "id", unique = true, nullable = false)
	@GeneratedValue
	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Column(name = "NAME", length = 45)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "LASTNAME", length = 45)
	public String getLastname() {
		return this.lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	@Column(name = "EMAIL", unique = true, length = 45)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "PASSWORD", length = 45)
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "STATUS", length = 45)
	@Enumerated(EnumType.STRING)
	public StatusUser getStatus() {
		return this.status;
	}

	public void setStatus(StatusUser status) {
		this.status = status;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "REGISTER_DATE", length = 0)
	public Date getRegisterDate() {
		return this.registerDate;
	}

	public void setRegisterDate(Date registerDate) {
		this.registerDate = registerDate;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
	public Set<Type> getTypes() {
		return this.types;
	}

	public void setTypes(Set<Type> types) {
		this.types = types;
	}
	@Temporal(TemporalType.DATE)
	@Column(name="EXPIRATION_DATE")	
	public Date getExpirationDate() {
		
		return expirationDate;
	}

	public void setExpirationDate(Date expirationDate) {
		this.expirationDate = expirationDate;
	}

}
