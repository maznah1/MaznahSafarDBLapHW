package AuthRepository;


import model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface StudentRepository extends JpaRepository<Student,Integer> {
    Student findStudentById(Integer id );
  //  Create endpoint that takes student name and return one student (return bad request if student name is invalid)
    Student findStudentByname(String name);
   // Create endpoint that takes student major and return all students under this major (return bad request the major)

  List <Student> findStudentByMajor(String major);
  //  Create endpoint that takes student age and return all students who have this age or above
    List<Student>findStudentsByAge(Integer age);

}
