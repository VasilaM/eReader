package vasila.mir.ereader;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import vasila.mir.ereader.data.db.BooksDbHelper;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.ViewHolder> {

    List<Integer> images;
    LayoutInflater inflater;
    Context context;
    public MainAdapter(Context ctx, List<Integer> images){
        this.images = images;
        this.inflater = LayoutInflater.from(ctx);
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.custom_grid_layout,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.gridIcon.setImageResource(images.get(position));
    }

    @Override
    public int getItemCount() {
        return images.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView gridIcon;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            context = itemView.getContext();
            gridIcon = itemView.findViewById(R.id.image_view);

            itemView.setOnClickListener(v ->{
                    Intent intent = new Intent(context, ViewPager.class);
                    context.startActivity(intent);
            });
        }
    }
}
