package com.cronos.gft.domain.ports;

import com.cronos.gft.domain.models.PriceDto;
import java.util.List;

public interface PriceRepository {

    List<PriceDto> findAll();
}
