package model;

public class Borrowing {

    private String memberId;
    private String memberName;
    private String bookId;
    private String bookTitle;
    private String issueDate;
    private String dueDate;
    private String returnDate;
    private String status;


    public String getBookTitle() {
        return bookTitle;
    }

//    public void setBookTitle(String bookTitle) {
//        this.bookTitle = bookTitle;
//    }

    public String getMemberId() {
        return memberId;
    }

//    public void setMemberId(String memberId) {
//        this.memberId = memberId;
//    }

    public String getMemberName() {
        return memberName;
    }

//    public void setMemberName(String memberName) {
//        this.memberName = memberName;
//    }

    public String getBookId() {
        return bookId;
    }

    public String getIssueDate() {
        return issueDate;
    }

//    public void setIssueDate(String issueDate) {
//        this.issueDate = issueDate;
//    }

    public String getDueDate() {
        return dueDate;
    }

//    public void setDueDate(String dueDate) {
//        this.dueDate = dueDate;
//    }

//    public String getReturnDate() {
//        return returnDate;
//    }

    public void setReturnDate(String returnDate) {
        this.returnDate = returnDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }




}
