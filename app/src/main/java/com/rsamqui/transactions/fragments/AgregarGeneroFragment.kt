package com.rsamqui.transactions.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.rsamqui.transactions.R
import com.rsamqui.transactions.dao.GeneroDao
import com.rsamqui.transactions.database.DBGenero
import com.rsamqui.transactions.databinding.FragmentAgregarGeneroBinding
import com.rsamqui.transactions.entities.GeneroEntity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AgregarGeneroFragment : Fragment() {

    private lateinit var binding:FragmentAgregarGeneroBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentAgregarGeneroBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val navController = Navigation.findNavController(view)
        val db: DBGenero = DBGenero.getInstace(this.requireContext().applicationContext)
        val dao: GeneroDao = db.generoDao()

        with(binding){
            btnAgregar.setOnClickListener {

                val id = GeneroEntity(0, generoNombre.text.toString(), true)

                CoroutineScope(Dispatchers.Main).launch {
                    dao.insertGenero(id)
                }
                navController.navigate(R.id.action_agregarGeneroFragment_to_generoFragment)

            }
        }
    }

}