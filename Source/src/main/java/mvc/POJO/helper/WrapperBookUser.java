package mvc.POJO.helper;

import mvc.POJO.Book;
import mvc.POJO.User;

public class WrapperBookUser {

    private Book book;

    private User user;

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
