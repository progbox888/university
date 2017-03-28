package university.storage;

import university.modules.Course;

import java.io.UnsupportedEncodingException;
import java.sql.*;

/**
 * Created by Norik on 28.03.2017.
 */
public class CourseDAO {
    private  Connection connection;

    private static final CourseDAO instance  = new CourseDAO();

    private CourseDAO(){
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","");
        }
        catch (SQLException e) {
            System.out.println("Unable to connect to the database");
            e.printStackTrace();
        }
    }

    public static CourseDAO getCourseDAO(){
        return instance;
    }

    public void addCourse(Course course){
        String query = "INSERT  INTO  course(courseName, syllabus) VALUE (?,?)";
        setCourse(query,course);
    }

    public void updateCourse(int id, Course course){
        String query = "UPDATE  course SET courseName = ?, syllabus = ? WHERE courseID = " + id;
        setCourse(query,course);
    }

    public void deleteCourse(int courseID){
        if (courseID < 0)
            throw new IllegalArgumentException();
        String query = "DELETE FROM course WHERE courseID = " + courseID;
        try {
            PreparedStatement statement  = connection.prepareStatement(query);
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public  Course getCourse(int courseID){
        String query = "SELECT courseName, syllabus FROM course WHERE  courseID = " + courseID;
        Course course = null;
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                String courseName = resultSet.getNString("courseName");
                byte[] array = resultSet.getBytes("syllabus");
                String description = new String(array,"UTF-8");
                course = new Course(courseName, description);
            }
    } catch (SQLException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return course;
    }

    private  void setCourse(String query, Course course){
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setNString(1,course.getCourseName());
            statement.setNString(2,course.getDescription());
            statement.execute();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
