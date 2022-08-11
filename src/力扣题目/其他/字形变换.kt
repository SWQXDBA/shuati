package 力扣题目.其他

enum class Way {
    UP, DOWN
}

class Mover(
    var direction: Way,
    var row: Int
) {
    var currentRow: Int = 0
    var currentCol: Int = 0

    fun moveNext() {
        if (row == 1) {
            currentCol++
            return
        }

        if (direction == Way.DOWN) {
            if (currentRow < row - 1) {
                down()
            } else {
                direction = Way.UP
                up()
            }
        } else {
            if (currentRow > 0) {
                up()
            } else {
                direction = Way.DOWN
                down()
            }
        }
    }

    private fun down() {
        currentRow++
    }

    private fun up() {
        currentRow--
        currentCol++
    }
}

fun convert(s: String, numRows: Int): String {
    val block = Array(1000) { CharArray(1000) }

    val mover = Mover(Way.DOWN, numRows)
    val charArray = s.toCharArray()
    for (c in charArray) {
        block[mover.currentRow][mover.currentCol] = c
        mover.moveNext()
    }
    val stringBuilder = StringBuilder()
    var built = 0
    for (chars in block) {
        for (char in chars) {
            if (built == s.length) {
                return stringBuilder.toString()
            } else if (char == Char.MIN_VALUE) {
                continue
            } else {
                stringBuilder.append(char)
                built++
            }
        }
    }
    return ""

}

fun main() {


    println(
        convert(
            "PAYPALISHIRING",
            3
        )
    )
}