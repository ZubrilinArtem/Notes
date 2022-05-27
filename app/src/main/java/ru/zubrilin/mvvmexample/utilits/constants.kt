package ru.zubrilin.mvvmexample.utilits

import ru.zubrilin.mvvmexample.MainActivity
import ru.zubrilin.mvvmexample.database.DataBaseRepository

lateinit var APP_ACTIVITY: MainActivity
lateinit var REPOSITORY: DataBaseRepository
const val TYPE_DATABASE = "type database"
const val TYPE_ROOM = "type_room"
const val TYPE_FIREBASE = "type_firebase"
lateinit var EMAIL:String
lateinit var PASSWORD:String