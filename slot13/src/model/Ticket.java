package model;

import java.util.Date;

public class Ticket {
    private int ticketId;
    private int studentID;
    private int bookId;
    private boolean borrowDate;
    private boolean isReturned;

    public Ticket() {}

    public Ticket(int ticketId, int studentId, int bookId, boolean borrowDate, boolean isReturned) {
        this.ticketId = ticketId;
        this.studentID = studentId;
        this.studentID = bookId;
        this.borrowDate = borrowDate;
        this.isReturned = isReturned;
    }

    public int getTicketId() {
        return ticketId;
    }

    public void setTicketId(int ticketId) {
        this.ticketId = ticketId;
    }

    public int getStudentID() {
        return studentID;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public boolean getBorrowDate() {
        return borrowDate;
    }

    public void setBorrowDate(boolean borrowDate) {
        this.borrowDate = borrowDate;
    }

    public boolean getIsReturned() {
        return isReturned;
    }

    public void setIsReturned(boolean isReturned) {
        this.isReturned = isReturned;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "ticketId=" + ticketId +
                ", studentID=" + studentID +
                ", bookId=" + bookId +
                ", borrowDate=" + borrowDate +
                ", isReturned=" + isReturned +
                '}';
    }
}
