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

import vasila.mir.ereader.data.db.Book;


public class MainAdapter extends RecyclerView.Adapter<MainAdapter.ViewHolder> {

    private List<Integer> images;
    private List<Book> listOfBooks; // null
    private OnItemClickListener listener;

    public MainAdapter(List<Integer> images, OnItemClickListener listener){
        this.images = images;
        this.listener = listener;
    }

    public void setListOfBooks(List<Book> books) {
        this.listOfBooks = books;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.custom_grid_layout, parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        if(listOfBooks != null) {
            holder.gridIcon.setImageResource(images.get(position));
            holder.bookName.setText(listOfBooks.get(position).bookName);
        }
    }

    @Override
    public int getItemCount() {
        if(listOfBooks != null)
            return listOfBooks.size();
        else return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView gridIcon;
        TextView bookName;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            gridIcon = itemView.findViewById(R.id.image_view);
            bookName = itemView.findViewById(R.id.book_name);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            listener.onItemClick(listOfBooks.get(getAdapterPosition()));
        }
    }

    public interface OnItemClickListener {
        public void onItemClick(Book book);
    }
}
