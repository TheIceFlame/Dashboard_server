package com.dashboard.samah.Entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
public class Visitor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String ipAddress;

    private LocalDateTime visitTime;

    public Visitor(String ipAddress, LocalDateTime visitTime) {
        this.ipAddress = ipAddress;
        this.visitTime = visitTime;
    }
}
