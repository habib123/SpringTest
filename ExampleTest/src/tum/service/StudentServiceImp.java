package tum.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tum.repository.StudentRepository;
import tum.spring.Student;

@Service
public class StudentServiceImp implements StudentService{

	
	@Resource
	private StudentRepository studentRepository;
	
	@Override
	@Transactional
	public Student create(Student student) {
		Student createStudent = student;
		return studentRepository.save(createStudent);
	}

	@Override
	@Transactional
	public List<Student> findAll() {
		
		return studentRepository.findAll();
	}

	@Override
	@Transactional
	public Student findById(int id) {
		// TODO Auto-generated method stub
		return studentRepository.findOne(id);
	}

	@Override
	@Transactional
	public void update(Student student) {
	Student studentUpdate =	studentRepository.findOne(student.getId());
	if(studentUpdate ==  null)
		System.out.print("Error");
	
	studentUpdate.setName(student.getName());
	studentUpdate.setPassword(student.getPassword());
	
		
	}

	@Override
	@Transactional
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		studentRepository.delete(id);
	}

	@Override
	public List<Student> findByName(String string) {
		// TODO Auto-generated method stub
		return studentRepository.findByName1(string);
	}




}
