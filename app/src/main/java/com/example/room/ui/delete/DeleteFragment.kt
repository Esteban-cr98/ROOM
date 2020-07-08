package com.example.room.ui.delete

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.room.R
import com.example.room.ROOM
import com.example.room.model.DeudorDAO
import kotlinx.android.synthetic.main.fragment_delete.*

class DeleteFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_delete, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        bt_eliminar.setOnClickListener{
            val nombre = et_nombre.text.toString()

            val deudorDAO = ROOM.database.DeudorDAO()
            val deudor = deudorDAO.buscarDeudor(nombre)

            if(deudor != null){
                deudorDAO.borrarDeudor(deudor)
            } else {
                Toast.makeText(context, "Deudor no encontrado", Toast.LENGTH_SHORT).show()
            }
        }
    }

}