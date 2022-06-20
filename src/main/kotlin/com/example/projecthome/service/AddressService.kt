package com.example.projecthome.service

import com.example.projecthome.db.repositore.AddressRepository
import com.example.projecthome.dto.AddressDto
import com.example.projecthome.mapper.AddressMapper
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import javax.transaction.Transactional

@Transactional
@Service
class AddressService(
    private val addressRepository: AddressRepository,
    private val mapper: AddressMapper
) {
    fun create(dto: AddressDto): AddressDto =
        mapper.toDto(addressRepository.save(mapper.toEntity(dto)))

    fun getBuId(id:Long):AddressDto = mapper.toDto(addressRepository.findByIdOrNull(id)?: error("Entity with if = $id is not found!"))

    fun getAll():List<AddressDto> = addressRepository.findAll().map{
        mapper.toDto(it)
    }.sortedBy { it.id }

    fun deleteById(id:Long){
        addressRepository.findByIdOrNull(id) ?: error ("Entity with if = $id is not found!")
        addressRepository.deleteById(id)
    }

    fun update(dto:AddressDto):AddressDto = mapper.toDto(
        addressRepository.save(
            addressRepository.getById(
                dto.id ?: error("Entity with id = ${dto.id} is not found!")
            ).apply{
                country = dto.country
                city = dto.city
                streetName = dto.streetName
                buildingNumber = dto.buildingNumber
                flatNumber = dto.flatNumber
                zipCode = dto.zipCode
                addressType = dto.addressType
            }
        )
    )



}