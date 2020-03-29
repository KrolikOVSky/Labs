package Lab4;

public class DepartmentDin {
    private Lecturer lecturer;
    private DepartmentDin next;
    private static final String DEPARTMENT_FORMAT_STRING = "Name of department: %s; Quantity of Lecturers: %d; ";

    public DepartmentDin() {
        lecturer = null;
        next = null;
    }

    public DepartmentDin(String name) {
        lecturer = new Lecturer();
        lecturer.setSurname(name);
        lecturer.setId(0);
        lecturer.setPosition(null);
        lecturer.setSalary(0.25);
        next = null;
    }

    public DepartmentDin(Lecturer lecturer) {
        this.lecturer = lecturer;
        next = null;
    }

    public void setName(String name) {
        lecturer.setSurname(name);
    }

    public String getName() {
        return lecturer.getSurname();
    }

    public int getQuantity() {
        int number = 0;
        DepartmentDin element = next;
        while (element != null) {
            number++;
            element = element.next;
        }
        return number;
    }

    public Lecturer getLecturer(int id) {
        if (next == null) return null;
        DepartmentDin element = next;
        while (element != null) {
            if (element.lecturer.getId() == id) return element.lecturer;
            element = element.next;
        }
        return null;
    }

    public String toString() {
        return String.format(DEPARTMENT_FORMAT_STRING, this.lecturer.getSurname(), getQuantity());
    }

    public boolean addLecturer(Lecturer lecturer) {
        if (getLecturer(lecturer.getId()) != null) return false;
        DepartmentDin element = new DepartmentDin(lecturer);
        if (next == null) next = element;
        else {
            DepartmentDin old = next;
            next = element;
            element.next = old;
        }
        return true;
    }

    public boolean delLecturer(int id) {
        DepartmentDin element = this;
        while (element.next != null) {
            if (element.next.lecturer.getId() == id) {
                element.next = element.next.next;
                return true;
            }
            element = element.next;
        }
        return false;
    }

    public double getMidSalary() {
        if (next == null) return 0;
        double middle = 0;
        int number = 0;
        DepartmentDin element = next;
        while (element != null) {
            middle += element.lecturer.getSalary();
            number++;
            element = element.next;
        }
        return middle / number;
    }

    public DepartmentDin getAboveMidSalary(){
        double middle = getMidSalary();
        DepartmentDin head = new DepartmentDin(String.format("Lecturer who has salary above middle %f: ", middle));
        DepartmentDin element = next;
        while (element != null){
            if(element.lecturer.getSalary() > middle)head.addLecturer(element.lecturer);
            element = element.next;
        }
        return head;
    }

    public DepartmentDin betweenSalary(double a, double b) {
        DepartmentDin head = new DepartmentDin(String.format("Lecturer who have salary between %f to %f", a, b));
        DepartmentDin element = next;
        while (element != null) {
            double x = element.lecturer.getSalary();
            if (x >= a && x <= b) head.addLecturer(new Lecturer(element.lecturer));
            element = element.next;
        }
        return head;
    }

    public void print(){
        System.out.println(lecturer.getSurname());
        System.out.printf("%5s%5s%17s%11s%17s\n", "№", "ID", "Lecturer", "Position", "Salary");
        DepartmentDin element = next;
        int i = 0;
        while(element != null){
            System.out.printf("%-7d%-15d%-16s%-16s%-10.2f\n", i, element.lecturer.getId(), element.lecturer.getSurname(), element.lecturer.getPosition(), element.lecturer.getSalary());
            element = element.next;
            i++;
        }
    }
}
