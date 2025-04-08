package com.sercanozbek.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StudentUIDto {

    @NotEmpty(message = "FirstName Alanı Boş Bırakılamaz!")
    @Min(value = 3)
    @Max(value = 10)
    private String firstName;

    @Size(min = 2, max = 30)
    private String lastName;

    private Date birthOfDate;

    @Email(message = "Email formatında bir adres giriniz!")
    private String email;
}
