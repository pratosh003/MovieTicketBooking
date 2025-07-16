public class ShowSeat extends Seat{
    int id;
    Double price;
    Show show;
    ShowSeatStatus showSeatStatus;

    public ShowSeat(Double price, Show show, ShowSeatStatus showSeatStatus) {
        this.price = price;
        this.show = show;
        this.showSeatStatus = showSeatStatus;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Show getShow() {
        return show;
    }

    public void setShow(Show show) {
        this.show = show;
    }

    public ShowSeatStatus getShowSeatStatus() {
        return showSeatStatus;
    }

    public void setShowSeatStatus(ShowSeatStatus showSeatStatus) {
        this.showSeatStatus = showSeatStatus;
    }
}
