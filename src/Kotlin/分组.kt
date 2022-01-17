package Kotlin

fun main() {
    var numbers = listOf("one", "two", "three", "four", "five")

    println(numbers.groupBy { it.first().toUpperCase() })
    println(numbers.groupBy(keySelector = { it.first() }, valueTransform = { it.toUpperCase() }))

    numbers = listOf("one", "two", "three", "four", "five", "six")
    println(numbers.groupingBy { it.first() }.eachCount())
/*    println(numbers.groupingBy { it.first() }.aggregate{
            k,v,i
    })*/
    /*  val aggregated = numbers.groupingBy { it % 3 }.aggregate { key, accumulator: StringBuilder?, element, first ->
          if (first) // first element
              StringBuilder().append(key).append(":").append(element)
          else
              accumulator!!.append("-").append(element)
      }

      println(numbers.groupingBy { it.first() }.eachCount())*/
}