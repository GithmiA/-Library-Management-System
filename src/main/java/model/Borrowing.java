package model;

public class Borrowing {

    private String memberId;
    private String bookTitle;
    private String issueDate;
    private String dueDate;
    private String returnDate;
    private String status;

    public Borrowing(String memberId,String bookTitle, String issueDate, String dueDate, String status) {
        this.memberId = memberId;
        this.bookTitle = bookTitle;
        this.issueDate = issueDate;
        this.dueDate = dueDate;
        this.status = status;
    }
    public Borrowing() {

    }

    public String getBookTitle() {
        return bookTitle;
    }

    public String getMemberId() {
        return memberId;
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
