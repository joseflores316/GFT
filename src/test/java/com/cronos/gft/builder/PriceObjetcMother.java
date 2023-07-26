package com.cronos.gft.builder;

import com.cronos.gft.domain.models.PriceDto;
import com.cronos.gft.infraestructure.entity.PriceEntity;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class PriceObjetcMother {

    public static final PriceDto ANY_DTO = aPriceDto();
    public static final PriceEntity ANY_ENTITY = aPriceEntity();

    public static final List<PriceEntity> ANY_LIST_ENTITY = aListPriceEntity();

    public static final List<PriceDto> ANY_LIST_DTO = aListPriceDto();

    private static List<PriceDto> aListPriceDto() {
        return List.of(aPriceDto());
    }

    private static List<PriceEntity> aListPriceEntity() {
        return List.of(aPriceEntity());
    }

    private static PriceEntity aPriceEntity() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        LocalDateTime parseStartDate = formatter.parse("2020-06-14 00:00:00", LocalDateTime::from);
        LocalDateTime parseEndDate = formatter.parse("2020-12-31 23:59:59", LocalDateTime::from);

        return PriceEntity.builder()
                .id(1L)
                .brandId(1L)
                .startDate(parseStartDate)
                .endDate(parseEndDate)
                .priceList(1L)
                .productId(35455L)
                .priority(0L)
                .price(35.50)
                .curr("EUR")
                .build();
    }

    private static PriceDto aPriceDto() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        LocalDateTime parseStartDate = formatter.parse("2020-06-14 00:00:00", LocalDateTime::from);
        LocalDateTime parseEndDate = formatter.parse("2020-12-31 23:59:59", LocalDateTime::from);

        return PriceDto.builder()
                .id(1L)
                .brandId(1L)
                .startDate(parseStartDate)
                .endDate(parseEndDate)
                .priceList(1L)
                .productId(35455L)
                .priority(0L)
                .price(35.50)
                .curr("EUR")
                .build();
    }
}
