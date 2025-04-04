package PatientManagement;

public class Patient {
    String name;
    String symptom;
    int severity;

    public Patient(String name, String symptom, int severity) {
        this.name = name;
        this.symptom = symptom;
        this.severity = severity;
    }

    @Override
    public String toString() {
        return (name + " (" + symptom + "), Severity: " + severity);
    }
}
