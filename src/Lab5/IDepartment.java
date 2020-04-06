package Lab5;

public interface IDepartment {

    void setNameOfDep(String name);

    String getNameOfDep();

    int getNumberOfLecturer();

    Lecturer getLecturer(int id);

    boolean addLecturer(Lecturer lecturer);

    boolean delLecturer(int id);

    double getMidSalary();

    IDepartment getAboveMidSalary();

    IDepartment betweenSalary(double a, double b);

    void print();

    void sort();
}
