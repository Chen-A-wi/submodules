package com.awilab.common.ext

import org.junit.jupiter.api.DisplayName
import org.junit.Test

internal class FromTypeExtKtTest {
    enum class SampleAnimalType(val animalType: String) {
        CAT("cat"),
        DOG("dog"),
        UNKNOWN("unknown");

        companion object {
            fun fromType(value: String?): SampleAnimalType = SampleAnimalType::animalType.fromType(
                value = value,
                default = UNKNOWN
            )
        }
    }

    @Test
    @DisplayName("測試FromType fail get default")
    fun fromTypeDefaultTest() {
        SampleAnimalType.fromType(value = "bird") shouldBe SampleAnimalType.UNKNOWN
    }

    @Test
    @DisplayName("測試FromType to cat")
    fun fromCatTypeTest() {
        SampleAnimalType.fromType(value = "cat") shouldBe SampleAnimalType.CAT
    }

    @Test
    @DisplayName("測試FromType to dog")
    fun fromDogTypeTest() {
        SampleAnimalType.fromType(value = "dog") shouldBe SampleAnimalType.DOG
    }
}