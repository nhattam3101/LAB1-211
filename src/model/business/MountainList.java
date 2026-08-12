
package model.business;

import model.models.Mountain;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class MountainList {
    private String pathFile = "MountainList.csv";
    private List<Mountain> mountainList = new ArrayList<>();
//    constructor

    public MountainList() {
    }
//    method 
    public Mountain get(String mountainCode){
        if(mountainCode.isEmpty()) return null;
        for (Mountain mountain : mountainList) {
            if(mountain.getMountainCode().equalsIgnoreCase(mountainCode))
                return mountain;
        }
        return null;
    }
    
    public boolean isValidMountainCode(String mCode){
        if(mCode == null || mCode.isEmpty()){
            return false;
        }
        for (Mountain mountain : mountainList) {
            if(mountain.getMountainCode().equalsIgnoreCase(mCode))
                return true;
        }
        return false;
    }
    
    private  Mountain dataToOject(String text){
        if(text == null || text.isEmpty()) return null;
        StringTokenizer st = new StringTokenizer(text, ",");
        String mountainCode = st.nextToken().trim();
        String mountain = st.nextToken().trim();
        String province = st.nextToken().trim();
        String description = st.nextToken().trim();
        return new Mountain(mountainCode, mountain, province, description);
    }
    
    public void readFromFile(){
        File f = new File(pathFile);
        if(!f.exists()){
            System.out.println("Mountain file not exist");
            return;
        }
//        list tạm để hứng trước khi trường hợp đọc lỗi sau mỗi lần cứ clear nếu để ở đầu
        List<Mountain> tempList = new ArrayList<>(mountainList);

        try(BufferedReader reader = 
                    new BufferedReader(new FileReader(f))){
            //từ JDK 8 có có khả năng đóng mở tự động nếu ví dụ trường 
            String text;
            boolean firstLine = true;

            while ((text = reader.readLine()) != null) {
                if (firstLine) {
                    firstLine = false;
                    continue;
                }

                if (text.trim().isEmpty()) continue;

                tempList.add(dataToOject(text));
            }
            
            
            mountainList.clear();
            mountainList.addAll(tempList);
            
            System.out.println("Loading successfully");
        }catch(IOException e){
            System.out.println("Error:" + e.getMessage());
        }
    }
}
