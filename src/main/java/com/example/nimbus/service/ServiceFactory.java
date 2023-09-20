package com.example.nimbus.service;

import com.example.nimbus.service.custom.impl.DepartmentServiceImpl;
import com.example.nimbus.service.custom.impl.StudentServiceImpl;

public class ServiceFactory {
    private static ServiceFactory serviceFactory;

    private ServiceFactory(){}

    public static ServiceFactory getInstance(){
        return serviceFactory==null?serviceFactory = new ServiceFactory():serviceFactory;
    }

    public SuperService getService(ServiceType serviceType){
        switch (serviceType){
            case STUDENT :
                return new StudentServiceImpl();
            case DEPARTMENT:
                return new DepartmentServiceImpl();
            default:
                return null;
        }
    }
    public enum ServiceType{
        STUDENT,DEPARTMENT
    }
}
