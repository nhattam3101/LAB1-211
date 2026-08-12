package tools;

public interface Acceptable {
    public final String STUDENT_ID = "^[CcDdHhSsQq][Ee]\\d{6}$";
    public final String NAME_VALID = "^.{2,20}$";
    public final String DOUBLE_VALID = "^\\d+(\\.\\d+)$";
    public final String INTEGER_VALID = "\\d+";
    public final String PHONE_VALID = "^0\\d{9}$";
    public final String VIETTEL_VALID =
        "^(032|033|034|035|036|037|038|039|086|096|097|098)\\d{7}$";
    public static final String CAMPUS_CODE = "^(?i)(CE|DE|HE|SE|QE)$";

    public final String VNPT_VALID =
        "^(081|082|083|084|085|088|091|094)\\d{7}$";
    public final String EMAIL_VALID = 
            "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";
//    method
    public static boolean isValid(String data, String pattern){
        return data.matches(pattern);
    }
}
