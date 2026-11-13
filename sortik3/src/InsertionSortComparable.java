import java.util.List;

// <T extends Comparable<T>> означает, что класс работает с любым типом T,
// объекты которого умеют сравнивать себя друг с другом через метод compareTo()
public class InsertionSortComparable<T extends Comparable<T>> implements Sorting<T> {

    @Override
    public void sort(List<T> list) {
        for (int i = 1; i < list.size(); i++) {
            T key = list.get(i); // Запоминаем текущий вставляемый элемент
            int j = i - 1;

            // Сдвигаем вправо все элементы, которые БОЛЬШЕ key.
            // Условие list.get(j).compareTo(key) > 0 заменяет обычное list.get(j) > key
            while (j >= 0 && list.get(j).compareTo(key) > 0) {
                list.set(j + 1, list.get(j));
                j--;
            }

            // Ставим key на освободившееся место
            list.set(j + 1, key);
        }
    }
}
