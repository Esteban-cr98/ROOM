package com.example.room

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.room.model.Registro
import com.example.room.model.RegistroDAO
import kotlinx.android.synthetic.main.activity_register.*
import java.sql.Types.NULL

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)


        bt_registrar.setOnClickListener {

            val correo = et_Correo.text.toString()
            val pass = et_contrasena.text.toString()
            val nombre = et_nombre.text.toString()
            val confpass = et_confContra.text.toString()
            val cedula= et_cedula.text.toString()

            if(correo.isEmpty() || pass.isEmpty() || confpass. isEmpty() || nombre.isEmpty() || cedula.isEmpty()){
                tv_fallo.text ="Complete todos los campos."
            }else{
                if (pass.length > 5){
                    if(pass==confpass){
                        val registro = Registro(NULL, correo, pass, nombre,cedula)
                        val registroDAO : RegistroDAO = ROOM.database2.RegistroDAO()
                        registroDAO.crearRegistro(registro)

                        val intent : Intent =Intent(this, LoginActivity ::class.java)
                        startActivity(intent)
                        Toast.makeText(this, "Registro exitoso",Toast.LENGTH_SHORT).show()
                        finish()
                    }else{
                        tv_fallo.text = "Las contraseñas no coinciden."
                    }
                }else{
                    Toast.makeText(this, "Contraseñas de 6 caracteres mínimo", Toast.LENGTH_SHORT).show()
                }

            }


        }

    }
}