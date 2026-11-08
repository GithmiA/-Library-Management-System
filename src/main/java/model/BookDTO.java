package model;

public class BookDTO {

    private String bookId;
    private String bookTitle;
    private String bookAuthor;
    private String bookCategory;
    private Integer bookPublishYear;
    private Integer bookQuantity;

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

    public Integer getBookPublishYear() {
        return bookPublishYear;
    }

    public void setBookPublishYear(Integer bookPublishYear) {
        this.bookPublishYear = bookPublishYear;
    }

    public Integer getBookQuantity() {
        return bookQuantity;
    }

    public void setBookQuantity(Integer bookQuantity) {
        this.bookQuantity = bookQuantity;
    }

    @Override
    public String toString() {
        return bookId + " - " + bookTitle;
    }
}
