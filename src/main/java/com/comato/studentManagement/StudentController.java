package com.comato.studentManagement;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;


@RestController  //telling java this class contains APIs
public class StudentController {
    //database
    //HashMap<Integer,Student> studentDB = new HashMap<>();

    @Autowired
    StudentService studentService;

    //add student
    @PostMapping("/add_student")
    public ResponseEntity<String> addStudent(@RequestBody() Student student){
        //add it to our DB

        String ret = studentService.addStudent(student);

        return new ResponseEntity<>(ret, HttpStatus.CREATED);

    }

    //get student details by id
    @GetMapping("/get_by_id")
    public ResponseEntity<Student> getStudentByAdmNo(@RequestParam("id") Integer id){

        Student student = studentService.getByID(id);

        if(student != null)
            return new ResponseEntity<>(student,HttpStatus.OK);

        return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);

    }


    //get student details by name
    @GetMapping("/get_student_by_name")
    public ResponseEntity<Student> getByName(@RequestParam("name") String name){

        Student student = studentService.getByName(name);

        if(student != null)
            return new ResponseEntity<>(student,HttpStatus.OK);

        return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);

    }

    //get student details by path variable
   /* @GetMapping("/get_by_path/{id}")
    public Student getByPath(@PathVariable("id")Integer id){
        return studentDB.get(id);
    }*/



    //delete student detail
    @DeleteMapping("/delete_student")
    public ResponseEntity<String> deleteStudent(@RequestParam("id") Integer id){

        String ret = studentService.deleteStudent(id);

        if(ret.equals("Successfully Deleted!"))
            return new ResponseEntity<>(ret,HttpStatus.OK);

        return new ResponseEntity<>(ret,HttpStatus.NOT_FOUND);

    }

    //update student details
    @PutMapping("/update_DB")
    public ResponseEntity<String> updateInfo(@RequestBody() Student student){

        String ret = studentService.updateStudent(student);

        return new ResponseEntity<>(ret,HttpStatus.OK);

    }


}
