package orlandroyd.todolist.activities;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import orlandroyd.todolist.R;
import orlandroyd.todolist.util.FileHelper;

public class ToDoActivity extends AppCompatActivity {

    // UI
    EditText etItem;
    Button btnAgregar;
    ListView lvLista;
    // Adapter
    ArrayList<String> itemList = new ArrayList<>();
    ArrayAdapter<String> arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todo);

        // Back
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_close);

        // inicializar los view en UI
        init();
        // llenar la lista
        setupList();
        // Añadir onClick
        btnAgregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addItem();
            }
        });
        // Eliminar de la lista
        lvLista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Mostrar un Dialogo
                showDialogDelete(position);
            }
        });
    }

    private void init() {
        etItem = (EditText) findViewById(R.id.et_nota);
        btnAgregar = (Button) findViewById(R.id.btn_agregar);
        lvLista = (ListView) findViewById(R.id.list_notas);
    }

    private void setupList() {
        itemList = FileHelper.readData(this);
        arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, itemList);
        lvLista.setAdapter(arrayAdapter);
    }

    private void addItem() {
        // Obtener el texto del editText
        String nota = etItem.getText().toString().trim();
        // Validación
        if (!nota.isEmpty()) {
            // Agregar a la lista
            itemList.add(nota);
            // Limpiar el editText
            etItem.setText("");
            // Guardar en el File
            FileHelper.writeData(itemList, getApplicationContext());
            // Actualizar el ListView
            arrayAdapter.notifyDataSetChanged();

        } else {
            Toast.makeText(this, "Nota vacía...", Toast.LENGTH_SHORT).show();
        }
    }

    private void showDialogDelete(final int position) {
        // Setup Alert Dialog
        AlertDialog.Builder dialog = new AlertDialog.Builder(ToDoActivity.this);
        // Titulo
        dialog.setTitle("Eliminar");
        // Mensaje
        dialog.setMessage("Desea eliminar este item?");
        // Quitar que se cancele si se presiona fuera del dialogo
        dialog.setCancelable(false);
        // Boton negativo
        dialog.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        // Boton positivo
        dialog.setPositiveButton("Si", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                itemList.remove(position);
                arrayAdapter.notifyDataSetChanged();
                FileHelper.writeData(itemList, getApplicationContext());
            }
        });
        // Crear el Alert Dialog
        AlertDialog alertDialog = dialog.create();
        // Mostrar el dialogo
        alertDialog.show();
    }

}
