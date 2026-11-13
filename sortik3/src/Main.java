import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

public class Main {
    public static void main(String[] args) {

        // 1. Тест на Integer
        Sorting<Integer> intSorter = new InsertionSortComparable<>();
        List<Integer> ints = new ArrayList<>(Arrays.asList(42, 15, 8, 99, 4, 23));
        intSorter.sort(ints);
        System.out.println("Integer:       " + ints);

        // 2. Тест на String (лексикографический порядок / по алфавиту)
        Sorting<String> stringSorter = new InsertionSortComparable<>();
        List<String> strings = new ArrayList<>(Arrays.asList("Банан", "Яблоко", "Апельсин", "Груша"));
        stringSorter.sort(strings);
        System.out.println("String:        " + strings);

        // 3. Тест на LocalDateTime (хронологический порядок)
        Sorting<Instant> dateSorter = new InsertionSortComparable<>();
        List<Instant> dates = new ArrayList<>(Arrays.asList(
                Instant.parse("2026-12-31T23:59:00Z"),
                Instant.parse("2025-01-01T10:00:00Z"),
                Instant.parse("2026-05-15T14:30:00Z")
        ));
        dateSorter.sort(dates);
        System.out.println("Instant: " + dates);

        // 4. Тест на Student
        Sorting<Student> studentSorter = new InsertionSortComparable<>();
        List<Student> students = new ArrayList<>(Arrays.asList(
                new Student("Иван", 4.5),
                new Student("Анна", 4.9),
                new Student("Пётр", 3.8),
                new Student("Алексей", 4.5)
        ));
        studentSorter.sort(students);
        System.out.println("Student:       " + students);

        // 5. Тест на UUID
        Sorting<UUID> uuidSorter = new InsertionSortComparable<>();
        List<UUID> uuids = new ArrayList<>(Arrays.asList(
                UUID.fromString("f81d4fae-7dec-11d0-a765-00a0c91e6bf6"),
                UUID.fromString("00000000-0000-0000-0000-000000000001"),
                UUID.fromString("a81d4fae-7dec-11d0-a765-00a0c91e6bf6")
        ));
        uuidSorter.sort(uuids);
        System.out.println("UUID:          " + uuids);
    }
}