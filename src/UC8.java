import java.util.*;

/**
 * ================================================================
 * CLASS - UseCase8BookingHistoryReport (Main Class)
 * ================================================================
 *
 * Demonstrates Booking History and Reporting functionality.
 * Stores confirmed bookings and generates reports.
 *
 * @author samir
 * @version 8.0
 */
public class UC8{

    public static void main(String[] args) {

        BookingHistory history = new BookingHistory();
        BookingReportService reportService = new BookingReportService();

        // Create sample reservations
        Reservations r1 = new Reservations("R101", "Aayusha", "Single");
        Reservations r2 = new Reservations("R102", "Samir", "Double");
        Reservations r3 = new Reservations("R103", "Anjan", "Suite");

        // Confirm bookings → add to history
        history.addReservation(r1);
        history.addReservation(r2);
        history.addReservation(r3);

        // Display all bookings
        System.out.println("===== BOOKING HISTORY =====");
        history.displayAllReservations();

        // Generate report
        System.out.println("\n===== BOOKING REPORT =====");
        reportService.generateSummaryReport(history.getAllReservations());
    }
}

/**
 * ================================================================
 * CLASS - Reservation
 * ================================================================
 *
 * Represents a confirmed reservation.
 */
class Reservations {

    private String reservationId;
    private String customerName;
    private String roomType;

    public Reservations(String reservationId, String customerName, String roomType) {
        this.reservationId = reservationId;
        this.customerName = customerName;
        this.roomType = roomType;
    }

    public String getReservationId() {
        return reservationId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getRoomType() {
        return roomType;
    }

    public void display() {
        System.out.println("ID: " + reservationId +
                ", Name: " + customerName +
                ", Room: " + roomType);
    }
}

/**
 * ================================================================
 * CLASS - BookingHistory
 * ================================================================
 *
 * Stores confirmed reservations in insertion order.
 */
class BookingHistory {

    private List<Reservations> reservations;

    public BookingHistory() {
        reservations = new ArrayList<>();
    }

    /**
     * Adds a confirmed reservation to history.
     */
    public void addReservation(Reservations reservation) {
        reservations.add(reservation);
    }

    /**
     * Returns all stored reservations.
     */
    public List<Reservations> getAllReservations() {
        return reservations;
    }

    /**
     * Displays all reservations.
     */
    public void displayAllReservations() {
        for (Reservations r : reservations) {
            r.display();
        }
    }
}

/**
 * ================================================================
 * CLASS - BookingReportService
 * ================================================================
 *
 * Generates reports from booking history.
 */
class BookingReportService {

    /**
     * Generates a summary report.
     */
    public void generateSummaryReport(List<Reservations> reservations) {

        System.out.println("Total Bookings: " + reservations.size());

        Map<String, Integer> roomCount = new HashMap<>();

        for (Reservations r : reservations) {
            roomCount.put(r.getRoomType(),
                    roomCount.getOrDefault(r.getRoomType(), 0) + 1);
        }

        System.out.println("Room Type Distribution:");
        for (String type : roomCount.keySet()) {
            System.out.println(type + " : " + roomCount.get(type));
        }
    }
}