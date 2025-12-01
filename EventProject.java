
import java.util.Scanner;

public class EventProject {

    // إدخال من المستخدم
    static Scanner input = new Scanner(System.in);

    // كائن لإدارة الفعاليات
    static EventManager manager = new EventManager();

    public static void main(String[] args) {

        boolean running = true; // للتحكم في استمرار البرنامج

        // Loop رئيسية
        while (running) {

            // طباعة القائمة (Menu)
            System.out.println("===== Event Management System =====");
            System.out.println("1) Add Event");
            System.out.println("2) Update Event");
            System.out.println("3) Delete Event");
            System.out.println("4) Search Event by ID");
            System.out.println("5) Show All Events");
            System.out.println("0) Exit");
            System.out.print("Enter choice: ");

            String choice = input.nextLine(); //  اختيار المستخدم

            // Switch لاختيار العملية
            switch (choice) {
                case "1":
                    addEvent();
                    break;
                case "2":
                    updateEvent();
                    break;
                case "3":
                    deleteEvent();
                    break;
                case "4":
                    searchEvent();
                    break;
                case "5":
                    showAllEvents();
                    break;
                case "0":
                    System.out.println("Application closed.");
                    running = false; // 
                    break;
                default:
                    System.out.println("Invalid choice.");
            }

            System.out.println(); // سطر فاصل
        }
    }

    // إضافة فعالية جديدة
    static void addEvent() {
        System.out.println("--- Add Event ---");

        System.out.print("Enter ID: ");
        int id = input.nextInt(); // قراءة رقم
        input.nextLine(); //  

        // التأكد من عدم تكرار ID
        Event found = manager.findById(id);
        if (found != null) {
            System.out.println("Event with this ID already exists.");
            return;
        }

        System.out.print("Enter name: ");
        String name = input.nextLine();

        System.out.print("Enter date: ");
        String date = input.nextLine();

        System.out.print("Enter location: ");
        String location = input.nextLine();

        System.out.print("Enter type (Lecture / Workshop / Course ...): ");
        String type = input.nextLine();

        System.out.print("Enter description: ");
        String desc = input.nextLine();

        //  (استخدام constructor)
        Event e = new Event(id, name, date, location, desc, type);

        // إضافة الفعالية في المصفوفة
        boolean ok = manager.addEvent(e);

        if (ok) {
            System.out.println("Event added.");
        } else {
            System.out.println("Event list is full. Cannot add.");
        }
    }

    // تعديل فعالية
    static void updateEvent() {
        System.out.println("--- Update Event ---");

        System.out.print("Enter ID of event to update: ");
        int id = input.nextInt();
        input.nextLine();

        Event e = manager.findById(id);

        if (e == null) {
            System.out.println("Event not found.");
            return;
        }

        System.out.println("Current data:");
        e.printInfo(); // polymorphism مع interface

        // نطلب القيم الجديدة
        System.out.print("Enter new name: ");
        String name = input.nextLine();

        System.out.print("Enter new date: ");
        String date = input.nextLine();

        System.out.print("Enter new location: ");
        String location = input.nextLine();

        System.out.print("Enter new type: ");
        String type = input.nextLine();

        System.out.print("Enter new description: ");
        String desc = input.nextLine();

        // تعديل البيانات (Encapsulation مع setters)
        e.setName(name);
        e.setDate(date);
        e.setLocation(location);
        e.setEventType(type);
        e.setDescription(desc);

        System.out.println("Event updated.");
    }

    // حذف فعالية
    static void deleteEvent() {
        System.out.println("--- Delete Event ---");

        System.out.print("Enter ID of event to delete: ");
        int id = input.nextInt();
        input.nextLine();

        boolean ok = manager.deleteById(id);

        if (ok) {
            System.out.println("Event deleted.");
        } else {
            System.out.println("Event not found.");
        }
    }

    // البحث عن فعالية  
    static void searchEvent() {
        System.out.println("--- Search Event by ID ---");

        System.out.print("Enter ID: ");
        int id = input.nextInt();
        input.nextLine();

        Event e = manager.findById(id);

        if (e == null) {
            System.out.println("Event not found.");
        } else {
            System.out.println("Event found:");
            e.printInfo(); // استدعاء method من interface
        }
    }

    // عرض جميع الفعاليات
    static void showAllEvents() {
        System.out.println("--- All Events ---");

        int count = manager.getCount();
        if (count == 0) {
            System.out.println("No events.");
            return;
        }

        // Loop على المصفوفة
        for (int i = 0; i < count; i++) {
            Event e = manager.getEventAt(i);
            e.printInfo();
        }
    }
}