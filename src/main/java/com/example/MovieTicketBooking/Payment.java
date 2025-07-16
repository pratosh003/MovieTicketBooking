public class Payment {
    int id;
    boolean paymentDone;

    public boolean isPaymentDone(){
        if(paymentDone){
            return true;
        }
        return false;
    }
}
