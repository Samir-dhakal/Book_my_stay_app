/**
 * ==================================
 * RoomAllocationService
 * ==================================
 *
 * this class is responsible for conforming booking request and assigning room
 *
 * it ensures each room has unique id ,inventory updated immediately and no room is double- booked
 *
 * @version 6.0
 */

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

 class RoomAllocationService {
    private Set<String> allocateRoomIds;
    private Map<String,Set<String>> assignedRoomsByType;

    public RoomAllocationService(){
        allocateRoomIds=new HashSet<>();
        assignedRoomsByType =new HashMap<>();
    }

    public void allocateRoom (Reservation reservation, RoomInventory roomInventory){
        String roomType= reservation.getRoomType();

        Map<String ,Integer> availability=roomInventory.getRoomAvailability();
        if(availability.containsKey(roomType) && availability.get(roomType)-1>0){
            String roomID =generateRoomId(roomType);
            allocateRoomIds.add(roomID);

            assignedRoomsByType.putIfAbsent(roomType, new HashSet<>());
            assignedRoomsByType.get(roomType).add(roomID);

            roomInventory.updateAvailability(roomType, availability.get(roomType) - 1);

            System.out.println("Booking confirmed for Guest: "
                    + reservation.getGuestName()
                    + ", Room ID: " + roomID);

        }
        else {
            System.out.println("No room available for the Guest: "+reservation.getGuestName());
        }

    }

    private String generateRoomId(String roomType){
        int count = assignedRoomsByType
                .getOrDefault(roomType, new HashSet<>())
                .size() + 1;

        if (roomType.equals("Single Room")) {
            return "Single-" + count;
        } else if (roomType.equals("Double Room")) {
            return "Double-" + count;
        } else {
            return "Suite-" + count;
        }
    }

}
public class UseCase6RoomAllocation {
    public static void main(String[] args) {

        RoomInventory inventory=new RoomInventory();
        RoomAllocationService service=new RoomAllocationService();

        Reservation r1 = new Reservation("aayusha", "Single Room");
        Reservation r2 = new Reservation("samir", "Suite Room");
        Reservation r3 = new Reservation("Chintu_sai", "Single Room");

        System.out.println("Room allocating Service");
        service.allocateRoom(r1,inventory);
        service.allocateRoom(r2,inventory);
        service.allocateRoom(r3,inventory);


    }

}
