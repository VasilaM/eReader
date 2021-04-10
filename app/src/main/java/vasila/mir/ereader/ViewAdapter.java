package vasila.mir.ereader;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import vasila.mir.ereader.data.db.Page;

public class ViewAdapter extends RecyclerView.Adapter<ViewAdapter.ViewHolder> {

    private List<Page> pageList;

    public void setPages(List<Page> listOfPages) {
        this.pageList = listOfPages;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_main, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        if(pageList != null) {
            holder.textView.setText(pageList.get(position).pageContents);
            holder.pageNumber.setText(String.valueOf(pageList.get(position).pageNum));
        }
    }

    @Override
    public int getItemCount() {
        if(pageList != null)
            return pageList.size();
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView textView;
        TextView pageNumber;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.pageContents);
            pageNumber = itemView.findViewById(R.id.page_number);
        }
    }
}

