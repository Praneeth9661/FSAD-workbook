package com.klu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class StudentConstructor {

    private final int id = 30418;
    private final String name = "Yeswanth";
    private final String gender = "Male";

    private Certification certification;

    @Autowired
    public StudentConstructor(Certification certification) {
        this.certification = certification;
    }

    public void displayStudent() {
        System.out.println("Student ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Gender: " + gender);
        certification.displayCertification();
    }
}