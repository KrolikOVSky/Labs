package Lab5;

public class DepartmentIStat implements IDepartment {
    private static final int MIN_NUM = 5;
    private static final String DEPARTMENT_FORMAT_STRING = "Name of department: %s; Quantity of Lecturers: %d; ";
    private String nameOfDep;
    private Lecturer[] lecturerList;
    private int numberOfLecturer;

    public DepartmentIStat() {
        this.nameOfDep = "";
        this.lecturerList = new Lecturer[MIN_NUM];
        this.numberOfLecturer = 0;
    }

    public DepartmentIStat(String nameOfDep, int num_max) {
        this.nameOfDep = nameOfDep;
        this.numberOfLecturer = 0;
        this.lecturerList = new Lecturer[num_max];
    }

    public String getNameOfDep() {
        return nameOfDep;
    }

    public int getNumberOfLecturer() {
        return numberOfLecturer;
    }

    public void setNameOfDep(String nameOfDep) {
        this.nameOfDep = nameOfDep;
    }

    public Lecturer getLecturer(int id) {
        for (Lecturer list : this.lecturerList) if (list != null && list.getId() == id) return list;
        return null;
    }

    public boolean addLecturer(Lecturer lecturer) {
        if (numberOfLecturer == lecturerList.length) return false;
        for (var i = 0; i < numberOfLecturer; i++) if (lecturerList[i].getId() == lecturer.getId()) return false;
        lecturerList[numberOfLecturer] = lecturer;
        numberOfLecturer += 1;
        return true;
    }

    public boolean delLecturer(int id) {
        int i;
        for (i = 0; i < numberOfLecturer; i++) {
            if (lecturerList[i].getId() == id) break;
        }
        if (i == numberOfLecturer) return false;
        for (i += 1; i < numberOfLecturer; i++) lecturerList[i - 1] = lecturerList[i];
        lecturerList[i - 1] = null;
        numberOfLecturer--;
        return true;
    }

    public double getMidSalary() {
        if (numberOfLecturer == 0) return 0;
        double middle = 0;
        for (var i : lecturerList) {
            if (i != null) middle += i.getSalary();
        }
        return middle / numberOfLecturer;
    }

    public DepartmentIStat getAboveMidSalary() {
        double middle = getMidSalary();
        DepartmentIStat list = new DepartmentIStat(String.format("Lecturer with salary above middle %.2f:\n", middle), numberOfLecturer);
        for (int i = 0; i < numberOfLecturer; i++) {
            if(lecturerList[i].getSalary() > middle) list.addLecturer(lecturerList[i]);
        }
        return list;
        /*if (numberOfLecturer == 0) return null;
        Lecturer[] X = new Lecturer[numberOfLecturer];
        int j = 0;
        double middle = getMidSalary();
        for (var i : lecturerList)
            if (i != null) {
                if (i.getSalary() > middle) {
                    X[j] = i;
                    j += 1;
                }
            }
        if (j == 0) return null;
        Lecturer[] Y = new Lecturer[j];
        for (var i = 0; i < j; i++) Y[i] = X[i];
        return Y;*/
    }

    public DepartmentIStat betweenSalary(double a, double b) {
        DepartmentIStat list = new DepartmentIStat(String.format("Lecturer with salary between [%.2f][%.2f]:\n", a, b), numberOfLecturer);
        for (int i = 0; i < numberOfLecturer; i++) {
            double x = lecturerList[i].getSalary();
            if(x >= a && x <= b) list.addLecturer(lecturerList[i]);
        }
        return list;
        /*if (numberOfLecturer == 0) return null;
        Lecturer[] X = new Lecturer[numberOfLecturer];
        int j = 0;
        for (var i : lecturerList) {
            if (i != null) {
                double temp = i.getSalary();
                if ((temp >= a) && (temp <= b)) {
                    X[j] = i;
                    j += 1;
                }
            }
        }
        if (j == 0) return null;
        Lecturer[] Y = new Lecturer[j];
        for (var i = 0; i < j; i++) Y[i] = X[i];
        return Y;*/
    }

    public void print() {
        System.out.println(nameOfDep);
        if (numberOfLecturer != 0) {
            System.out.printf("%5s%17s%11s%17s\n", "ID", "Lecturer", "Position", "Salary");
            try {
                for (var i = 0; i < numberOfLecturer; i++) {
                    System.out.printf("%-7d %-15s %-15s %-10s\n", lecturerList[i].getId(), lecturerList[i].getSurname(), lecturerList[i].getPosition(), lecturerList[i].getSalary());
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
                System.out.println("Error");
            }
        }
    }

    @Override
    public String toString() {
        return String.format(DEPARTMENT_FORMAT_STRING, nameOfDep, numberOfLecturer);
    }

    public void sort() {
        boolean flag;
        for (int m = numberOfLecturer - 1; m > 0; m--) {
            flag = true;
            for (int j = 0; j < m; j++)
                if (lecturerList[j].getSalary() > lecturerList[j + 1].getSalary()) {
                    Lecturer b = lecturerList[j];
                    lecturerList[j] = lecturerList[j + 1];
                    lecturerList[j + 1] = b;
                    flag = false;
                }
            if (flag) break;
        }
    }
}
