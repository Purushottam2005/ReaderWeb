package com.camilolopes.readerweb.model.bean;

// default package
// Generated 10/06/2013 22:40:38 by Hibernate Tools 4.0.0

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

/**
 * Type generated by hbm2java
 */
@Entity
@Table(name = "type")
public class Type implements java.io.Serializable {

	private static final long serialVersionUID = 2644022136811709451L;
	
	private long id;
	private String description;
	private Set<User> users = new HashSet<User>();

	public Type() {
	}

	public Type(int id) {
		this.id = id;
	}

	public Type(int id, String description, Set<User> users) {
		this.id = id;
		this.description = description;
		this.users = users;
	}

	@Id
	@GeneratedValue
	@Column(name = "ID", unique = true, nullable = false)
	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Column(name = "DESCRIPTION", length = 45)
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "type",  targetEntity=User.class)
	@Cascade({CascadeType.SAVE_UPDATE})
	public Set<User> getUsers() {
		return this.users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

}
