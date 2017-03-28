import university.Procedures;
import university.modules.Course;
import university.modules.Student;

import java.util.Map;
import java.util.Scanner;

/**
 * Created by Norik on 28.03.2017.
 */
public class Main {
    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        Student student = new Student("hkkjhkj","fdhkj","kjdsk@mail","546865");
        Course course = new Course("math","jdhkjdhdhdjkhdkhjgdjskhgsdkjhg");
        Procedures procedures = new Procedures();
        procedures.addCourse(course);
        Course course1 = procedures.getCourse(4);
        System.out.println(course1.getCourseName());
        System.out.println(course1.getDescription());
    }

}
