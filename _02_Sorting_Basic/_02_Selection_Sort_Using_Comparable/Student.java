package _02_Sorting_Basic._02_Selection_Sort_Using_Comparable;

/**
 * Created by mohon on 2017/10/12.
 */
public class Student implements Comparable<Student> {

    private String name;
    private int score;

    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }

    @Override
    public int compareTo(Student student) {
        if(this.score < student.score) {
            return -1;
        } else if(this.score > student.score) {
            return 1;
        } else {
            return this.name.compareTo(student.name);
        }
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", score=" + score +
                '}';
    }
}
