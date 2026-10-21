public class course {
    //attributes defined
    private String courseName;
    private int courseId;
    private double grade;
    private int creditHours;
    private Instructor instructor;


    //constructors overloading
    public course(String courseName, int courseId, double grade, int creditHours) {
        this.courseName = courseName;
        this.courseId = courseId;
        this.grade = grade;
        this.creditHours = creditHours;
        
    }
    
}
//the getters and setters
public void setCourseName(String courseName) {
    this.courseName = courseName;
}
public void setInstruction