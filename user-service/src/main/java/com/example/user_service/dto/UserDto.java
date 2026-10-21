package com.example.user_service.dto;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDto {
    private Long id;
    private String name;
    private String surname;
    private String email;
    private String address;
    private Boolean alerting;
    private double energyAlertingThreshold;
}

