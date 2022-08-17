package AuthRepository;


import model.Student;
import model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface TeacherRepository extends JpaRepository<Teacher,Integer> {

   // Create endpoint that takes teacher id and return one teacher (return bad request if teacher id is invalid
Teacher findTeacherById(Integer id);

  // Create endpoint that takes teacher salary and return all teachers who have this salaray or above

   List <Teacher>findTeacherBySalay(Integer salaray);


}
