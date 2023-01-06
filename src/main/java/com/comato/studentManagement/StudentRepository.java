package com.comato.studentManagement;

import org.springframework.stereotype.Repository;

import java.util.HashMap;

@Repository
public class StudentRepository {

    HashMap<Integer,Student> studentDB = new HashMap<>();

    public String addStudent(Student student){

        int id = student.id;

        studentDB.put(id,student);

        return "Successfully added the student";

    }

    public Student getByID(Integer id){

        return studentDB.get(id);

    }

    public Student getByName(String name){

        for(Student s : studentDB.values()){

            if(s.name.equals(name))
                return s;

        }

        return null;
    }

    public String deleteStudent(Integer id){

        if(studentDB.containsKey(id)) {

            studentDB.remove(id);
            return "Successfully Deleted!";

        }

        return "Student ID not found";
    }

    public String updateDB(Student student){

        int id = student.id;

        studentDB.put(id,student);

        return "Student details updated successfully!";
    }

}
