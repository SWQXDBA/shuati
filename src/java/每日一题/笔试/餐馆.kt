package 每日一题.笔试

import java.util.*

data class Customer(val member: Int, val money: Int)

fun main() {
    val scanner = Scanner(System.`in`)
    val n = scanner.nextInt()
    val m = scanner.nextInt()
    val desk = mutableListOf<Int>()
    val customers = mutableListOf<Customer>()
    repeat(n) {
        desk.add(scanner.nextInt())
    }
    repeat(m) {
        val members = scanner.nextInt()
        val money = scanner.nextInt()
        customers.add(Customer(members, money))
    }
    desk.sort()

    var total = 0
    desk.forEach { currentDesk ->
        var maxIndex = 0
        var maxMoney = 0
        if (customers.size == 0) return@forEach
        customers.forEachIndexed { i, customer ->
            if (currentDesk >= customer.member && maxMoney <= customer.money) {
                maxIndex = i
                maxMoney = customer.money
            }
        }
        total += maxMoney
        customers.removeAt(maxIndex)
    }
    println(total)
}