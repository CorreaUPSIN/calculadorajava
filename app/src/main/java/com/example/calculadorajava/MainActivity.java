package com.example.calculadorajava;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Button;
import android.view.View;
import android.widget.Toast;
import android.content.Intent;
import android.app.AlertDialog;
import android.content.DialogInterface;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Obtener los valores de strings.xml
        String usuario = getResources().getString(R.string.Usuario);
        String contraseña = getResources().getString(R.string.Contraseña);
        String nombreUsuario = getResources().getString(R.string.nombreUsuario);

        // Obtener una referencia al EditText
        EditText inputUser = findViewById(R.id.inputUser);
        EditText inputPass = findViewById(R.id.inputPass);

        // Obtener una referencia al botón
        Button btnLogin = findViewById(R.id.btnLogin);
        Button btnSalir = findViewById(R.id.btnSalir);


        // Hacer algo con el botón obtenido
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Obtener el contenido del EditText
                String nombreUsuario = inputUser.getText().toString();
                String passUsuario = inputPass.getText().toString();

                if (nombreUsuario.equals(usuario) && passUsuario.equals(contraseña)) {
                    Bundle bundle = new Bundle();
                    bundle.putString("Usuario", nombreUsuario);


                    Toast.makeText(getApplicationContext(), "Bienvenido", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(MainActivity.this, CalculadorActivity.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(getApplicationContext(), "Usuario:" + usuario + ", Contraseña:"+ contraseña , Toast.LENGTH_SHORT).show();

                }

            }
        });

        btnSalir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Confirmación");
                builder.setMessage("¿Estás seguro de querer salir?");
                builder.setPositiveButton("Sí", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // Acciones a realizar si se selecciona "Sí"
                        finishAffinity(); // Cierra todas las actividades y sale de la aplicación
                    }
                });
                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // Acciones a realizar si se selecciona "No"
                        dialog.dismiss(); // Cierra el diálogo sin realizar ninguna acción adicional
                    }
                });
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });


    }
}