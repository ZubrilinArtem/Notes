package ru.zubrilin.mvvmexample.utilits

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import ru.zubrilin.mvvmexample.MainActivity
import ru.zubrilin.mvvmexample.database.DataBaseRepository

lateinit var APP_ACTIVITY: MainActivity
lateinit var REPOSITORY: DataBaseRepository
const val TYPE_DATABASE = "type database"
const val TYPE_ROOM = "type_room"
const val TYPE_FIREBASE = "type_firebase"
lateinit var EMAIL:String
lateinit var PASSWORD:String
const val ID_FIREBASE = "idFirebase"
const val NAME = "name"
const val TEXT = "text"
lateinit var AUTH: FirebaseAuth
lateinit var CURRENT_ID:String
lateinit var REF_DATABASE: DatabaseReference