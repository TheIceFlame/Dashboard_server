package com.dashboard.samah.Controllers;

import com.dashboard.samah.Entities.ContactForm;
import com.dashboard.samah.Services.ContactFormService;
import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/contact")
@CrossOrigin(origins = {"https://samah.vercel.app/","https://dashboardsamah.vercel.app/","http://localhost:4200/","http://localhost:4201/"})
public class ContactFormController {

    @Autowired
    private ContactFormService contactFormService;

    @PostMapping("/submit")
    public String submitForm(@RequestBody ContactForm contactForm) throws MessagingException {
        contactFormService.submitContactForm(contactForm);
        return "Form submitted successfully";
    }

    @GetMapping("/all")
    public Page<ContactForm> getAllEmails(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        return contactFormService.getAllEmails(page, size);
    }
    @GetMapping("/count")
    public Long getAllEmails() {
        return contactFormService.Count();
    }
}
