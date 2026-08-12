package model;

public class StatisticalInfo {
    private String mountainCode;
    private int numOfStudent;
    private double totalCost;
//    

    public StatisticalInfo() {
    }

    public StatisticalInfo(String mountainCode, int numOfStudent, double totalCost) {
        this.mountainCode = mountainCode;
        this.numOfStudent = numOfStudent;
        this.totalCost = totalCost;
    }
    
//    getter setter

    public String getMountainCode() {
        return mountainCode;
    }

    public int getNumOfStudent() {
        return numOfStudent;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public void setMountainCode(String mountainCode) {
        this.mountainCode = mountainCode;
    }

    public void setNumOfStudent(int numOfStudent) {
        this.numOfStudent = numOfStudent;
    }

    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }
    
    @Override
    public String toString() {
        if(Integer.valueOf(mountainCode) < 10){
            return String.format("| MT0%-13s | %-22d | %,15.0f |",
                    mountainCode, numOfStudent, totalCost);
        }else{
            return String.format("| MT%-14s | %-22d | %,15.0f |",
                    mountainCode, numOfStudent, totalCost);
        }
    }
}
