import javax.imageio.plugins.jpeg.JPEGImageReadParam;
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

        /**
         * Задание 5.1
         * Приведите пример использования рекурсии.
         *
         * В жизни обычную рекурсию можно показать на примере матрешки, а бесконечную – если поставить друг напротив
         * друга 2 зеркала (навести веб камеру на монитор, на выбор).
         */

        /**
         * Задание 5.2
         * Реализуйте простой пример бесконечной рекурсии и обычной рекурсии с условием для выхода.
         * Примером самой простой бесконечной рекурсии можно назвать счетчик, который при каждом вызове увеличивает
         * значение на 1 (не спрашивайте меня зачем, я не знаю). Хотел реализовать рекурсивное вычисление числа пи,
         * но такое решение простым назвать не получится. Ожидаемо такой метод приведет к переполнению стека, поэтому
         * я его закомментирую.
         * Обычная рекурсия – это вычисление факториала.
         */
        System.out.println("\nЗадание 5.2");
        //counter(0);
        System.out.println(factorial(3));

        /**
         * Задание 5.3
         * Приведите пример изображающий стек вызова и стек вызова с рекурсией.
         *
         * Стек вызовов можно представить в виде математической игры. Допустим, у нас есть пустая банка от Pringles, куда
         * мы кладем карточки с заданиями таким образом, чтобы самое первое задание оказалось вверху, а самое последнее
         * на дне банки. Поочередно доставая карточки мы должны выполнять указанные в них задания, а результат
         * использовать в качестве входного параметра для последующей карточки. Некоторые карточки не будут требовать
         * входной результат, в них нужно будет производить вычисления только на основе данных из карточки. Но так или
         * иначе мы должны доставать карточки в строго обозначенной последовательности и выполнять задание в них.
         *
         * Проедлагаю рассмотреть работу стека вызовов с рекурсией на предыдущем примере. Теперь представим, что
         * карточка с заданием у нас только одна, она должна возвращать результат и находиться вне банки, а в банке
         * лежит несколько чипсов. Каждый раз, доставая и съедая один чипс, мы должны выполнить задание на карточке и
         * сохранить результат для дальнейшего использования в очередной итерации задания. Количество чипсов в банке
         * будет определять количество выполнений задания на карточке.
         */

        /**
         * Задание 5.4
         * Реализуйте простой алгоритм использующий цикл и простой алгоритм использующий рекурсию.
         * Оцените два алгоритма с помощью базового метода System.nanoTime().
         */
        System.out.println("\nЗадание 5.4");

        timer.start();
        int n = 100;
        int factorial = 1;
        for (int i = 1; i <= n; i++) {
            factorial = factorial * i;
        }
        System.out.println("Loop for calculating " + n + "! is executed "
                + timer.fix() + " nanoseconds");

        timer.start();
        factorial(n);
        System.out.println("Recursive call to calculate " + n + "! is executed " + timer.fix() + " nanoseconds");

        /**
         * Задание 5.5
         * Реализуйте алгоритм двоичного рекурсивного поиска на основе массива из задания 2.1.
         * Оцените алгоритм двоичного рекурсивного поиска с помощью базового метода System.nanoTime() и сравните с обычным двоичным поиском.
         */
        System.out.println("\nЗадание 5.5");
        intsCopy = Arrays.copyOf(ints, ints.length);
        Arrays.sort(intsCopy);
        System.out.println(Arrays.toString(intsCopy));
        desiredValue = intsCopy[randomizer.nextInt(30)];
        timer.start();
        System.out.println("Position is "
                + recursiveBinaryFind(desiredValue, 0, intsCopy.length - 1, intsCopy));
        System.out.println("Recursive binary find for array from " + intsCopy.length + " elements took "
                + timer.fix() + " nanoseconds");

        timer.start();
        binaryFind(intsCopy, desiredValue, timer);
        System.out.println("Binary find took " + timer.fix() + " nanoseconds");

        /**
         * Задание 5.6
         * На основе массива из задания 2.1 реализуйте алгоритм сортировки слиянием.
         * Оцените алгоритм сортировки слиянием с помощью базового метода System.nanoTime() и сравните с сортировкой методом sort().
         */
        System.out.println("\nЗадание 5.6");
        intsCopy = Arrays.copyOf(ints, ints.length);
        int[] intsCopy2 = Arrays.stream(intsCopy).mapToInt(Integer::intValue).toArray();
        timer.start();
        sortMerge(intsCopy2);
        System.out.println("Merge sort algorithm ran in " + timer.fix() + " nanoseconds");
        intsCopy2 = Arrays.stream(intsCopy).mapToInt(Integer::intValue).toArray();
        timer.start();
        Arrays.sort(intsCopy2);
        System.out.println("sort() method ran in " + timer.fix() + " nanoseconds");

        /**
         * Задания 6.1
         * Приведите пример использования древовидной структуры.
         *
         * Древовидную структуру можно использовать для описания любой иерархии, где есть подчиненные и руководители,
         * в генеалогии для обозначения предков и потомков и много где еще.
         */

        /**
         * Задание 6.2
         * Реализуйте класс узла дерева и базовый шаблон дерева с базовыми
         * методами.
         * Задание 6.3
         * Реализуйте методы поиска и вставки узла в дерево.
         * Задание 6.4
         * Реализуйте базовые методы обхода дерева и метода дисплей.
         * Реализуйте поиск максимума и минимума.
         * Задание 6.5
         * Реализуйте метод удаления узла и выполните оценку времени базовых
         * методов дерева с помощью System.nanoTime().
         */
        System.out.println("\nЗадание 6.2-6.5");
        Tree theTree = new Tree();

        timer.start();
        theTree.insert(new Person(4, "Ivan", 35));
        System.out.println("Вставка в дерево занимает " + timer.fix() + " наносекунд");
        theTree.insert(new Person(2, "Ivan1", 78));
        theTree.insert(new Person(3, "Ivan2", 24));
        theTree.insert(new Person(5, "Ivan3", 21));

        timer.start();
        theTree.max().display();
        System.out.println("Поиск максимального значения в дереве занимает " + timer.fix() + " наносекунд");
        timer.start();
        theTree.min().display();
        System.out.println("Поиск минимального значения в дереве занимает " + timer.fix() + " наносекунд");

        timer.start();
        theTree.find(3).display();
        System.out.println("Поиск произвольного значения в дереве занимает " + timer.fix() + " наносекунд");

        timer.start();
        theTree.delete(2);
        System.out.println("Удаление из дерева занимает " + timer.fix() + " наносекунд");

        timer.start();
        theTree.displayTree();
        System.out.println("Вывод дерева занимает " + timer.fix() + " наносекунд");

        /**
         * Задание 6.6
         * Реализуйте на основе массива из задания 2.1 алгоритм пирамидальной
         * сортировки с реализацией бинарной пирамиды.
         * Выполните оценку алгоритма пирамидальной сортировки с помощью
         * System.nanoTime() и сравните с предыдущими алгоритмами сортировки.
         */
        System.out.println("\nЗадание 6.6");

        timer.start();
        HeapSort arrSort = new HeapSort();
        arrSort.sort(ints);
        System.out.println("Пирамидальная сортировка занимает " + timer.fix() + " наносекунд");


        /**
         * Задание 6.7
         * Приведите пример сбалансированного дерева и его применения.
         *
         * Сбалансированным называется такое дерево, где для каждой его вершины количество вершин в правом и левом
         * поддеревьях различается не более чем на 1.
         */

        /**
         * Задание 7.1
         * Приведите пример графа.
         *
         * Примером графа может быть сеть маршрутов с расстояниями между его вершинами – городами.
         */

        /**
         * Задание 7.2
         * Реализуйте базовые методы графа.
         */
        System.out.println("\nЗадание 7.2");
        Graph graph = new Graph();
        graph.addVertex('A');
        graph.addVertex('B');
        graph.addVertex('C');
        graph.addVertex('D');
        graph.addVertex('E');
        graph.addVertex('H');

        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(0, 3);
        graph.addEdge(3, 4);

        graph.displayVertex(4);

        /**
         * Задание 7.3
         * В программный код из задания 7.2 добавьте реализацию метода обхода
         * в глубину.
         * Выполните оценку времени с помощью System.nanoTime().
         */
        System.out.println("\nЗадание 7.3");
        timer.start();
        graph.dfs();
        System.out.println("Обход в глубину занимает " + timer.fix() + " наносекунд");

        timer.start();
        graph.DFS(0);
        System.out.println("Обход в глубину с рекурсией занимает " + timer.fix() + " наносекунд");

        /**
         * Задание 7.4
         * В базовом графе из задания 7.2 реализуйте метод обхода в ширину.
         * Выполните оценку времени с помощью System.nanoTime().
         */
        System.out.println("\nЗадание 7.4");
        timer.start();
        graph.bfs();
        System.out.println("Обход в ширину занимает " + timer.fix() + " наносекунд");

        timer.start();
        graph.BFS(0);
        System.out.println("Обход 2 в ширину занимает " + timer.fix() + " наносекунд");

        /**
         * Задание 8.1
         * Приведите пример использование хеш-таблиц.
         *
         * Хеш-таблицы обычно используются для реализации ассоциативных массивов, когда индексом сложного объекта в
         * массиве выступает его хеш-функция.
         */

        /**
         * Задание 8.2
         * Приведите примеры ключей и коллизий.
         *
         * Ключем называется исходные данные, подлежащие преобразованию через хеш-функцию. Коллизия – это когда
         * хеш-функция на несколько разных ключей возвращает одинаковую хеш-сумму.
         */

        /**
         * Задание 8.3
         * Приведите примеры популярных и эффективных хеш-функций.
         *
         * Эффективная хеш-функция должна удовлетворять нескольким требованиям: не создавать хеш-таблицу избыточного
         * размера и при этом минимизировать количество коллизий. Как вариант использовать такую хеш-функцию, которая
         * допускает хранение 2n элементов в хеш-таблице, где n – количество возможных ключей.
         */

        /**
         * Задание 8.4
         * На основе данных массива из задания 2.3 реализуйте хеш-таблицу с
         * помощью открытой адресации, а конкретнее метода линейного пробирования
         */
        System.out.println("\nЗадание 8.4");
        bigIntsCopy = Arrays.copyOf(bigInts, bigInts.length);

        HashTable hTable = new HashTable(bigIntsCopy.length * 2, false);

        for (int i = 0; i < bigIntsCopy.length; i++) {
            Item aDataItem = new Item(bigIntsCopy[i]);
            hTable.insert(aDataItem);
        }

        hTable.display();

        /**
         * Задание 8.5
         * Перестройте программный код задания 8.4 из алгоритма линейного
         * пробирования в алгоритм двойного хеширования.
         * Сравните отличительные черты двух алгоритмов.
         */
        System.out.println("\nЗадание 8.5");
        bigIntsCopy = Arrays.copyOf(bigInts, bigInts.length);

        hTable = new HashTable(bigIntsCopy.length * 2, true);

        for (int i = 0; i < bigIntsCopy.length; i++) {
            Item aDataItem = new Item(bigIntsCopy[i]);
            hTable.insert(aDataItem);
        }

        hTable.display();

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

    public static int factorial(int i) {
        if (i == 1 || i == 0) {
            return 1;
        }
        return factorial(i - 1) * i;
    }

    public static int counter(int i) {
        return counter( i + 1);
    }

    public static int recursiveBinaryFind(int searchKey, int low, int high, Integer arr[]) {

        if (low > high)
            return arr.length;

        int mid = (low + high) / 2;

        if (arr[mid] == searchKey)
            return recursiveBinaryFind(searchKey, low + 1, high ,arr);
        else
            return recursiveBinaryFind(searchKey, low, high - 1, arr);
    }

    public static int binaryFind(Integer[] intsCopy, int desiredValue, Timer timer) {
        int firstIndex = 0;
        int lastIndex = intsCopy.length - 1;
        while (true) {
            timer.increaseCounter();
            int middleIndex = (lastIndex + firstIndex) / 2;
            if (intsCopy[middleIndex] == desiredValue) {
                System.out.println(desiredValue + " contains in " + middleIndex + " index and found for "
                        + timer.getCounter() + " iterations");
                return middleIndex;
            } else if (intsCopy[middleIndex] < desiredValue) {
                firstIndex = middleIndex + 1;
            } else {
                lastIndex = middleIndex - 1;
            }
        }
    }

    public static int[] sortMerge(int[] arr) {
        int len = arr.length;
        if (len < 2) return arr;
        int middle = len / 2;
        return merge(sortMerge(Arrays.copyOfRange(arr, 0, middle)),
                sortMerge(Arrays.copyOfRange(arr, middle, len)));
    }

    public static int[] merge(int[] a, int[] b) {
        int[] result = new int[a.length + b.length];
        int aIndex = 0;
        int bIndex = 0;

        for (int i = 0; i < result.length; i++) {
            result[i] = a[aIndex] < b[bIndex] ? a[aIndex] : b[bIndex];
            if (aIndex == a.length) {
                System.arraycopy(b, bIndex, result, ++i, b.length - bIndex);
                break;
            }
            if (bIndex == b.length) {
                System.arraycopy(a, aIndex, result, ++i, a.length - aIndex);
                break;
            }
        }
        return result;
    }

    static class Person {
        public String name;
        public int id;
        public  int age;

        public Person(int id, String name, int age) {
            this.name = name;
            this.id = id;
            this.age = age;
        }
    }

    static class Node {
        public Person person;
        public Node leftChild;
        public Node rightChild;

        public void display() {
            System.out.println("Name: " + person.name + ", age: " + person.age);
        }
    }

    static class Tree {
        private Node root;

        public void insert(Person person){
            Node node = new Node();
            node.person = person;

            if (root == null)
                root = node;
            else {
                Node current = root;
                Node parent;

                while (true) {
                    parent = current;
                    if (person.id < current.person.id) {
                        current = current.leftChild;
                        if (current == null) {
                            parent.leftChild = node;
                            return;
                        }
                    } else {
                        current = current.rightChild;
                        if (current == null) {
                            parent.rightChild = node;
                            return;
                        }
                    }
                }
            }
        }

        public Node find (int key) {
            Node current = root;

            while (current.person.id != key) {
                if (key < current.person.id)
                    current = current.leftChild;
                else
                    current = current.rightChild;
                if (current == null)
                    return null;
            }
            return current;
        }

        private void preOrder (Node rootNode) {
            if (rootNode != null) {
                rootNode.display();
                preOrder(rootNode.leftChild);
                preOrder(rootNode.rightChild);
            }
        }

        private void postOrder (Node rootNode) {
            if (rootNode != null) {
                preOrder(rootNode.leftChild);
                preOrder(rootNode.rightChild);
                rootNode.display();
            }
        }

        private void inOrder (Node rootNode) {
            if (rootNode != null) {
                inOrder(rootNode.leftChild);
                rootNode.display();
                inOrder(rootNode.rightChild);
            }
        }

        public Node min() {
            Node current, last = null;
            current = root;
            while (current != null) {
                last = current;
                current = current.leftChild;
            }
            return last;
        }

        public Node max() {
            Node current, last = null;
            current = root;
            while (current != null) {
                last = current;
                current = current.rightChild;
            }
            return last;
        }

        public boolean delete (int id) {
            Node current = root;
            Node parent = root;

            boolean isLeftChild = true;

            while (current.person.id != id) {
                parent = current;
                if (id < current.person.id) {
                    isLeftChild = true;
                    current = current.leftChild;
                } else {
                    isLeftChild = false;
                    current = current.rightChild;
                }
                if (current == null)
                    return false;
            }

            if (current.leftChild == null && current.rightChild == null) {
                if (current == root)
                    root = null;
                else if (isLeftChild)
                    parent.leftChild = null;
                else
                    parent.rightChild = null;

            } else if (current.rightChild == null) {
                if (current == null)
                    root = current.leftChild;
                else  if (isLeftChild)
                    parent.leftChild = current.leftChild;
                else
                    parent.rightChild = current.leftChild;
            } else if (current.leftChild == null) {
                if (current == null)
                    root = current.rightChild;
                else if (isLeftChild)
                    parent.leftChild = current.rightChild;
                else
                    parent.rightChild = current.rightChild;
            } else {
                Node successor = getSuccessor(current);
                if (current == root)
                    root = successor;
                else if (isLeftChild)
                    parent.leftChild = successor;
                else
                    parent.rightChild = successor;
                successor.leftChild = current.leftChild;
            }
            return true;
        }

        public Node getSuccessor(Node node) {
            Node successorParent = node;
            Node successor = node;
            Node current = node.rightChild;

            while (current != null) {
                successorParent = successor;
                successor = current;
                current = current.leftChild;
            }

            if (successor != node.rightChild) {
                successorParent.leftChild = successor.rightChild;
                successor.rightChild = node.rightChild;
            }
            return successor;
        }

        public void displayTree () {
            Node current = root;
            System.out.println("Симметричный");
            inOrder(root);
            System.out.println("Прямой");
            preOrder(root);
            System.out.println("Обратный");
            postOrder(current);
        }
    }

    static class HeapSort {

        private static int heapSize;

        public static void sort (Integer[] a) {
            buildHeap(a);
            while (heapSize > 1) {
                swap(a, 0, heapSize - 1);
                heapSize--;
                heapify(a, 0);
            }
        }

        private static void buildHeap(Integer[] a) {
            heapSize = a.length;
            for (int i = a.length / 2; i >= 0 ; i--) {
                heapify(a, i);

            }
        }

        private static void heapify(Integer[] a, int i) {
            Integer l = left(i);
            Integer r = right(i);
            Integer largest = i;
            if (l <heapSize && a[i] < a[l]) {
                largest = l;
            }
            if (r <heapSize && a[i] < a[r]) {
                largest = r;
            }
            if (i != largest) {
                swap(a, i, largest);
                heapify(a, largest);
            }
        }

        private static Integer right (int i) {
            return 2 * i + 2;
        }

        private static Integer left (int i) {
            return 2 * i + 1;
        }

        private static void swap (Integer[] a, int i, int j) {
            Integer temp = a[i];
            a[i] = a[j];
            a[j] = temp;
        }
    }

    static class Vertex {
        char label;
        boolean wasVisited;

        public Vertex(char label) {
            this.label = label;
            this.wasVisited = false;
        }
    }

    static class Graph {
        private final int MAX_VERTS = 32;
        private Vertex[] vertexList;
        private int[][] adjMat;
        private int size;
        private Stack stack;

        public Graph() {
            stack = new Stack(MAX_VERTS);
            vertexList = new Vertex[MAX_VERTS];
            adjMat = new int[MAX_VERTS][MAX_VERTS];
            size = 0;
            for (int i = 0; i < MAX_VERTS; i++) {
                for (int j = 0; j < MAX_VERTS; j++) {
                    adjMat[i][j] = 0;
                }
            }
        }

        private int getAdjUnvisitedVertex(int ver) {
            for (int i = 0; i < size; i++) {
                if (adjMat[ver][i] == 1 && vertexList[i].wasVisited == false)
                    return i;
            }
            return -1;
        }

        public void dfs() {
            vertexList[0].wasVisited = true;
            displayVertex(0);
            stack.push(0);
            while (!stack.isEmpty()) {
                int v = getAdjUnvisitedVertex(stack.peek());
                if (v == -1)
                    stack.pop();
                else {
                    vertexList[v].wasVisited = true;
                    displayVertex(v);
                    stack.push(v);
                }
            }

            for (int i = 0; i < size; i++) {
                vertexList[i].wasVisited = false;
            }
        }

        public void DFS(int f) {
            vertexList[f].wasVisited = true;

            for (int i = 0; i < size; i++) {
                int v = getAdjUnvisitedVertex(f);
                if (!vertexList[i].wasVisited && v != -1) {
                    fullDisplayVertex(f, v);
                    DFS(i);
                }
            }
        }

        public void bfs() {
            Queue<Integer> queue = new LinkedList<>();
            vertexList[0].wasVisited = true;
            displayVertex(0);
            queue.add(0);
            int v2;
            while (!queue.isEmpty()) {
                int v1 = queue.remove();
                while ((v2 = getAdjUnvisitedVertex(v1)) != -1) {
                    vertexList[v2].wasVisited = true;
                    displayVertex(v2);
                    queue.add(v2);
                }
            }
            for (int i = 0; i < size; i++) {
                vertexList[i].wasVisited = false;
            }
        }

        public void BFS(int v) {
            int[] queue = new int[size];
            int qH = 0;
            int qT = 0;

            vertexList[0].wasVisited = true;
            queue[qT++] = v;

            displayVertex(0);

            int v2;
            while (qH < qT) {
                v = queue[qH++];

                for (int i = 0; i < size; i++) {
                    v2 = getAdjUnvisitedVertex(v);
                    if (!vertexList[i].wasVisited && v2 != -1) {
                        vertexList[i].wasVisited = true;
                        displayVertex(qT);
                        queue[qT++] = i;
                    }
                }
            }
            for (int i = 0; i < size; i++) {
                vertexList[i].wasVisited = false;
            }
        }

        public void addVertex(char label) {
            vertexList[size++] = new Vertex(label);
        }

        public void addEdge(int start, int end) {
            adjMat[start][end] = 1;
            adjMat[end][start] = 1;
        }

        public void displayVertex(int vertex) {
            System.out.println(vertexList[vertex].label);
        }

        public void fullDisplayVertex(int vertex1, int vertex2) {
            System.out.println("Вершины " + vertexList[vertex1].label + "-" + vertexList[vertex2].label);
        }
    }

    public static class Stack {
        private int maxSize;
        private int[] stackArr;
        private int top;

        public Stack(int size) {
            this.maxSize = size;
            this.stackArr = new int[size];
            this.top = -1;
        }

        public void push(int i) {
            stackArr[++top] = i;
        }

        public int pop() {
            return stackArr[top--];
        }

        public boolean isEmpty() {
            return (top == -1);
        }

        public int peek() {
            return stackArr[top];
        }

    }

    static class Item {
        private int data;

        public Item(int data) {
            this.data = data;
        }

        public int getKey() {
            return data;
        }
    }

    static class HashTable {
        private Item[] hashArr;
        private int arrSize;
        private Item nonItem;
        boolean doubleHash;

        public HashTable(int size, boolean doubleHash) {
            arrSize = size;
            hashArr = new Item[arrSize];
            nonItem = new Item(-1);
            this.doubleHash = doubleHash;
        }

        public void display() {
            for (int i = 0; i < arrSize; i++) {
                if (hashArr[i] != null)
                    System.out.println(hashArr[i].getKey());
                else
                    System.out.println("***");
            }
        }

        public int hashFunc(int key) {
            return key % arrSize;
        }

        public int hashFuncDouble(int key) {
            return 5 - key % 5;
        }

        public void insert(Item item) {
            int key = item.getKey();
            int hashVal = hashFunc(key);
            int stepSize = hashFuncDouble(key);
            while (hashArr[hashVal] != null && hashArr[hashVal].getKey() != -1) {
                if (doubleHash)
                    hashVal += stepSize;
                else
                    ++ hashVal;
                hashVal %= arrSize;
            }
            hashArr[hashVal] = item;

        }

        public Item delete(int key) {
            int hashVal = hashFunc(key);
            int stepSize = hashFuncDouble(key);
            while (hashArr[hashVal] != null) {
                if (hashArr[hashVal].getKey() == key) {
                    Item temp = hashArr[hashVal];
                    hashArr[hashVal] = nonItem;
                    return temp;
                }
                if (doubleHash)
                    ++hashVal;
                else
                    hashVal += stepSize;
                hashVal %= arrSize;
            }
            return null;
        }

        public Item find(int key) {
            int hashVal = hashFunc(key);
            int stepSize = hashFuncDouble(key);
            while (hashArr[hashVal].getKey() == key)
                return hashArr[hashVal];
            ++ hashVal;
            if (doubleHash)
                hashVal += stepSize;
            else
                hashVal %= arrSize;
            return null;
        }

        private int getPrime(int min) {
            for (int i = min + 1; true; i++) {
                if (isPrime(i))
                    return i;
            }
        }

        private boolean isPrime(int n) {
            for (int j = 2; (j * j <= n); j++)
                if (n * j == 0)
                    return false;
            return true;
        }
    }

}
