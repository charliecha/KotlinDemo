import com.score.Score;
import com.student.Student;
import com.teacher.Teacher;

public class Main {

    public static void main(String[] args) {
        Teacher teacher = new Teacher();
        teacher.setName("jack");
        Student student = new Student();
        student.setId("1001");
        student.setName("lucyy");
        student.setTeacher(teacher);

        System.out.println(student);

        Score score = new Score();
        score.setScore(80);

        System.out.println(score.getScore());
    }
}
