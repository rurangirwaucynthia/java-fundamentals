
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

 public class registryManager {


    private List<Student> students = new ArrayList<>();



    
    public void loadStudentsFromFile(String fileName) {

        
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {

            String line;

    
            while ((line = reader.readLine()) != null) {

                
                if (line.trim().isEmpty()) {
                    continue;
                }

            
                String[] parts = line.split(",");

                
                if (parts.length != 4) {
                    System.out.println("Skipping bad line: " + line);
                    continue;
                }

                try {
                    
                    int id = Integer.parseInt(parts[0].trim());
                    String name = parts[1].trim();
                    double gpa = Double.parseDouble(parts[2].trim());
                    String major = parts[3].trim();

                
                    Student student = new Student(id, name, gpa, major);
                    students.add(student);

                } catch (NumberFormatException e) {
                    
                    
                    System.out.println("Skipping line (not student data): " + line);
                }
            }

            System.out.println("Loaded " + students.size() + " students.\n");

        } catch (IOException e) {
            
            System.out.println("Error reading file: " + e.getMessage());
        }
    }


    public void displayAllStudents() {
        for (Student s : students) {
            System.out.println(s); 
        }
    }

    
    public void groupStudentsByMajor() {

        
        Map<String, List<String>> groups = new LinkedHashMap<>();

        for (Student s : students) {
            String major = s.getMajor();

            
            if (!groups.containsKey(major)) {
                groups.put(major, new ArrayList<>());
            }

            
            groups.get(major).add(s.getName());
        }

        
        for (Map.Entry<String, List<String>> entry : groups.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
    

