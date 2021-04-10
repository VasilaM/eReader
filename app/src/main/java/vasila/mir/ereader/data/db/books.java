package vasila.mir.ereader.data.db;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class books {
    @PrimaryKey
    @NonNull
    public int bookID;

    @NonNull
    public String bookName;
}
