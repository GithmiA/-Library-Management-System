package model;

public class Book {

    private String bookId;
    private String bookTitle;
    private int quantity;

    public Book() {

    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }


    public int getQuantity() {
        return quantity;
    }

    @Override
    public String toString() {
        return bookId + " - " + bookTitle;
    }
}
