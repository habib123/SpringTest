package tum.spring;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import java.util.List;

@Entity
//@NamedQuery(name = "Student.findByName1",query = "select s from Student s where s.name = ?1")
@Table(name = "student")
public class Student {
	
	@Id
 	@GeneratedValue(strategy=GenerationType.AUTO)
 	private int id;
	
	private String name;
	
	private String password;
/*	@OneToMany(targetEntity=Course.class)
	private List courseList;*/
	
 
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
/*	public List getCourseList() {
		return courseList;
	}
	public void setCourseList(List courseList) {
		this.courseList = courseList;
	}*/

	



}
