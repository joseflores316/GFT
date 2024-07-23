package com.cronos.gft.infraestructure.rest.mapper;

import com.cronos.gft.domain.models.PriceDto;
import com.cronos.gft.infraestructure.entity.PriceEntity;
import java.util.List;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PriceMapper {

    PriceEntity toEntity(PriceDto priceDto);

    PriceDto toDto(PriceEntity priceEntity);

    List<PriceDto> toDtoList(List<PriceEntity> priceEntity);

    List<PriceEntity> toEntityList(List<PriceDto> priceDto);

}
