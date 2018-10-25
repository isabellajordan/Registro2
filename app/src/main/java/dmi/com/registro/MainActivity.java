package dmi.com.registro;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    //Con base de datos

    EditText nombre;
    EditText correo;
    EditText contrasena;
    Button enviar;

    FirebaseDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Instanciar base de datos
        db= FirebaseDatabase.getInstance();

        nombre= findViewById(R.id.edt_nombre);
        correo= findViewById(R.id.edt_correo);
        contrasena= findViewById(R.id.edt_contrasena);
        enviar=findViewById(R.id.btn_enviar);

        //Acceder a la base de datos
        enviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Usuario usuario= new Usuario(nombre.getText().toString(),correo.getText().toString(),contrasena.getText().toString());
                //
                db.getReference().child("usuarios").setValue(usuario);
            }
        });

    }
}
