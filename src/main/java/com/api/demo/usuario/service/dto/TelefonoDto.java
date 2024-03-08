package com.api.demo.usuario.service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;

@Data
@Validated
@NoArgsConstructor
@AllArgsConstructor
public class TelefonoDto {

    private String number;

    private String citycode;

    private String contrycode;

}
