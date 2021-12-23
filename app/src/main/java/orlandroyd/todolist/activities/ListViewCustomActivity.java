package orlandroyd.todolist.activities;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import orlandroyd.todolist.R;
import orlandroyd.todolist.adapter.AdaptadorTitulares;
import orlandroyd.todolist.model.Titular;

public class ListViewCustomActivity extends AppCompatActivity {

    private Titular[] datos = new Titular[]{
            new Titular("Título 1", "Subtítulo largo 1"),
            new Titular("Título 2", "Subtítulo largo 2"),
            new Titular("Título 3", "Subtítulo largo 3"),
            new Titular("Título 4", "Subtítulo largo 4"),
            new Titular("Título 5", "Subtítulo largo 5")
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view_custom);
        // Back
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_arrow_back);

        AdaptadorTitulares adaptador =
                new AdaptadorTitulares(this, datos);
        ListView lstOpciones = (ListView) findViewById(R.id.list_opciones);
        lstOpciones.setAdapter(adaptador);

        lstOpciones.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> a, View v, int position, long id) {
                String opcionSeleccionada =
                        ((Titular) a.getAdapter().getItem(position)).getTitulo();
                Toast.makeText(getApplicationContext(), "Opción seleccionada: " + opcionSeleccionada,
                        Toast.LENGTH_SHORT).show();
            }
        });
    }
}
