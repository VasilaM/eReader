package vasila.mir.ereader;

import java.util.List;

import vasila.mir.ereader.data.db.Book;
import vasila.mir.ereader.data.db.Dao;
import vasila.mir.ereader.data.db.Page;

public class Repository {

    private Dao dao;

    public Repository() {
        dao = BookApp.getBookApp().getBooksDatabase().bookDao();
    }

    public List<Book> getListOfBooks() {
        return dao.getListOfBooks();
    }

    public List<Page> getListOfPages(int bookId) {
        return dao.getListOfPages(bookId);
    }
}
