package com.api.demo;

import com.api.demo.usuario.service.dto.TelefonoDto;
import com.api.demo.usuario.service.dto.UsuarioDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.HashSet;
import java.util.Set;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class UsuarioRestTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void UsuarioCreated200Test() throws Exception {

        UsuarioDto usuarioDto = createUsuarioDTO();
        mockMvc.perform(
                        MockMvcRequestBuilders.post("/api/v1/usuario")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(asJsonString(usuarioDto)))
                .andExpect(status().is2xxSuccessful());

    }

    @Test
    void UsuarioBadRequest403Test() throws Exception {

        UsuarioDto usuarioDto = createUsuarioDTO();
        usuarioDto.setEmail("juanrodriguez.org");
        mockMvc.perform(
                        MockMvcRequestBuilders.post("/api/v1/usuario")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(asJsonString(usuarioDto)))
                .andExpect(status().isBadRequest());

    }

    @Test
    void UsuarioUnauthorized401Test() throws Exception {

        UsuarioDto usuarioDto = createUsuarioDTO();
        usuarioDto.setEmail("reiger.cl@gmail.com");
        mockMvc.perform(
                        MockMvcRequestBuilders.post("/api/v1/usuario")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(asJsonString(usuarioDto)))
                .andExpect(status().is2xxSuccessful());

        mockMvc.perform(
                        MockMvcRequestBuilders.post("/api/v1/usuario")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(asJsonString(usuarioDto)))
                .andExpect(status().isUnauthorized());

    }


    private UsuarioDto createUsuarioDTO() {
        UsuarioDto dto = new UsuarioDto();
        dto.setName("Juan Rodriguez");
        dto.setEmail("juan@rodriguez.org");
        dto.setPassword("hunter2");

        Set<TelefonoDto> phones = new HashSet<>();

        phones.add(new TelefonoDto("1234567","1","5"));
        return dto;
    }

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
