package com.cronos.gft.application.service.impl;

import com.cronos.gft.application.service.PriceService;
import com.cronos.gft.domain.models.PriceDto;
import com.cronos.gft.domain.ports.PriceRepository;
import com.cronos.gft.infraestructure.exceptions.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;

@Service
public class PriceServiceImpl implements PriceService {

    private final PriceRepository priceRepository;

    public PriceServiceImpl(PriceRepository priceRepository) {
        this.priceRepository = priceRepository;
    }

    @Override
    public PriceDto findPrice(LocalDateTime date, Long productId, Long brandId) {
        List<PriceDto> priceList = this.priceRepository.findAll().stream()
                .filter(priceDto -> priceDto.getStartDate().isBefore(date) && priceDto.getEndDate().isAfter(date))
                .filter(priceDto -> priceDto.getProductId().equals(productId))
                .filter(priceDto -> priceDto.getBrandId().equals(brandId))
                .toList();

        if(priceList.size() > 1) {
            return priceList.stream().max(Comparator.comparing(PriceDto::getPriority)).get();
        }else{
            return priceList.stream().findFirst().orElseThrow(() -> new ResourceNotFoundException("Price not found"));
        }

    }
}
