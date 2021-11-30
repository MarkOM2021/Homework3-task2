const val previousMonthPayments = 0
const val amount = 100_000
const val cardType = "VK Pay"

fun main() {
    println("Комиссия по текущей операции составляет " + cardTypeChooser(cardType) + " копеек")
}

fun cardTypeChooser(cardType: String): Int {
    val cardTypeSwitch = when (cardType) {
        "Mastercard", "Maestro" -> mastercardMaestro(amount)
        "Visa", "Mir" -> visaMir(amount)
        else -> vkPay()
    }
    return cardTypeSwitch
}

fun mastercardMaestro(amount: Int): Int {
    val commissionMastercardMaestro = when (previousMonthPayments) {
        in 0..7_500_000 -> 0
        else -> (amount * 0.006 + 2_000)
    }
    return commissionMastercardMaestro.toInt()
}

fun visaMir(amount: Int): Int {

    val commissionVisaMir = when (val commission = (amount * 0.0075).toInt()) {
        in 0..3_500 -> 3500
        else -> commission
    }
    return commissionVisaMir
}

fun vkPay(): Int {
    return 0
}