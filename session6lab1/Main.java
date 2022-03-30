package session6lab1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        StudentList studentList = new StudentList();
        Scanner sc = new Scanner(System.in);
        int x;
        for (; ; ) {
            System.out.println("\nChoose the function you want");
            System.out.println("0. Exit");
            System.out.println("1. Add student");
            System.out.println("2. Edit student by ID");
            System.out.println("3. Delete student by ID");
            System.out.println("4. Sort students by GPA");
            System.out.println("5. Sort students by name");
            System.out.println("6. Show student list");
            do {
                x = sc.nextInt();
            } while (x<0 || x>6);
            switch (x) {
                case 1: {
                    studentList.addStudent();
                    break;
                }
                case 2: {
                    studentList.editStudentbyID();
                    break;
                }
                case 3: {
                    studentList.deleteStudentbyID();
                    break;
                }
                case 4: {
                    studentList.sortStudentsbyGPA();
                    break;
                }
                case 5: {
                    studentList.sortStudentsbyName();
                    break;
                }
                case 6: {
                    studentList.showList();
                    break;
                }
                case 0: {
                    System.out.println("Progress stopped");
                    return;
                }
            }
        }
    }
}
