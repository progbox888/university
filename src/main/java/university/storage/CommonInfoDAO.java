package university.storage;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Norik on 28.03.2017.
 */
public class CommonInfoDAO {
    private Connection connection;
    private static final CommonInfoDAO instnce = new CommonInfoDAO();

    private CommonInfoDAO(){
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static CommonInfoDAO getInstnce(){
        return instnce;
    }

    public void assignGradeToStudent(int studentID, int courseID, int grade){
        String query = "INSERT INTO student_course(studentID,courseID,grade) value(?,?,?)";
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1,studentID);
            statement.setInt(2,courseID);
            statement.setInt(3,grade);
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void assignLecturerToCourse(int courseID, int lecturetID){
        String query = "INSERT INTO course_lecturer(courseID,lecturerID) VALUE(?,?)";
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1,courseID);
            statement.setInt(2,lecturetID);
            statement.execute();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public Map<Integer,Integer> getStudentGrades(int studentID){
        Map<Integer,Integer> map = new HashMap<>();
        String query = "SELECT courseID, grade FROM student_course WHERE studentID =" + studentID;
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                int courseID = resultSet.getInt("courseID");
                int grade = resultSet.getInt("grade");
                map.put(courseID,grade);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return map;
    }
}
