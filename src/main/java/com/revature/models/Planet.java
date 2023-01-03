package com.revature.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "planets")
public class Planet {

	@Id
	@Column(name = "id")
	private int id;
	@Column(name = "name")
	private String planetName;
	@Column(name = "ownerid")
	private int ownerId;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPlanetName() {
		return planetName;
	}
	public void setPlanetName(String planetName) {
		this.planetName = planetName;
	}
	public int getOwnerId() {
		return ownerId;
	}
	public void setOwnerId(int ownerId) {
		this.ownerId = ownerId;
	}
	
	@Override
	public String toString() {
		return "Planet [id=" + id + ", planetName=" + planetName + ", ownerId=" + ownerId + "]";
	}

}

// import java.io.Serializable;
// import java.util.List;

// import lombok.Data;
// import lombok.NoArgsConstructor;

// @Data
// @NoArgsConstructor
// public class Planet {
	
// 	private int id;
// 	private String name;
// 	private int ownerId;
// }
