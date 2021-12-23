package orlandroyd.todolist.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import orlandroyd.todolist.R;
import orlandroyd.todolist.model.Titular;

public class AdaptadorTitulares extends ArrayAdapter {

    private Titular[] datos;
    private Activity context;

    public AdaptadorTitulares(Activity context, Titular[] datos) {
        super(context, R.layout.listitem_titular, datos);
        this.context = context;
        this.datos = datos;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View item = inflater.inflate(R.layout.listitem_titular, null);
        TextView lblTitulo = (TextView) item.findViewById(R.id.LblTitulo);
        lblTitulo.setText(datos[position].getTitulo());
        TextView lblSubtitulo = (TextView) item.findViewById(R.id.LblSubTitulo);
        lblSubtitulo.setText(datos[position].getSubtitulo());
        return (item);
    }
}
