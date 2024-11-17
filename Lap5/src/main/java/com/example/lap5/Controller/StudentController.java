package com.example.lap5.Controller;

import com.example.lap5.Model.Student;
import com.example.lap5.Recaponse.Recaponse;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
////////serveer port 1212
@RestController
@RequestMapping("/api/v1/lap5")
public class StudentController {

    //Q1
    ArrayList<Student> students = new ArrayList<>();

    @PostMapping("/create")
    public Recaponse createStudent(@RequestBody Student student) {
        students.add(student);
        return new Recaponse("Add Student is successful");
    }

    @GetMapping("/display")
    public ArrayList<Student> getStudents() {
        return students;
    }

    @PutMapping("/update/{index}")
   public Recaponse updateStudent(@PathVariable int index,@RequestBody Student student) {
        students.set(index, student);
        return new Recaponse("Update Student is successful");
   }


   @DeleteMapping("delete/{id}")
   public Recaponse deleteStudent(@PathVariable int id) {

        for (Student student : students) {
            if (student.getId() == id) {
                students.remove(student);
                return new Recaponse("Delete Student is successful");
            }
        }
        return new Recaponse("Delete Student is not successful");
   }


   @GetMapping("/honors/{index}")
   public Recaponse gpaClassify(@PathVariable int index) {


            if(students.get(index).getGPA()>= 4.50){
                return new Recaponse(students.get(index).getName()+ ": He received first class honors");
            } else if (students.get(index).getGPA() >= 4.0 && students.get(index).getGPA() < 4.50) {
                return new Recaponse(students.get(index).getName()+ ": He received second class honors");
            }else
                return new Recaponse("He received no class honors");
   }

   @GetMapping("/average")
   public ArrayList<Student> averageGPA() {
        ArrayList<Student> averageGPA = new ArrayList<>();
        double average = 0;
        for (Student student : students) {
            average += student.getGPA();
        }
        average /= students.size();
        for (Student student : students) {
          if(student.getGPA() >= average){
              averageGPA.add(student);
          }
        }

        return averageGPA;
   }

   ///////////end Q1














}
