package model;

public class BookDTO {

    private String bookId;
    private String bookTitle;
    private String bookAuthor;
    private String bookCategory;
    private String bookPublishYear;
    private String bookQuantity;

    public BookDTO() {

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

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public String getBookCategory() {
        return bookCategory;
    }

    public void setBookCategory(String bookCategory) {
        this.bookCategory = bookCategory;
    }

    public String getBookPublishYear() {
        return bookPublishYear;
    }

    public void setBookPublishYear(String bookPublishYear) {
        this.bookPublishYear = bookPublishYear;
    }

    public String getBookQuantity() {
        return bookQuantity;
    }

    public void setBookQuantity(String bookQuantity) {
        this.bookQuantity = bookQuantity;
    }

    @Override
    public String toString() {
        return bookId + " - " + bookTitle;
    }
}
