package ru.skillbranch.devintensive

import org.junit.Test

import org.junit.Assert.*
import ru.skillbranch.devintensive.extensions.TimeUnits
import ru.skillbranch.devintensive.extensions.add
import ru.skillbranch.devintensive.extensions.format
import ru.skillbranch.devintensive.extensions.toUserView
import ru.skillbranch.devintensive.models.*
import java.util.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }
    @Test
    fun test_instance() {
        //val user = User(id="1")
        //val user1 = User(id="2", firstName = "John", lastName = "Wick")
        //val user2 = User(id="3", firstName = "John", lastName = "Silverhand", avatar = null, lastVisit = Date(), isOnline = true)
        val user2 = User(id="2", firstName = "John", lastName = "Sena")

        //user.printMe()
        //user1.printMe()
        //user2.printMe()

        //println("$user $user1 $user2")
    }

    @Test
    fun test_factory(){
       //  User.Factory.makeUser("John Sane")
       // var user = User.makeUser("John Sane")
       // var user1 = User.makeUser("John Wick")
       // var user2 = User.makeUser("John Silverhand")
        val user = User.makeUser("John Wick")
        val user1 = User.makeUser("John")
        val user2 = User.makeUser(" ")
        val user3 = User.makeUser("")
        val user4 = User.makeUser(null)
//        val user2 = user.copy(id = "2", lastName = "Cena", lastVisit = Date())

//        print("$user \n$user2")
        print("$user \n$user1\n$user2\n$user3\n$user4")
    }

    @Test
    fun test_decomposition() {
        val user = User.makeUser("John Wick")
        fun getUserInfo() = user
        val (id, firstName, lastName) = getUserInfo()
        println("$id, $firstName, $lastName")
        println("${user.component1()}, ${user.component2()}, ${user.component3()}")
    }

    @Test
    fun test_copy() {
        val user = User.makeUser("John Wick")
        //val user2 = user
        //var user2 = user.copy()
        val user2 = user.copy(id="2", lastVisit = Date().add(-2, TimeUnits.MINUTE))
        //val user2 = user.copy(lastVisit = Date().add(-2, "hours"))
        val user3 = user.copy(lastName = "Cena", lastVisit = Date().add(2, TimeUnits.HOUR))

        //if (user.equals(user2)){
        //    println("equals data and hash \n ${user.hashCode()} \n $user \n ${user2.hashCode()} \n $user2")
        //}else{
        //    println("not equals data and hash \n ${user.hashCode()} \n $user \n ${user2.hashCode()} \n $user2")
        //}

        //if (user == user2){
        //    println("equals data and hash \n ${user.hashCode()} \n $user \n ${user2.hashCode()} \n $user2")
        //}else{
        //    println("not equals data and hash \n ${user.hashCode()} \n $user \n ${user2.hashCode()} \n $user2")
        //}

        //if (user === user2){
        //    println("equals address \n ${System.identityHashCode(user)} \n $user \n" +
        //            " ${System.identityHashCode(user2)} \n $user2")
        //}else{
        //    println("not equals address \n ${System.identityHashCode(user)} \n $user \n" +
        //            " ${System.identityHashCode(user2)} \n $user2")
        //}
        //user2 = user
        //user2.lastName = "Doe"
        //if (user === user2){
        //    println("equals address \n ${System.identityHashCode(user)} \n $user \n" +
        //           " ${System.identityHashCode(user2)} \n $user2")
        //}else{
        //   println("not equals address \n ${System.identityHashCode(user)} \n $user \n" +
        //           " ${System.identityHashCode(user2)} \n $user2")
        //}

        println("""
            ${user.lastVisit?.format("HH:mm")}
            ${user2.lastVisit?.format()}
            ${user3.lastVisit?.format()}
        """.trimIndent())
    }

    @Test
    fun data_mapping() {
        val user = User.makeUser("Макеев Михаил")
        val newUser = user.copy(lastVisit = Date().add(-7, TimeUnits.SECOND))
        println(user)
        var userView = user.toUserView()
        userView.printMe()
        userView = user.toUserView()
        userView.printMe()
    }

    @Test
    fun test_abstract_factory() {
        val user = User.makeUser("Василий Петров")
        val txtMessage = BaseMessage.makeMessage(user, Chat("0"), payload = "Preved Medved", type = "text")
        val imgMessage = BaseMessage.makeMessage(user, Chat("0"), payload = "Image url of Preved Medved",
            type = "image", isIncoming = true)
        when(txtMessage){
            is TextMessage -> println("This is text message")
            is ImageMessage -> println("This is image message")
        }
        when(imgMessage){
            is TextMessage -> println("This is text message")
            is ImageMessage -> println("This is image message")
        }

        println(txtMessage.formatMessage())
        println(imgMessage.formatMessage())
    }

}
