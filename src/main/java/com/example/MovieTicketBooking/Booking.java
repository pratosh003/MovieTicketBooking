import java.util.List;

public class Booking {
    private int id;
    private User user;
    private Show show;
    private List<ShowSeat> bookedSeats;
    private BookingStatus bookingStatus;

    public Booking(User user, Show show, List<ShowSeat> bookedSeats, BookingStatus bookingStatus) {
        this.user = user;
        this.show = show;
        this.bookedSeats = bookedSeats;
        this.bookingStatus = bookingStatus;
    }

    public int getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public Show getShow() {
        return show;
    }

    public List<ShowSeat> getBookedSeats() {
        return bookedSeats;
    }

    public BookingStatus getBookingStatus() {
        return bookingStatus;
    }

    public void setBookingStatus(BookingStatus bookingStatus) {
        this.bookingStatus = bookingStatus;
    }
}
