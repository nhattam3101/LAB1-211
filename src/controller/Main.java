package controller;

import model.business.MountainList;
import model.business.StudentList;
import view.View;

public class Main {

    public static void main(String[] args) {
        MountainList mountains = new MountainList();
        StudentList students = new StudentList();
        View view = new View();
        
        mountains.readFromFile();
        students.readFromFile();
        
        int choice;

        do {
            choice = view.getChoice();

            switch (choice) {
                case 1:
                    students.create(mountains);
                    break;

                case 2:
                    students.update(mountains);
                    break;

                case 3:
                    students.showAll();
                    break;

                case 4:
                    students.delete();
                    break;

                case 5:
                    students.searchByName();
                    break;

                case 6:
                    students.filterByCampusCode();
                    break;

                case 7:
                    students.statisticalizeByMountainPeak();
                    break;

                case 8:
                    students.saveToFile();
                    break;

                case 9:
                    System.out.println("Goodbye!");
                    break;
            }

        } while (choice != 9);
    }
}