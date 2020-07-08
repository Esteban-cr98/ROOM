package com.example.room

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.room.model.RegistroDAO
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)


        bt_register.setOnClickListener {
            val intent : Intent =Intent(this, RegisterActivity ::class.java)
            startActivity(intent)
        }

        bt_log.setOnClickListener {

            val correo = et_email.text.toString()
            val pass = et_pass.text.toString()
            val registroDAO : RegistroDAO = ROOM.database2.RegistroDAO()
            val registro = registroDAO.buscarRegistro(correo)

            if(registro != null){
                if (pass == registro.clave){
                    startActivity(Intent(this, MainActivity ::class.java))
                }else{
                    Toast.makeText(this,"Clave incorrecta", Toast.LENGTH_SHORT).show()
                }
            }else{
                Toast.makeText(this,"Usuario no registrado", Toast.LENGTH_SHORT).show()
            }
        }
    }
}