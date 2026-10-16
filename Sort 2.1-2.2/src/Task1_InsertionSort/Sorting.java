package Task1_InsertionSort;
import java.util.List;

public interface Sorting<T extends Comparable<T>> {
    void sort(List<T> nums);
}

