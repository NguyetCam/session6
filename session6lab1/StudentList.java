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
                    System.out.println("Old name: " + st.getName() + ". New name: ");
                    st.setName(sc.nextLine());
                    System.out.println("Old DOB: " + st.getBday() + ". New DOB: ");
                    st.setBday(LocalDate.parse(sc.nextLine()));
                    System.out.println("Old address: " + st.getAddress() + ". New name: ");
                    st.setAddress(sc.nextLine());
                    System.out.format("Old GPA: %.2f. New GPA: ",st.getGpa());
                    st.setGpa(sc.nextFloat());
                    System.out.println("Student " + st.getName() + " has been edited");
                    return;
                }
            }
            System.out.println("ID " + id + " is not available");
        }
    }

    public void deleteStudentbyID(){
        if(StudentList.size()==0)System.out.println("List is empty");
        else {
            System.out.println("Insert student's ID");
            Scanner sc = new Scanner(System.in);
            String id = sc.nextLine();
            StudentList.removeIf(st -> id.equals(st.getId()));
            System.out.println("Student ID " + id + " has been removed");
        }
    }

    public void sortStudentsbyGPA(){
        String idtemp,nametemp,addresstemp;
        LocalDate bdaytemp;
        double gpatemp;
        if(StudentList.size()==0) System.out.println("There aren't any students in the list");
        else {
            for(int i=0;i<StudentList.size();i++){
                for(int j=0;j<StudentList.size();j++){
                    if(StudentList.get(i).getGpa()>StudentList.get(j).getGpa()){
                        gpatemp = StudentList.get(j).getGpa();
                        StudentList.get(j).setGpa(StudentList.get(i).getGpa());
                        StudentList.get(i).setGpa(gpatemp);
                        idtemp = StudentList.get(j).getId();
                        StudentList.get(j).setId(StudentList.get(i).getId());
                        StudentList.get(i).setId(idtemp);
                        nametemp = StudentList.get(j).getName();
                        StudentList.get(j).setName(StudentList.get(i).getName());
                        StudentList.get(i).setName(nametemp);
                        addresstemp = StudentList.get(j).getAddress();
                        StudentList.get(j).setAddress(StudentList.get(i).getAddress());
                        StudentList.get(i).setAddress(addresstemp);
                        bdaytemp = StudentList.get(j).getBday();
                        StudentList.get(j).setBday(StudentList.get(i).getBday());
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
