/*
    Test companion object
 */

import java.time.LocalDateTime

class MyTime(val time: LocalDateTime = LocalDateTime.now())

class MyClass1() {

    object myTime {
        val myTime = MyTime()

        fun getMyTimeInstance(): MyTime {
            return myTime
        }
    }

    fun showTime() = println(MyClass1.myTime.getMyTimeInstance().time)
}

// Same as MyClass1. Only added the keyword 'companion'
class MyClass2() {

    companion object myTime {
        val myTime = MyTime()

        fun getMyTimeInstance(): MyTime {
            return myTime
        }
    }

    fun showTime() = println(MyClass2.getMyTimeInstance().time)
}

fun main(args: Array<String>) {

    println("Hello world!")
    Thread.sleep(1000)

    val a = MyClass1()
    val b = MyClass1()

    Thread.sleep(1000)
    println(LocalDateTime.now())

    // Lazy initialization. object is created by the next call
    println(MyClass1.myTime.getMyTimeInstance().time)
    a.showTime()
    b.showTime()

    println("------------------")
    Thread.sleep(1000)

    val c = MyClass2()
    val d = MyClass2()

    Thread.sleep(1000)
    println(LocalDateTime.now())

    // Eager initialization. object is created by initializing variables above
    println(MyClass2.getMyTimeInstance().time)
    c.showTime()
    d.showTime()
}