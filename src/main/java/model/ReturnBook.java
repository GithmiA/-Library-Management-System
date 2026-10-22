package model;

import java.time.LocalDate;

public class ReturnBook {

    private String memberId;
    private String name;
    private String phoneNumber;
    private String bookTitle;
    private String borrowedDate;
    private String dueDate;
    private String status;

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
