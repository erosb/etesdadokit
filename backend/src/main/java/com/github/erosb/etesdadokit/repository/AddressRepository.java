package com.github.erosb.etesdadokit.repository;

import com.github.erosb.etesdadokit.domain.AddressEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<AddressEntity, Long> {
}
