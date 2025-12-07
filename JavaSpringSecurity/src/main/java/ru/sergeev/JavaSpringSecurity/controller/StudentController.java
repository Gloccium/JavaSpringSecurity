package ru.sergeev.JavaSpringSecurity.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.sergeev.JavaSpringSecurity.entity.Student;
import ru.sergeev.JavaSpringSecurity.repository.StudentRepository;

import java.util.Optional;

@Slf4j
@Controller
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    @GetMapping("/list")
    public String getAllStudents(Model model) {
        log.info("list all students");
        model.addAttribute("students", studentRepository.findAll());
        return "list-students";
    }

    @GetMapping("/addStudentForm")
    public String addStudentForm(Model model) {
        model.addAttribute("student", new Student());
        return "add-student-form";
    }

    @PostMapping("/saveStudent")
    public String saveStudent(@ModelAttribute Student student) {
        studentRepository.save(student);
        return "redirect:/list";
    }

    @GetMapping("/showUpdateForm")
    public String showUpdateForm(@RequestParam("studentId") Long studentId,
                                 Model model) {
        Optional<Student> optionalStudent = studentRepository.findById(studentId);

        if (optionalStudent.isPresent()) {
            model.addAttribute("student", optionalStudent.get());
            return "add-student-form";
        } else {
            return "redirect:/list";
        }
    }

    @GetMapping("/deleteStudent")
    public String deleteStudent(@RequestParam("studentId") Long studentId) {
        studentRepository.deleteById(studentId);
        return "redirect:/list";
    }
}