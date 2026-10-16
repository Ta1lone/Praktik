package Task1_InsertionSort;

import java.util.List;


public class InsertionSort implements Sorting<Integer> {

    @Override
    public void sort(List<Integer> nums) {

        // Начинаем со 2-го, потому что один элемент всегда отсортирован
        for (int i = 1; i < nums.size(); i++) {

            // Берем элемент и запоминаем его значение
            Integer el = nums.get(i);

            // Смотрим на соседа слева
            int j = i - 1;

            // Идём, пока не упремся в начало списка и пока сосед слева больше
            while (j >= 0 && nums.get(j).compareTo(el) > 0) {

                // Сосед больше сдвигаем его на одну позицию вправо
                nums.set(j + 1, nums.get(j));

                // смотрим еще на одного соседа левее.
                j--;
            }

            // Цикл закончился, значит, мы нашли соседа, который меньше, записываем его
            nums.set(j + 1, el);
        }
    }
}