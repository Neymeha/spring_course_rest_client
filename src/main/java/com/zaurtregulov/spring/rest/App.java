package com.zaurtregulov.spring.rest;

import com.zaurtregulov.spring.rest.configuration.MyConfig;
import com.zaurtregulov.spring.rest.entity.Employee;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

/**
 * Hello world!
 *
 */
public class App {
    public static void main( String[] args ) {
        AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(MyConfig.class);
        Communication communication=context.getBean("communication", Communication.class);
        List<Employee> allEmployees=communication.getAllEmployees();
        System.out.println(allEmployees);

        Employee employeeById=communication.getEmployee(1);
        System.out.println(employeeById);

        Employee newEmp=new Employee("Sveta","Sokolova","IT",1200);
        newEmp.setId(10);
        communication.saveEmployee(newEmp);

        communication.deleteEmployee(10);
    }
}
