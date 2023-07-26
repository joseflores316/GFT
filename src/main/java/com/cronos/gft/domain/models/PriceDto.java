package com.cronos.gft.domain.models;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PriceDto {

    @Schema(name ="id" ,description = "Brand id", example = "1", requiredMode = Schema.RequiredMode.REQUIRED)
    private Long id;

    private Long brandId;

    private LocalDateTime startDate;

    private LocalDateTime endDate;

    private Long priceList;

    private Long productId;

    private Long priority;

    private Double price;

    private String curr;
}
