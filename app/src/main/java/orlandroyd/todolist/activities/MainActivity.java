package orlandroyd.todolist.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import orlandroyd.todolist.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String[] destinations = getResources().getStringArray(R.array.destinations);

        ArrayAdapter<String> adaptador = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, destinations);

        ListView listView = (ListView) findViewById(R.id.list_main);
        listView.setAdapter(adaptador);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override

            public void onItemClick(AdapterView<?> a, View v, int position, long id) {
                switch (position) {
                    case 0:
                        startActivity(new Intent(getApplicationContext(), ListViewActivity.class));
                        break;
                    case 1:
                        startActivity(new Intent(getApplicationContext(), ListViewCustomActivity.class));
                        break;
                    case 2:
                        startActivity(new Intent(getApplicationContext(), ToDoActivity.class));
                        break;
                    case 3:
                        startActivity(new Intent(getApplicationContext(), RecyclerViewActivity.class));
                        break;
                }
            }
        });


    }

}
