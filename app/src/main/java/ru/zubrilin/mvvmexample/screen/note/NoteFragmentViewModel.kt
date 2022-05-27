package ru.zubrilin.mvvmexample.screen.note

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import ru.zubrilin.mvvmexample.models.AppNote
import ru.zubrilin.mvvmexample.utilits.REPOSITORY

class NoteFragmentViewModel(application: Application): AndroidViewModel(application) {

    fun delete(note:AppNote, onSucces: () -> Unit) =
        viewModelScope.launch(Dispatchers.IO){
            REPOSITORY.delete(note){
                launch(Dispatchers.Main){
                    onSucces()
                }
            }
        }

}