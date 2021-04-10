package vasila.mir.ereader;

import android.app.Application;

import androidx.room.Room;

import vasila.mir.ereader.data.db.booksDatabase;

public class BookApp extends Application {
    public static BookApp bookApp;
    private booksDatabase booksDatabase;

    @Override
    public void onCreate(){
        super.onCreate();
        bookApp = this;
        booksDatabase = Room.databaseBuilder(this, booksDatabase.class, "books.db")
                .createFromAsset("database/books.db")
                .build();
    }

    public static BookApp getBookApp() {
        return bookApp;
    }

    public booksDatabase getBooksDatabase(){
        return booksDatabase;
    }


}
