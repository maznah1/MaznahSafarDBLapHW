package Service;

import AipException.AipException;
import AuthRepository.StudentRepository;
import lombok.RequiredArgsConstructor;
import model.Student;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ServiceStudent {

    private final StudentRepository studentRepository;

    public List<Student> getStudent() {
        return studentRepository.findAll();
    }

    public void addStudent(Student student) {
        studentRepository.save(student);
    }


    public void updataStudent(Student student, Integer id) {
        Student oldStudent = studentRepository.getById(id);
        oldStudent.setName(student.getName());
        oldStudent.setAge(student.getAge());
        //  oldStudent.getMajor(student.getMajor());
        studentRepository.save(oldStudent);

    }

    public void deletStudent(Integer id) {
        Student Studentts = studentRepository.getById(id);
        studentRepository.delete(Studentts);

    }

    public Student getStudentByid(Integer id) {
        Student student = studentRepository.findStudentById(id);
        if (student == null) {
            throw new AipException("wrong student id ");
        }
        return student;
    }

    public Student getStudentByname(String name) {
        Student student = studentRepository.findStudentByname(name);
        if (student == null) {
            throw new AipException("wrong name student");
        }
        return student;
    }

    public List<Student> getStudentBymajor(String major){
        List<Student> students=studentRepository.findStudentByMajor(major);
        if (students.isEmpty()){
            throw new AipException("wrong name major");
        }
        return students;
    }

    public List<Student> getStudentsByAge(Integer age) {
        List<Student> students=studentRepository.findStudentsByAge(age);
        return students;
    }
}



