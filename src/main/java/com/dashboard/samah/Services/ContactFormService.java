package com.dashboard.samah.Services;

import com.dashboard.samah.Entities.ContactForm;
import com.dashboard.samah.Repositories.ContactFormRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ContactFormService {

    @Autowired
    private ContactFormRepository contactFormRepository;

    @Autowired
    private JavaMailSender mailSender;

    public void submitContactForm(ContactForm contactForm) {
        contactForm.setSubmittedAt(LocalDateTime.now());
        contactFormRepository.save(contactForm);
        sendEmail(contactForm);
    }

    private void sendEmail(ContactForm contactForm) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo("your-email@example.com"); // Replace with your email address
        message.setSubject(contactForm.getSubject());
        message.setText("Name: " + contactForm.getName() +
                "\nEmail: " + contactForm.getEmail() +
                "\nMessage: " + contactForm.getMessage());

        mailSender.send(message);
    }
}
