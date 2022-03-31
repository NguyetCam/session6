package session6lab1;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class StudentList {
    ArrayList<Student> StudentList = new ArrayList<Student>();

    public void addStudent(){
            System.out.println("Add student");
            Scanner sc = new Scanner(System.in);
            System.out.println("Student's ID");
            String id = sc.nextLine();
            for(Student st:StudentList){
                if(st.getId().equals(id)){
                    System.out.println("This ID is available");
                    return;
                }
            }
            System.out.println("Student's name");
            String name = sc.nextLine();
            System.out.println("Date of birth");
            LocalDate bday = LocalDate.parse(sc.nextLine());
            System.out.println("Address");
            String address = sc.nextLine();
            System.out.println("GPA");
            double gpa = sc.nextFloat();
            StudentList.add(new Student(id,name,bday,address,gpa));
            System.out.println("Student " + name + " has been added into the list");
            }

    public void editStudentbyID(){
        if(StudentList.size()==0)System.out.println("List is empty");
        else {
            Scanner sc = new Scanner(System.in);
            System.out.println("Insert student's ID");
            String id = sc.nextLine();
            for (Student st : StudentList) {
                if (id.equals(st.getId())) {
                    System.out.println("You are editing student: " + st.getName());
                    System.out.println("Date of birth: " + st.getBday());
                    System.out.println("Address:  " + st.getAddress());
                    System.out.println("GPA:  " + st.getGpa());
                    System.out.println("Choose the field that you want to edit");
                    System.out.println("1. Name\n2. Date of birth\n3. Address\n4. GPA\n5. Cancel");
                    int x;
                    do {
                        x = sc.nextInt();
                    }while (x<1 || x>5);
                    switch (x){
                        case 1:{
                            System.out.println("Enter new name");
                            editName(id);
                            break;
                        }
                        case 2:{
                            System.out.println("Enter new date of birth");
                            editBday(id);
                            break;
                        }
                        case 3:{
                            System.out.println("Enter new address");
                            editAddress(id);
                            break;
                        }
                        case 4:{
                            System.out.println("Enter new GPA");
                            editGpa(id);
                            break;
                        }
                        case 5:{
                            System.out.println("Cancelled");
                            return;
                        }
                    }
                    return;
                }
            }
            System.out.println("ID " + id + " is not available");
        }
    }

    public void editName(String id){
        for(Student st:StudentList){
            if(st.getId().equals(id)){
                Scanner sc = new Scanner(System.in);
                st.setName(sc.nextLine());
            }
        }
    }

    public void editBday(String id){
        for(Student st:StudentList){
            if(st.getId().equals(id)){
                Scanner sc = new Scanner(System.in);
                st.setBday(LocalDate.parse(sc.nextLine()));
            }
        }
    }

    public void editAddress(String id){
        for(Student st:StudentList){
            if(st.getId().equals(id)){
                Scanner sc = new Scanner(System.in);
                st.setAddress(sc.nextLine());
            }
        }
    }

    public void editGpa(String id){
        for(Student st:StudentList){
            if(st.getId().equals(id)){
                Scanner sc = new Scanner(System.in);
                st.setGpa(sc.nextFloat());
            }
        }
    }

    public void deleteStudentbyID(){
        if(StudentList.size()==0)System.out.println("List is empty");
        else {
            System.out.println("Insert student's ID");
            Scanner sc = new Scanner(System.in);
            String id = sc.nextLine();
            for(Student st:StudentList){
                if(id.equals(st.getId())){
                    System.out.println("Student " + st.getName() + " has been removed");
                    StudentList.remove(st);
                    return;
                }
            }
            System.out.println("This ID is not available");
        }
    }

    public void sortStudentsbyGPA(){
        //Cách Cường
//        StudentList.sort(Comparator.comparing(Student::getGpa));
        String idtemp,nametemp,addresstemp;
        LocalDate bdaytemp;
        double gpatemp;
        if(StudentList.size()==0) System.out.println("There aren't any students in the list");
        else {
            for(int i=0;i<StudentList.size();i++){
                for (Student student : StudentList) {
                    if (StudentList.get(i).getGpa() > student.getGpa()) {
                        gpatemp = student.getGpa();
                        student.setGpa(StudentList.get(i).getGpa());
                        StudentList.get(i).setGpa(gpatemp);
                        idtemp = student.getId();
                        student.setId(StudentList.get(i).getId());
                        StudentList.get(i).setId(idtemp);
                        nametemp = student.getName();
                        student.setName(StudentList.get(i).getName());
                        StudentList.get(i).setName(nametemp);
                        addresstemp = student.getAddress();
                        student.setAddress(StudentList.get(i).getAddress());
                        StudentList.get(i).setAddress(addresstemp);
                        bdaytemp = student.getBday();
                        student.setBday(StudentList.get(i).getBday());
                        StudentList.get(i).setBday(bdaytemp);
                    }
                }
            }
            System.out.println("Sort students by GPA");
            System.out.println("| ID |   Student's name   | Date of birth |     Address     | GPA |");
            for (Student st:StudentList) {
                System.out.format("|%4s|%20s|%15s|%17s|%5.2f|\n",st.getId(),st.getName(),st.getBday(),st.getAddress(),st.getGpa());
            }
        }
    }

    public void sortStudentsbyName(){
        Collections.sort(StudentList, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });
        //Cách Cường:
//        StudentList.sort(Comparator.comparing(Student::getName));
        System.out.println("Sort students by name");
        System.out.println("| ID |   Student's name   | Date of birth |     Address     | GPA |");
        for (Student st:StudentList) {
            System.out.format("|%4s|%20s|%15s|%17s|%5.2f|\n",st.getId(),st.getName(),st.getBday(),st.getAddress(),st.getGpa());
        }
    }

    public void showList(){
        if (StudentList.size()==0) System.out.println("List is empty");
        else {
            System.out.println("Student list");
            System.out.println("| ID |   Student's name   | Date of birth |     Address     | GPA |");
            for (Student st:StudentList) {
                System.out.format("|%4s|%20s|%15s|%17s|%5.2f|\n",st.getId(),st.getName(),st.getBday(),st.getAddress(),st.getGpa());
            }
        }
    }
}
