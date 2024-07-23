package com.cronos.gft.infraestructure.adaptador;

import com.cronos.gft.domain.models.PriceDto;
import com.cronos.gft.domain.ports.PriceRepository;
import com.cronos.gft.infraestructure.rest.mapper.PriceMapper;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
@Slf4j
public class PriceRepositoryImpl implements PriceRepository {

    private final PriceJpaRepository priceJpaRepository;

    @Autowired
    private PriceMapper priceMapper;

    public PriceRepositoryImpl(PriceJpaRepository priceJpaRepository) {
        this.priceJpaRepository = priceJpaRepository;
    }

    @Override
    public List<PriceDto> findAll() {
        return priceMapper.toDtoList(this.priceJpaRepository.findAll());
    }
}
