package com.rsamqui.transactions.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.rsamqui.transactions.R
import com.rsamqui.transactions.adapters.GeneroAdapter
import com.rsamqui.transactions.dao.GeneroDao
import com.rsamqui.transactions.database.DBGenero
import com.rsamqui.transactions.databinding.FragmentGeneroBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class GeneroFragment : Fragment() {

    lateinit var binding: FragmentGeneroBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentGeneroBinding.inflate(inflater, container, false)
        return binding.root
        }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val navController = Navigation.findNavController(view)
        val db: DBGenero = DBGenero.getInstace(this.requireContext().applicationContext)
        val dao: GeneroDao = db.generoDao()

        CoroutineScope(Dispatchers.Main).launch {
            var listU = dao.getAll()

            binding.recyclerGenero.layoutManager = LinearLayoutManager(context)
            val adapter = GeneroAdapter(listU)
            binding.recyclerGenero.adapter = adapter
        }

        binding.btnAgregar.setOnClickListener {
            navController.navigate(R.id.action_generoFragment_to_agregarGeneroFragment)
        }
    }

}