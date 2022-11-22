package 力扣题目.剑指offer

fun main() {
    println(exist(arrayOf(charArrayOf('a', 'a')), "aaa"))
}

fun exist(board: Array<CharArray>, word: String): Boolean {

    for (rowIndex in board.indices) {
        for (colIndex in board[rowIndex].indices) {
            if (board[rowIndex][colIndex] == word[0]) {

                if (test(board, word, Array(board.size) { BooleanArray(board[0].size) }, rowIndex, colIndex, 0)) {
                    return true
                }
            }
        }
    }
    return false;

}

/**
 * x:行坐标 y:列坐标
 */
fun test(board: Array<CharArray>, word: String, used: Array<BooleanArray>, x: Int, y: Int, matchIndex: Int): Boolean {
    if (x < 0 || y < 0 || x >= board.size || y >= board[0].size || used[x][y]) {
        return false
    }

    if (board[x][y] == word[matchIndex]) {
        if (matchIndex == word.length - 1) {
            return true
        }
    } else {
        return false
    }

    used[x][y] = true
    if (test(board, word, used, x + 1, y, matchIndex + 1) ||
        test(board, word, used, x - 1, y, matchIndex + 1) ||
        test(board, word, used, x, y + 1, matchIndex + 1) ||
        test(board, word, used, x, y - 1, matchIndex + 1)
    ) {
        return true
    }
    used[x][y] = false
    return false

}
