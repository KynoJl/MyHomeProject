package com.example.projecthome.controller

import com.example.projecthome.dto.AddressDto
import com.example.projecthome.service.AddressService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/address")
class AddressController(
    val addressService: AddressService
) {

    @PostMapping
    fun create(@RequestBody dto: AddressDto) =
        ResponseEntity(addressService.create(dto), HttpStatus.CREATED)

    @GetMapping("/{id")
    fun getById(@PathVariable("id") id: Long) = addressService.getBuId(id)

    @GetMapping
    fun getAll() = addressService.getAll()

    @DeleteMapping
    fun deleteById(@PathVariable ("id") id:Long) = addressService.deleteById(id)

    @PutMapping
    fun update(@RequestBody dto:AddressDto) = addressService.update(dto)

}