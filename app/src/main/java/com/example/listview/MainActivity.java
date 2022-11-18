package com.example.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv=findViewById(R.id.textView);

        //Creamos un array con los elementos seleccionables
        String[]elementos={getString(R.string.galicia),getString(R.string.asturias),
                           getString(R.string.cantabria),getString(R.string.navarra),
                           getString(R.string.aragon),getString(R.string.castilla)};

        //Obtenemos la referencia de la lista
        ListView l= findViewById(R.id.lista);

        //Creamos un adaptador de texto(String)
        //Creamos el adaptador
        ArrayAdapter<String> adaptador;
        adaptador= new ArrayAdapter<String>(this,R.layout.fila,elementos);

        //Añadimos el listener
        l.setOnItemClickListener(this);

        //Le damos el adaptador a la lista
        l.setAdapter(adaptador);



    }
    @Override
    public void onItemClick(AdapterView<?> adapterview, View view, int i, long l){
        tv.setText(("Has elegido " + adapterview.getItemAtPosition(i).toString()));
    }
}