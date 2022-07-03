package com.example.projecthome

import com.example.projecthome.db.entity.AddressType
import com.example.projecthome.dto.AddressDto
import com.example.projecthome.mapper.AddressMapper
import io.kotest.assertions.assertSoftly
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertTimeout
import java.io.IOException
import java.time.Duration.ofMillis


class DecoderTest {
    private val mapper: AddressMapper = AddressMapper()


    @Test
    fun shouldMapperToEntity() {
        //задаём случайные параметры
        val addressDto:AddressDto = easyRandom()

        val result = mapper.toEntity(addressDto)


        // Проверяем после преобразования
        assertSoftly {
            result.id shouldBe (addressDto.id)
            result.country shouldBe( addressDto.country)
            result.city shouldBe addressDto.city
            result.streetName shouldBe addressDto.streetName
            result.buildingNumber shouldBe addressDto.buildingNumber
            result.flatNumber shouldBe addressDto.flatNumber
            result.zipCode shouldBe addressDto.zipCode
            println(result)
        }



        assert(result.id == addressDto.id)
        assert(result.country == addressDto.country)
        assert(result.city == addressDto.city)
        assert(result.streetName == addressDto.streetName)
        assert(result.buildingNumber == addressDto.buildingNumber)
        assert(result.flatNumber == addressDto.flatNumber)
        assert(result.zipCode == addressDto.zipCode)


    }
    @Test
    fun `Timeout not exceeded`() {
        val addressDto:AddressDto = easyRandom()
        // Тест упадёт после выполнения лямбда-выражения, если оно превысит 1000 мс
        assertTimeout(ofMillis(1000)) {
            print("Выполняется операция, которая займёт не больше 1 секунды")
            mapper.toEntity(addressDto)
        }
    }
    @Test
    fun shouldMapperToDto() {
        val addressDto:AddressDto = easyRandom()

        val result = mapper.toEntity(addressDto)
        val resultDto = mapper.toDto(result)

        assertSoftly {
            resultDto.id shouldBe (addressDto.id)
            resultDto.country shouldBe( addressDto.country)
            resultDto.city shouldBe addressDto.city
            resultDto.streetName shouldBe addressDto.streetName
            resultDto.buildingNumber shouldBe addressDto.buildingNumber
            resultDto.flatNumber shouldBe addressDto.flatNumber
            resultDto.zipCode shouldBe addressDto.zipCode
            println(resultDto)

        }
    }
}