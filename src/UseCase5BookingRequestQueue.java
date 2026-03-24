import java.awt.print.Book;
import java.util.LinkedList;
import java.util.Queue;

class Reservation {
    private String guestName;
    private String roomType;

    public Reservation(String guestName,String roomType) {
        this.roomType = roomType;
        this.guestName=guestName;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public String getGuestName() {
        return guestName;
    }

    public void setGuestName(String guestName) {
        this.guestName = guestName;
    }
}
class BookingRequestQueue{
    private Queue<Reservation> requestQueue;
    public BookingRequestQueue(){
        requestQueue=new LinkedList<>();
    }
    public void addRequest(Reservation reservation){
        requestQueue.offer(reservation);
    }
    public Reservation getNextRequest(){
       return requestQueue.poll();
    }
    public boolean hasPendingRequests(){return requestQueue.isEmpty();}

    @Override
    public String toString() {
        return "BookingRequestQueue{" +
                "requestQueue=" + requestQueue +
                '}';
    }
    void display(){
        requestQueue.stream().forEach(n->System.out.println(n.getGuestName()+n.getRoomType()));
    }
    void removeBookingRequest(){
        requestQueue.remove();
    }
}



public class UseCase5BookingRequestQueue {
    public static void main (String [] args){
    System.out.println("Booking Request Queue");
        BookingRequestQueue bookingQueue = new BookingRequestQueue();
        Reservation r1=new Reservation("ayush" ,"Single Room");
        Reservation r2=new Reservation("anjan","Double Room");
        Reservation r3 = new Reservation("samir", "Suite Room");
        bookingQueue.addRequest(r1);
        bookingQueue.addRequest(r2);
        bookingQueue.addRequest(r3);



        bookingQueue.display();
    }
}
