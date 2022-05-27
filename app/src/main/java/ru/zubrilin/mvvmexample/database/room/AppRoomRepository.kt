package ru.zubrilin.mvvmexample.database.room

import androidx.lifecycle.LiveData
import ru.zubrilin.mvvmexample.database.DataBaseRepository
import ru.zubrilin.mvvmexample.models.AppNote

class AppRoomRepository(private val appRoomDao: AppRoomDao): DataBaseRepository {

    override val allNotes: LiveData<List<AppNote>>
        get() = appRoomDao.getAllNotes()

    override suspend fun insert(note: AppNote, onSuccess: () -> Unit) {
        appRoomDao.insert(note)
        onSuccess()
    }

    override suspend fun delete(note: AppNote, onSuccess: () -> Unit) {
        appRoomDao.delete(note)
        onSuccess()
    }
}