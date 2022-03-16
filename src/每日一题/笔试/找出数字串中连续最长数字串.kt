package 每日一题.笔试

import java.util.*

fun main() {
    val scanner = Scanner(System.`in`)
    val str = scanner.nextLine()
    var stringBuilder = StringBuilder()
    var maxStr = ""
    for (c in str) {
        if (c in '0'..'9') {
            stringBuilder.append(c)
        } else {
            if (maxStr.length < stringBuilder.length) {
                maxStr = stringBuilder.toString()
            }
            stringBuilder = StringBuilder()
        }
    }
    if (maxStr.length < stringBuilder.length) {
        maxStr = stringBuilder.toString()
    }
    println(maxStr)
}