package org.example.springmvc.DTO;

import lombok.Data;

@Data
public class ContactFormDTO{
    private String name;
    private String email;
    private String message;
}
