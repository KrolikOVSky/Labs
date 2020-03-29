package Lab3;

public class Lecturer {

    private int id;
    private String surname;
    private String position;
    private double salary;
    private String LECTURER_FORMAT_STRING = "Lecturer: %s;\t id: %d;\t position: %s;\t salary: %.3f\n";

    public Lecturer() {
        this.id = 0;
        this.surname = "";
        this.position = "";
        this.salary = 0;
    }

    public Lecturer(int id, String surname, String position, double salary) {
        this.id = id;
        this.surname = surname;
        this.position = position;
        if (salary >= 0.25 && salary <= 1.75)
            this.salary = salary;
        else {
            System.out.println("Wrong salary");
            this.salary = 0;
        }
    }

    public Lecturer(Lecturer lecturer) {
        id = lecturer.id;
        surname = lecturer.surname;
        position = lecturer.position;
        salary = lecturer.salary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        try {
            this.id = id;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        if (salary >= 0.25 && salary <= 1.75)
            this.salary = salary;
        else System.out.println("Wrong salary");
    }

    @Override
    public String toString() {
        return String.format(LECTURER_FORMAT_STRING, surname, id, position, salary);
    }
}
