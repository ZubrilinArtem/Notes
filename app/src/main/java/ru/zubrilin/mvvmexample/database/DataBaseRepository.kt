package ru.zubrilin.mvvmexample.database

import androidx.lifecycle.LiveData
import ru.zubrilin.mvvmexample.models.AppNote

interface DataBaseRepository {

    val allNotes:LiveData<List<AppNote>>

    suspend fun insert(note: AppNote, onSuccess:()->Unit)
    suspend fun delete(note: AppNote, onSuccess:()->Unit)

}