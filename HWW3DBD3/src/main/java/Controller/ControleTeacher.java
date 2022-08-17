package Controller;
import Service.ServiceTeacher;
import dto.ApiResponse;
import lombok.RequiredArgsConstructor;
import model.Student;
import model.Teacher;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("api/v1/Teacher")
@RequiredArgsConstructor
public class ControleTeacher {

    private final ServiceTeacher serviceTeacher;

    @GetMapping("/Teacher")
    public ResponseEntity<List> getTeacher() {
        List<Teacher> teacherList = serviceTeacher.getTeacher();
        return ResponseEntity.status(200).body(teacherList);
    }


    @PostMapping("/Teacher")
    public ResponseEntity<ApiResponse> addTeacher(@RequestBody @Valid Teacher teacher) {
        serviceTeacher.addTeacher(teacher);
        return ResponseEntity.status(201).body(new ApiResponse("new teacher add", 201));

    }

    @PostMapping("/Teacher/{id}")
    public ResponseEntity<ApiResponse> updataTeacher(@RequestBody @Valid Teacher teacher, @PathVariable Integer id) {
        serviceTeacher.updataTeacher(teacher, id);
        return ResponseEntity.status(201).body(new ApiResponse("new Teacher updata", 201));

    }

    @DeleteMapping("/Teacher/{id}")
    public ResponseEntity<ApiResponse> deletTeacher(@PathVariable Integer id) {
        serviceTeacher.deletTeacher(id);
        return ResponseEntity.status(201).body(new ApiResponse("deletTeacher p", 201));

    }
//
//    @GetMapping("/Student/id")
//    public ResponseEntity<Student>getStudentByid(@RequestParam Integer id){
//        Student student=serviceStudent.getStudentByid(id);
//        return ResponseEntity.status(200).body(student);

//    @GetMapping("/Teacher/id")
//    public ResponseEntity<List> findTeacherById(@RequestParam Integer id){
//        List<Teacher> teacherList=serviceTeacher.getTeacher();
//        return ResponseEntity.status(200).body(teacherList);}


    @GetMapping("/Teacher/id")
    public ResponseEntity<Teacher> findTeacherById(@RequestParam Integer id) {
        Teacher teacher = serviceTeacher.getTeacherById(id);
        return ResponseEntity.status(200).body(teacher);

    }
//    @GetMapping("/major")
//    private ResponseEntity<List>getStudentBymajor(@RequestBody String major){
//        List<Student>student=serviceStudent.getStudentBymajor(major);
//        return ResponseEntity.status(200).body(student);
//
//    }

    @GetMapping("/ salary")
    public  ResponseEntity<List>getTecherBysalary(@RequestParam Integer salaty){

        List<Teacher>teacherList=serviceTeacher.getTecherBysalary(salaty);
        return ResponseEntity.status(200).body(teacherList);
    }

}

