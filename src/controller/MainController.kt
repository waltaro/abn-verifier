package controller

import javafx.scene.text.Text

fun verifyAbn(abn : String, statusText : Text) : Boolean {
    println(abn)
    statusText.text = abn
    return false
}