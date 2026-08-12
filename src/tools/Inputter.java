package tools;

import java.util.Scanner;

public class Inputter {

    private static final Scanner SC = new Scanner(System.in);

    public static int getAnInteger(String inputMsg, String errMsg) {
        while (true) {
            try {
                System.out.print(inputMsg);
                return Integer.parseInt(SC.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println(errMsg);
            }
        }
    }

    public static int getAnInteger(String inputMsg, String errMsg, int lowerBound, int upperBound) {
        while (true) {
            try {
                System.out.print(inputMsg);
                int number = Integer.parseInt(SC.nextLine().trim());
                if (number < lowerBound || number > upperBound) {
                    System.out.println(errMsg);
                    continue;
                }
                return number;
            } catch (NumberFormatException e) {
                System.out.println(errMsg);
            }
        }
    }

    public static double getADouble(String inputMsg, String errMsg) {
        while (true) {
            try {
                System.out.print(inputMsg);
                return Double.parseDouble(SC.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println(errMsg);
            }
        }
    }

    public static double getADouble(String inputMsg, String errMsg, double lowerBound, double upperBound) {
        while (true) {
            try {
                System.out.print(inputMsg);
                double number = Double.parseDouble(SC.nextLine().trim());
                if (number < lowerBound || number > upperBound) {
                    System.out.println(errMsg);
                    continue;
                }
                return number;
            } catch (NumberFormatException e) {
                System.out.println(errMsg);
            }
        }
    }

    public static String getAString(String inputMsg, String errMsg) {
        while (true) {
            System.out.print(inputMsg);
            String str = SC.nextLine().trim();
            if (!str.isEmpty()) return str;
            System.out.println(errMsg);
        }
    }

    public static String getAString(String inputMsg, String errMsg, String regex) {
        while (true) {
            System.out.print(inputMsg);
            String str = SC.nextLine().trim();
            if (!str.isEmpty() && str.matches(regex)) return str;
            System.out.println(errMsg);
        }
    }

    public static String updateString(String inputMsg, String oldValue) {
        System.out.print(inputMsg);
        String str = SC.nextLine().trim();
        return str.isEmpty() ? oldValue : str;
    }

    public static String updateString(String inputMsg, String errMsg, String oldValue, String regex) {
        while (true) {
            System.out.print(inputMsg);
            String str = SC.nextLine().trim();
            if (str.isEmpty()) return oldValue;
            if (str.matches(regex)) return str;
            System.out.println(errMsg);
        }
    }

    public static int updateInteger(String inputMsg, String errMsg, int oldValue) {
        while (true) {
            System.out.print(inputMsg);
            String str = SC.nextLine().trim();
            if (str.isEmpty()) return oldValue;
            try {
                return Integer.parseInt(str);
            } catch (NumberFormatException e) {
                System.out.println(errMsg);
            }
        }
    }

    public static int updateInteger(String inputMsg, String errMsg, int oldValue, int lowerBound, int upperBound) {
        while (true) {
            System.out.print(inputMsg);
            String str = SC.nextLine().trim();
            if (str.isEmpty()) return oldValue;
            try {
                int number = Integer.parseInt(str);
                if (number >= lowerBound && number <= upperBound) return number;
            } catch (NumberFormatException e) {}
            System.out.println(errMsg);
        }
    }

    public static double updateDouble(String inputMsg, String errMsg, double oldValue) {
        while (true) {
            System.out.print(inputMsg);
            String str = SC.nextLine().trim();
            if (str.isEmpty()) return oldValue;
            try {
                return Double.parseDouble(str);
            } catch (NumberFormatException e) {
                System.out.println(errMsg);
            }
        }
    }

    public static double updateDouble(String inputMsg, String errMsg, double oldValue, double lowerBound, double upperBound) {
        while (true) {
            System.out.print(inputMsg);
            String str = SC.nextLine().trim();
            if (str.isEmpty()) return oldValue;
            try {
                double number = Double.parseDouble(str);
                if (number >= lowerBound && number <= upperBound) return number;
            } catch (NumberFormatException e) {}
            System.out.println(errMsg);
        }
    }

    public static boolean getYesNo(String inputMsg) {
        while (true) {
            System.out.print(inputMsg);
            String str = SC.nextLine().trim();
            if (str.equalsIgnoreCase("Y")) return true;
            if (str.equalsIgnoreCase("N")) return false;
            System.out.println("Please enter Y or N!");
        }
    }
}