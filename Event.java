 
interface Printable {
    void printInfo(); // Abstraction: تعريف بدون تنفيذ
}

//  يمثل أساس أي فعالية
abstract class EventBase implements Printable {

    // خصائص الفعالية 
    private int id;
    private String name;
    private String date;
    private String location;
    private String description;

    //  رئيسي
    public EventBase(int id, String name, String date,
                     String location, String description) {

        this.id = id;
        this.name = name;
        this.date = date;
        this.location = location;
        this.description = description;
    }

    // Getters & Setters (Encapsulation)
    public int getId() {
        return id;
    }

    public void setId(int id) { //  modifier + method
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) { 
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) { 
        this.date = date;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) { 
        this.location = location;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) { 
        this.description = description;
    }

    // دالة مجردة (Abstraction) لتحديد نوع الفعالية
    public abstract String getType();

    // تنفيذ لطريقة الـ interface (Polymorphism: ممكن تتغيّر في الكلاس الابن)
    public void printInfo() {
        System.out.println("ID: " + id +
                " | Name: " + name +
                " | Date: " + date +
                " | Location: " + location +
                " | Type: " + getType() +
                " | Description: " + description);
    }
}

// Event يرث من EventBase Inheritance + Polymorphism
public class Event extends EventBase {

    private String eventType; // نوع الفعالية (Workshop / Lecture)

    // constructor كامل (Overload 1)
    public Event(int id, String name, String date,
                 String location, String description,
                 String eventType) {

        super(id, name, date, location, description); // استدعاء Constructor الأب
        this.eventType = eventType;
    }

    // constructor مبسط (Overload 2)
    public Event(int id, String name) {
        super(id, name, "unknown", "unknown", "no description");
        this.eventType = "General";
    }

    // Override للدالة المجردة من EventBase
    public String getType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    // Override لطريقة printInfo (Polymorphism)
    @Override
    public void printInfo() {
        // نستخدم سلوك الأب + نضيف جملة توضيحية
        System.out.print("[EVENT] ");
        super.printInfo(); // استدعاء دالة الأب
    }
}