// test shouldn’t take more than 30 minutes
// There are 3 classes: Student, Subject and Mark
// - Fill the data according to the following conditions (use lists)
// 1. It is known that there are such students in the group: Valery Popov, Semyon Korzhev, Peter Ivanov, Maria Semenova and Kolya Nesterenko
// 2. Mathematics, Physics, Astronomy, History and Ethics are learned by this group and all subjects are mandatory excluding Ethics. It is optional.
// 3. Fill the data about marks if it is known that students have mark 3 for mandatory subjects and Maria has mark 5 for History and Ethics.
// 4. Please print results in a such way:
//   Popova Valeria Mathematics-1 Physics-2 Astronomy-0 History-1 Ethics-3 (do not display the subject info if there is no data about it)

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Test {

    public static void main(String[] args) {
        List<Student> group = new ArrayList<>(5);
        List<Subject> subjects = new ArrayList<>(5);
        List<Mark> marks = new ArrayList<>();
        //1
        group.add(0, new Student("Valery","Popov"));
        group.add(1, new Student("Semyon","Korzhev"));
        group.add(2, new Student("Peter","Ivanov"));
        group.add(3, new Student("Maria","Semenova"));
        group.add(4, new Student("Kolya","Nesterenko"));
        // 2
        subjects.add(0, new Subject("Mathematics", true));
        subjects.add(1, new Subject("Physics", true));
        subjects.add(2, new Subject("Astronomy", true));
        subjects.add(3, new Subject("History", true));
        subjects.add(4, new Subject("Ethics", false));
        // 3
        for (Subject subject : subjects) {
            for (Student student : group) {
                if (
                    student.getFirstName().equals("Maria") &&
                    (subject.getName().equals("History") ||
                    subject.getName().equals("Ethics"))
                ) {
                    marks.add(new Mark(student, subject, 5));
                } else if (subject.isMandatory()) {
                    marks.add(new Mark(student, subject, 3));
                }
            }
        }
        // 4
        for (Student student: group) {
            System.out.print(student.getFirstName() + " " + student.getLastName() + " ");
            for (Mark mark : marks) {
                if (mark.getStudent() == student) {
                    System.out.print(mark.getSubject().getName() + "-" + mark.getRank() + " ");
                }
            }
            System.out.println();
        }
    }
}
