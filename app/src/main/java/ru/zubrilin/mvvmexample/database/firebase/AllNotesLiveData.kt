package ru.zubrilin.mvvmexample.database.firebase

import androidx.lifecycle.LiveData
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.firebase.ktx.Firebase
import ru.zubrilin.mvvmexample.models.AppNote
import ru.zubrilin.mvvmexample.utilits.REF_DATABASE

class AllNotesLiveData : LiveData<List<AppNote>>() {

    private val listenner = object : ValueEventListener {
        override fun onDataChange(snapshot: DataSnapshot) {
            value = snapshot.children.map {
                it.getValue(AppNote::class.java) ?: AppNote()
            }
        }

        override fun onCancelled(error: DatabaseError) {

        }

    }

    override fun onActive() {
        REF_DATABASE.addValueEventListener(listenner)
        super.onActive()
    }

    override fun onInactive() {
        REF_DATABASE.removeEventListener(listenner)
        super.onInactive()
    }
}