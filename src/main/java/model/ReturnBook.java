package model;


public class ReturnBook {

    private final String memberId;
    private final String name;
    private final String phoneNumber;
    private final String bookTitle;
    private final String borrowedDate;
    private final String dueDate;
    private final String status;

    public ReturnBook(String memberId, String name, String phoneNumber, String bookTitle, String borrowedDate, String dueDate,String status) {
        this.memberId = memberId;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.bookTitle = bookTitle;
        this.borrowedDate = borrowedDate;
        this.dueDate = dueDate;
        this.status = status;
    }


    public String getMemberId() {
        return memberId;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public String getBorrowedDate() {
        return borrowedDate;
    }

    public String getDueDate() {
        return dueDate;
    }

    public String getStatus() {
        return status;
    }
}
