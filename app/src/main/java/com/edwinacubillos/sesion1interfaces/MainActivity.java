package com.edwinacubillos.sesion1interfaces;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private String nombre, apellido, mail, telefono, sexo, hobbies = "",ciudad;
    private EditText eNombre, eApellido, eMail, eTelefono;
    private RadioButton rMasculino, rFemenino;
    private CheckBox cCine, cDormir, cComer, cBailar;
    private Spinner sCiudades;

    private TextView tInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        eNombre = (EditText) findViewById(R.id.eNombre);
        eApellido = (EditText) findViewById(R.id.eApellido);
        tInfo = (TextView) findViewById(R.id.tInfo);
        eMail = (EditText) findViewById(R.id.eMail);
        eTelefono = (EditText) findViewById(R.id.eTelefono);
        rMasculino = (RadioButton) findViewById(R.id.rMasculino);
        rFemenino = (RadioButton) findViewById(R.id.rFemenino);
        cCine = (CheckBox) findViewById(R.id.cCine);
        cDormir = (CheckBox) findViewById(R.id.cDormir);
        cComer = (CheckBox) findViewById(R.id.cComer);
        cBailar = (CheckBox) findViewById(R.id.cBailar);
        sCiudades = (Spinner) findViewById(R.id.sCiudades);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.ciudades, android.R.layout.simple_spinner_item);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        sCiudades.setAdapter(adapter);

        sCiudades.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                ciudad = adapterView.getItemAtPosition(i).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }

    public void Registrar(View view) {
        nombre = eNombre.getText().toString();
        apellido = eApellido.getText().toString();
        mail = eMail.getText().toString();
        telefono = eTelefono.getText().toString();

        if (cCine.isChecked()) {
            hobbies += "cine ";
        }
        if (cDormir.isChecked()) {
            hobbies += "dormir ";
        }
        if (cComer.isChecked()) {
            hobbies += "comer ";
        }
        if (cBailar.isChecked()) {
            hobbies += "bailar ";
        }

        if (rMasculino.isChecked()) {
            sexo = "Masculino";
        } else {
            sexo = "Femenino";
        }

        tInfo.setText("Nombre: " + nombre + " \nApellido: " + apellido + " \nCorreo: " + mail + " \nTelefono: " + telefono +
                " \nSexo: " + sexo + " \nhobbies: " + hobbies+ " \nciudad: " + ciudad);
    }
}
