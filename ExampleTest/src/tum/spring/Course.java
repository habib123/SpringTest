package tum.spring;

import javax.persistence.*;

@Entity
@Table(name = "courses")
public class Course {
	
	@Id
	@GeneratedValue
	private Integer id;

	private String courseName;


	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}



}
