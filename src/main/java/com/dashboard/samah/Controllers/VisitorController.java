package com.dashboard.samah.Controllers;


import com.dashboard.samah.DTO.VisitorDTO;
import com.dashboard.samah.Services.VisitorService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/visitors")
@CrossOrigin(origins = {"https://samah.vercel.app/","https://dashboardsamah.vercel.app/","http://localhost:4200/","http://localhost:4201/"})
public class VisitorController {
    private final VisitorService visitorService;

    public VisitorController(VisitorService visitorService) {
        this.visitorService = visitorService;
    }

    // Register each visit
    @GetMapping("/register")
    public void registerVisit(HttpServletRequest request) {
        visitorService.registerVisit(request);
    }

    // Get total number of visitors
    @GetMapping("/count")
    public VisitorDTO getTotalVisitors() {
        return visitorService.getTotalVisitors();
    }
}
