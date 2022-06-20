package com.example.projecthome.dto

import com.example.projecthome.db.entity.AddressType

data class AddressDto(
    var id: Long? = null,
    var country: String? = null,
    var city: String? = null,
    var streetName: String? = null,
    var buildingNumber: Int? = null,
    var flatNumber: Int? = null,
    var zipCode: String? = null,
    var addressType: AddressType? = null

)
