/** package vasila.mir.ereader;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class PageNumAdapter extends RecyclerView.Adapter<PageNumAdapter.ViewHolder> {
    List<Integer> pageNums;
    LayoutInflater inflater;

    public PageNumAdapter(Context ctx, List<Integer> textViews){
        this.pageNums = pageNums;
        this.inflater = LayoutInflater.from(ctx);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater
                .inflate(R.layout.page_number, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.pageNum.setText(pageNums.get(position));
    }

    @Override
    public int getItemCount() {
        return pageNums.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView pageNum;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            pageNum = itemView.findViewById(R.id.pageNum);
        }
    }


}
 **/