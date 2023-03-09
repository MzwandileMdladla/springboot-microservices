package za.co.jengo.springbbootrestapi.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import za.co.jengo.springbbootrestapi.bean.Student;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/v1/students")
public class StudentController {

    @GetMapping
    public ResponseEntity getStudents() {
        List students = new ArrayList<>();
        students.add(new Student(2, "Super","Mario"));
        students.add(new Student(3, "Langa","Mdladla"));

        return ResponseEntity.ok()
                .header("custom-header", "Langa")
                .body(students);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable int id) {
        return ResponseEntity.ok(new Student(id, "Mzwandile", "Mdladla"));
    }

    @GetMapping("/query")
    public ResponseEntity<Student> getStudentId(@RequestParam int id) {
        return ResponseEntity.ok(new Student(id, "Mzwandile", "Mdladla"));
    }

    @PostMapping
    public ResponseEntity<Student> createStudent(@RequestBody Student student) {
        return new ResponseEntity<>(student, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Student> updateStudent(@RequestBody Student student, @PathVariable int id) {
        return ResponseEntity.ok(student);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable int id) {
        return ResponseEntity.ok("Student deleted.");
    }
}
