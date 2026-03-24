import java.util.HashMap;
import java.util.Map;
import java.util.zip.DeflaterOutputStream;

class RoomInventory{
private Map<String,Integer> roomAvailability;

    public RoomInventory(){
        roomAvailability=new HashMap<>();
        initializeInventory();


    }
    private void initializeInventory(){
        roomAvailability.put("Single Room",5);
        roomAvailability.put("Double Room",3);
        roomAvailability.put("Suite Room",2);
    }
    public  Map<String , Integer>getRoomAvailability(){
        return roomAvailability;
    }

}
public class UseCase3InventorySetup{
     public static void main (String [] args){
SingleRoom singleRoom = new SingleRoom();
DoubleRoom doubleRoom=new DoubleRoom();
SuiteRoom suiteRoom=new SuiteRoom();
         RoomInventory invertory=new RoomInventory();
         System.out.println("Single Room:");
         singleRoom.displayRoom();
         System.out.println("Available: "+invertory.getRoomAvailability().get("Single Room"));
         System.out.println("double Room:");
         doubleRoom.displayRoom();
         System.out.println("Available: "+invertory.getRoomAvailability().get("Double Room"));
         System.out.println("Suite Room:");
         suiteRoom.displayRoom();
         System.out.println("Available: "+invertory.getRoomAvailability().get("Suite Room"));

     }
}
