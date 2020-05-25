package Lab3;

import java.io.*;
import java.nio.file.*;

public class Main {
    private static void printLecturer(Object [] arr){
        if(arr == null) {
            System.out.println("null 77\n");
            return;
        }
        for(var i : arr){
            if(i.equals("\r") || i.equals("\n") || i.equals("\r\n") || i.equals("\n\r")) System.out.println("\n");
            System.out.printf("%-25s",i);
        }
        System.out.println();
    }

    private static String[] fileToString(){
        String[] content = new String[0];
        try {
            content = Files.readString(Paths.get("resources/1.txt")).replaceAll("\r\n", "").split(",");
        } catch (IOException e) {
            e.printStackTrace();
        }

        return content;
    }

    public static void main(String[] args) {
        args = fileToString();
        DepartmentStat it = new DepartmentStat("ИИТУТС",10);
        DepartmentStat physics = new DepartmentStat();
        physics.setNameOfDep("Физика");
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

        if(!physics.addLecturer(new Lecturer(123456, "Чемшит", "Профессор", 1.75))){
            System.out.printf("Can't add lecturer 98746 at department %s:", physics.getNameOfDep());
            System.out.println("List overflow\n");
        }

        it.print();
        System.out.printf("Middle salary of department: %.2f\n", it.getMidSalary());
        System.out.println("Lecturer with salary above middle:");
        it.getAboveMidSalary();
        System.out.println("Lecturer with salary between [0.25, 1.2]");
        printLecturer(it.betweenSalary(0.25, 1.2));
        it.delLecturer(76544);
        System.out.println("Lecturers after deleting");
        it.print();

        physics.print();
        System.out.printf("Middle salary of department: %.2f\n", physics.getMidSalary());
        System.out.println("Lecturer with salary above middle:");
        physics.getAboveMidSalary();
        System.out.println("Lecturer with salary between [0.25, 1.75]");
        printLecturer(physics.betweenSalary(1, 1.75));
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

        it.sort();
        it.print();

    }
}

