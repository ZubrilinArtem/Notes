package ru.zubrilin.mvvmexample.screen.main

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import ru.zubrilin.mvvmexample.utilits.REPOSITORY

class MainFragmentViewModel(application: Application): AndroidViewModel(application) {
    val allNotes = REPOSITORY.allNotes
    fun signOut(){
        REPOSITORY.signOut()
    }

}