package com.example.nimbus;

import com.example.nimbus.entities.DepartmentEntity;
import com.example.nimbus.entities.StudentEntity;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class StudentEntityMockingTests {

    StudentEntity student = mock(StudentEntity.class);

    @Test
    public void checkStudentDepartmentIsNull(){
        StudentEntityMocking studentServiceMocking = new StudentEntityMocking();
        when(this.student.getDepartment()).thenReturn(new DepartmentEntity(1,"TestingDepartment"));
        studentServiceMocking.setStudent(student);
        Assertions.assertEquals(1,studentServiceMocking.checkStudentDepartmentIsNull());

    }
}
