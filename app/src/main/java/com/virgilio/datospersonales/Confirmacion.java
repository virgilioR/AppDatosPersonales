package com.virgilio.datospersonales;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Confirmacion extends AppCompatActivity {

    private TextView txtNombre;
    private TextView txtDob;
    private TextView txtTelefono;
    private TextView txtEmail;
    private TextView txtDescripcion;
    private Button btnEditar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmacion);

        txtNombre = (TextView) findViewById(R.id.txtNombre);
        txtDob = (TextView) findViewById(R.id.txtDob);
        txtTelefono = (TextView) findViewById(R.id.txtTelefono);
        txtEmail = (TextView) findViewById(R.id.txtEmail);
        txtDescripcion = (TextView) findViewById(R.id.txtDescripcion);
        btnEditar = (Button) findViewById(R.id.btnEditar);

        Bundle extras = getIntent().getExtras();

        txtNombre.setText( extras.getString("nombre") );
        txtDob.setText( extras.getString("dob") );
        txtTelefono.setText( extras.getString("telefono") );
        txtEmail.setText( extras.getString("email") );
        txtDescripcion.setText( extras.getString("descripcion") );

        btnEditar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent( getApplicationContext(), MainActivity.class );
                i.putExtra("nombre", txtNombre.getText().toString());
                i.putExtra("dob", txtDob.getText().toString());
                i.putExtra("telefono", txtTelefono.getText().toString());
                i.putExtra("email", txtEmail.getText().toString());
                i.putExtra("descripcion", txtDescripcion.getText().toString());
                i.putExtra("action", "edit");
                startActivity( i );
            }
        });
    }
}