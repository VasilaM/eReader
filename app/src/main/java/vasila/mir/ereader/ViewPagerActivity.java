package vasila.mir.ereader;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.CompositePageTransformer;
import androidx.viewpager2.widget.MarginPageTransformer;
import androidx.viewpager2.widget.ViewPager2;

import java.util.List;

import vasila.mir.ereader.data.db.Page;

public class ViewPagerActivity extends AppCompatActivity {
    ViewPager2 vpContent, pageNumber;
    //List<Integer> textViews;
    ViewAdapter adapter;

    private Repository repository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pager_view);
        repository = new Repository();

        adapter = new ViewAdapter();
        vpContent = findViewById(R.id.view_pager);
        vpContent.setAdapter(adapter);
        vpContent.setClipToPadding(false);
        vpContent.setClipChildren(false);
        vpContent.setOffscreenPageLimit(3);
        vpContent.getChildAt(0).setOverScrollMode(View.OVER_SCROLL_NEVER);

        CompositePageTransformer transformer = new CompositePageTransformer();
        transformer.addTransformer(new MarginPageTransformer(8));
        transformer.addTransformer((page, position) -> {
            float v = 1 - Math.abs(position);
            page.setScaleY(0.8f + v * 0.2f);
        });
        vpContent.setPageTransformer(transformer);

        initPages();
    }

    private void initPages() {
        PagesAsyncTask task = new PagesAsyncTask();
        task.execute();
    }

    private class PagesAsyncTask extends AsyncTask<Void, Void, Void> {

        List<Page> pages;

        @Override
        protected Void doInBackground(Void... voids) {
            pages = repository.getListOfpages(
                    getIntent().getIntExtra("bookId", 0)
            );
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            adapter.setPages(pages);
        }
    }

}


/**
 * pageNumber.setAdapter(pageNumAdapter);
 * pageNumber.setClipToPadding(false);
 * pageNumber.setClipChildren(false);
 * pageNumber.setOffscreenPageLimit(3);
 * pageNumber.getChildAt(0).setOverScrollMode(View.OVER_SCROLL_NEVER);
 * <p>
 * CompositePageTransformer transformer1 = new CompositePageTransformer();
 * transformer1.addTransformer(new MarginPageTransformer(8));
 * transformer1.addTransformer((page, position) -> {
 * float v = 1 - Math.abs(position);
 * <p>
 * page.setScaleY(0.8f + v * 0.2f);
 * });
 * <p>
 * pageNumber.setPageTransformer(transformer1);
 **/
