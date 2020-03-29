package Lab5;

public class DepartmentIDin implements IDepartment{
    private Lecturer lecturer;
    private DepartmentIDin next;
    private static final String DEPARTMENT_FORMAT_STRING = "Name of department: %s; Quantity of Lecturers: %d; ";

    public DepartmentIDin() {
        lecturer = null;
        next = null;
    }

    public DepartmentIDin(String name) {
        lecturer = new Lecturer();
        lecturer.setSurname(name);
        lecturer.setId(0);
        lecturer.setPosition(null);
        lecturer.setSalary(0.25);
        next = null;
    }

    public DepartmentIDin(Lecturer lecturer) {
        this.lecturer = lecturer;
        next = null;
    }

    public void setNameOfDep(String name) {
        lecturer.setSurname(name);
    }

    public String getNameOfDep() {
        return lecturer.getSurname();
    }

    public int getNumberOfLecturer() {
        int number = 0;
        DepartmentIDin element = next;
        while (element != null) {
            number++;
            element = element.next;
        }
        return number;
    }

    public Lecturer getLecturer(int id) {
        if (next == null) return null;
        DepartmentIDin element = next;
        while (element != null) {
            if (element.lecturer.getId() == id) return element.lecturer;
            element = element.next;
        }
        return null;
    }

    public String toString() {
        return String.format(DEPARTMENT_FORMAT_STRING, this.lecturer.getSurname(), getNumberOfLecturer());
    }

    public boolean addLecturer(Lecturer lecturer) {
        if (getLecturer(lecturer.getId()) != null) return false;
        DepartmentIDin element = new DepartmentIDin(lecturer);
        if (next == null) next = element;
        else {
            DepartmentIDin old = next;
            next = element;
            element.next = old;
        }
        return true;
    }

    public boolean delLecturer(int id) {
        DepartmentIDin element = this;
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
        DepartmentIDin element = next;
        while (element != null) {
            middle += element.lecturer.getSalary();
            number++;
            element = element.next;
        }
        return middle / number;
    }

    public DepartmentIDin getAboveMidSalary(){
        double middle = getMidSalary();
        DepartmentIDin head = new DepartmentIDin(String.format("Lecturer who has salary above middle %f: ", middle));
        DepartmentIDin element = next;
        while (element != null){
            if(element.lecturer.getSalary() > middle)head.addLecturer(element.lecturer);
            element = element.next;
        }
        return head;
    }

    public DepartmentIDin betweenSalary(double a, double b) {
        DepartmentIDin head = new DepartmentIDin(String.format("Lecturer who have salary between %f to %f", a, b));
        DepartmentIDin element = next;
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
        DepartmentIDin element = next;
        int i = 0;
        while(element != null){
            System.out.printf("%-7d%-15d%-16s%-16s%-10.2f\n", i, element.lecturer.getId(), element.lecturer.getSurname(), element.lecturer.getPosition(), element.lecturer.getSalary());
            element = element.next;
            i++;
        }
    }

    public void sort(){

    }
}
