class TicketBooking {
    int tickets = 5;

    synchronized void bookTicket(String user, int count) {
        if (tickets >= count) {
            System.out.println(user + " is booking " + count + " ticket(s)");
            tickets -= count;
            System.out.println("Booking successful for " + user);
            System.out.println("Tickets remaining: " + tickets);
        } else {
            System.out.println("Sorry " + user + ", tickets not available");
        }
    }
}

// Using Thread class
class BookingThread extends Thread {
    TicketBooking booking;

    BookingThread(TicketBooking booking) {
        this.booking = booking;
    }

    public void run() {
        booking.bookTicket("User 1", 2);
    }
}

// Using Runnable interface
class BookingRunnable implements Runnable {
    TicketBooking booking;

    BookingRunnable(TicketBooking booking) {
        this.booking = booking;
    }

    public void run() {
        booking.bookTicket("User 2", 2);
    }
}

public class Main {
    public static void main(String[] args) {
        TicketBooking booking = new TicketBooking();

        BookingThread t1 = new BookingThread(booking);

        Thread t2 = new Thread(new BookingRunnable(booking));

        Thread t3 = new Thread(() -> {
            booking.bookTicket("User 3", 2);
        });

        t1.start();
        t2.start();
        t3.start();
    }
}
