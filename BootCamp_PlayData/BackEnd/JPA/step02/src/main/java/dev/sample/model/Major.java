package dev.sample.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Major {
	
	@Id // PK·Î ¸ÊÇÎ ¼³Á¤
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "major_id", nullable = false)
	private Long id; // MAJOR_ID
	
	@Column(name = "major_name", nullable = false)
	private String majorName; // MAJOR_NAME
	
	
	
	public Major() {}

	public Major(String majorName) {
		this.majorName = majorName;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getMajorName() {
		return majorName;
	}
	public void setMajorName(String majorName) {
		this.majorName = majorName;
	}

	@Override
	public String toString() {
		return "Major [id=" + id + ", majorName=" + majorName + "]";
	}
	
}
