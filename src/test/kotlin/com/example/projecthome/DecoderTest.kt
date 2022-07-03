package com.example.projecthome

import com.example.projecthome.db.entity.AddressType
import com.example.projecthome.dto.AddressDto
import com.example.projecthome.mapper.AddressMapper
import io.kotest.assertions.assertSoftly
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test
import java.io.IOException


class DecoderTest {
    private val mapper: AddressMapper = AddressMapper()


    @Test
    fun shouldMapper() {
        //задаём случайные параметры
        val addressDto:AddressDto = easyRandom()

        val result = mapper.toEntity(addressDto)
        val result2 = mapper.toDto(result)

        // Проверяем после преобразования
        assertSoftly {
            result.id shouldBe (addressDto.id)
            result.country shouldBe( addressDto.country)
            result.city shouldBe addressDto.city
            result.streetName shouldBe addressDto.streetName
            result.buildingNumber shouldBe addressDto.buildingNumber
            result.flatNumber shouldBe addressDto.flatNumber
            result.zipCode shouldBe addressDto.zipCode

        }

        assertSoftly {
            result2.id shouldBe (addressDto.id)
            result2.country shouldBe( addressDto.country)
            result2.city shouldBe addressDto.city
            result2.streetName shouldBe addressDto.streetName
            result2.buildingNumber shouldBe addressDto.buildingNumber
            result2.flatNumber shouldBe addressDto.flatNumber
            result2.zipCode shouldBe addressDto.zipCode

        }

        assert(result.id == addressDto.id)
        assert(result.country == addressDto.country)
        assert(result.city == addressDto.city)
        assert(result.streetName == addressDto.streetName)
        assert(result.buildingNumber == addressDto.buildingNumber)
        assert(result.flatNumber == addressDto.flatNumber)
        assert(result.zipCode == addressDto.zipCode)

    }
}