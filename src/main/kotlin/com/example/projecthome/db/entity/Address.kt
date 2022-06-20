package com.example.projecthome.db.entity

import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.time.LocalDateTime
import javax.persistence.Entity
import javax.persistence.EntityListeners
import javax.persistence.EnumType
import javax.persistence.Enumerated
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table

@Entity
@EntityListeners(AuditingEntityListener::class)
@Table(name = "address")
data class Address(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0,
    var country: String? = null,
    var city: String? = null,
    var streetName: String? = null,
    var buildingNumber: Int? = null,
    var flatNumber: Int? = null,
    var zipCode: String? = null,
    var created: LocalDateTime = LocalDateTime.now(),

    @Enumerated(EnumType.STRING)
    var addressType: AddressType? = null
)

enum class AddressType{
    BUILDING,
    FLAT
}

