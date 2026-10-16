package Task2_MergeSort;
import java.util.List;

public class MergeSort implements Sorting<Integer> {

    private Integer[] temp;

    @Override
    public void sort(List<Integer> nums) {
        // Если список пустой или там всего 1 элемент, он уже тип отсортирован
        if (nums == null || nums.size() <= 1) {
            return;
        }

        temp = new Integer[nums.size()];

        // Начинаем слайсить
        slice(nums, 0, nums.size() - 1);
    }

    private void slice(List<Integer> nums, int start, int end) {
        // Левая граница встречается с правой, значит 1 элемент получился
        if (start >= end) {
            return;
        }

        // Ищем серединку.
        int middle = start + (end - start) / 2;

        // продолжаем слайсить левую
        slice(nums, start, middle);

        // и правую
        slice(nums, middle + 1, end);

        // закончили, начинаем соединять
        merge(nums, start, middle, end);
    }

    private void merge(List<Integer> nums, int start, int middle, int end) {

        for (int i = start; i <= end; i++) {
            temp[i] = nums.get(i);
        }

        int left = start;         // указываю на начало левой в temp
        int right = middle + 1;   // указываю начало правой половинки в temp
        int writeIndex = start;   // указываю на начало оригинального массива

        while (left <= middle && right <= end) {

            if (temp[left] <= temp[right]) {
                // записываем его в оригинальный массив и сдвигаем начало
                nums.set(writeIndex++, temp[left++]);
            } else {
                // ну тут с правым так же
                nums.set(writeIndex++, temp[right++]);
            }
        }

        // правая половинка закончилась первой, в левая осталась еще, значит просто дописываем их все в конец
        while (left <= middle) {
            nums.set(writeIndex++, temp[left++]);
        }

    }
}