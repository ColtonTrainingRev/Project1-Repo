package com.revature.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "moons")
public class Moon {

	@Id
	@Column(name = "id")
	private int id;
	@Column(name = "name")
	private String name;
	@Column(name = "myplanetid")
	private int myPlanetId;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getMyPlanetId() {
		return myPlanetId;
	}
	public void setMyPlanetId(int myPlanetId) {
		this.myPlanetId = myPlanetId;
	}
	
	@Override
	public String toString() {
		return "Moon [id=" + id + ", name=" + name + ", myPlanetId=" + myPlanetId + "]";
	}
	
}

// import lombok.Data;
// import lombok.NoArgsConstructor;

// @Data
// @NoArgsConstructor
// public class Moon {
	
// 	private int id;
// 	private String name; 
// 	private int myPlanetId;
// }
