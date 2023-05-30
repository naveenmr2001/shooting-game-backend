package com.m2p.shootinggame;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(ShootingGameController.class)
public class ShootingGameControllerTests {

    @MockBean
    private ShootingGameService shootingGameService;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void toCheckTheHealthOfHero() throws Exception {
        Mockito.when(shootingGameService.getHealth("Hero")).thenReturn(100);
        mockMvc.perform(get("/api/health?heroOrVillan=Hero")).andExpect(status().isOk())
                .andExpect(content().string(String.valueOf(100)))
                .andDo(print());
    }
    @Test
    void toCheckTheHealthOfVillan() throws Exception {
        Mockito.when(shootingGameService.getHealth("Villan")).thenReturn(100);
        mockMvc.perform(get("/api/health?heroOrVillan=Villan")).andExpect(status().isOk())
                .andExpect(content().string(String.valueOf(100)));
    }

    @Test
    void toCheckTheExceptionInGetHealth() throws Exception {
        mockMvc.perform(get("/api/health?heroOrVillan=Police")
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(result -> assertTrue(result.getResolvedException() instanceof BadArgumentsException))
                .andExpect(result -> assertEquals("Bad Argument", result.getResolvedException().getMessage()));
    }

    @Test
    void toCheckTheShootingOfVillan() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/api/shoot?heroOrVillan=Villan"))
                .andDo(print())
                .andExpect(status().is(201));
    }

    @Test
    void toCheckTheShootingOfHero() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/api/shoot?heroOrVillan=Hero"))
                .andDo(print())
                .andExpect(status().is(201));
    }

    @Test
    void toCheckTheArmorIsSet() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.post("/api/armour?trueOrFalse=true"))
                .andDo(print())
                .andExpect(status().is(201));
    }

    @Test
    void toResetTheGame() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.post("/api/reset"))
                .andDo(print())
                .andExpect(status().is(201));
    }
}
