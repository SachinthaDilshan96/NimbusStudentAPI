package com.example.nimbus;

import com.example.nimbus.dao.custom.StudentDao;
import com.example.nimbus.entities.StudentEntity;
import com.example.nimbus.service.custom.StudentService;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.Optional;

import static org.mockito.Mockito.when;

public class StudentServiceMockingTests {
    @Mock
    StudentDao studentDao;

    @Test
    public void updateFirstName() throws Exception{
        StudentEntity student = new StudentEntity();
        student.setFirstName("FirstName");
        when(studentDao.findById(Mockito.anyInt())).thenReturn(Optional.of(student));
        //Assertions.assertEquals();
    }
}
