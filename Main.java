import java.io.File;

public class Main {

    public static void main(String[] args) {

        
        registryManager manager = new registryManager();

        File file = new File("students.txt");

        
        manager.loadStudentsFromFile(file.getPath());

        
        System.out.println("=== All Students ===");
        manager.displayAllStudents();

        
        System.out.println("\n=== Students Grouped by Major ===");
        manager.groupStudentsByMajor();
    }
}
