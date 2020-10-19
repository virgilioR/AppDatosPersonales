package com.virgilio.datospersonales;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView txtNombre;
    private DatePicker dpDob;
    private TextView txtTelefono;
    private TextView txtEmail;
    private TextView txtDescripcion;
    private Button btnSiguiente;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtNombre = (TextView) findViewById(R.id.txtNombre);
        dpDob = (DatePicker) findViewById(R.id.dpDob);
        txtTelefono = (TextView) findViewById(R.id.txtTelefono);
        txtEmail = (TextView) findViewById(R.id.txtEmail);
        txtDescripcion = (TextView) findViewById(R.id.txtDescripcion);
        btnSiguiente = (Button) findViewById(R.id.btnSiguiente);


        // action = extras.getString("action", "");
        //Log.e( "intent", this.getIntent().getDataString() );
        if( this.getIntent().getExtras() != null ){
            Bundle extras = getIntent().getExtras();
            txtNombre.setText( extras.getString("nombre") );
            txtTelefono.setText( extras.getString("telefono") );
            txtEmail.setText( extras.getString("email") );
            txtDescripcion.setText( extras.getString("descripcion") );

            String date = extras.getString("dob");
            String[] dateSplit = date.split("/");
            int dia = Integer.valueOf(dateSplit[0]);
            int mes = Integer.valueOf(dateSplit[1]);
            int anio = Integer.valueOf(dateSplit[2]);
            dpDob.updateDate(anio, ( mes - 1 ), dia);
        }

        btnSiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String d = dpDob.getDayOfMonth() < 10 ? "0" + dpDob.getDayOfMonth() : "" + dpDob.getDayOfMonth();
                String m = ( dpDob.getMonth() + 1 ) < 10 ? "0" + ( dpDob.getMonth() + 1 ) : "" + ( dpDob.getMonth() + 1 );
                Intent i = new Intent( getApplicationContext(), Confirmacion.class );
                i.putExtra("nombre", txtNombre.getText().toString());
                i.putExtra("dob", d + "/" + m + "/" + dpDob.getYear());
                i.putExtra("telefono", txtTelefono.getText().toString());
                i.putExtra("email", txtEmail.getText().toString());
                i.putExtra("descripcion", txtDescripcion.getText().toString());
                startActivity( i );
            }
        });

    }
}