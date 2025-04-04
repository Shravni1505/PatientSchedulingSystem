package PatientManagement;
import java.util.*;

public class PatientPriorityComparator implements Comparator<Patient> {
    @Override
    public int compare(Patient p1, Patient p2) {
        return Integer.compare(p2.severity, p1.severity);
    }
}
