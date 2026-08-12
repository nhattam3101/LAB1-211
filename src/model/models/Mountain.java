package model.models;

public class Mountain {
    private String mountainCode;
    private String mountain;
    private String province;
    private String description;
//    constructor

    public Mountain() {
    }

    public Mountain(String mountainCode, String mountain, String province, String description) {
        this.mountainCode = mountainCode;
        this.mountain = mountain;
        this.province = province;
        this.description = description;
    }
//    getter setter

    public String getMountainCode() {
        return mountainCode;
    }

    public String getMountain() {
        return mountain;
    }

    public String getProvince() {
        return province;
    }

    public String getDescription() {
        return description;
    }

    public void setMountainCode(String mountainCode) {
        this.mountainCode = mountainCode;
    }

    public void setMountain(String mountain) {
        this.mountain = mountain;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public void setDescription(String description) {
        this.description = description;
    }
//    method object
    @Override
    public String toString(){
        return String.format("MT0%s, %s, %s, %s", 
                                mountainCode, mountain, province, description);
    }
}
