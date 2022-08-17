package Controller;


import Service.ServiceStudent;
import dto.ApiResponse;
import lombok.RequiredArgsConstructor;
import model.Student;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.w3c.dom.stylesheets.LinkStyle;

import javax.swing.*;
import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("api/v1/student")

@RequiredArgsConstructor
public class ControlrStudent {

    private final ServiceStudent serviceStudent;


   @GetMapping("/Student")
  public ResponseEntity<List> getStudent(){
     List<Student> studentList=serviceStudent.getStudent();
     return ResponseEntity.status(200).body(studentList);}


    @PostMapping("/Student")
    public ResponseEntity<ApiResponse>addStudent(@RequestBody @Valid Student student){
       serviceStudent.addStudent(student);
       return ResponseEntity.status(201).body(new ApiResponse("new Student add",201));
    }
    @PostMapping("/Student/{id}")
    public ResponseEntity<ApiResponse>updataStudent(@RequestBody @Valid Student student,@PathVariable Integer id){
       serviceStudent.updataStudent(student,id);
        return ResponseEntity.status(201).body(new ApiResponse("new Student updata",201));
    }
    @DeleteMapping("/Student/{id}")
    public ResponseEntity<ApiResponse>deletStudent(@PathVariable Integer id){
       serviceStudent.deletStudent(id);
        return ResponseEntity.status(201).body(new ApiResponse("aup",201));

    }

    @GetMapping("/Student/id")
    public ResponseEntity<Student>getStudentByid(@RequestParam Integer id){
       Student student=serviceStudent.getStudentByid(id);
       return ResponseEntity.status(200).body(student);
    }
    @GetMapping("/Student/name")
    private ResponseEntity<Student>getStudentBtname(@RequestBody String name){
       Student student=serviceStudent.getStudentByname(name);
       return ResponseEntity.status(200).body(student);
    }
    //getStudentBymajor
    @GetMapping("/major")
    private ResponseEntity<List>getStudentBymajor(@RequestBody String major){
       List<Student>student=serviceStudent.getStudentBymajor(major);
        return ResponseEntity.status(200).body(student);

    }

@GetMapping("/age")
    private  ResponseEntity<List>getStudentsByAge(@RequestBody Integer age) {

    List<Student> students = serviceStudent.getStudentsByAge(age);
    return ResponseEntity.status(200).body(students);
}

    }



