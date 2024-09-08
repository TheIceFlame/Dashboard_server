package com.dashboard.samah.Services;

import com.dashboard.samah.Entities.ContactForm;
import com.dashboard.samah.Repositories.ContactFormRepository;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.AddressException;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ContactFormService {

    @Autowired
    private ContactFormRepository contactFormRepository;

    @Autowired
    private JavaMailSender mailSender;

    public void submitContactForm(ContactForm contactForm){
        contactForm.setSubmittedAt(LocalDateTime.now());
        contactFormRepository.save(contactForm);
//        sendEmail(contactForm);
    }

    private void sendEmail(ContactForm contactForm) throws AddressException, MessagingException {
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);

        // Set sender address (update this to a valid address configured with your SMTP server)
        helper.setFrom(new InternetAddress("razador1999@gmail.com"));

        // Set recipient address
        helper.setTo("djoabdo1999@gmail.com");

        // Set subject
        helper.setSubject(contactForm.getSubject());

        // Set email body
        String emailContent = "Name: " + contactForm.getName() +
                "\nEmail: " + contactForm.getEmail() +
                "\nMessage: " + contactForm.getMessage();
        helper.setText(emailContent, "text/plain"); // Use text/plain for plain text email

        // Send email
        mailSender.send(message);
    }

    public Page<ContactForm> getAllEmails(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return contactFormRepository.findAll(pageable);
    }

    public Long Count() {
        return contactFormRepository.count();
    }
}
