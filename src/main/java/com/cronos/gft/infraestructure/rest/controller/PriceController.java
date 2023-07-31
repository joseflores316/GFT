package com.cronos.gft.infraestructure.rest.controller;

import com.cronos.gft.application.service.PriceService;
import com.cronos.gft.domain.models.PriceDto;
import com.cronos.gft.infraestructure.exceptions.BadArgumentsException;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Tag(name = "Price API", description = "The Price API")
@RestController
@RequestMapping("/api/price")
@Slf4j
public class PriceController {

    private final PriceService priceService;


    public PriceController(PriceService priceService) {
        this.priceService = priceService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<PriceDto> getPrice(@RequestParam(required = false) String date, @RequestParam(required = false) Long productId, @RequestParam(required = false) Long brandId)  {
        //return error message when the parameter is missing
        if (date == null || productId == null || brandId == null) {
            throw new BadArgumentsException("Missing parameters");
        }

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        LocalDateTime parseDate = formatter.parse(date, LocalDateTime::from);

        return new ResponseEntity<>(priceService.findPrice(parseDate, productId, brandId), HttpStatus.OK);
    }
}