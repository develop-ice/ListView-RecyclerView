package orlandroyd.todolist.activities;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import orlandroyd.todolist.R;

public class ListViewActivity extends AppCompatActivity {

    final String[] datos = new String[]{"Elem1", "Elem2", "Elem3", "Elem4", "Elem5"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);
        // Back
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_arrow_back);

        ArrayAdapter<String> adaptador = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, datos);

        ListView lstOpciones = (ListView) findViewById(R.id.list_opciones);

        lstOpciones.setAdapter(adaptador);

    }
}
