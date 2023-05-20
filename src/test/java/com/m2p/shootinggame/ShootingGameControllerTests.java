package com.m2p.shootinggame;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

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
        mockMvc.perform(MockMvcRequestBuilders.get("/health?heroOrVillan=Hero")).andExpect(status().isOk())
                .andExpect(content().string(String.valueOf(100)))
                .andDo(print());
    }
    @Test
    void toCheckTheHealthOfVillan() throws Exception {
        Mockito.when(shootingGameService.getHealth("Villan")).thenReturn(100);
        mockMvc.perform(MockMvcRequestBuilders.get("/health?heroOrVillan=Villan")).andExpect(status().isOk())
                .andExpect(content().string(String.valueOf(100)));
    }

    @Test
    void toCheckTheShootingOfVillan() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/shoot?heroOrVillan=Villan"))
                .andDo(print())
                .andExpect(status().is(201));
    }

    @Test
    void toCheckTheShootingOfHero() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/shoot?heroOrVillan=Hero"))
                .andDo(print())
                .andExpect(status().is(201));
    }

    @Test
    void toCheckTheArmorIsSet() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.post("/armor"))
                .andDo(print())
                .andExpect(status().is(201));
    }
}
