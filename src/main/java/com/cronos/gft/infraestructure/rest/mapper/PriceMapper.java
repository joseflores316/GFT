package com.cronos.gft.infraestructure.rest.mapper;

import com.cronos.gft.domain.models.PriceDto;
import com.cronos.gft.infraestructure.entity.PriceEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PriceMapper {

    PriceEntity toEntity(PriceDto priceDto);

    PriceDto toDto(PriceEntity priceEntity);

    List<PriceDto> toDtoList(List<PriceEntity> priceEntity);

    List<PriceEntity> toEntityList(List<PriceDto> priceDto);

}
