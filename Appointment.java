    import java.util.*;
    import java.io.*;
 
    class DoctorAppointment {
    private Map<String, List<String>> appointments;
 
    public DoctorAppointment() {
        this.appointments = new HashMap<>();
    }
 
    public boolean bookAppointment(String date, String time) {
        if (!appointments.containsKey(date)) {
            appointments.put(date, new ArrayList<>());
        }
        
        List<String> times = appointments.get(date);
        if (times.contains(time)) {
            return false; // Slot already booked
        }
        
        times.add(time);
        return true; // Slot booked successfully
    }
 
    public int getTotalBookings(String date) {
        return appointments.containsKey(date) ? appointments.get(date).size() : 0;
    }
 
    public void displayAppointments() {
        System.out.println("Appointments:");
        for (Map.Entry<String, List<String>> entry : appointments.entrySet()) {
            String date = entry.getKey();
            List<String> times = entry.getValue();
            System.out.println("Date: " + date + ", Bookings: " + times.size());
            System.out.println("Times: " + times);
        }
    }
}
 
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
 
        DoctorAppointment doctor = new DoctorAppointment();
 
        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Book a slot");
            System.out.println("2. Total bookings of the day");
            System.out.println("3. Exit");
 
            System.out.print("Enter your choice (1/2/3): ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character
 
            switch (choice) {
                case 1:
                    System.out.print("Enter your name:  ");
                    String name=scanner.nextLine();
                    System.out.print("Enter appointment date (yyyy-MM-dd): ");
                    String inputDate = scanner.nextLine();
                    System.out.print("Enter appointment time (hh:mm AM/PM): ");
                    String inputTime = scanner.nextLine();
                    if (doctor.bookAppointment(inputDate, inputTime)) {
                        System.out.println("Appointment booked successfully!");
                    } else {
                        System.out.println("Sorry, the slot is already booked. Please choose another slot.");
                    }
                    break;
                case 2:
                    System.out.print("Enter the date to check total bookings (yyyy-MM-dd): ");
                    String dateToCheck = scanner.nextLine();
                    int totalBookings = doctor.getTotalBookings(dateToCheck);
                    System.out.println("Total bookings on " + dateToCheck + ": " + totalBookings);
                    break;
                case 3:
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
       }
}
}
}
