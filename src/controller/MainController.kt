package controller

import javafx.scene.paint.Color
import javafx.scene.text.Text

/**
 * Verify ABN
 */
fun verifyAbn(abn : String, statusText : Text) {

    val isValidAbn = calcAbnWeight(abn)

    if(isValidAbn) {
        statusText.text = "Valid ABN"
        statusText.fill = Color.GREEN
    }else {
        statusText.text = "Invalid ABN"
        statusText.fill = Color.FIREBRICK
    }
}

/**
 * Calculates ABN weight
 */
fun calcAbnWeight(abnInput : String) : Boolean {

    /* Constants */
    val EXPECTED_ABN_SIZE = 11
    val DIVISOR = 89.0

    /* Stuff */
    val weightFactor = listOf<Int>(10, 1, 3, 5, 7, 9, 11, 13, 15, 17, 19)
    var abn = mutableListOf<Double>()
    var sum = 0.0

    /* Add abn numbers to the mutable list */
    abnInput.filter { it.isDigit() }
            .forEach { abn.add(Character.getNumericValue(it).toDouble()) }

    /* Precautionary check for abn numbers */
    if(abn.size != EXPECTED_ABN_SIZE) return false

    /* Subtract 1 from the first digit */
    abn[0]--

    /* Do calculation */
    for(i in 0..EXPECTED_ABN_SIZE - 1) {
        sum += abn.get(i) * weightFactor.get(i)
    }

    /* Check to see if the ABN is valid */
    if(sum % DIVISOR == 0.0) { return true } else { return false }

}