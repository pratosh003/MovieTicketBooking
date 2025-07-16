import java.util.ArrayList;
import java.util.List;

public class BookingService {


    Booking createBooking(User user, Show show, List<Integer> seats, Payment payment){
        for(int seat: seats){
            show.blockSeat(seat);
        }
        if(payment.isPaymentDone()){
            for(int seat: seats){
                show.bookSeat(seat);
            }
        }
        List<ShowSeat> bookedSeats = new ArrayList<>();
        for(int seat: seats){
            bookedSeats.add(show.getShowSeatById(seat));
        }
        return new Booking(user, show, bookedSeats, BookingStatus.BOOKED);
    }

    Booking cancelBooking(Booking booking){
        List<ShowSeat> seats = booking.getBookedSeats();
        for(ShowSeat seat: seats){
            seat.setShowSeatStatus(ShowSeatStatus.AVAILABLE);
        }
        booking.setBookingStatus(BookingStatus.CANCELED);
        return booking;
    }
}
