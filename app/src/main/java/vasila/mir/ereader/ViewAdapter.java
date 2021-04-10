 package vasila.mir.ereader;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ViewAdapter extends RecyclerView.Adapter<ViewAdapter.ViewHolder> {
     List<Integer> textViews;
     LayoutInflater inflater;

    public ViewAdapter(Context ctx, List<Integer> textViews){
        this.textViews = textViews;
        this.inflater = LayoutInflater.from(ctx);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater
                .inflate(R.layout.item_main, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.textView.setText(textViews.get(position));
    }

    @Override
    public int getItemCount() {
        return textViews.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView textView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            textView = itemView.findViewById(R.id.text_view);
        }
    }


}

