package ru.zubrilin.mvvmexample.database.room

import androidx.lifecycle.LiveData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import ru.zubrilin.mvvmexample.database.DataBaseRepository
import ru.zubrilin.mvvmexample.models.AppNote

class AppRoomRepository(private val appRoomDao: AppRoomDao): DataBaseRepository {

    override val allNotes: LiveData<List<AppNote>>
        get() = appRoomDao.getAllNotes()

    override suspend fun insert(note: AppNote, onSuccess: () -> Unit) {
        appRoomDao.insert(note)
        coroutineScope { launch(Dispatchers.Main){onSuccess()} }

    }

    override suspend fun delete(note: AppNote, onSuccess: () -> Unit) {
        appRoomDao.delete(note)
        coroutineScope { launch(Dispatchers.Main){onSuccess()} }
    }

    override fun signOut() {
        super.signOut()
    }
}