import java.util.ArrayList;
import java.util.Arrays; 
class Student {
    private int id;
    private String name;
    private String department;
    private int[] marks;          

    
    public Student(int id, String name, String department, int[] marks) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.marks = marks;
    }

    
    public int getId() { return id; }
    public String getName() { return name; }
    public String getDepartment() { return department; }
    public int[] getMarks() { return marks; }

    
    public void setName(String name) { this.name = name; }
    public void setDepartment(String department) { this.department = department; }
    public void setMarks(int[] marks) { this.marks = marks; }

    
    public double getAverage() {
        int sum = 0;
        for (int i = 0; i < marks.length; i++) {
            sum = sum + marks[i];
        }
        return (double) sum / marks.length;
    }

    
    public boolean hasValidMarks() {
        if (marks.length != 5) {
            return false;
        }
        for (int i = 0; i < marks.length; i++) {
            if (marks[i] < 0 || marks[i] > 100) {
                return false;
            }
        }
        return true;
    }

    
    public boolean passedAll() {
        for (int i = 0; i < marks.length; i++) {
            if (marks[i] < 50) {
                return false;      
            }
        }
        return true;
    }

    public void print() {
        System.out.printf("%d | %s | %s | %s | average: %.2f%n",
                id, name, department, Arrays.toString(marks), getAverage());
    }
}


class StudentManager {
    
    private ArrayList<Student> students = new ArrayList<>();

    

    
    public double average(int[] marks) {
        int sum = 0;
        for (int i = 0; i < marks.length; i++) {
            sum = sum + marks[i];
        }
        return (double) sum / marks.length;
    }

    
    public int highest(int[] marks) {
        int max = marks[0];
        for (int i = 1; i < marks.length; i++) {
            if (marks[i] > max) {
                max = marks[i];
            }
        }
        return max;
    }

    
    public int lowest(int[] marks) {
        int min = marks[0];
        for (int i = 1; i < marks.length; i++) {
            if (marks[i] < min) {
                min = marks[i];
            }
        }
        return min;
    }

    
    public void showAverages() {
        for (int i = 0; i < students.size(); i++) {
            Student s = students.get(i);
            System.out.printf("%s average: %.2f%n", s.getName(), average(s.getMarks()));
        }
    }

    
    public void showHighestLowest() {
        for (int i = 0; i < students.size(); i++) {
            Student s = students.get(i);
            System.out.println(s.getName() + " -> highest: " + highest(s.getMarks())
                    + ", lowest: " + lowest(s.getMarks()));
        }
    }

    
    public Student studentWithHighestAverage() {
        if (students.size() == 0) {
            return null;
        }
        Student best = students.get(0);
        for (int i = 1; i < students.size(); i++) {
            if (students.get(i).getAverage() > best.getAverage()) {
                best = students.get(i);
            }
        }
        return best;
    }

    
    public int countPassedAll() {
        int count = 0;
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).passedAll()) {
                count++;
            }
        }
        return count;
    }


    public int[] sortMarks(int[] marks) {
        int[] sorted = new int[marks.length];
        for (int i = 0; i < marks.length; i++) {
            sorted[i] = marks[i];                       
        }
        for (int round = 0; round < sorted.length - 1; round++) {
            for (int j = 0; j < sorted.length - 1 - round; j++) {
                if (sorted[j] > sorted[j + 1]) {
                    int temp = sorted[j];               
                    sorted[j] = sorted[j + 1];
                    sorted[j + 1] = temp;
                }
            }
        }
        return sorted;
    }

    
    public double classAverage() {
        int sum = 0;
        int count = 0;
        for (int i = 0; i < students.size(); i++) {
            int[] marks = students.get(i).getMarks();
            for (int j = 0; j < marks.length; j++) {
                sum = sum + marks[j];
                count++;
            }
        }
        if (count == 0) {
            return 0;
        }
        return (double) sum / count;
    }

    
    public int[] marksAboveClassAverage() {
        double avg = classAverage();

        int count = 0;
        for (int i = 0; i < students.size(); i++) {
            int[] marks = students.get(i).getMarks();
            for (int j = 0; j < marks.length; j++) {
                if (marks[j] > avg) {
                    count++;
                }
            }
        }

        int[] result = new int[count];
        int position = 0;
        for (int i = 0; i < students.size(); i++) {
            int[] marks = students.get(i).getMarks();
            for (int j = 0; j < marks.length; j++) {
                if (marks[j] > avg) {
                    result[position] = marks[j];
                    position++;
                }
            }
        }
        return result;
    }



    
    public boolean addStudent(Student s) {
        if (!s.hasValidMarks()) {
            System.out.println("Cannot add " + s.getName() + ": marks must be 5 values from 0 to 100.");
            return false;
        }
        if (findById(s.getId()) != null) {
            System.out.println("Cannot add " + s.getName() + ": ID " + s.getId() + " already exists.");
            return false;
        }
        students.add(s);
        return true;
    }

    
    public void showAll() {
        for (int i = 0; i < students.size(); i++) {
            students.get(i).print();
        }
    }

    
    public Student findById(int id) {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getId() == id) {
                return students.get(i);
            }
        }
        return null;
    }

    
    public void showByDepartment(String department) {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getDepartment().equalsIgnoreCase(department)) {
                students.get(i).print();
            }
        }
    }

    
    public boolean updateDepartment(int id, String newDepartment) {
        Student s = findById(id);
        if (s == null) {
            return false;
        }
        s.setDepartment(newDepartment);
        return true;
    }

    
    public boolean removeStudent(int id) {
        Student s = findById(id);
        if (s == null) {
            return false;
        }
        students.remove(s);
        return true;
    }

    
    public void showTopFive() {
        ArrayList<Student> copy = new ArrayList<>(students);
        for (int place = 1; place <= 5 && copy.size() > 0; place++) {
            Student best = copy.get(0);
            for (int i = 1; i < copy.size(); i++) {
                if (copy.get(i).getAverage() > best.getAverage()) {
                    best = copy.get(i);
                }
            }
            System.out.print(place + ". ");
            best.print();
            copy.remove(best);
        }
    }
    
    public void showBelow50() {
        boolean found = false;
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getAverage() < 50) {
                students.get(i).print();
                found = true;
            }
        }
        if (!found) {
            System.out.println("(nobody)");
        }
    }

    

    public void countByDepartment() {
        ArrayList<String> departments = new ArrayList<>();
        for (int i = 0; i < students.size(); i++) {
            String d = students.get(i).getDepartment();
            if (!departments.contains(d)) {
                departments.add(d);
            }
        }
        for (int i = 0; i < departments.size(); i++) {
            int count = 0;
            for (int j = 0; j < students.size(); j++) {
                if (students.get(j).getDepartment().equals(departments.get(i))) {
                    count++;
                }
            }
            System.out.println(departments.get(i) + ": " + count);
        }
    }

    
    public void showThirdHighest() {
    
        ArrayList<Student> sorted = new ArrayList<>(students);
        for (int round = 0; round < sorted.size() - 1; round++) {
            for (int j = 0; j < sorted.size() - 1 - round; j++) {
                if (sorted.get(j).getAverage() < sorted.get(j + 1).getAverage()) {
                    Student temp = sorted.get(j);
                    sorted.set(j, sorted.get(j + 1));
                    sorted.set(j + 1, temp);
                }
            }
        }
        
        int rank = 0;
        double lastAverage = -1;
        boolean found = false;
        for (int i = 0; i < sorted.size(); i++) {
            if (sorted.get(i).getAverage() != lastAverage) {
                rank++;
                lastAverage = sorted.get(i).getAverage();
            }
            if (rank == 3) {
                sorted.get(i).print();
                found = true;
            }
        }
        if (!found) {
            System.out.println("There is no third-highest average (fewer than 3 different averages).");
        }
    }

    
    public ArrayList<Student> getPassedAllList() {
        ArrayList<Student> result = new ArrayList<>();
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).passedAll()) {
                result.add(students.get(i));
            }
        }
        return result;
    }
}


public class Exercise1 {
    public static void main(String[] args) {
        StudentManager manager = new StudentManager();

        manager.addStudent(new Student(1, "Alice", "Computer Science", new int[]{85, 90, 78, 92, 88}));
        manager.addStudent(new Student(2, "Brian", "Computer Science", new int[]{60, 55, 70, 65, 58}));
        manager.addStudent(new Student(3, "Chloe", "Engineering", new int[]{45, 38, 50, 42, 40}));
        manager.addStudent(new Student(4, "David", "Engineering", new int[]{75, 80, 68, 72, 79}));
        manager.addStudent(new Student(5, "Esther", "Mathematics", new int[]{95, 98, 92, 97, 99}));
        manager.addStudent(new Student(6, "Felix", "Mathematics", new int[]{50, 52, 49, 55, 60}));
        manager.addStudent(new Student(7, "Grace", "Physics", new int[]{70, 65, 72, 68, 74}));
        manager.addStudent(new Student(8, "Henry", "Physics", new int[]{30, 42, 35, 48, 40}));
        manager.addStudent(new Student(9, "Irene", "Business", new int[]{88, 76, 84, 90, 81}));
        manager.addStudent(new Student(10, "Jack", "Business", new int[]{55, 60, 58, 62, 57}));
        manager.addStudent(new Student(11, "Kelly", "Computer Science", new int[]{92, 85, 90, 88, 94}));
        manager.addStudent(new Student(12, "Liam", "Engineering", new int[]{62, 48, 70, 55, 66}));
        manager.addStudent(new Student(13, "Mia", "Mathematics", new int[]{80, 82, 79, 85, 83}));
        manager.addStudent(new Student(14, "Noah", "Physics", new int[]{20, 35, 40, 28, 45}));
        manager.addStudent(new Student(15, "Olivia", "Business", new int[]{72, 68, 75, 70, 77}));

        System.out.println("===== PART B: ARRAYS =====");
        System.out.println("\n-- Averages --");
        manager.showAverages();
        System.out.println("\n-- Highest / lowest --");
        manager.showHighestLowest();
        System.out.print("\nHighest average: ");
        manager.studentWithHighestAverage().print();
        System.out.println("Students who passed all 5 subjects: " + manager.countPassedAll());
        int[] unsorted = {85, 40, 92, 15, 70};
        System.out.println("Sorting " + Arrays.toString(unsorted) + " -> "
                + Arrays.toString(manager.sortMarks(unsorted)));
        System.out.printf("Class average: %.2f%n", manager.classAverage());
        System.out.println("Marks above class average: " + Arrays.toString(manager.marksAboveClassAverage()));

        System.out.println("\n===== PART C: LISTS =====");
        System.out.println("\n-- All students --");
        manager.showAll();

        System.out.println("\n-- Search ID 5 --");
        Student found = manager.findById(5);
        if (found != null) {
            found.print();
        } else {
            System.out.println("Not found");
        }

        System.out.println("\n-- Physics students --");
        manager.showByDepartment("Physics");

        System.out.println("\n-- Update ID 7 to Engineering --");
        System.out.println("Updated? " + manager.updateDepartment(7, "Engineering"));

        System.out.println("\n-- Remove ID 15 --");
        System.out.println("Removed? " + manager.removeStudent(15));

        System.out.println("\n-- Try to add duplicate ID 1 --");
        manager.addStudent(new Student(1, "Fake", "Business", new int[]{50, 50, 50, 50, 50}));

        System.out.println("\n-- Try to add a student with an invalid mark (150) --");
        manager.addStudent(new Student(99, "Bad", "Business", new int[]{50, 50, 150, 50, 50}));

        System.out.println("\n-- Top five --");
        manager.showTopFive();

        System.out.println("\n-- Average below 50 --");
        manager.showBelow50();

        System.out.println("\n-- Students per department --");
        manager.countByDepartment();

        System.out.println("\n-- Third highest average --");
        manager.showThirdHighest();

        System.out.println("\n-- Students who passed all subjects --");
        ArrayList<Student> passed = manager.getPassedAllList();
        for (int i = 0; i < passed.size(); i++) {
            passed.get(i).print();
        }
    }
}
