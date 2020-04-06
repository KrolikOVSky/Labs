package Lab4;

import java.io.*;
import java.nio.file.*;

public class Main {
    private static String[] fileToString(){
        String[] content = new String[0];
        try {
            content = Files.readString(Paths.get("C:\\Users\\alan2\\Desktop\\1.txt")).replaceAll("\r\n", "").split(",");
        } catch (IOException e) {
            e.printStackTrace();
        }

        return content;
    }

    public static void main(String[] args) {
        args = fileToString();
        Lab4.DepartmentDin it = new Lab4.DepartmentDin("ИИТУТС");
        Lab4.DepartmentDin physics = new Lab4.DepartmentDin("Физика");
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

        if(!it.addLecturer(new Lecturer(76544, "Чемшит", "Профессор", 1.75))){
            System.out.printf("Can't add lecturer 76544 at department %s:", it.getNameOfDep());
            System.out.println("Duplicated id");
        }

        it.print();
        System.out.printf("Middle salary of department: %.2f\n", it.getMidSalary());
        it.getAboveMidSalary().print();
        it.betweenSalary(0.25, 1.2).print();
        it.delLecturer(76544);
        System.out.println("Lecturers after deleting");
        it.print();
        System.out.println();

        physics.print();
        System.out.printf("Middle salary of department: %.2f\n", physics.getMidSalary());
        physics.getAboveMidSalary().print();
        physics.betweenSalary(1, 1.75).print();
        physics.delLecturer(10948);
        System.out.println("Lecturers after deleting");
        physics.print();
        System.out.println();

        System.out.println("Checking of lecturers:");
        int id = 798465;
        Lecturer itLecturer1 = it.getLecturer(id);
        System.out.printf("At Department: %s\n", it.getNameOfDep());
        if(itLecturer1 == null) System.out.printf("No lecturer with id: %d\n", id);
        else System.out.println(itLecturer1);

        id = 798005;
        itLecturer1 = it.getLecturer(id);
        if(itLecturer1 == null) System.out.printf("No lecturer with id: %d\n", id);
        else System.out.println(itLecturer1);

        id = 711165;
        System.out.printf("At Department: %s\n", physics.getNameOfDep());
        itLecturer1 = physics.getLecturer(id);
        if(itLecturer1 == null) System.out.printf("No lecturer with id: %d\n", id);
        else System.out.println(itLecturer1);

        System.out.println("--------------------------------\n");
        it.print();
        System.out.println("--------------------------------\n");
        it.sort();
        it.print();
        System.out.println("--------------------------------\n");


    }
}

