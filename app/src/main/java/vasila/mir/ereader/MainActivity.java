package vasila.mir.ereader;


import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import vasila.mir.ereader.data.db.BooksDbHelper;

public class MainActivity extends AppCompatActivity {
    RecyclerView dataList;
    List<Integer> images;
    MainAdapter adapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        BooksDbHelper helper = new BooksDbHelper(this);
        SQLiteDatabase myDatabase = helper.getReadableDatabase();


        Cursor cursor = myDatabase
                    .rawQuery("SELECT * FROM pages WHERE pageID = 2", new String[]{});
        cursor.moveToFirst();

        Log.d("NAAAAAAME",cursor.getString(cursor.getColumnIndex("pageContents")));


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dataList = findViewById(R.id.data_list);

        images = new ArrayList<>();

        images.add(R.drawable.kite_runner);
        images.add(R.drawable.cinder);
        images.add(R.drawable.flowers_for_algernon);

        adapter = new MainAdapter(this,images);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,2,GridLayoutManager.VERTICAL,false);
        dataList.setLayoutManager(gridLayoutManager);
        dataList.setAdapter(adapter);


    }
}