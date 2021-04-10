package vasila.mir.ereader.data.db;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Book.class, Page.class}, version = 1)
public abstract class booksDatabase extends RoomDatabase{
    public abstract Dao bookDao();
}
