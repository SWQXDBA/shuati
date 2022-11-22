package 力扣题目.剑指offer

fun minArray(numbers: IntArray): Int {
    for (i in numbers.indices) {
        if (i != numbers.size - 1) {
            if (numbers[i + 1] < numbers[i]) {
                return numbers[i + 1]
            }
        }
    }
    return numbers[0]

}