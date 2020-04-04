package com.github.erosb.etesdadokit.common.address;

import com.github.erosb.etesdadokit.common.address.AddressEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<AddressEntity, Long> {
}
