package com.klu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Student {

    private final int id = 30418;
    private final String name = "Yeswanth";
    private final String gender = "Male";

    @Autowired
    private Certification certification;

    public void displayStudent() {
        System.out.println("Student ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Gender: " + gender);
        certification.displayCertification();
    }
}