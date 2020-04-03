package com.github.erosb.etesdadokit.repository;

import com.github.erosb.etesdadokit.domain.ContactInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactInfoRepository extends JpaRepository<ContactInfo, Long> {
}
