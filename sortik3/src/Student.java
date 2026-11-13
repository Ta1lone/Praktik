public class Student implements Comparable<Student> {
    private String name;
    private double gpa;

    public Student(String name, double gpa) {
        this.name = name;
        this.gpa = gpa;
    }

    @Override
    public int compareTo(Student other) {
        // Сначала сравниваем по баллу (или другому полю из вашей задачи 2.3)
        int gpaCompare = Double.compare(this.gpa, other.gpa);
        if (gpaCompare != 0) {
            return gpaCompare;
        }
        // Если баллы равны — сравниваем по имени
        return this.name.compareTo(other.name);
    }

    @Override
    public String toString() {
        return name + " (" + gpa + ")";
    }
}