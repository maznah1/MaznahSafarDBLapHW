package Service;

import AipException.AipException;
import AuthRepository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import model.Student;
import model.Teacher;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ServiceTeacher {

    private final TeacherRepository teacherRepository;

    public List<Teacher> getTeacher() {
        return teacherRepository.findAll();
    }

    public void addTeacher(Teacher teacher) {
        teacherRepository.save(teacher);
    }

    public void updataTeacher(Teacher teacher, Integer id) {
        Teacher oldTeacher = teacherRepository.getById(id);
        oldTeacher.setName(teacher.getName());
        oldTeacher.setSalay(teacher.getSalay());
        teacherRepository.save(teacher);
    }

    public void deletTeacher(Integer id) {
        Teacher teacherr = teacherRepository.getById(id);
        teacherRepository.delete(teacherr);

    }

    public Teacher getTeacherById(Integer id) {

        Teacher teacher = teacherRepository.findTeacherById(id);
        if (teacher == null) {
            throw new AipException("wrong T id ");
       }
            return teacher;
  }


    public List<Teacher> getTecherBysalary(Integer salaty) {
        List<Teacher> teacherList=teacherRepository.findTeacherBySalay(salaty);
        return teacherList;

    }
}




