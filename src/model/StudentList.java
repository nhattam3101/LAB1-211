package model;

import model.Student;
import model.MountainList;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import model.Statistics;
import tools.Acceptable;
import tools.Inputter;

public class StudentList{
    List<Student> studentList = new ArrayList<>();
    private String pathFile = "registrations.dat";
    boolean isSaved = false;
    private static final String HEADER_TABLE =
        "--------------------------------------------------------------------------------\n"
      + "Student ID | Name                 | Phone      | Peak Code | Fee\n"
      + "--------------------------------------------------------------------------------";

    private static final String FOOTER_TABLE =
        "--------------------------------------------------------------------------------"; 
//    CÁC NHÓM METHOD BỔ TRỢ
    //    hàm bỏ trợ cho việc thêm học sinh và chọn núi mới
    private String inputMountainCode(MountainList mountains){
        while(true){
            String mCode = Inputter.getAString("Mountain code: ", "Invalid code!");
            if(mountains.isValidMountainCode(mCode)){
                return mCode;
            }
            System.out.println("Mountain code not exits in list!");
        }
    }
//    bổ trợ cho việc update
    private String inputUpdateMountainCode(MountainList mountains, String oldValue) {
        if(oldValue == null || oldValue.isEmpty()) return null;
        while (true) {
            String code = Inputter.updateString(
                    "New mountain code [Enter to keep old]: ",
                    oldValue
            );
            if (code.equals(oldValue) || mountains.isValidMountainCode(code)) {
                return code;
            }
            System.out.println("Mountain code does not exist!");
        }
    }
//    hàm tính chi phí đã trừ discount và chưa trừ
    private double inputTutionFee(String phone){
        double default_fee = 6000000;
        if(phone.matches(Acceptable.VNPT_VALID) || 
           phone.matches(Acceptable.VIETTEL_VALID)){
            return default_fee - (default_fee * 0.35);
        }
        return default_fee;
    }
//    hàm bổ chợ check xem id đó đã tồn tại đối tượng nào sở hữu nó chưa
    private Student checkExist(String code){
        if(code == null || code.isEmpty()) return null;
        for (Student student : studentList) {
            if(student.getCode().equalsIgnoreCase(code)) return student;
        }
        return null;
    }
//    hàm bổ trợ cho việc hiển thị danh sách 
    private void showAll(List<Student> list) {
        if(list == null || list.size() == 0 || list.isEmpty()){
            System.out.println("No student have registered yet");
            return;
        }
        System.out.println(HEADER_TABLE);
        for (Student student : list) {
            System.out.println(student);
        }
        System.out.println(FOOTER_TABLE);
    }
//    hàm bổ trợ cho việc lọc campus
    private List<Student> filterCampus(String code){
        List<Student> result = new ArrayList<>();
        for (Student student : studentList) {
            if(student.getCode().toUpperCase().startsWith(code.toUpperCase())){
                result.add(student);
            }    
        }
        return result;
    }
    
//    CÁC NHÓM METHOD CHÍNH
    //tạo mới
    public void create(MountainList mountains){
        String code = Inputter.getAString("Student ID: ", "Invalid ID!", Acceptable.STUDENT_ID);
        String name = Inputter.getAString("Name: ", "Invalid name!", Acceptable.NAME_VALID);
        String phone = Inputter.getAString("Phone: ", "Invalid phone!", Acceptable.PHONE_VALID);
        String email = Inputter.getAString("Email: ", "Invalid email!", Acceptable.EMAIL_VALID);
        String moutainCode = inputMountainCode(mountains);
        double tutionFee = inputTutionFee(phone);
        studentList.add(new Student(code, name, phone, email, moutainCode, tutionFee)); 
        System.out.println("Creating successfully!");
    }
//  update
    public void update(MountainList mountains){
        String code;
        Student key;
        showAll();//show danh sách để người dùng nhìn thấy id nào để biết mà sữa
        while (true) {
            code = Inputter.getAString("Student ID to update: ", "Invalid ID", Acceptable.STUDENT_ID);
            key = checkExist(code);
            if (key != null) break;
            System.out.println("This student has not registered yet");
        }

        String name = Inputter.updateString("New name [Enter to keep old]: ", "Invalid name", key.getName(), Acceptable.NAME_VALID);
        String phone = Inputter.updateString("New phone [Enter to keep old]: ", "Invalid phone", key.getPhone(), Acceptable.PHONE_VALID);
        String email = Inputter.updateString("New email [Enter to keep old]: ", "Invalid email", key.getEmail(), Acceptable.EMAIL_VALID);

        String mountainCode = inputUpdateMountainCode(mountains, key.getMountainCode());
//      set
        key.setName(name);
        key.setPhone(phone);
        key.setEmail(email);
        key.setMountainCode(mountainCode);
        System.out.println("Updating successfully!");
    }
    
    public void delete(){
//        nhập id để xoá
        String keyCode;
        Student key;
        boolean sure;
        
        keyCode = Inputter.getAString("Enter student code to delete: ", "Invalid code", Acceptable.STUDENT_ID);
        key = checkExist(keyCode);
        if(key == null){
            System.out.println("This student has not registered yet");
            return;
        }else{
            System.out.println("The inforation of student before delete: ");
            System.out.println(key.toString());
            sure = Inputter.getYesNo("Are you sure?[Y/N]");
            if(sure){
                studentList.remove(key);
                System.out.println("This registration has been successfully deleted!");
            }else return;
            
        }
    }
    
    public void showAll(){
        showAll(studentList);
    }
    
    public void searchById(){
        String keyCode;
        Student key;
        
        keyCode = Inputter.getAString("Enter student code to search: ", "Invalid code", Acceptable.STUDENT_ID);
        key = checkExist(keyCode);
        if(key == null){
            System.out.println("No one matches the search criteria");
            return;
        }else{
            System.out.println(HEADER_TABLE);
            System.out.println(key.toString());
            System.out.println(FOOTER_TABLE);
        }
    }
    
    public void searchByName(){
        String name;
        Student key = null;
        
        name = Inputter.getAString("Enter student name to search: ", "Invalid name", Acceptable.NAME_VALID);
        for (Student student : studentList) {
            if(student.getName().contains(name)){
                key = student;
            }
        }
        if(key == null){
            System.out.println("No one matches the search criteria");
            return;
        }else{
            System.out.println(HEADER_TABLE);
            System.out.println(key.toString());
            System.out.println(FOOTER_TABLE);
        }
    }

    public void filterByCampusCode(){
        String code = Inputter.getAString("Enter a campus code: ", "Invalid code", 
                                        Acceptable.CAMPUS_CODE);
        List<Student> rs = filterCampus(code);
        if(rs.isEmpty()){
            System.out.println("No students have registered under this campus");
        }else{
            System.out.println(HEADER_TABLE);
            for (Student r : rs) {
                System.out.println(r.toString());
            }
            System.out.println(FOOTER_TABLE);
        }
        
    }
    
    public void statisticalizeByMountainPeak() {
        if (studentList.isEmpty()) {
            System.out.println("No registration data available.");
            return;
        }

        Statistics statistics = new Statistics(studentList);
        statistics.showStatistics();
    }
    
    public void saveToFile() {
        try (ObjectOutputStream oos =
                new ObjectOutputStream(new FileOutputStream(pathFile))) {

            for (Student student : studentList) {
                oos.writeObject(student);
            }
            isSaved = true;
            System.out.println("Registration data has been successfully saved.");

        } catch (IOException e) {
            System.out.println("Save file failed: " + e.getMessage());
        }
    }
    
    public void saveBeforeExit() {
    if (isSaved) return;

    String choice = Inputter.getAString("Data has changed. Do you want to save before exiting? (Y/N): ", "Please enter Y or N", "^[YyNn]$");

    if (choice.equalsIgnoreCase("Y")) {
        saveToFile();
    }
}
    
    public void readFromFile() {
        File file = new File(pathFile);

        if (!file.exists()) return;

        List<Student> tempList = new ArrayList<>();

        try (ObjectInputStream ois =
                new ObjectInputStream(new FileInputStream(file))) {

            while (true) {
                try {
                    Student student = (Student) ois.readObject();
                    tempList.add(student);
                } catch (EOFException e) {
                    break;
                }
            }

            studentList.clear();
            studentList.addAll(tempList);
            boolean isSaved = true;
            System.out.println("Loading file successfully");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Read file failed: " + e.getMessage());
        }
    }
}
