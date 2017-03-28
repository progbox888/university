package university.modules;

/**
 * Created by Norik on 28.03.2017.
 */
public class Course {
    private String courseName;
    private String description;

    public Course(String courseName){
        this.courseName = courseName;
    }

    public Course(String courseName, String description){
        this.courseName = courseName;
        this.description = description;
    }

    public String getCourseName() {
        return courseName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
