package tools;

import tools.Inputter;
import java.util.ArrayList;

/*
là cái khuôn đúc ra các loại menu
*/
public class Menu {
    private ArrayList<String> otpList = new ArrayList<>();
    private String title;//tên menu
    private String inputMsg;//lời mời nhập lựa chọn
    private String errorMsg;//lời thông báo lỗi
    
    //constructor

    public Menu(String title, String inputMsg, String errorMsg) {
        this.title = title;
        this.inputMsg = inputMsg;
        this.errorMsg = errorMsg;
    }
    
    //add option
    public void addOtp(String otp){
        otpList.add(otp);
    }
    //print
    public void print(){
        System.out.println("----" + title + "----");
        int seq = 1;//sequence: tuần tự/ có thứ tự
        for (String otp : otpList) {
            System.out.println(seq++ + "." + otp);
        }
    }
    
    //getchoice
    public int getChoice(){
        return Inputter.getAnInteger(inputMsg, 
                              errorMsg + "between 1 and" + otpList.size(),
                              1, otpList.size());
    }
}
