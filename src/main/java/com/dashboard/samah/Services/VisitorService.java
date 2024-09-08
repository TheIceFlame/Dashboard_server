package com.dashboard.samah.Services;


import com.dashboard.samah.DTO.VisitorDTO;
import com.dashboard.samah.Entities.Visitor;
import com.dashboard.samah.Repositories.VisitorRepository;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;

@Service
public class VisitorService {
    private final VisitorRepository visitorRepository;

    public VisitorService(VisitorRepository visitorRepository) {
        this.visitorRepository = visitorRepository;
    }

    public void registerVisit(HttpServletRequest request) {
        String ipAddress = request.getRemoteAddr();
        Visitor visitor = new Visitor(ipAddress, LocalDateTime.now());
        visitorRepository.save(visitor);
    }

    public VisitorDTO getTotalVisitors() {
        long totalVisitors = visitorRepository.count();
        return new VisitorDTO(totalVisitors);
    }
}
