package com.example.projecthome.db.repositore

import org.springframework.data.jpa.repository.JpaRepository
import com.example.projecthome.db.entity.Address

interface AddressRepository : JpaRepository<Address, Long>
