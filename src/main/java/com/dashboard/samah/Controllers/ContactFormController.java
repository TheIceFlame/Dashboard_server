package com.dashboard.samah.Controllers;

import com.dashboard.samah.Entities.ContactForm;
import com.dashboard.samah.Services.ContactFormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/contact")
@CrossOrigin(origins = {"https://samah.vercel.app/","https://dashboardsamah.vercel.app/","http://localhost:4200/","http://localhost:4201/"})
public class ContactFormController {

    @Autowired
    private ContactFormService contactFormService;

    @PostMapping("/submit")
    public String submitForm(@RequestBody ContactForm contactForm) {
        contactFormService.submitContactForm(contactForm);
        return "Form submitted successfully";
    }
}
