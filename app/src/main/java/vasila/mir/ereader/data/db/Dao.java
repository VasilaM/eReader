package vasila.mir.ereader.data.db;

import androidx.room.Query;

import java.util.List;

@androidx.room.Dao
public interface Dao {

    @Query("SELECT * FROM books")
    List<Book> getListOfBooks();

    @Query("SELECT * FROM pages WHERE bookID = :bookId")
    List<Page> getListOfPages(int bookId);
}
