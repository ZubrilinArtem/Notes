package ru.zubrilin.mvvmexample.database.firebase

import androidx.lifecycle.LiveData
import com.google.firebase.auth.FirebaseAuth
import ru.zubrilin.mvvmexample.database.DataBaseRepository
import ru.zubrilin.mvvmexample.models.AppNote
import ru.zubrilin.mvvmexample.utilits.EMAIL
import ru.zubrilin.mvvmexample.utilits.PASSWORD

class AppFirebaseRepository: DataBaseRepository {

    private val mAuth = FirebaseAuth.getInstance()

    override val allNotes: LiveData<List<AppNote>>
        get() = TODO("Not yet implemented")

    override suspend fun insert(note: AppNote, onSuccess: () -> Unit) {
        TODO("Not yet implemented")
    }

    override suspend fun delete(note: AppNote, onSuccess: () -> Unit) {
        TODO("Not yet implemented")
    }

    override fun connectToDatabase(onSuccess: () -> Unit, onFail: (String) -> Unit) {
        mAuth.signInWithEmailAndPassword(EMAIL, PASSWORD)
            .addOnSuccessListener { onSuccess() }
            .addOnFailureListener {
                mAuth.createUserWithEmailAndPassword(EMAIL, PASSWORD)
                    .addOnSuccessListener { onSuccess() }
                    .addOnFailureListener{ onFail(it.message.toString()) }
            }
    }

    override fun signOut() {
        mAuth.signOut()
    }
}