package model;

import java.time.LocalDate;

public class BorrowingDTO {

    private String memberId;
    private String fullName;
    private String bookId;
    private String bookTitle;
    private String issueDate;
    private String dueDate;
    private String returnDate;
    private String status;

    public BorrowingDTO() {

    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public void setIssueDate(String issueDate) {
        this.issueDate = issueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getFullName() {
        return fullName;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public String getMemberId() {
        return memberId;
    }

    public String getBookId() {
        return bookId;
    }


    public String getIssueDate() {
        return issueDate;
    }

    public String getDueDate() {
        return dueDate;
    }

    public String getStatus() {
        return status;
    }

    public void setReturnDate(String returnDate) {
        this.returnDate = returnDate;
    }

    public String getReturnDate() {
        return returnDate;
    }
}
