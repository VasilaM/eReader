package vasila.mir.ereader;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import vasila.mir.ereader.data.db.Book;
import vasila.mir.ereader.data.db.BooksDbHelper;

public class MainActivity extends AppCompatActivity {
    RecyclerView dataList;
    List<Integer> images;
    MainAdapter adapter;
    Repository repository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        repository = new Repository();

        // Widgets
        dataList = findViewById(R.id.data_list);
        images = new ArrayList<>();
        images.add(R.drawable.kite_runner);
        images.add(R.drawable.cinder);
        images.add(R.drawable.flowers_for_algernon);

        adapter = new MainAdapter(images, new MainAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(Book book) {
                Intent intent = new Intent(getApplicationContext(), ViewPagerActivity.class);
                intent.putExtra("bookId", book.bookID);
                startActivity(intent);
            }
        });

        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,2, GridLayoutManager.VERTICAL,false);
        dataList.setLayoutManager(gridLayoutManager);
        dataList.setAdapter(adapter);

        initListOfBooks();
    }

    private void initListOfBooks() {
        ListOfBooksAsyncTask listOfBooksAsyncTask = new ListOfBooksAsyncTask();
        listOfBooksAsyncTask.execute();
    }

    private class ListOfBooksAsyncTask extends AsyncTask<Void, Void, Void> {

        List<Book> listOfBooks;

        @Override
        protected Void doInBackground(Void... voids) {
            listOfBooks = repository.getListOfBooks();
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            Log.d("TEST_TAG", "onPostExecute: " + listOfBooks.size());
            adapter.setListOfBooks(listOfBooks);
        }
    }
}