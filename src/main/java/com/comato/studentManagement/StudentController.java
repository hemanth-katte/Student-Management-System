package com.comato.studentManagement;


import org.springframework.web.bind.annotation.*;

import java.util.HashMap;


@RestController  //telling java this class contains APIs
public class StudentController {
    //database
    HashMap<Integer,Student> studentDB = new HashMap<>();

    //add student
    @PostMapping("/add_student")
    public String addStudent(@RequestBody() Student student){
        //add it to our DB

        int key = student.id;

        studentDB.put(key,student);

        return "Student added successfully!";
    }

    //get student details by id
    @GetMapping("/get_by_id")
    public Student getStudentByAdmNo(@RequestParam("id") Integer id){

        Student student = studentDB.get(id);
        return student;
    }


    //get student details by name
    @GetMapping("/get_student_by_name")
    public Student getByName(@RequestParam("name") String name){
        for(int id : studentDB.keySet()){
            Student s = studentDB.get(id);
            if(s.name.equals(name))
                return s;
        }
        return null;
    }

    //get student details by path variable
    @GetMapping("/get_by_path/{id}")
    public Student getByPath(@PathVariable("id")Integer id){
        return studentDB.get(id);
    }



    //delete student detail
    @DeleteMapping("/delete_student")
    public String deleteStudent(@RequestParam("id") Integer id){
        studentDB.remove(id);
        return "Student with id " + id + " succesfully deleted";
    }

    //update student details
    @PutMapping("/update_DB")
    public String updateInfo(@RequestBody() Student student){
        int id = student.id;
        studentDB.put(id,student);

        return "Successfully updated the DB";

    }


}
