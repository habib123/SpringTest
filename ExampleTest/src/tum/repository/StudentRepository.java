package tum.repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import tum.spring.*;


public interface StudentRepository extends JpaRepository<Student, Integer>{

	 @Query("SELECT s FROM Student s WHERE LOWER(s.name) = LOWER(:string1)")
	public List<Student> findByName1(@Param("string1") String string);
}
