package ru.skillbranch.devintensive.models

class Chat(
    val id : String,
    val members: MutableList<User> = mutableListof(),
    val messages: MutableList<BaseMessage> = mutableListof()

    ) {


}