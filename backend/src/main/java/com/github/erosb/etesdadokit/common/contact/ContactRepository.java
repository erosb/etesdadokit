package com.github.erosb.etesdadokit.common.contact;

import com.github.erosb.etesdadokit.common.contact.ContactEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepository extends JpaRepository<ContactEntity, Long> {
}
