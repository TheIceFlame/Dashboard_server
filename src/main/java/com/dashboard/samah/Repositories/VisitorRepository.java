package com.dashboard.samah.Repositories;



import com.dashboard.samah.Entities.Visitor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VisitorRepository extends JpaRepository<Visitor, Long> {

    long count();
}
