package Task2_MergeSort;
import java.util.List;

/**
 * Общий интерфейс для всех сортировок.
 * Гарантирует, что у любого класса сортировки будет метод sort.
 */
public interface Sorting<T extends Comparable<T>> {
    void sort(List<T> nums);
}