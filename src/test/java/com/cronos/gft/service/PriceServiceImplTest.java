package com.cronos.gft.service;

import com.cronos.gft.application.service.PriceService;
import com.cronos.gft.builder.PriceObjetcMother;
import com.cronos.gft.infraestructure.adaptador.PriceJpaRepository;
import com.cronos.gft.infraestructure.rest.mapper.PriceMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
@SpringBootTest
class PriceServiceImplTest {

    @MockBean
    PriceJpaRepository priceJpaRepository;

    @MockBean
    PriceMapper priceMapper;

    @Autowired
    PriceService priceService;

    @Test
    void findPrice() {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        LocalDateTime parseDate = formatter.parse("2020-06-14 10:00:00", LocalDateTime::from);

        when(priceJpaRepository.findAll()).thenReturn(PriceObjetcMother.ANY_LIST_ENTITY);
        when(priceMapper.toDto(any())).thenReturn(PriceObjetcMother.ANY_DTO);
        when(priceMapper.toDtoList(anyList())).thenReturn(PriceObjetcMother.ANY_LIST_DTO);

        assertEquals(PriceObjetcMother.ANY_DTO,priceService.findPrice(parseDate, 35455L, 1L));


    }

}
