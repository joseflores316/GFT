package com.cronos.gft.infraestructure.adaptador;

import com.cronos.gft.infraestructure.entity.PriceEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PriceJpaRepository extends JpaRepository<PriceEntity, Long> {



}
