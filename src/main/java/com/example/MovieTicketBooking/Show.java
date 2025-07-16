import java.util.Date;
import java.util.List;

public class Show {
    int id;
    Theatre theatre;
    Movie movie;
    Date startTime;
    Date endTime;
    List<ShowSeat> showSeatList;

    public int getId() {
        return id;
    }

    public Theatre getTheatre() {
        return theatre;
    }

    public Movie getMovie() {
        return movie;
    }

    public Date getStartTime() {
        return startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public ShowSeat getShowSeatById(int id) {
        for(ShowSeat seat: showSeatList){
            if(seat.id == id){
                return seat;
            }
        }
        return null;
    }

    public void bookSeat(int id){
        ShowSeat seat = getShowSeatById(id);
        seat.showSeatStatus = ShowSeatStatus.BOOKED;
    }

    public void blockSeat(int id){
        ShowSeat seat = getShowSeatById(id);
        seat.showSeatStatus = ShowSeatStatus.BLOCKED;
    }
}
