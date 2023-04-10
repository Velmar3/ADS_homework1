public class Sort {

    public static void main(String[] args) {
        int[] array = new int[] {
                4, 2, 5, 8, 4, 7, 6, 0, 3, 7, 1, 9
        };
        headheapSort(array);
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }

    // Пирамидальная сортировка(кучей) O(n*log n)
    public static void headheapSort(int[] array) {
        // Построение кучи (перегруппируем массив)
        for (int i = array.length / 2 - 1; i >= 0; i--) {
            heapSort(array, array.length, i);
        }
        // Один за другим извлекаем элемениты из кучи
        for (int i = array.length - 1; i >= 0; i--) {
            // Перемещаем текущий корень в корень
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;

            // Вызываем процедуру heapSort на уменьшенной куче
            heapSort(array, i, 0);

        }
    }

    public static void heapSort(int[] array, int heapSize, int rootIndex) {
        int largest = rootIndex; // инициализируем найбольший элемент как корень
        int leftChild = 2 * rootIndex + 1; // левый
        int rightChild = 2 * rootIndex + 2; // правый

        // Ели левый дочерний больше корня
        if (leftChild < heapSize && array[leftChild] > array[largest])
            largest = leftChild;
        // Ели правый дочерний больше, чем самый большой элемент на данный момент
        if (rightChild < heapSize && array[rightChild] > array[largest])
            largest = rightChild;
        // Если самый большой элемент не корень
        if (largest != rootIndex) {
            int temp = array[rootIndex];
            array[rootIndex] = array[largest];
            array[largest] = temp;

            // Рекурсивно преобразуем в двоичную кучу затронутое поддерево
            heapSort(array, heapSize, largest);
        }

    }
}