package ru.zubrilin.mvvmexample.screen.start

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import ru.zubrilin.mvvmexample.database.firebase.AppFirebaseRepository
import ru.zubrilin.mvvmexample.database.room.AppRoomDatabase
import ru.zubrilin.mvvmexample.database.room.AppRoomRepository
import ru.zubrilin.mvvmexample.utilits.REPOSITORY
import ru.zubrilin.mvvmexample.utilits.TYPE_FIREBASE
import ru.zubrilin.mvvmexample.utilits.TYPE_ROOM
import ru.zubrilin.mvvmexample.utilits.showToast

class StartFragmentViewModel(application: Application): AndroidViewModel(application) {
    private val context = application

    fun initDatabase(type: String, onSuccess: () -> Unit){
        when(type){
            TYPE_ROOM -> {
                val dao = AppRoomDatabase.getInstance(context).getAppRoomDao()
                REPOSITORY = AppRoomRepository(dao)
                onSuccess()
            }
            TYPE_FIREBASE -> {
                REPOSITORY = AppFirebaseRepository()
                REPOSITORY.connectToDatabase({onSuccess()}, { showToast(it)})
            }
        }
    }
}