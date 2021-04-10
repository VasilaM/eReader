package vasila.mir.ereader.data.db;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "books")
public class Book {
    @PrimaryKey
    @NonNull
    public int bookID;

    @NonNull
    public String bookName;
}