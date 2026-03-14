package com.klu;

import org.springframework.stereotype.Component;

@Component
public class Certification {

    private final int id = 501;
    private final String name = "AWS Certified Developer";
    private final String dateOfCompletion = "12-02-2026";

    public void displayCertification() {
        System.out.println("Certification ID: " + id);
        System.out.println("Certification Name: " + name);
        System.out.println("Completion Date: " + dateOfCompletion);
    }
}