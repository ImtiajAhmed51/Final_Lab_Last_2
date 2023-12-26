package imtiaj.rest;


import imtiaj.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import imtiaj.service.StudentService;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentRestController {

    private final StudentService studentService;

    @Autowired
    public StudentRestController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping(path = "/students")
    public String addStudent(@RequestBody User student) {
        studentService.save(student);
        return "Successful";
    }

    @PutMapping(path = "/students")
    public String updateStudent(@RequestBody User student) {
        studentService.update(student);
        return "Successful";
    }

    @GetMapping(path = "/students")
    public List<User> listStudents() {
        return studentService.getAll();
    }

    @GetMapping(path = "/students/count")
    public int listStudentsCount() {
        return studentService.getAll().size();
    }

    @GetMapping(path="/students/{id}")
    public User showStudent(@PathVariable int id) {

        return studentService.get(id);
    }

    @GetMapping(path="/students/{id}/edit")
    public User showEditForm(@PathVariable int id) {
        return studentService.get(id);
    }

    @DeleteMapping(path = "/students/{id}")
    public String deleteStudent(@PathVariable int id) {
        studentService.delete(id);
        return "deleted";
    }
}