package vasila.mir.ereader.data.db;


import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {books.class, pages.class}, version = 1)
public abstract class booksDatabase extends RoomDatabase{
    public abstract Dao bookDao();
}
