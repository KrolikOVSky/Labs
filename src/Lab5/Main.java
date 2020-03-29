package Lab5;

import java.io.*;
import java.nio.file.*;

public class Main {
    private static void setDepStatus(IDepartment department, String status){
        department.setNameOfDep(String.format("%s %s",department.getNameOfDep(), status));
    }

    private static String[] fileToString() {
        String[] content = new String[0];
        try {
            content = Files.readString(Paths.get("C:\\Users\\alan2\\Desktop\\1.txt")).replaceAll("\r\n", "").split(",");
        } catch (IOException e) {
            e.printStackTrace();
        }

        return content;
    }

    public static void run(String[] args) {
        args = fileToString();
        IDepartment it = new DepartmentIStat("ИИТУТС", 10);
        IDepartment physics = new DepartmentIDin("Физика");
        var j = 0;

        for (int i = 0; i < 5; i++) {
            int id = Integer.parseInt(args[j]);
            j++;
            String name = args[j];
            j++;
            double salary = Double.parseDouble(args[j]);
            j++;
            String position = args[j];
            j++;
            it.addLecturer(new Lecturer(id, name, position, salary));
        }

        for (int i = 0; i < 5; i++) {
            int id = Integer.parseInt(args[j]);
            j++;
            String name = args[j];
            j++;
            double salary = Double.parseDouble(args[j]);
            j++;
            String position = args[j];
            j++;
            physics.addLecturer(new Lecturer(id, name, position, salary));
        }

        System.out.println("Created next Departments");
        System.out.printf("%s\n%s\n\n", it, physics);

        if (!it.addLecturer(new Lecturer(123456, "Чемшит", "Профессор", 1.75))) {
            System.out.printf("Can't add lecturer 98746 at department %s:", it.getNameOfDep());
            System.out.println("List overflow\n\n");
        }

        if (!physics.addLecturer(new Lecturer(76544, "Чемшит", "Профессор", 1.75))) {
            System.out.printf("Can't add lecturer 76544 at department %s:", physics.getNameOfDep());
            System.out.println("Duplicated id\n\n");
        }

        it.print();
        System.out.println("Lecturer with salary above middle:\n");
        it.getAboveMidSalary().print();
        System.out.println("Lecturer with salary between [0.25, 1.2]\n");
        it.betweenSalary(0.25, 1.2).print();
        it.delLecturer(76544);
        System.out.println("Lecturers after deleting");
        it.print();

        System.out.println();

        physics.print();
        System.out.println("Lecturer with salary above middle:\n");
        physics.getAboveMidSalary().print();
        System.out.println("Lecturer with salary between [0.25, 1.75]\n");
        physics.betweenSalary(0.25, 1.75).print();
        physics.delLecturer(10948);
        System.out.println("Lecturers after deleting");
        physics.print();

        System.out.println();

        System.out.println("Checking of lecturers:");
        int id = 798465;
        Lecturer itLecturer1 = it.getLecturer(id);
        System.out.printf("At Department: %s\n", it.getNameOfDep());
        if (itLecturer1 == null) System.out.printf("No lecturer with id: %d\n", id);
        else System.out.println(itLecturer1);

        id = 798005;
        itLecturer1 = it.getLecturer(id);
        if (itLecturer1 == null) System.out.printf("No lecturer with id: %d\n", id);
        else System.out.println(itLecturer1);

        id = 711165;
        System.out.printf("At Department: %s\n", physics.getNameOfDep());
        itLecturer1 = physics.getLecturer(id);
        if (itLecturer1 == null) System.out.printf("No lecturer with id: %d\n", id);
        else System.out.println(itLecturer1);

        setDepStatus(it, "certified with A");
        setDepStatus(physics, "Not certified");
        System.out.println("After certification");
        System.out.printf("%s;\n",it.getNameOfDep());
        System.out.printf("%s;\n",physics.getNameOfDep());

    }
}
