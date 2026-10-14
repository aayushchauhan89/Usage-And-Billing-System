
import java.util.*;
import java.time.*;

public class UsageAndBillingSystem {
    static Scanner sc = new Scanner(System.in);
    static int cap = 2;
    static int firstHrPrice = 30, extraHrPrice = 10;
    static int nextId = 101;
    static HashMap<String, Instant> active = new HashMap<>();
    static HashMap<String, String> users = new HashMap<>();

    public static void main(String[] args) {
        int ch;
        do {
            System.out.println("1.View Room");
            System.out.println("2.Start Usage");
            System.out.println("3.Stop Usage");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");

            ch = sc.nextInt();
            sc.nextLine();

            switch(ch) {
                case 1:
                    System.out.println("Meeting Room: R101");
                    System.out.println("Capacity : " + cap);
                    System.out.println("Available slot : " + (cap -active.size()));
                    break;

                case 2:
                    if(active.size()>=cap) {
                        System.out.println("Room is full");
                        break;
                    }

                    System.out.print("Enter User ID: ");
                    String user = sc.nextLine();

                    if(user.isEmpty()) {
                        System.out.println("User ID can not be null");
                        break;
                    }

                    boolean exists = false;
                    for(String u : users.values()) {
                        if(u.equals(user)) {
                            exists = true;
                            break;
                        }
                    }

                    if(exists) {
                        System.out.println("User already active");
                        break;
                    }
                    String id = "S" + (nextId);
                    nextId++;
                    active.put(id, Instant.now());
                    users.put(id, user);

                    System.out.println("Usage started Session ID: " + id);
                    break;

                case 3:
                    System.out.print("enter session id : ");
                    String sid = sc.nextLine();
                
                    if(!active.containsKey(sid)) {
                        System.out.println("Invalid session ID!");
                        break;
                    }

                    Duration d = Duration.between(active.get(sid), Instant.now());
                    long sec = d.getSeconds();
                    long min = (sec + 59)/60;
                    long hr = (sec + 3599)/3600;

                    long amt = 0;

                    if(hr > 0) {
                        amt = firstHrPrice + (hr - 1) * extraHrPrice;
                    }

                    System.out.println("User: " + users.get(sid));
                    System.out.println("Duration: " + min + " minutes");
                    System.out.println("Billable hours: " + hr);
                    System.out.println("Total bill: Rs. " + amt);

                    active.remove(sid);
                    users.remove(sid);

                    System.out.println("Room slot released.");
                    break;

                case 4:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while(ch != 4);

        sc.close();
    }
}
