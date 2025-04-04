package PatientManagement;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        PatientScheduler scheduler = new PatientScheduler();
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n Patient Scheduling System ");
            System.out.println("1. Add Patient");
            System.out.println("2. Serve Next Patient");
            System.out.println("3. Search Patient Name Prefix");
            System.out.println("4. Search Symptom Prefix");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter patient name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter symptom: ");
                    String symptom = sc.nextLine();
                    System.out.print("Enter severity (1-10): ");
                    int severity = sc.nextInt();
                    scheduler.addPatient(name, symptom, severity);
                    break;

                case 2:
                    scheduler.serveNextPatient();
                    break;

                case 3:
                    System.out.print("Enter name prefix to search: ");
                    String namePrefix = sc.nextLine();
                    scheduler.searchPatientNamePrefix(namePrefix);
                    break;

                case 4:
                    System.out.print("Enter symptom prefix to search: ");
                    String symptomPrefix = sc.nextLine();
                    scheduler.searchSymptomPrefix(symptomPrefix);
                    break;

                case 0:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 0);

        sc.close();
    }
}