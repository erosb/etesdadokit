package com.github.erosb.etesdadokit.repository;

import com.github.erosb.etesdadokit.domain.ContactEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepository extends JpaRepository<ContactEntity, Long> {
}
