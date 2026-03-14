package com.klu;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainAppConstructor {

    public static void main(String[] args) {

        ApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        StudentConstructor student = context.getBean(StudentConstructor.class);
        student.displayStudent();
    }
}