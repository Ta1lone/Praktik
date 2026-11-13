import java.util.List;

public class coutsort implements Sorting<Integer> {
    @Override
    public void sort(List<Integer> nums) {
        // 1. Создаем массив для подсчета частоты встреченных чисел (диапазон 0-127)
        int[] counts = new int[128];

        // 2. Подсчитываем количество каждого числа в списке
        for (int num : nums) {
            counts[num]++;
        }

        // 3. Перезаписываем исходный список в порядке возрастания
        int index = 0;
        for (int val = 0; val < counts.length; val++) {
            while (counts[val] > 0) {
                nums.set(index, val);
                index++;
                counts[val]--;
            }
        }
    }
}

