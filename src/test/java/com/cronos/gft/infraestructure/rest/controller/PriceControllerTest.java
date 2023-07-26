package com.cronos.gft.infraestructure.rest.controller;

import com.cronos.gft.application.service.PriceService;
import com.cronos.gft.builder.PriceObjetcMother;
import com.cronos.gft.domain.models.PriceDto;
import com.cronos.gft.infraestructure.exceptions.ResourceNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.*;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(PriceController.class)
class PriceControllerTest {


    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PriceService priceService;

    @BeforeEach
    void setUp() {
        PriceObjetcMother.ANY_DTO.setPrice(35.50);
    }

    @Test
    void getPriceTest1() throws Exception{

        //Given
        when(priceService.findPrice(LocalDateTime.parse("2020-06-14 10:00:00", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")), 35455L, 1L)).thenReturn(PriceObjetcMother.ANY_DTO);

        //When
        mockMvc.perform(get("/api/price?date=2020-06-14 10:00:00&productId=35455&brandId=1").contentType("application/json"))
        //Then
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.price").value(35.50));

        verify(priceService, times(1)).findPrice(LocalDateTime.parse("2020-06-14 10:00:00", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")), 35455L, 1L);
    }

    @Test
    void getPriceTest2() throws Exception{

        //Given
        PriceObjetcMother.ANY_DTO.setPrice(25.45);

        when(priceService.findPrice(LocalDateTime.parse("2020-06-14 16:00:00", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")), 35455L, 1L)).thenReturn(PriceObjetcMother.ANY_DTO);

        //When
        mockMvc.perform(get("/api/price?date=2020-06-14 16:00:00&productId=35455&brandId=1").contentType("application/json"))
                //Then
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.price").value(25.45));

        verify(priceService, times(1)).findPrice(LocalDateTime.parse("2020-06-14 16:00:00", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")), 35455L, 1L);
    }

    @Test
    void getPriceTest3() throws Exception{

        //Given
        when(priceService.findPrice(LocalDateTime.parse("2020-06-14 21:00:00", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")), 35455L, 1L)).thenReturn(PriceObjetcMother.ANY_DTO);

        //When
        mockMvc.perform(get("/api/price?date=2020-06-14 21:00:00&productId=35455&brandId=1").contentType("application/json"))
                //Then
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.price").value(35.50));

        verify(priceService, times(1)).findPrice(LocalDateTime.parse("2020-06-14 21:00:00", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")), 35455L, 1L);
    }

    @Test
    void getPriceTest4() throws Exception{

        //Given
        PriceObjetcMother.ANY_DTO.setPrice(30.50);
        when(priceService.findPrice(LocalDateTime.parse("2020-06-15 10:00:00", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")), 35455L, 1L)).thenReturn(PriceObjetcMother.ANY_DTO);

        //When
        mockMvc.perform(get("/api/price?date=2020-06-15 10:00:00&productId=35455&brandId=1").contentType("application/json"))
                //Then
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.price").value(30.50));

        verify(priceService, times(1)).findPrice(LocalDateTime.parse("2020-06-15 10:00:00", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")), 35455L, 1L);
    }

    @Test
    void getPriceTest5() throws Exception{

        //Given
        PriceObjetcMother.ANY_DTO.setPrice(38.95);
        when(priceService.findPrice(LocalDateTime.parse("2020-06-16 21:00:00", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")), 35455L, 1L)).thenReturn(PriceObjetcMother.ANY_DTO);

        //When
        mockMvc.perform(get("/api/price?date=2020-06-16 21:00:00&productId=35455&brandId=1").contentType("application/json"))
                //Then
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.price").value(38.95));

        verify(priceService, times(1)).findPrice(LocalDateTime.parse("2020-06-16 21:00:00", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")), 35455L, 1L);
    }

}