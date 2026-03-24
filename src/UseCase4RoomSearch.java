public class UseCase4RoomSearch {
    public static void main ( String[] args){
        RoomInventory inventory=new RoomInventory();
        RoomSearchService roomSearchService=new RoomSearchService();
        SingleRoom singleRoom=new SingleRoom();
        DoubleRoom doubleRoom=new DoubleRoom();
        SuiteRoom suiteRoom=new SuiteRoom();
        roomSearchService.searchAvailableRooms(inventory,singleRoom,doubleRoom,suiteRoom);
    }
}
