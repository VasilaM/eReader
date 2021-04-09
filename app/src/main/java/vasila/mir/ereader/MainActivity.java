package vasila.mir.ereader;


import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView dataList;
    List<Integer> images;
    MainAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dataList = findViewById(R.id.data_list);


        images = new ArrayList<>();

        images.add(R.drawable.kite_runner);
        images.add(R.drawable.kite_runner);
        images.add(R.drawable.kite_runner);
        images.add(R.drawable.kite_runner);
        images.add(R.drawable.kite_runner);
        images.add(R.drawable.kite_runner);
        images.add(R.drawable.kite_runner);
        images.add(R.drawable.kite_runner);
        adapter = new MainAdapter(this,images);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,2,GridLayoutManager.VERTICAL,false);
        dataList.setLayoutManager(gridLayoutManager);
        dataList.setAdapter(adapter);


    }
}