import java.util.Scanner;

public class SMcal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of subjects: ");
        int numSub = scanner.nextInt();

        int totalM = 0;
        
       
        for (int i = 1; i <= numSub; i++) {
            System.out.print("Enter marks obtained in Subject " + i + " (out of 100): ");
            int marks = scanner.nextInt();

           
            if (marks < 0 || marks > 100) {
                System.out.println("Invalid marks! Please enter a value between 0 and 100.");
                i--;  
                continue;
            }

            totalM += marks;
        }

        
        double avgpercentage = (double) totalM / numSub;

        
        String grade;
        if (avgpercentage >= 90) {
            grade = "A+";
        } else if (avgpercentage >= 80) {
            grade = "A";
        } else if (avgpercentage >= 70) {
            grade = "B";
        } else if (avgpercentage >= 60) {
            grade = "C";
        } else if (avgpercentage >= 50) {
            grade = "D";
        } else {
            grade = "F (Fail)";
        }


        System.out.println("\n----- Results -----");
        System.out.println("Total Marks: " + totalM);
        System.out.println("Average Percentage: " + avgpercentage + "%");
        System.out.println("Grade: " + grade);

        scanner.close();
    }
}
