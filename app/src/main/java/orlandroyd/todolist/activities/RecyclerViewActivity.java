package orlandroyd.todolist.activities;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.ArrayList;

import orlandroyd.todolist.R;
import orlandroyd.todolist.adapter.AdaptadorPeloteros;
import orlandroyd.todolist.model.Pelotero;

public class RecyclerViewActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private AdaptadorPeloteros adapter;

    ArrayList<Pelotero> datos = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);

        // Back
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_arrow_back);

        // Llenar la lista
        for (int i = 0; i < 5; i++) {
            datos.add(new Pelotero(R.drawable.img_ayala, "Alexander Ayala", "Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod"));
            datos.add(new Pelotero(R.drawable.img_madam, "Frank Mádam", "Sit amet, consectetur adipisicing elit, sed do eiusmod"));
            datos.add(new Pelotero(R.drawable.img_tellez, "Yendri Téllez", "Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod"));
            datos.add(new Pelotero(R.drawable.img_moa, "Leonel Moa Jr.", "Tempor incididunt ut labore et dolore magna aliqua. Ut enim ad mi"));
            datos.add(new Pelotero(R.drawable.img_samon, "Yordanis Samón", "Quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea com"));
        }

        // Setup Recycler
        recyclerView = findViewById(R.id.recycler);
        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        adapter = new AdaptadorPeloteros(datos);
        recyclerView.setAdapter(adapter);

        // OnClick
        adapter.setOnItemClickListener(new AdaptadorPeloteros.OnItemClickListener() {

            @Override
            public void OnItemClick(Pelotero pelotero) {
                Toast.makeText(getApplicationContext(), "Seleccionado: " + pelotero.getTitle(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void OnDeleteClick(int position) {
                removeItem(position);
            }
        });

    }

    public void removeItem(int position) {
        datos.remove(position);
        adapter.notifyItemRemoved(position);
    }

}
