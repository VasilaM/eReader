package vasila.mir.ereader;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.CompositePageTransformer;
import androidx.viewpager2.widget.MarginPageTransformer;
import androidx.viewpager2.widget.ViewPager2;

import java.util.ArrayList;
import java.util.List;

import vasila.mir.ereader.data.db.BooksDbHelper;


public class ViewPager extends AppCompatActivity {
    ViewPager2 vpContent, pageNumber;
    List<Integer> textViews;
  //  List<Integer> pageNums;
    ViewAdapter adapter;
 //   PageNumAdapter pageNumAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pager_view);

        vpContent = findViewById(R.id.view_pager);
    //    pageNumber = findViewById(R.id.page_num_viewer);




        textViews = new ArrayList<>();
        textViews.add(R.id.page1);
        textViews.add(R.id.pageContents);
        textViews.add(R.id.pageContents);
        textViews.add(R.id.pageContents);
        textViews.add(R.id.pageContents);
        textViews.add(R.id.pageContents);
        textViews.add(R.id.pageContents);
        textViews.add(R.id.pageContents);
        textViews.add(R.id.pageContents);
        textViews.add(R.id.pageContents);

        /**pageNums  = new ArrayList<>();
        pageNums.add(R.id.pageNum);
        pageNums.add(R.id.pageNum);
        pageNums.add(R.id.pageNum);
        pageNums.add(R.id.pageNum);
        pageNums.add(R.id.pageNum);
         **/

        adapter = new ViewAdapter(this, textViews);
     //   pageNumAdapter = new PageNumAdapter(this, pageNums);

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

    /**    vpContent.setPageTransformer(transformer);


        pageNumber.setAdapter(pageNumAdapter);
        pageNumber.setClipToPadding(false);
        pageNumber.setClipChildren(false);
        pageNumber.setOffscreenPageLimit(3);
        pageNumber.getChildAt(0).setOverScrollMode(View.OVER_SCROLL_NEVER);

        CompositePageTransformer transformer1 = new CompositePageTransformer();
        transformer1.addTransformer(new MarginPageTransformer(8));
        transformer1.addTransformer((page, position) -> {
            float v = 1 - Math.abs(position);

            page.setScaleY(0.8f + v * 0.2f);
        });

        pageNumber.setPageTransformer(transformer1);
     **/
    }

}
