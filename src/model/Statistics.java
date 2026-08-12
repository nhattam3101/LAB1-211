package model;

import java.util.HashMap;
import java.util.List;

public class Statistics extends HashMap<String, StatisticalInfo> {

    private final String HEADER_TABLE =
        "|-------------------------------------------------------------|\n"
      + "| Peak Name        | Number of Participants | Total Cost      |\n"
      + "|------------------|------------------------|-----------------|";

private final String FOOTER_TABLE =
        "|-------------------------------------------------------------|";

    public Statistics() {
    }

    public Statistics(List<Student> list) {
        statisticalize(list);
    }

    public final void statisticalize(List<Student> list) {
        this.clear();

        for (Student student : list) {
            String mountainCode = student.getMountainCode();

            if (this.containsKey(mountainCode)) {
                StatisticalInfo info = this.get(mountainCode);
                info.setNumOfStudent(info.getNumOfStudent() + 1);
                info.setTotalCost(info.getTotalCost() + student.getTutionFee());
            } else {
                StatisticalInfo info = new StatisticalInfo(
                        mountainCode, 1, student.getTutionFee()
                );
                this.put(mountainCode, info);
            }
        }
    }

    public void showStatistics() {
        if (this.isEmpty()) {
            System.out.println("No statistical data available.");
            return;
        }

        System.out.println(HEADER_TABLE);
        for (StatisticalInfo info : this.values()) {
            System.out.println(info.toString());
        }
        System.out.println(FOOTER_TABLE);
    }
}