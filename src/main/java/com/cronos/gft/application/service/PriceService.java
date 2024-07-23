package com.cronos.gft.application.service;

import com.cronos.gft.domain.models.PriceDto;
import java.time.LocalDateTime;

public interface PriceService {

    PriceDto findPrice(LocalDateTime date, Long productId, Long brandId);
}
