package com.kunkun.springwebone.entity;

import lombok.*;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {
    private Integer ID;
    private String UserName;
    private String Password;
    private String TrueName;
    private Integer Age;
    private LocalDateTime CreateTime;
}
