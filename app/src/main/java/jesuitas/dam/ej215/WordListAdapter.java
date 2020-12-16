package jesuitas.dam.ej215;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.LinkedList;
import java.util.List;

public class WordListAdapter extends RecyclerView.Adapter<WordListAdapter.WordViewHolder> {

    private List<Peliculas> mpeliculas;
    private Context mcontext;
    private LayoutInflater mInflater;

    public WordListAdapter(Context context, List<Peliculas> peliculas) {
        mInflater=LayoutInflater.from(context);
        mpeliculas=peliculas;
        mcontext=context;
    }

    class WordViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        public TextView textname;
        public TextView textGenre;
        public ImageView imagen;

        public WordViewHolder(@NonNull View itemView, WordListAdapter adapter) {
            super(itemView);
            textname=itemView.findViewById(R.id.name);
            textGenre=itemView.findViewById(R.id.genero);
            imagen=itemView.findViewById(R.id.imagen_id);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int mposition=getLayoutPosition();
            String web=mpeliculas.get(mposition).murl;
            Intent intent= new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse(web));
            if (intent.resolveActivity(mcontext.getPackageManager()!=null)){
                mcontext.startActivity(intent);
            }
        }
    }

    @NonNull
    @Override
    public WordListAdapter.WordViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mItemView = mInflater.inflate(R.layout.wordlist_item, parent, false);
        return new WordViewHolder(mItemView, this);
    }

    @Override
    public void onBindViewHolder(@NonNull WordListAdapter.WordViewHolder holder, int position) {
        holder.textname.setText(mpeliculas.get(position).mnombre);
        holder.textGenre.setText(mpeliculas.get(position).mgenero);
        holder.imagen.setImageResource(mpeliculas.get(position).mimagen);
    }

    @Override
    public int getItemCount() {
        return mpeliculas.size();
    }
}
