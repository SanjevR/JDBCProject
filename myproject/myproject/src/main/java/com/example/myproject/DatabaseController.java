package com.example.myproject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class DatabaseController {

    @Autowired
    private FamilyRepository familyRepository;

    @GetMapping("/api/data")
public List<Family> getData() {
    List<Family> families = familyRepository.findAll();

    // Print each family's actual fields
    for (Family fam : families) {
        System.out.println("DEBUG: id=" + fam.getId() 
                            + ", firstName=" + fam.getFirstName() 
                            + ", lastName=" + fam.getLastName() 
                            + ", phoneNo=" + fam.getPhoneNo());
    }

    return families;
}
}