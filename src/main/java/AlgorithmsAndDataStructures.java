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

        /**
         * Задание 4.1
         * На основе данных объектного списка из задания 3.4 реализуйте
         * простой стек и его базовые методы.
         * Оцените время выполнения операций с помощью базового метода
         * System.nanoTime().
         */

        linkedListWithObjects.add(new Object());

        System.out.println("\nЗадание 4.1");
        timer.start();
        StackM<Object> myStack = new StackM<>(linkedListWithObjects.size());
        System.out.println("My stack for " + linkedListWithObjects.size() + " elements was created in "
                + timer.fix() + " nanoseconds");

        timer.start();
        for (int i = 0; i < linkedListWithObjects.size(); i++) {
            if (myStack.isFull()) break;
            myStack.push(linkedListWithObjects.get(i));
        }
        System.out.println("Inserting " + myStack.size() + " items into my stack takes "
                + timer.fix() + " nanoseconds");

        timer.start();
        myStack.peek();
        System.out.println("Viewing one item in my stack takes "
                + timer.fix() + " nanoseconds");

        int size = myStack.size();
        timer.start();
        while (!myStack.isEmpty()) {
            myStack.pop();
        }
        System.out.println("Deleting " + size + " items from my stack takes "
                + timer.fix() + " nanoseconds");

        /**
         * Задание 4.2
         * На основе данных объектного списка из задания 3.4 реализуйте
         * простую очередь и его базовые методы.
         * Реализуйте вспомогательные методы.
         * Оцените время выполнения операций с помощью базового метода
         * System.nanoTime().
         */
        System.out.println("\nЗадание 4.2");
        timer.start();
        QueueM<Object> queueM = new QueueM<>(linkedListWithObjects.size());
        System.out.println("My queue for " + linkedListWithObjects.size() + " elements was created in "
                + timer.fix() + " nanoseconds");

        timer.start();
        for (int i = 0; i < linkedListWithObjects.size(); i++) {
            if (queueM.isFull()) break;
            queueM.insert(linkedListWithObjects.get(i));
        }
        System.out.println("Inserting " + queueM.size() + " items into my queue takes " + timer.fix() + " nanoseconds");

        timer.start();
        queueM.peek();
        System.out.println("Viewing one item in my queue takes " + timer.fix() + " nanoseconds");

        size = queueM.size();
        timer.start();
        while (!queueM.isEmpty()) {
            queueM.remove();
        }
        System.out.println("Deleting " + size + " items from my queue takes " + timer.fix() + " nanoseconds");

        /**
         * Задание 4.3
         * На основе данных объектного списка из задания 3.4 реализуйте
         * простой дек и его базовые методы.
         * Оцените время выполнения операций с помощью базового метода
         * System.nanoTime().
         */
        System.out.println("\nЗадание 4.3");
        Deque<Object> deque = new ArrayDeque<>();
        timer.start();
        for (int i = 0; i < linkedListWithObjects.size(); i++) {
            deque.add(linkedListWithObjects.get(i));
        }
        deque.addFirst(new Object());
        deque.addLast(3);
        System.out.println("Inserting " + deque.size() + " items into dequeue takes " + timer.fix() + " nanoseconds");

        size = deque.size();
        timer.start();
        while (!deque.isEmpty()) {
            System.out.println(deque.poll());
        }
        System.out.println("Removing " + size + " items from dequeue takes " + timer.fix() + " nanoseconds");

        deque.add(2);

        deque.addFirst(1);
        deque.addLast(3);

        timer.start();
        System.out.println(deque.peekFirst());
        System.out.println(deque.peekLast());
        System.out.println("Viewing 2 items in dequeue takes " + timer.fix() + " nanoseconds");

        timer.start();
        System.out.println(deque.pollFirst());
        System.out.println(deque.pollLast());
        System.out.println("Viewing and removing 2 items from dequeue takes " + timer.fix() + " nanoseconds");

        /**
         * Задание 4.4
         * Реализуйте приоритетную очередь на основе ссылочных типов данных,
         * например, integer.
         * Оцените время выполнения операций с помощью базового метода
         * System.nanoTime().
         */
        System.out.println("\nЗадание 4.4");
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

        timer.start();
        priorityQueue.add(9);
        priorityQueue.add(4);
        priorityQueue.add(5);
        priorityQueue.add(2);
        priorityQueue.add(7);
        System.out.println("Adding " + priorityQueue.size() + " items into priority queue takes "
                + timer.fix() + " nanoseconds");

        size = priorityQueue.size();
        timer.start();
        while (!priorityQueue.isEmpty()) System.out.println(priorityQueue.poll());
        System.out.println("Viewing and removing " + size + " items from priority queue takes "
                + timer.fix() + " nanoseconds");

        /**
         * Задание 4.5
         * На основе данных из задания 4.1 и 4.2, реализуйте стек и очередь на
         * базе связанного списка.
         * Оцените время выполнения операций с помощью базового метода
         * System.nanoTime().
         */
        System.out.println("\nЗадание 4.5");
        StackList<Object> myStackList = new StackList<>();
        timer.start();
        size = 0;
        for (int i = 0; i < linkedListWithObjects.size(); i++) {
            myStackList.push(linkedListWithObjects.get(i));
            size++;
        }
        System.out.println("Inserting " + size + " items into my stack list takes "
                + timer.fix() + " nanoseconds");

        timer.start();
        myStackList.display();
        System.out.println("Showing " + size + " items from my stack list takes "
                + timer.fix() + " nanoseconds");
        timer.start();
        while (!myStackList.isEmpty()) {
            System.out.println("Item " + myStackList.pop() + " has been removed from stack list");
        }
        System.out.println("Removing " + size + " items from my stack list takes "
                + timer.fix() + " nanoseconds");

        System.out.println("--------------");
        MyQueue<Object> myQueue = new MyQueue<>();
        timer.start();
        size = 0;
        for (int i = 0; i < linkedListWithObjects.size(); i++) {
            myQueue.insert(linkedListWithObjects.get(i));
            size++;
        }
        System.out.println("Inserting " + size + " items into my queue list takes "
                + timer.fix() + " nanoseconds");

        timer.start();
        myQueue.display();
        System.out.println("Showing " + size + " items from my queue list takes "
                + timer.fix() + " nanoseconds");
        timer.start();
        while (!myQueue.isEmpty()) {
            System.out.println("Item " + myQueue.delete() + " has been removed from queue list");
        }
        System.out.println("Removing " + size + " items from my queue list takes "
                + timer.fix() + " nanoseconds");


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

        public void display() {
            System.out.println(link);
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

    static class StackM<T>{
        private int maxSize;
        private T[] stack;
        private int top;
        private int size;

        public StackM(int size) {
            maxSize = size;
            stack = (T[]) new Object[size];
            top = -1;
        }

        public void push(T i) {
            stack[++top] = i;
        }

        public T pop(){
            return stack[top--];
        }

        public T peek(){
            return stack[top];
        }

        public boolean isEmpty(){
            return (top == -1);
        }

        public boolean isFull(){
            return (top == maxSize - 1);
        }

        public int size() {
            return (top + 1);
        }
    }

    static class QueueM<T>{
        private int maxSize;
        private T[] queue;
        private int front;
        private int rear;
        private int items;

        public QueueM(int s) {
            maxSize = s;
            queue = (T[]) new Object[maxSize];
            front = 0;
            rear = -1;
            items = 0;
        }

        public void insert(T i) {
            if (rear == maxSize - 1) rear--;
            queue[++rear] = i;
            items++;
        }

        public T remove() {
            T temp = queue[front++];
            if (front == maxSize) front = 0;
            items--;
            return temp;
        }

        public T peek() { return queue[front];}

        public boolean isEmpty() { return (items == 0);}

        public boolean isFull() { return (items == maxSize);}

        public int size() { return  items; }

    }

    static class SinglyLinkedList<T> {
        public Link first;

        public SinglyLinkedList() {
            first = null;
        }

        public boolean isEmpty() {
            return (first == null);
        }

        public void insert(T t) {
            Link<T> link = new Link<>(t);
            link.next = first;
            first = link;
        }

        public Link<T> delete() {
            Link<T> temp = first;
            first = first.next;
            return temp;
        }

        public void display() {
            Link<T> current = first;
            while (current != null) {
                current.display();
                current = current.next;
            }

        }
    }

    static class StackList<T> {
        private SinglyLinkedList list;

        public StackList() {
            list = new SinglyLinkedList<T>();
        }

        public void push(T t) {
            list.insert(t);
        }

        public Link pop() {
            return list.delete();
        }

        public boolean isEmpty() {
            return list.isEmpty();
        }

        public void display() {
            list.display();
        }
    }

    static class DoublyLinkedList<T> {
        public Link first;
        public Link last;

        public DoublyLinkedList() {
            first = null;
            last = null;
        }

        public boolean isEmpty() {
            return (first == null);
        }

        public void insert(T t) {
            Link<T> link = new Link<>(t);
            if (this.isEmpty())
                first = link;
            else
                last.next = link;
            last = link;
        }

        public Link<T> delete() {
            Link<T> temp = first;
            if (first.next == null)
                last = null;
            first = first.next;
            return temp;
        }

        public void display() {
            Link<T> current = first;
            while (current != null) {
                current.display();
                current = current.next;
            }

        }
    }

    static class MyQueue<T> {
        private DoublyLinkedList queue;

        public MyQueue() {
            queue = new DoublyLinkedList<T>();
        }

        public boolean isEmpty() {
            return queue.isEmpty();
        }

        public void insert(T t) {
            queue.insert(t);
        }

        public Link delete() {
            return queue.delete();
        }

        public void display() {
            queue.display();
        }
    }
}
