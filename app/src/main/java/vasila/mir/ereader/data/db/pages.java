package vasila.mir.ereader.data.db;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity
public class pages {
    @PrimaryKey
    @NonNull
    public int pageID;

    @NonNull
    public int pageNum;

    @NonNull
    public String pageContents;

    @ForeignKey(entity = books.class, parentColumns = "bookID", childColumns = "bookID")
    @NonNull
    public int bookID;
}
