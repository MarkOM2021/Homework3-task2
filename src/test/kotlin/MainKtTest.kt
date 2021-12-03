import org.junit.Test

import org.junit.Assert.*

class MainKtTest {

    @Test
    fun cardTypeChooser_is_correct_Maestro_MC() {
        val typeOfCard = "Maestro"

        val result = cardTypeChooser(
            cardType = typeOfCard
        )

        assertEquals(0, result)
    }

    @Test
    fun cardTypeChooser_is_correct_Visa_Mir() {
        val typeOfCard = "Visa"

        val result = cardTypeChooser(
            cardType = typeOfCard
        )

        assertEquals(3_500, result)
    }

    @Test
    fun cardTypeChooser_is_correct_VKPay() {
        val typeOfCard = "VK Pay"

        val result = cardTypeChooser(
            cardType = typeOfCard
        )

        assertEquals(0, result)
    }

    @Test
    fun mastercardMaestro_is_correct_bigMonthPay() {
        val paymentHistory = 8_000_000
        val amountTest = 10_000

        val result = mastercardMaestro(
            previousMonthPayments = paymentHistory,
            amount = amountTest
        )

        assertEquals(2_060, result)
    }

    @Test
    fun mastercardMaestro_is_correct_littleMonthPay() {
        val paymentHistory = 6_000_000
        val amountTest = 10_000

        val result = mastercardMaestro(
            previousMonthPayments = paymentHistory,
            amount = amountTest
        )

        assertEquals(0, result)
    }

    @Test
    fun visaMir_is_correct_lessLimit() {
        val amountTest = 6_000_000

        val result = visaMir(
            amount = amountTest
        )

        assertEquals(3_500, result)
    }

    @Test
    fun visaMir_is_correct_overLimit() {
        val amountTest = 700_000

        val result = visaMir(
            amount = amountTest
        )

        assertEquals(5_250, result)
    }
}