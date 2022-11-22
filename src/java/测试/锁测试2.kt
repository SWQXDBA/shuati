package 测试


import MyTools.工具类.StopWatch
import java.nio.channels.FileChannel
import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.StandardOpenOption
import java.util.concurrent.atomic.AtomicInteger
import java.util.concurrent.locks.ReentrantLock
import kotlin.concurrent.thread

var max = 10000000
val repeat = 8
fun main() {

    sync()
    bigsync()
    reen()
    ato()
    none()


    println()

    sync()
    bigsync()
    reen()
    ato()
    none()

}
var int = 0
var ato = AtomicInteger()
fun sync() {
    val stopWatch = StopWatch()
    stopWatch.start()
    val mutableListOf = mutableListOf<Thread>()
    val any = Any()
    repeat(repeat) {

        mutableListOf.add(thread {
            for (i in 0..max) {
                synchronized(any) {
                    int++
                }
            }
        })
    }
    mutableListOf.forEach { it.join() }

    println("sync ${stopWatch.passedMills}")
}
fun reen() {
    val stopWatch = StopWatch()
    stopWatch.start()
    val mutableListOf = mutableListOf<Thread>()
    val reen = ReentrantLock()
    repeat(repeat) {

        mutableListOf.add(thread {
            for (i in 0..max) {
                reen.lock()
                try{
                    int++
                }finally {
                    reen.unlock()
                }
            }
        })
    }
    mutableListOf.forEach { it.join() }

    println("ReentrantLock ${stopWatch.passedMills}")
}
fun bigsync() {
    val stopWatch = StopWatch()
    stopWatch.start()
    val mutableListOf = mutableListOf<Thread>()
    val any = Any()
    repeat(repeat) {

        mutableListOf.add(thread {
            synchronized(any) {
                for (i in 0..max) {
                    int++
                }
            }
        })
    }
    mutableListOf.forEach { it.join() }

    println("bigsync ${stopWatch.passedMills}")
}

fun none() {
    val stopWatch = StopWatch()
    stopWatch.start()
    val mutableListOf = mutableListOf<Thread>()
    repeat(repeat) {
        val any = Any()
        mutableListOf.add(thread {
            for (i in 0..max) {
                int++
            }
        })
    }
    mutableListOf.forEach { it.join() }

    println("none ${stopWatch.passedMills}")
}
fun ato() {
    val stopWatch = StopWatch()
    stopWatch.start()
    val mutableListOf = mutableListOf<Thread>()
    repeat(repeat) {

        mutableListOf.add(thread {
            for (i in 0..max) {
                ato.incrementAndGet()
            }
        })
    }
    mutableListOf.forEach { it.join() }

    println("ato ${stopWatch.passedMills}")
}