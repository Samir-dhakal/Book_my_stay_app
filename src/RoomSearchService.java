import java.util.Map;

public class RoomSearchService {
    public void searchAvailableRooms(
            RoomInventory inventory,
            Room singleRoom,
            Room doubleRoom,
            Room sutiteRoom){
        Map<String,Integer> availability=inventory.getRoomAvailability();
        if(availability.get("Single Room")>0){
            System.out.println(availability.get("Single Room")+ " single rooms are available ");
        }
        if(availability.get("Double Room")>0){
            System.out.println(availability.get("Double Room")+ " single rooms are available ");
        }
        if(availability.get("Suite Room")>0){
            System.out.println(availability.get("Suite Room")+ " single rooms are available ");
        }


    }
}
