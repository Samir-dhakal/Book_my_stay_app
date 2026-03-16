 abstract class Room {

    protected  int numberOfBeds;
     protected  int squareFeet;
     protected  double pricePerNight ;

     public Room(int numberOfBeds, int squareFeet, double pricePerNight) {
         this.numberOfBeds=numberOfBeds;
         this.squareFeet=squareFeet;
         this.pricePerNight=pricePerNight;
     }




     public void displayRoomDetails() {
         System.out.println("number of beds "+ numberOfBeds);
         System.out.println("size of beds in square Feet "+squareFeet);
         System.out.println("Price per night "+pricePerNight);
     }
}
class SingleRoom extends Room{
    public SingleRoom() {
        super(1,250,1500.0);
    }


}
class DoubleRoom extends  Room {
    public DoubleRoom() {
        super(2,400,2500.0);
    }
}
class SuiteRoom extends Room{
    public SuiteRoom() {
        super(3,7000,50000.0);
    }
}
public class Rooms {
    public static void main (String[] args){
        SingleRoom singleRoom=new SingleRoom();
        singleRoom.displayRoomDetails();
        DoubleRoom doubleRoom=new DoubleRoom();
        doubleRoom.displayRoomDetails();
        SuiteRoom suiteRoom=new SuiteRoom();
        suiteRoom.displayRoomDetails();

    }
}
