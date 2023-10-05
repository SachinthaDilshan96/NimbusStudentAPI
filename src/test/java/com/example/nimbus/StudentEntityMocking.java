package com.example.nimbus;

import com.example.nimbus.entities.StudentEntity;


public class StudentEntityMocking {
    private StudentEntity student;

    public void setStudent(StudentEntity student){
        this.student = student;
    }

    public int checkStudentDepartmentIsNull(){
        if (this.student.getDepartment()!=null){
            System.out.println("student department is "+this.student.getDepartment().getDepartmentName());
            return 1;
        }else{
            System.out.println("student department is null");
            return -1;
        }
    }


}


