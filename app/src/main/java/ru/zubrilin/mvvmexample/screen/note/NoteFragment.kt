package ru.zubrilin.mvvmexample.screen.note

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import androidx.recyclerview.widget.RecyclerView
import ru.zubrilin.mvvmexample.R
import ru.zubrilin.mvvmexample.databinding.FragmentMainBinding
import ru.zubrilin.mvvmexample.databinding.FragmentNoteBinding
import ru.zubrilin.mvvmexample.models.AppNote
import ru.zubrilin.mvvmexample.screen.main.MainAdapter
import ru.zubrilin.mvvmexample.screen.main.MainFragmentViewModel
import ru.zubrilin.mvvmexample.utilits.APP_ACTIVITY

class NoteFragment : Fragment() {

    private var _binding: FragmentNoteBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel: NoteFragmentViewModel
    private lateinit var currentNote: AppNote


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentNoteBinding.inflate(layoutInflater, container, false)
        currentNote = arguments?.getSerializable("note") as AppNote
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        initialization()
    }

    private fun initialization() {
        setHasOptionsMenu(true)
        viewModel = ViewModelProvider(this).get(NoteFragmentViewModel::class.java)
        binding.noteText.text = currentNote.text
        binding.noteName.text = currentNote.name
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.note_action_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.btn_delete -> {
                viewModel.delete(currentNote){
                    APP_ACTIVITY.navController.navigate(R.id.action_noteFragment_to_mainFragment)
                }
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}