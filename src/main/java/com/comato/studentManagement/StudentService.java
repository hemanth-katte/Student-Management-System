package com.comato.studentManagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    public String addStudent(Student student){

        return studentRepository.addStudent(student);

    }

    public Student getByID(Integer id){

        return studentRepository.getByID(id);

    }

    public Student getByName(String name){

        return studentRepository.getByName(name);

    }

    public String deleteStudent(Integer id){

        return studentRepository.deleteStudent(id);

    }

    public String updateStudent(Student student){

        return studentRepository.updateDB(student);

    }

}
