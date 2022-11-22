package 每日一题

import java.util.*

data class TRecord(val fileName: String, val indexNumber: Int)

fun main() {
    val scanner = Scanner(System.`in`)
    val map = mutableMapOf<TRecord, Int>()
    while (scanner.hasNext()) {
        val str = scanner.nextLine()
        //用于测试
        if (str == "ok") {
            break
        }
        val split = str.split(" ")
        var fileStr = split[0]
        val indexNumber = Integer.valueOf(split[1])
        fileStr = fileStr.substringAfterLast('\\');
        if (fileStr.length > 16) {
            fileStr = fileStr.substring(fileStr.length - 16, fileStr.length)
        }
        val r = TRecord(fileStr, indexNumber)
        map[r] = map.getOrDefault(r, 0) + 1
    }
    var list = map.toList()
    if (list.size > 8) {
        list = list.subList(list.size - 8, list.size)
    }
    list.forEachIndexed { index, pair ->
        if (index == 8)
            return@forEachIndexed
        println("${pair.first.fileName} ${pair.first.indexNumber} ${pair.second}")
    }
}