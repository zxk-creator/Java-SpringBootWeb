package com.kunkun.springwebone.entity;

import lombok.*;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {
    private Integer id;
    private String userName;
    private String passwordHash;
    private Integer role;
    private LocalDateTime CreateTime;

    public String getPermissionType(){
        return switch (role){
            case 0 -> "访客";
            case 1 -> "管理员";
            default -> "访客";
        };
    }
}
