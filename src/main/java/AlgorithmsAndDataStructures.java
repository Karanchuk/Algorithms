import java.util.*;

public class AlgorithmsAndDataStructures {

    public static void main(String[] args) {
        Timer timer = new Timer();
        
        /**
         * Задание 1.1
         * Приведите пример алгоритмов и структур данных из жизни.
         * Ответ:
         * Алгоритмами можно считать рецепт приготовления яблочного пирога, инструкцию по замене ремня ГРМ
         * в автомобиле или построенный в смартфоне маршрут проезда в метро от Театральной до Вороьбевых гор.
         * Для этих примеров структурами данных будут выступать ссылка на рецепт в интернете, книга по ремонту
         * автомобиля и ответ сервера в формате JSON о кратчайшем маршруте между двумя станциями метро.
         *
         * Задание 1.2
         * Приведите пример алгоритмов и структур данных в программировании.
         * Ответ:
         * Примером алгоритма в программировании может быть метод сравнения 2-х коллекций на идентичность, который
         * возвращает уникальные для каждой коллекции значения. В качестве структуры данных для хранения коллекций
         * может выступать массив.
         *
         * Задание 1.3
         * Напишите программный код, в котором все данные хранятся только в переменных трех типов данных:
         * Ссылочные, примитивные и своего класса содержащего: конструктор и метод отображения данных.
         * Выведите написанные данные.
         */
        System.out.println("Задание 1.3");
        char letter = 'a';
        int[] array = new int[] {1,2,3,4};
        NewType myType = new NewType(1, "hello");

        System.out.println(letter);
        System.out.println(Arrays.toString(array));
        System.out.println(myType.getA() + " " + myType.getB());

        /**
         * Задание 1.4
         * Дополните предыдущий код сравнением ваших данных с другой переменной, данный код должен
         * имитировать простейший поиск перебором.
         * Оцените время выполнения алгоритма с помощью базового метода System.nanoTime().
         */
        System.out.println("\nЗадание 1.4");

        Object variable     = 'a';
        Object[] variables  = new Object[] {letter, array, myType};
        timer.start();

        for (Object o : variables) {
            System.out.println(o + (o == variable ? " = " : " <> ") + variable);
        }

        System.out.println("It took " + timer.fix() + " nanoseconds");

        /**
         * Задание 2.1
         * На основе программного кода из домашнего задания №1 реализуйте
         * массив на основе существующих примитивных или ссылочных типов
         * данных.
         * Выполните обращение к массиву и базовые операции класса Arrays.
         * Оценить выполненные методы с помощью базового класса
         * System.nanoTime().
         */
        System.out.println("\nЗадание 2.1");

        Random randomizer = new Random();
        Integer[] ints = new Integer[30];
        for (int i = 0; i < ints.length; i++) {
            ints[i] = randomizer.nextInt(100);
        }
        System.out.println(Arrays.toString(ints));
        timer.start();
        Integer[] intsCopy = Arrays.copyOf(ints, ints.length);
        System.out.println("It took " + timer.fix() + " nanoseconds");
        timer.start();
        System.out.println("Arrays is " + (Arrays.equals(ints, intsCopy) ? "" : "not") + " equals");
        System.out.println("It took " + timer.fix() + " nanoseconds");

        /**
         * Задание 2.2
         * На основе написанного кода в задании 2.1 реализуйте линейный и
         * двоичный поиск.
         * Оценить алгоритмы линейного и двоичного поиска с помощью
         * базового класса System.nanoTime(), при необходимости расширьте уже
         * существующий массив данных.
         */
        System.out.println("\nЗадание 2.2");
        int desiredValue = intsCopy[randomizer.nextInt(30)];

        timer.start();
        for (int i = 0; i < intsCopy.length; i++) {
            timer.increaseCounter();
            if (intsCopy[i] == desiredValue) {
                System.out.println(desiredValue + " contains in " + i + " index and found for "
                        + timer.getCounter() + " iterations");
                break;
            }
        }
        System.out.println("Linear search took " + timer.fix() + " nanoseconds");

        Arrays.sort(intsCopy);
        System.out.println(Arrays.toString(intsCopy));

        timer.start();
        int firstIndex = 0;
        int lastIndex = intsCopy.length - 1;
        while (true) {
            timer.increaseCounter();
            int middleIndex = (lastIndex + firstIndex) / 2;
            if (intsCopy[middleIndex] == desiredValue) {
                System.out.println(desiredValue + " contains in " + middleIndex + " index and found for "
                        + timer.getCounter() + " iterations");
                break;
            } else if (intsCopy[middleIndex] < desiredValue) {
                firstIndex = middleIndex + 1;
            } else {
                lastIndex = middleIndex - 1;
            }
        }
        System.out.println("Binary search took " + timer.fix() + " nanoseconds");

        /**
         * Задание 2.3
         * Создайте массив размером 400 элементов.
         * Выполните сортировку с помощью метода sort().
         * Оцените сортировку с помощью базового класса System.nanoTime().
         */
        System.out.println("\nЗадание 2.3");
        int[] bigInts = new int[400];
        for (int i = 0; i < bigInts.length; i++) {
            bigInts[i] = randomizer.nextInt(1000);
        }
        System.out.println(Arrays.toString(bigInts));

        int[] bigIntsCopy = Arrays.copyOf(bigInts, bigInts.length);
        timer.start();
        Arrays.sort(bigIntsCopy);
        System.out.println("Work of the sort method took " + timer.fix() + " nanoseconds.");

        /**
         * Задание 2.4
         * На основе существующего массива данных из задания 2.3 реализуйте
         * алгоритм сортировки пузырьком.
         * Оцените сортировку с помощью базового класса System.nanoTime().
         * Сравните время выполнения алгоритмы сортировки методом sort() из
         * задания 2.1 и сортировку пузырьком.
         */
        System.out.println("\nЗадание 2.4");
        bigIntsCopy = Arrays.copyOf(bigInts, bigInts.length);
        timer.start();
        bubbleSort(bigIntsCopy);
        System.out.println("Bubble sort method took " + timer.fix() + " nanoseconds");

        /**
         * Задание 2.5
         * На основе массива данных из задания 2.3 реализуйте алгоритм
         * сортировки методом выбора.
         * Оцените сортировку с помощью базового класса System.nanoTime().
         * Сравните с временем выполнения алгоритмов сортировки из прошлых
         * заданий 2.3 и 2.4.
         */
        System.out.println("\nЗадание 2.5");
        bigIntsCopy = Arrays.copyOf(bigInts, bigInts.length);
        timer.start();
        selectionSort(bigIntsCopy);
        System.out.println("Selection sort method took " + timer.fix() + " nanoseconds");

        /**
         * Задание 2.6
         * На основе массива данных из задания 2.3 реализуйте алгоритм
         * сортировки методом вставки.
         * Оцените сортировку с помощью базового класса System.nanoTime().
         * Сравните с временем выполнения алгоритмов сортировки из прошлых
         * заданий 2.3, 2.4 и 2.5.
         */
        System.out.println("\nЗадание 2.6");
        bigIntsCopy = Arrays.copyOf(bigInts, bigInts.length);
        timer.start();
        insertionSort(bigIntsCopy);
        System.out.println("Insertion sort method took " + timer.fix() + " nanoseconds");

        /**
         * Задание 3.1
         * На основе массива из домашнего задания 2.1 реализуйте простой список и коллекцию.
         * Оцените время выполнения преобразования.
         */
        System.out.println("\nЗадание 3.1");
        timer.start();
        ArrayList<Integer> arrayList = new ArrayList<>(Arrays.asList(ints));
        System.out.println("Converting to a list takes " + timer.fix() + " nanoseconds");

        /**
         * Задание 3.2
         * На основе списка из задания 3.1 реализуйте основные методы добавления,
         * удаления и получения объекта или элемента из списка.
         * Оценить выполненные методы с помощью базового класса System.nanoTime().
         */
        System.out.println("\nЗадание 3.2");
        timer.start();
        arrayList.add(5);
        System.out.println("Adding an item to the list takes " + timer.fix() + " nanoseconds");

        timer.start();
        arrayList.remove(arrayList.size() - 1);
        System.out.println("Removing an item to the list takes " + timer.fix() + " nanoseconds");

        timer.start();
        arrayList.get(arrayList.size() - 1);
        System.out.println("Getting list item takes " + timer.fix() + " nanoseconds");

        /**
         * Задание 3.3
         * Реализуйте простой односвязный список и его базовые методы.
         */
        System.out.println("\nЗадание 3.3");
        SingleLinkedList singleLinkedList = new SingleLinkedList<Integer>();
        singleLinkedList.insert(5);
        singleLinkedList.insert(10);
        singleLinkedList.display();

        /**
         * Задание 3.4
         * На основе списка из задания 3.1 реализуйте простой двусторонний список и его базовые методы.
         * Реализуйте список заполненный объектами из вашего класса из задания 1.3
         */
        List linkedList = new LinkedList(arrayList);

        List<Object> linkedListWithObjects = new LinkedList<>();
        linkedListWithObjects.add(letter);
        linkedListWithObjects.add(array);
        linkedListWithObjects.add(myType);

        /**
         * Задание 3.5
         * Реализуйте итератор на основе связанных списков из задания 3.4 и выполните базовые операции итератора.
         * Оцените время выполнения операций с помощью базового метода System.nanoTime()
         */
        System.out.println("\nЗадание 3.5");
        Iterator iterator = linkedListWithObjects.iterator();

        timer.start();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        System.out.println("Loop traversal for " + linkedListWithObjects.size() + " elements using an iterator " +
                "takes " + timer.fix() + " nanoseconds");
        iterator.remove();
    }

    public static class NewType {
        private final int a;
        private final String b;

        public NewType(int a, String b) {
            this.a = a;
            this.b = b;
        }

        public int getA() {
            return a;
        }

        public String getB() {
            return b;
        }
    }

    public static class Timer {
        private long startTime;
        private long elapsedNanos;
        private int counter;

        public void start() {
            startTime = System.nanoTime();
            elapsedNanos = 0;
            counter = 0;
        }
        public String fix() {
            elapsedNanos = System.nanoTime() - startTime;
            return String.format(Locale.FRANCE, "%,d", elapsedNanos);
        }
        public void increaseCounter() {
            counter++;
        }

        public int getCounter() {
            return counter;
        }
    }

    public static void bubbleSort(int[] data) {

        int swap;
        boolean sorted;

        for (int i = 0; i < data.length; i++) {

            sorted = true;

            for (int j = 1; j < (data.length - i); j++) {

                if (data[j - 1] > data[j]) {
                    swap = data[j - 1];
                    data[j - 1] = data[j];
                    data[j] = swap;
                    sorted = false;
                }

            }
            if (sorted) break;
        }
    }

    public static void selectionSort(int[] data) {
        int swap;

        for (int i = 0; i < data.length; i++) {
            int minValueIndex = i;
            for (int j = i + 1; j < data.length; j++)
                minValueIndex = (data[minValueIndex] <= data[j] ? minValueIndex : j);
            if (minValueIndex != i) {
                swap = data[minValueIndex];
                data[minValueIndex] = data[i];
                data[i] = swap;
            }
        }
    }

    public static void insertionSort(int[] data) {

        for (int i = 0; i < data.length; i++) {
            int value = data[i];
            int j = i - 1;
            for (; j >= 0; j--) {
                if (value < data[j]) {
                    data[j + 1] = data[j];
                } else {
                    break;
                }
            }
            data[j + 1] = value;
        }

    }

    static class Link<T> {
        private T link;
        private Link<T> next;

        public Link(T link) {
            this.link = link;
        }

        public Link<T> getNext() {
            return next;
        }

        public void setNext(Link<T> next) {
            this.next = next;
        }

        public T getValue() {
            return link;
        }
    }

    static class SingleLinkedList<T> {
        private Link<T> first;

        public SingleLinkedList() {
            first = null;
        }

        public boolean isEmpty() {
            return (first == null);
        }

        public void insert(T link) {
            Link<T> l = new Link<>(link);
            l.setNext(first);
            this.first = l;
        }

        public Link<T> delete() {
            Link<T> temp = first;
            first = first.getNext();
            return temp;
        }

        public void display() {
            Link<T> current = first;
            while (current != null) {
                System.out.println(current.getValue());
                current = current.getNext();
            }
        }

        public T find(T searchNode) {
            Link<T> findNode = new Link<>(searchNode);
            Link<T> current = first;
            while (current != null) {
                if (current.getValue().equals(findNode.getValue())) {
                    return findNode.getValue();
                }
                current = current.getNext();
            }
            return null;
        }
    }

}
