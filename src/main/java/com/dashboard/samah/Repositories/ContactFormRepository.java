package com.dashboard.samah.Repositories;

import com.dashboard.samah.Entities.ContactForm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactFormRepository extends JpaRepository<ContactForm, Long> {
}