package model;

public class Book {

    private String bookId;
    private String bookTitle;
    private String author;
    private String category;
    private String publishedYear;
    private int quantity;

    public Book(String bookId, String bookTitle, String author, String category, String publishedYear, int quantity) {
        this.bookId = bookId;
        this.bookTitle = bookTitle;
        this.author = author;
        this.category = category;
        this.publishedYear = publishedYear;
        this.quantity = quantity;
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

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getPublishedYear() {
        return publishedYear;
    }

    public void setPublishedYear(String publishedYear) {
        this.publishedYear = publishedYear;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return bookId + " - " + bookTitle;
    }
}
