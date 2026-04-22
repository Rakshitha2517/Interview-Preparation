import java.util.*;
class Patient {
    static ArrayList<Patient> patients = new ArrayList<>();
    int id;
    String name;
    int age;
    String phone;

    public Patient(int id, String name, int age, String phone) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.phone = phone;
    }

    public static void addPatient(Scanner sc) {
        System.out.print("Enter Patient ID: ");
        int id = sc.nextInt(); sc.nextLine();

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Age: ");
        int age = sc.nextInt(); sc.nextLine();

        System.out.print("Enter Phone: ");
        String phone = sc.nextLine();

        patients.add(new Patient(id, name, age, phone));
        System.out.println("Patient added!");
    }

    public static Patient findPatient(int id) {
        for (Patient p : patients) {
            if (p.id == id) return p;
        }
        return null;
    }
}
class Doctor {
    static ArrayList<Doctor> doctors = new ArrayList<>();
    int id;
    String name;
    String specialization;

    public Doctor(int id, String name, String specialization) {
        this.id = id;
        this.name = name;
        this.specialization = specialization;
    }

    public static void addDoctor(Scanner sc) {
        System.out.print("Enter Doctor ID: ");
        int id = sc.nextInt(); sc.nextLine();

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Specialization: ");
        String spec = sc.nextLine();

        doctors.add(new Doctor(id, name, spec));
        System.out.println("Doctor added!");
    }

    public static Doctor findDoctor(int id) {
        for (Doctor d : doctors) {
            if (d.id == id) return d;
        }
        return null;
    }
}

class Appointment {
    static ArrayList<Appointment> appointments = new ArrayList<>();
    int appId;
    Patient patient;
    Doctor doctor;
    String date;
    String status;

    public Appointment(int appId, Patient patient, Doctor doctor, String date) {
        this.appId = appId;
        this.patient = patient;
        this.doctor = doctor;
        this.date = date;
        this.status = "Booked";
    }

    public static void bookAppointment(Scanner sc) {
        System.out.print("Enter Appointment ID: ");
        int appId = sc.nextInt();

        System.out.print("Enter Patient ID: ");
        int pid = sc.nextInt();

        System.out.print("Enter Doctor ID: ");
        int did = sc.nextInt(); sc.nextLine();

        System.out.print("Enter Date: ");
        String date = sc.nextLine();

        Patient p = Patient.findPatient(pid);
        Doctor d = Doctor.findDoctor(did);

        if (p != null && d != null) {
            appointments.add(new Appointment(appId, p, d, date));
            System.out.println("Appointment booked!");
        } else {
            System.out.println("Invalid Patient or Doctor ID");
        }
    }

    public static void viewAppointments() {
        if (appointments.isEmpty()) {
            System.out.println("No appointments found.");
            return;
        }

        for (Appointment a : appointments) {
            System.out.println("AppID: " + a.appId +
                    ", Patient: " + a.patient.name +
                    ", Doctor: " + a.doctor.name +
                    ", Date: " + a.date +
                    ", Status: " + a.status);
        }
    }

    public static void cancelAppointment(Scanner sc) {
        System.out.print("Enter Appointment ID: ");
        int id = sc.nextInt();

        for (Appointment a : appointments) {
            if (a.appId == id) {
                a.status = "Cancelled";
                System.out.println("Appointment cancelled!");
                return;
            }
        }

        System.out.println("Appointment not found.");
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n===== Hospital Management System =====");
            System.out.println("1. Add Patient");
            System.out.println("2. Add Doctor");
            System.out.println("3. Book Appointment");
            System.out.println("4. View Appointments");
            System.out.println("5. Cancel Appointment");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");

            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    Patient.addPatient(sc);
                    break;

                case 2:
                    Doctor.addDoctor(sc);
                    break;

                case 3:
                    Appointment.bookAppointment(sc);
                    break;

                case 4:
                    Appointment.viewAppointments();
                    break;

                case 5:
                    Appointment.cancelAppointment(sc);
                    break;

                case 0:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } 
          while (choice != 0);

    }
}
