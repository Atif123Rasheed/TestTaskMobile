package suvorov.testtaskmobile.util

import java.text.DecimalFormat

fun Int?.homeDollarString(): String {
    return this?.let {
        "$${DecimalFormat().format(this)}"
    } ?: ""
}

fun Int?.shopDollarString(): String {
    return this?.let {
        "$${DecimalFormat(",000.00").format(this)}"
    } ?: ""
}

fun Int?.cartDollarString(): String {
    return this?.let {
        "$${DecimalFormat(".00").format(this)}"
    } ?: ""
}