package Kotlin

import kotlin.reflect.KProperty

class 委托 {
}

class Student {

    val age: Int by Age()
    lateinit var _name: String
    var name: String
        get() = _name
        set(value) {
            _name = value
        }
}


open class Age {
    operator fun getValue(student: Student, property: KProperty<*>): Int {
        return 1
    }
}

fun main() {
    var student = Student()
    student.name = "666"
    println(student._name)
    println(student.age)
}