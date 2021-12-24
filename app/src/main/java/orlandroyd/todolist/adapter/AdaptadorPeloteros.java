package orlandroyd.todolist.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import orlandroyd.todolist.R;
import orlandroyd.todolist.model.Pelotero;

public class AdaptadorPeloteros extends RecyclerView.Adapter<AdaptadorPeloteros.PeloterosViewHolder> {

    private ArrayList<Pelotero> datos = new ArrayList<>();

    class PeloterosViewHolder extends RecyclerView.ViewHolder {

        ImageView imgAvatar;
        TextView tvTitulo;
        TextView tvSub;
        ImageView imgDelete;

        PeloterosViewHolder(View itemView) {
            super(itemView);
            imgAvatar = itemView.findViewById(R.id.img_avatar);
            tvTitulo = itemView.findViewById(R.id.tv_title);
            tvSub = itemView.findViewById(R.id.tv_sub);
            imgDelete = itemView.findViewById(R.id.img_delete);

            // OnCLick general
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    if (listener != null && position != RecyclerView.NO_POSITION) {
                        listener.OnItemClick(datos.get(position));
                    }
                }
            });

            // OnCLick especifico
            imgDelete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    if (listener != null && position != RecyclerView.NO_POSITION) {
                        listener.OnDeleteClick(position);
                    }
                }
            });

        }
    }

    public AdaptadorPeloteros(ArrayList<Pelotero> datos) {
        this.datos = datos;
    }

    @Override
    public PeloterosViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.listitem_recycler, parent, false);
        return new PeloterosViewHolder(view);
    }

    @Override
    public void onBindViewHolder(PeloterosViewHolder holder, int position) {

        Pelotero currentItem = datos.get(position);

        holder.imgAvatar.setImageResource(currentItem.getImgAvatar());
        holder.tvTitulo.setText(currentItem.getTitle());
        holder.tvSub.setText(currentItem.getSub());

    }

    @Override
    public int getItemCount() {
        return datos.size();
    }

    /**
     * OnClick
     */
    private OnItemClickListener listener;

    public interface OnItemClickListener {
        void OnItemClick(Pelotero pelotero);
        void OnDeleteClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }
}
