//كلاس لادارة الفعاليات بستخدامAray 

public class EventManager {

    // مصفوفة لتخزين 100 فعالية كحد أقصى
    private Event[] events = new Event[30];

    // عدد الفعاليات الفعلي داخل المصفوفة
    private int count = 0;

    // إضافة فعالية جديدة
    public boolean addEvent(Event e) {

        if (count >= events.length) {
            return false; // المصفوفة ممتلئة
        }

        events[count] = e;
        count++; // زيادة العدد
        return true;
    }

    // البحث عن فعالية بالـ ID
    public Event findById(int id) {

        // loop على جميع العناصر المستخدمة
        for (int i = 0; i < count; i++) {
            Event e = events[i];

            if (e.getId() == id) { // استخدام Operator ==
                return e;
            }
        }

        return null; // لم نجد الفعالية
    }

    // حذف فعالية بالـ ID (تحريك العناصر في المصفوفة)
    public boolean deleteById(int id) {

        for (int i = 0; i < count; i++) {
            if (events[i].getId() == id) {

                // نحرك العناصر اللي بعده خطوة لليسار
                for (int j = i; j < count - 1; j++) {
                    events[j] = events[j + 1];
                }

                events[count - 1] = null; // آخر واحد نخليه فاضي
                count--; // تقليل العدد
                return true;
            }
        }

        return false;
    }

    // إرجاع عدد الفعاليات الحالية
    public int getCount() {
        return count;
    }

    // إرجاع فعالية حسب رقم الفهرس في المصفوفة
    public Event getEventAt(int index) {

        if (index >= 0 && index < count) {
            return events[index];
        }

        return null;
    }
}