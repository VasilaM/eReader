package vasila.mir.ereader.data.db;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(
        tableName = "pages",
        foreignKeys = {
                @ForeignKey(
                        entity = Book.class,
                        parentColumns = "bookID",
                        childColumns = "bookID"
                )
        }
)

public class Page {
    @PrimaryKey
    @NonNull
    public int pageID;

    @NonNull
    public int bookID;

    @NonNull
    public int pageNum;

    @NonNull
    public String pageContents;
}
