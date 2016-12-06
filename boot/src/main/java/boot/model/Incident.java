package boot.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="incident")
public class Incident implements Serializable {
	
	
	private static final long serialVersionUID = 1L;
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="incident_id")
	private int incidentID;
	@Column(name="parent_id")
	private int parentID;
	@Column(length=60, name="search_id")
	private String searchID;
	@Column(length=60, name="name")
	private String name;

	
	public Incident(int parentID, String searchID,String name){
		super();
		this.parentID = parentID;
		this.searchID = searchID;
		this.name = name;
		
	}
	
	public Incident(){
		this(0, "", "");
	}
	
	

	public int getIncidentID() {
		return incidentID;
	}

	public void setIncidentID(int incidentID) {
		this.incidentID = incidentID;
	}

	public int getParentID() {
		return parentID;
	}

	public void setParentID(int parentID) {
		this.parentID = parentID;
	}

	public String getSearchID() {
		return searchID;
	}

	public void setSearchID(String searchID) {
		this.searchID = searchID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Incident [incidentID=" + incidentID + ", parentID=" + parentID + ", searchID=" + searchID + ", name="
				+ name + "]";
	}

	
}
