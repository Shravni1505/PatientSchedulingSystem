package PatientManagement;
import java.util.*;

public class PatientScheduler {
    private Trie nameTrie = new Trie();
    private Trie symptomTrie = new Trie();

    private Queue<Patient> regularQueue = new LinkedList<>();
    private PriorityQueue<Patient> emergencyHeap = new PriorityQueue<>(new PatientPriorityComparator());

    public void addPatient(String name, String symptom, int severity) {
        Patient patient = new Patient(name, symptom, severity);
        nameTrie.insert(name);
        symptomTrie.insert(symptom);

        if (severity >= 7) {
            emergencyHeap.add(patient);
        } else {
            regularQueue.add(patient);
        }
        System.out.println("Patient added successfully.");
    }

    public void serveNextPatient() {
        if (!emergencyHeap.isEmpty()) {
            System.out.println("Serving emergency: " + emergencyHeap.poll());
        } else if (!regularQueue.isEmpty()) {
            System.out.println("Serving regular: " + regularQueue.poll());
        } else {
            System.out.println("No patients in the queue.");
        }
    }

    public void searchPatientNamePrefix(String prefix) {
        if (nameTrie.searchPrefix(prefix)) {
            System.out.println("Patient with name prefix '" + prefix + "' found.");
        } else {
            System.out.println("No patient with that name prefix.");
        }
    }

    public void searchSymptomPrefix(String prefix) {
        if (symptomTrie.searchPrefix(prefix)) {
            System.out.println("Symptom prefix '" + prefix + "' found.");
        } else {
            System.out.println("No matching symptom.");
        }
    }
}