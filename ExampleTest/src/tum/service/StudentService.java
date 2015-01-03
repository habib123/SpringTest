package tum.service;



import java.util.List;

import tum.spring.Student;


public interface StudentService {
	
	public Student create(Student student);
	public List<Student> findAll();
	public Student findById(int id);

	public void update(Student id);
	public void delete(Integer id);
	public List<Student> findByName(String string);
	

}
