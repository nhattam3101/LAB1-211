package view;

import tools.Menu;

public class View {

    private Menu menu;

    public View() {
        menu = new Menu(
                "Mountain Hiking Challenge Registration",
                "Enter your choice: ",
                "Your choice must be from 1 to 9!"
        );

        menu.addOtp("New Registration");
        menu.addOtp("Update Registration Information");
        menu.addOtp("Display Registered List");
        menu.addOtp("Delete Registration Information");
        menu.addOtp("Search Participants by Name");
        menu.addOtp("Filter Data by Campus");
        menu.addOtp("Statistics by Mountain Peak");
        menu.addOtp("Save Data to File");
        menu.addOtp("Exit");
    }

    public int getChoice() {
        menu.print();
        return menu.getChoice();
    }
}