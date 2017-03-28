package university;

import university.modules.Course;
import university.modules.Lecturer;
import university.modules.Student;
import university.storage.CommonInfoDAO;
import university.storage.CourseDAO;
import university.storage.LecturerDAO;
import university.storage.StudentDAO;

import java.util.Map;

/**
 * Created by Norik on 28.03.2017.
 */
public class Procedures {
    private static final StudentDAO studentDAO = StudentDAO.getStudentDAO();
    private static final CourseDAO courseDAO = CourseDAO.getCourseDAO();
    private static final LecturerDAO lecturerDAO = LecturerDAO.getLecturerDAO();
    private static final CommonInfoDAO commonInfoDAO = CommonInfoDAO.getInstnce();

    public void addStudent(Student student){
        studentDAO.addStudent(student);
    }

    public Student getStudent(int studentID){
        return studentDAO.getStudent(studentID);
    }

    public void updateStudent(int id,Student student){
        studentDAO.updateStudent(id,student);
    }

    public void deleteStudent(int studentID){
        studentDAO.deleteStudent(studentID);
    }

    public void addCourse(Course course){
        courseDAO.addCourse(course);
    }

    public Course getCourse(int id){
        return courseDAO.getCourse(id);
    }

    public void updateCourse(int courseID, Course course){
        courseDAO.updateCourse(courseID,course);
    }

    public void deleteCourse(int id){
        courseDAO.deleteCourse(id);
    }

    public void addLecturer(Lecturer lecturer){
        lecturerDAO.addLecturer(lecturer);
    }

    public Lecturer getLecturer(int id){
        return lecturerDAO.getLecturer(id);
    }

    public void updateLecturer(int id, Lecturer lecturer){
        lecturerDAO.updateLecturer(id,lecturer);
    }

    public void deleteLecturer(int id){
        lecturerDAO.deleteLecturer(id);
    }

    public void assignGradeToStudent(int studentID, int courseID, int grade){
        commonInfoDAO.assignGradeToStudent(studentID,courseID,grade);
    }

    public void assignLecturerToCourse(int courseID, int lecturerID){
        commonInfoDAO.assignLecturerToCourse(courseID,lecturerID);
    }


    public Map<Integer,Integer> getStudentGrades(int studentID){
        return commonInfoDAO.getStudentGrades(studentID);
    }
}
