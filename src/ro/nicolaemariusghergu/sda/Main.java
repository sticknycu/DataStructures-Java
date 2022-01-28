package ro.nicolaemariusghergu.sda;

import com.sun.source.tree.Tree;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {

    public static void main(String[] args) {
        // write your code here
        //bubbleSort(); -- O(n^2) -- stable
        //selectionSort(); -- O(n^2) -- unstable
        //insertionSort(); -- O(n^2) -- stable
        //shellShort(); -- O(n^2) -- unstable
        //System.out.println(calculateFactorial(10));
        //System.out.println(recursiveFactorial(10));
        /*
        // mergeSort(); -- Divide et Impera -- O(n log n) -- stable
        /

        int[] intArray = arrayList();
        int length = intArray.length;
        mergeSort(intArray, 0, length);
         */

        /*
        //quickSort(); -- Divide et Impera -- O(n log n) -- almost all time time -- unstable
        / worst - O(n^2)

        int[] intArray = arrayList();
        int length = intArray.length;
        quickSort(intArray, 0, length);
         */

        //countingSort(); -- not an in-place algorithm, O(n), can be stable, but for not unstable
        /*
        int[] intArray = {2, 5, 9, 8, 2, 8, 7, 10, 4, 3};
        countingSort(intArray, 1, 10);
         */

        //int[] intArray = arrayList();
        //int length = intArray.length;
        //radixSort(intArray, 0, length); // must use a stable sort algorithm at each stage
        // O(n) but can run slower than O(n log n) algorithms

        // stable counting sort now

        // just for documentation
        //Arrays.parallelSort(intArray);
        //Arrays.sort(intArray);
        //Arrays.stream(intArray).forEach(System.out::println);

        // Challenge 1) Sort Merge Sort to do descending order
        //int[] sortedElements = mergeSort(intArray, 0, length, true);
        //Arrays.stream(sortedElements).forEach(System.out::println);

        // Challenge 2) Change insert sort so that it uses recursion
        //int[] intArray = arrayList();
        //int length = intArray.length;
        //insertionSortRecursive(intArray, length);

        // Challenge 3)


        /*
        -----------------------------
         */
        // Lists

        // Abstract data type
        // Array List

        class Employee {
            private String firstName;
            private String lastName;
            private int id;

            public Employee(String firstName, String lastName, int id) {
                this.firstName = firstName;
                this.lastName = lastName;
                this.id = id;
            }

            public String getFirstName() {
                return firstName;
            }

            public void setFirstName(String firstName) {
                this.firstName = firstName;
            }

            public String getLastName() {
                return lastName;
            }

            public void setLastName(String lastName) {
                this.lastName = lastName;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            @Override
            public String toString() {
                return "Employee{" +
                        "firstName='" + firstName + '\'' +
                        ", lastName='" + lastName + '\'' +
                        ", id=" + id +
                        '}';
            }

            @Override
            public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;

                Employee employee = (Employee) o;

                if (id != employee.id) return false;
                if (!firstName.equals(employee.firstName)) return false;
                return lastName.equals(employee.lastName);
            }

            @Override
            public int hashCode() {
                int result = firstName.hashCode();
                result = 31 * result + lastName.hashCode();
                result = 31 * result + id;
                return result;
            }
        }

        // look at ArrayList::add() implementation
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Jane", "Jones", 123));
        employees.add(new Employee("John", "Doe", 4567));
        employees.add(new Employee("Mary", "Smith", 22));
        employees.add(new Employee("Mike", "Wilson", 3245));


        employees.forEach(System.out::println);

        // constant time O(1) when we use ArrayList::get();
        System.out.println(employees.get(1));

        System.out.println(employees.isEmpty());

        employees.set(1, new Employee("John", "Adams", 4568));
        employees.forEach(System.out::println);

        // capacity is the number of the list can hold, not the same with size.
        System.out.println(employees.size());

        employees.add(3, new Employee("John", "Doe", 4567));
        employees.forEach(System.out::println);

        System.out.println(employees.size());
        Employee[] employeeArray = employees.toArray(new Employee[employees.size()]);
        for (Employee employee : employeeArray) {
            System.out.println(employee);
        }

        System.out.println(employees.contains(new Employee("Mary", "Smith", 22)));

        System.out.println(employees.indexOf(new Employee("John", "Doe", 4567)));

        // check for implementation of ArrayList::remove()
        employees.remove(2);

        employees.forEach(System.out::println);

        // so if you have the index, is contant, if not, is linear.


        // ArrayList -- not thread safe -- is not syncronized
        // Vector Class -- thread safe ArrayList -- is syncronized

        // look at vector constructor
        List<Employee> employeeVector = new Vector<>();

        // look at Vector::add() implementation -- is syncronized
        employees.add(new Employee("Jane", "Jones", 123));
        employees.add(new Employee("John", "Doe", 4567));
        employees.add(new Employee("Mary", "Smith", 22));
        employees.add(new Employee("Mike", "Wilson", 3245));

        employeeVector.forEach(System.out::println);

        // Singly Linked List
        // -- each item in the list is called a node
        // -- the first item in the list is the head of the list
        // -- last item of the list always points to null
        // -- next will be the type of node

        // Insert steps
        // 1. Create a new node "Bill"
        // 2. Assign "Jane" to the next field
        // 3. Assign head to "Bill"
        // 4. Will be O(1) time complexity

        // Delete steps
        // 1. Assign "Bill" to a temporary variable "removedNde"
        // 2. Assign "head" to "Jane"
        // 3. Return "removedNode"
        // 4. Will be O(1) time complexity

        System.out.println(); // clear line
        System.out.println("----> Singly Linked List <----");

        Employee janeJones = new Employee("Jane", "Jones", 123);
        Employee johnDoe = new Employee("John", "Doe", 4567);
        Employee marySmith = new Employee("Mary", "Smith", 22);
        Employee mikeWilson = new Employee("Mike", "Wilson", 3245);

        class EmployeeNode {
            // default value of object fields is null so we dont have to set it if we want to get last item
            private Employee employee;
            private EmployeeNode next;

            public EmployeeNode(Employee employee) {
                this.employee = employee;
            }

            public Employee getEmployee() {
                return employee;
            }

            public void setEmployee(Employee employee) {
                this.employee = employee;
            }

            public EmployeeNode getNext() {
                return next;
            }

            public void setNext(EmployeeNode next) {
                this.next = next;
            }

            public String toString() {
                return employee.toString();
            }
        }

        class hashMap {

            private EmployeeNode head;
            private int size;

            public void addToFront(Employee employee) {
                EmployeeNode node = new EmployeeNode(employee);
                node.setNext(head);
                head = node;
                size++;
            }

            public EmployeeNode removeFromFront() {
                if (isEmpty()) {
                    return null;
                }

                EmployeeNode removedNode = head;
                head = removedNode.getNext();
                size--;
                return removedNode;
            }

            public int getSize() {
                return size;
            }

            public boolean isEmpty() {
                return head == null;
            }

            public void printList() {
                EmployeeNode current = head;
                System.out.print("HEAD -> " );
                while (current != null) {
                    System.out.print(current);
                    System.out.print(" -> ");
                    current = current.getNext();
                }
                System.out.println("null");
            }
        }

        hashMap list = new hashMap();
        list.addToFront(janeJones);
        list.addToFront(johnDoe);
        list.addToFront(marySmith);
        list.addToFront(mikeWilson);

        System.out.println(list.getSize());
        list.printList();
        System.out.println(list.isEmpty());
        // if we want to add to the end, this will be O(n) because we will have to traverse all the nexts

        // sooo, best case when you want to add and remove items to a list is a linkedlist.
        // everything is done by memory, so you don't have to manage the memory use like arrays
        // best choise is not going to be a linkedlist if you have a tight memory and a large number of items

        list.removeFromFront();
        System.out.println(list.getSize());
        list.printList();

        System.out.println("----> Doubly Linked List <----");

        // Each item in the list has next and previous fields
        // The list has a head and a tail
        // we have a head and a tail
        // tail is last item which is not null from the list

        // Insert at head
        // 1) Create new node "Bill"
        // 2) Assign "Jane" to Bill's next field
        // 3) Assign whatever Jane is pointing to as previous to Bill's previous field
        // 4) Assign "Bill" to Jane's previous field
        // 5) Asign head to "Bill"
        // O(1) time complexity

        // we don't have to assign previous field to first element because is null
        // ----> null - bill <-> jane <-> john <-> mary <-> mike -> null
        // constant time when adding and removing, but linear when accesing other elements

        // insert at tail
        // 1) Create new node "Bill"
        // 2) Assign tail's next field to Bill's next field
        // 3) Assign tail to Bill's previous field
        // 4) Assign tail's next field to "Bill"
        // 5) Assign tail to "Bill"
        // O(1) time complexity

        // Delete from head
        // 1) Assign "Jane" to "removedNode"
        // 2) Assign John's previous field to Jane's previous field
        // 3) Assign head to Jane's next field
        // 4) Return "removedNode" from the method
        // O(1) time complexity

        // Delete from tail
        // 1) Asign "Bill" to "removedNode"
        // 2) Assign Mike's next field to Bill's next field
        // 3) Assign tail to Bill's previous field
        // 4) Return "removedNode" from the method
        // O(1) time complexity

        // Insert a node A between nodes B and C
        // 1) Assign A's next field to B's next field
        // 2) Assign A's previous field to C's previous field
        // 3) Assign B's next field to A
        // 4) Assign C's previous field to A
        // O(1) time complexity BUT we have to find the insertion position first
        // so this is actually O(n)

        // To remove node A from between B and C
        // 1) Assign A to "removedNode"
        // 2) Assign C's previous field to A' previous field
        // 3) Assign B's next field to A's next field
        // 4) Return A from the method
        // O(1) time complexity BUT we have to find A first
        // so this is actually O(n)

        class EmployeeNodeDoublyLinkedList {
            // default value of object fields is null so we dont have to set it if we want to get last item
            private Employee employee;
            private EmployeeNodeDoublyLinkedList next;
            private EmployeeNodeDoublyLinkedList previous;

            public EmployeeNodeDoublyLinkedList(Employee employee) {
                this.employee = employee;
            }

            public Employee getEmployee() {
                return employee;
            }

            public void setEmployee(Employee employee) {
                this.employee = employee;
            }

            public EmployeeNodeDoublyLinkedList getPrevious() {
                return previous;
            }

            public void setPrevious(EmployeeNodeDoublyLinkedList previous) {
                this.previous = previous;
            }

            public EmployeeNodeDoublyLinkedList getNext() {
                return next;
            }

            public void setNext(EmployeeNodeDoublyLinkedList next) {
                this.next = next;
            }

            public String toString() {
                return employee.toString();
            }
        }

        class EmployeeDoublyLinkedList {

            private EmployeeNodeDoublyLinkedList head;
            private EmployeeNodeDoublyLinkedList tail;
            private int size;

            public void addToEnd(Employee employee) {
                EmployeeNodeDoublyLinkedList node = new EmployeeNodeDoublyLinkedList(employee);
                if (tail == null) {
                    head = node;
                } else {
                    tail.setNext(node);
                    node.setPrevious(tail);
                }

                tail = node;
                size++;
            }

            public boolean addBefore(Employee newEmployee, Employee existingEmployee) {
                // if linkedlist is empty
                if (head == null) {
                    return false;
                }

                // find the existing employee
                EmployeeNodeDoublyLinkedList current = head;
                while (current != null && !current.getEmployee().equals(existingEmployee)) {
                    current = current.getNext();
                }

                if (current == null) {
                    return false;
                }

                EmployeeNodeDoublyLinkedList newNode = new EmployeeNodeDoublyLinkedList(newEmployee);
                newNode.setPrevious(current.getPrevious());
                newNode.setNext(current);
                current.setPrevious(newNode);
                // be carefull, there cannot exist a next of previous, can be null
                // this case is when head is current
                if (head == current) {
                    head = newNode;
                } else {
                    newNode.getPrevious().setNext(newNode);
                }

                /*EmployeeNodeDoublyLinkedList existingNode = new EmployeeNodeDoublyLinkedList(existingEmployee);
                EmployeeNodeDoublyLinkedList newNode = new EmployeeNodeDoublyLinkedList(newEmployee);

                newNode.setNext(existingNode);
                newNode.setPrevious(existingNode.getPrevious());
                existingNode.getPrevious().setNext(newNode);
                existingNode.setPrevious(newNode);*/

                size++;

                return true;
            }

            public void addToFront(Employee employee) {
                EmployeeNodeDoublyLinkedList node = new EmployeeNodeDoublyLinkedList(employee);

                if (head == null) {
                    tail = node;
                } else {
                    head.setPrevious(node);
                    node.setNext(head);
                }

                head = node;
                size++;
            }

            public EmployeeNodeDoublyLinkedList removeFromEnd() {
                if (isEmpty()) {
                    return null;
                }

                EmployeeNodeDoublyLinkedList removedNode = tail;

                if (tail.getPrevious() == null) {
                    head = null;
                } else {
                    tail.getPrevious().setNext(null);
                }

                tail = tail.getPrevious();
                size--;
                removedNode.setPrevious(null);
                return removedNode;
            }

            public EmployeeNodeDoublyLinkedList removeFromFront() {
                if (isEmpty()) {
                    return null;
                }

                EmployeeNodeDoublyLinkedList removedNode = head;

                if (head.getNext() == null) {
                    tail = null;
                } else {
                    head.getNext().setPrevious(null);
                }

                head = removedNode.getNext();
                size--;
                removedNode.setNext(null);
                return removedNode;
            }

            public int getSize() {
                return size;
            }

            public boolean isEmpty() {
                return head == null;
            }

            public void printList() {
                EmployeeNodeDoublyLinkedList current = head;
                System.out.print("HEAD -> " );
                while (current != null) {
                    System.out.print(current);
                    System.out.print(" <-> ");
                    current = current.getNext();
                }
                System.out.println("null");
            }
        }

        EmployeeDoublyLinkedList employeeDoublyLinkedList = new EmployeeDoublyLinkedList();

        employeeDoublyLinkedList.addToFront(janeJones);
        employeeDoublyLinkedList.addToFront(johnDoe);
        employeeDoublyLinkedList.addToFront(marySmith);
        employeeDoublyLinkedList.addToFront(mikeWilson);

        employeeDoublyLinkedList.printList();
        System.out.println(employeeDoublyLinkedList.size);

        Employee billEnd = new Employee("Bill", "End", 78);
        employeeDoublyLinkedList.addToEnd(billEnd);
        employeeDoublyLinkedList.printList();
        System.out.println(employeeDoublyLinkedList.size);


        employeeDoublyLinkedList.removeFromFront();
        employeeDoublyLinkedList.printList();
        System.out.println(employeeDoublyLinkedList.size);

        employeeDoublyLinkedList.removeFromEnd();
        employeeDoublyLinkedList.printList();
        System.out.println(employeeDoublyLinkedList.size);

        System.out.println("----> The JDK LinkedList class <----");
        // doubly linked list

        LinkedList<Employee> linkedList = new LinkedList<>();
        linkedList.addFirst(janeJones);
        linkedList.addFirst(johnDoe);
        linkedList.addFirst(marySmith);
        linkedList.addFirst(mikeWilson);

        Iterator<Employee> iterator = linkedList.iterator();
        System.out.println("HEAD -> ");
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
            System.out.println("<=>");
        }
        System.out.println("null");

        //for (Employee employee : linkedList) {
        //    System.out.println(employee);
        //}

        linkedList.addFirst(billEnd);
        // LinkedList::add() add to last
        // or we can use LinkedList::addLast()
        // TIP: Take a look to declaration and to AbstractSequentialList and Node
        linkedList.removeFirst(); // or linkedList.remove();
        linkedList.removeLast();

        // TIP: ALWAYS CHECK THE DOCUMENTATION

        iterator = linkedList.iterator();
        System.out.println("HEAD -> ");
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
            System.out.println("<=>");
        }
        System.out.println("null");

        // does exists circular linked list which the last element will point to first element and singly linked list

        // Challenge 1) Implement the addBefore() method for the EmployeeDoublyLinkedList class
        employeeDoublyLinkedList.printList();
        System.out.println(employeeDoublyLinkedList.getSize());
        employeeDoublyLinkedList.addBefore(mikeWilson, marySmith);
        employeeDoublyLinkedList.printList();
        System.out.println(employeeDoublyLinkedList.getSize());


        // Challenge 2)
        /*
        Implement a method in the IntegerLinkedList class that inserts a value in sorted order
        Lower values should appear first in the list (be closer to the head)
        If we insert 4, 2, 1, 5, list should look like HEAD->1->2->4->5->null
        IntegerLinkedList is a singly-linked list
         */

        class IntegerNode {

            private Integer value;
            private IntegerNode next;

            public IntegerNode(Integer value) {
                this.value = value;
            }

            public Integer getValue() {
                return value;
            }

            public void setValue(Integer value) {
                this.value = value;
            }

            public IntegerNode getNext() {
                return next;
            }

            public void setNext(IntegerNode next) {
                this.next = next;
            }

            public String toString() {
                return value.toString();
            }

        }


        class IntegerLinkedList {

            private IntegerNode head;
            private int size;

            public void addToFront(Integer value) {
                IntegerNode node = new IntegerNode(value);
                node.setNext(head);
                head = node;
                size++;
            }

            public IntegerNode removeFromFront() {
                if (isEmpty()) {
                    return null;
                }

                IntegerNode removedNode = head;
                head = head.getNext();
                size--;
                removedNode.setNext(null);
                return removedNode;
            }

            public void insertSorted(Integer value) {
                // assumption: the list is sorted
                if (head == null || head.getValue() >= value) {
                    addToFront(value);
                    return;
                }

                // find the insertion point
                IntegerNode current = head.getNext();
                IntegerNode previous = head;
                while (current != null && current.getValue() < value) {
                    previous = current;
                    current = current.getNext();
                }

                IntegerNode newNode = new IntegerNode(value);
                newNode.setNext(current);
                previous.setNext(newNode);

                size++;
            }

            public int getSize() {
                return size;
            }

            public boolean isEmpty() {
                return head == null;
            }

            public void printList() {
                IntegerNode current = head;
                System.out.print("HEAD -> ");
                while (current != null) {
                    System.out.print(current);
                    System.out.print(" -> ");
                    current = current.getNext();
                }
                System.out.println("null");
            }

        }


        Integer one = 1;
        Integer two = 2;
        Integer three = 3;
        Integer four = 4;

        IntegerLinkedList integerLinkedList = new IntegerLinkedList();
        integerLinkedList.insertSorted(three);
        integerLinkedList.printList();
        integerLinkedList.insertSorted(one);
        integerLinkedList.printList();
        integerLinkedList.insertSorted(two);
        integerLinkedList.printList();
        integerLinkedList.insertSorted(four);
        integerLinkedList.printList();


        System.out.println("----> Stacks <----");

        // Stack
        // Abstract data type
        // LIFO - Last in, first out
        // push - adds an item as the top item on the stack
        // pop - removes the top item on the stack
        // peek - gets the top item on the stack without popping it
        // Ideal backing data structure: linked list

        // O(1) for push, pop and peek, when using a linked list
        // if u use an array, then push is O(n), because the array
        // may have to be resized
        // If you know the maximum number of items that will
        // ever be on the stack, an array can be a good choise
        // if memory is tight, an array might be a good choice
        // Linked list is ideal

        class ArrayStack {

            private Employee[] stack;
            private int top;

            public ArrayStack(int capacity) {
                stack = new Employee[capacity];
            }

            public void push(Employee employee) {
                if (top == stack.length) {
                    // need to resize the backing array
                    Employee[] newArray = new Employee[2 * stack.length];
                    System.arraycopy(stack, 0, newArray, 0, stack.length);
                    stack = newArray;
                }

                stack[top++] = employee;
            }

            public Employee pop() {
                if (isEmpty()) {
                    throw new EmptyStackException();
                }

                Employee employee = stack[--top];
                stack[top] = null;
                return employee;
            }

            public Employee peek() {
                if (isEmpty()) {
                    throw new EmptyStackException();
                }

                return stack[top - 1];
            }

            public int size() {
                return top;
            }

            public boolean isEmpty() {
                return top == 0;
            }

            public void printStack() {
                for (int i = top - 1; i >= 0; i--) {
                    System.out.println(stack[i]);
                }
            }
        }


        ArrayStack stack = new ArrayStack(10);

        stack.push(new Employee("Jane", "Jones", 123));
        stack.push(new Employee("John", "Doe", 4567));
        stack.push(new Employee("Mary", "Smith", 22));
        stack.push(new Employee("Mike", "Wilson", 3245));
        stack.push(new Employee("Bill", "End", 78));

        stack.printStack();
        System.out.println("Peek: ");
        System.out.println(stack.peek());
        System.out.println("Pop: ");
        System.out.println(stack.pop());

        class LinkedStack {
            private LinkedList<Employee> stack;

            public LinkedStack() {
                stack = new LinkedList<>();
            }

            public void push(Employee employee) {
                stack.push(employee);
            }

            public Employee pop() {
                return stack.pop();
            }

            public Employee peek() {
                return stack.peek();
            }

            public boolean isEmpty() {
                return stack.isEmpty();
            }

            public void printStack() {
                ListIterator<Employee> iterator = stack.listIterator();
                while (iterator.hasNext()) {
                    System.out.println(iterator.next());
                }
            }
        }

        System.out.println("----> Linked List Stack <----");

        // constant time O(1) working with LinkedList
        LinkedStack linkedStack = new LinkedStack();
        linkedStack.push(janeJones);
        linkedStack.push(johnDoe);
        linkedStack.push(marySmith);
        linkedStack.push(mikeWilson);
        linkedStack.push(billEnd);

        linkedStack.printStack();
        System.out.println("Peek: " + linkedStack.peek());
        linkedStack.printStack();
        System.out.println("Pooped: " + linkedStack.pop());
        linkedStack.printStack();

        // Stack Challenge
        // Using a stack, determine whether a string is palindrome
        // Strings may contain punctuation and spaces. They should be ignored
        // Case should be ignored

        System.out.println(checkForPalindrome("aabbaa"));


        System.out.println("----> Queues <----");

        // Abstract data type
        // FIFO - first in, first out
        // add - also called enqueue - add an item to the end of the queue
        // remove - also called dequeue - remove the item at the front of the queue
        // peek - get the item at the front of the queue, but don't remove it

        // O(n) if implementation use array
        // O(1) if implementation use linked lists
        // exactly as stacks

        class ArrayQueue {
            private Employee[] queue;
            private int front;
            private int back;

            public ArrayQueue(int capacity) {
                queue = new Employee[capacity];
            }

            public void add(Employee employee) {
                // queue is full
                // resize again and again if we remove and add again and again
                // see Circular Queue for optimization
                if (back == queue.length) {
                    Employee[] newArray = new Employee[2 * queue.length];
                    System.arraycopy(queue, 0, newArray, 0, queue.length);
                    queue = newArray;
                }

                queue[back] = employee;

                back++;
            }

            public Employee remove() {
                if (size() == 0) {
                    throw new NoSuchElementException();
                }

                Employee employee = queue[front];
                queue[front] = null;
                front++;
                // if we deleted single item from queue we can reset those
                if (size() == 0) {
                    front = 0;
                    back = 0;
                }

                return employee;
            }

            public Employee peek() {
                if (size() == 0) {
                    throw new NoSuchElementException();
                }

                return queue[front];
            }

            public int size() {
                return back - front;
            }

            public void printQueue() {
                for (int i = front; i < back; i++) {
                    System.out.println(queue[i]);
                }
                //for (Employee employee : queue) {
                //    System.out.println(employee);
                //}
            }
        }

        ArrayQueue arrayQueue = new ArrayQueue(10);
        arrayQueue.add(janeJones);
        arrayQueue.add(johnDoe);
        arrayQueue.add(marySmith);
        arrayQueue.add(mikeWilson);
        arrayQueue.add(billEnd);

        arrayQueue.printQueue();

        System.out.println("---------------");
        System.out.println("Removing 2 items from Array Queue:");
        arrayQueue.remove();
        arrayQueue.remove();

        arrayQueue.printQueue();

        System.out.println("-----------------");

        System.out.println("Peek: " + arrayQueue.peek());

        System.out.println("----------------");
        System.out.println("Deleting the remaining 3 items");
        for (int i = 0; i < 3; i++) {
            arrayQueue.remove();
        }
        arrayQueue.printQueue();

        // if we remove now, we will get a NoSuchElementException
        //arrayQueue.remove();

        System.out.println("Something wrong with implementation so let's see -->");
        arrayQueue.add(janeJones);
        arrayQueue.add(johnDoe);
        arrayQueue.remove();
        arrayQueue.add(marySmith);
        arrayQueue.remove();
        arrayQueue.add(mikeWilson);
        arrayQueue.printQueue();

        System.out.println("----> Circular Queue <----");

        class CircularQueue {
            private Employee[] queue;
            private int front;
            private int back;

            public CircularQueue(int capacity) {
                queue = new Employee[capacity];
            }

            public void add(Employee employee) {
                // queue is full
                // OLD: back == queue.length --> will resize again and again if we remove and add again and again
                if (size() == queue.length - 1) {
                    int numItems = size();
                    Employee[] newArray = new Employee[2 * queue.length];

                    System.arraycopy(queue, front, newArray, 0, queue.length - front);
                    System.arraycopy(queue, 0, newArray, queue.length - front, back);

                    queue = newArray;

                    front = 0;
                    back = numItems;
                }

                // 0
                // 1 - john -- front
                // 2  - mary
                // 3  // back
                // 4
                // 5
                // 6
                // 7
                // ..
                // 9

                queue[back] = employee;
                // optimization
                if (back < queue.length - 1) {
                    back++;
                } else {
                    back = 0;
                }
            }

            public Employee remove() {
                if (size() == 0) {
                    throw new NoSuchElementException();
                }

                Employee employee = queue[front];
                queue[front] = null;
                front++;
                // if we deleted single item from queue we can reset those
                if (size() == 0) {
                    front = 0;
                    back = 0;
                } else if (front == queue.length) {
                    front = 0;
                }

                return employee;
            }

            public Employee peek() {
                if (size() == 0) {
                    throw new NoSuchElementException();
                }

                return queue[front];
            }

            public int size() {
                if (front <= back) {
                    return back - front;
                } else {
                    return back - front + queue.length;
                }
            }

            public void printQueue() {
                if (front <= back) {
                    for (int i = front; i < back; i++) {
                        System.out.println(queue[i]);
                    }
                } else {
                    for (int i = front; i < queue.length; i++) {
                        System.out.println(queue[i]);
                    }
                    for (int i = 0; i < back; i++) {
                        System.out.println(queue[i]);
                    }
                }
                //for (Employee employee : queue) {
                //    System.out.println(employee);
                //}
            }
        }



        CircularQueue circularQueue = new CircularQueue(4);
        circularQueue.add(janeJones);
        circularQueue.add(johnDoe);
        circularQueue.printQueue();
        System.out.println(circularQueue.size());
        System.out.println("----------REMOVE----------");
        circularQueue.remove();
        circularQueue.printQueue();
        System.out.println(circularQueue.size());
        System.out.println("-----------ADD-------");
        circularQueue.add(marySmith);
        circularQueue.printQueue();
        System.out.println(circularQueue.size());
        System.out.println("-----------REMOVE-------");
        circularQueue.remove();
        circularQueue.printQueue();
        System.out.println(circularQueue.size());
        System.out.println("---------ADD----------");
        circularQueue.add(mikeWilson);
        circularQueue.printQueue();
        System.out.println(circularQueue.size());
        System.out.println("---------REMOVE----------");
        circularQueue.remove();
        circularQueue.printQueue();
        System.out.println(circularQueue.size());
        System.out.println("------------ADD------");
        circularQueue.add(billEnd);
        circularQueue.printQueue();
        System.out.println(circularQueue.size());
        System.out.println("----------REMOVE--------");
        circularQueue.remove();
        circularQueue.printQueue();
        System.out.println(circularQueue.size());
        System.out.println("---------------------");

        System.out.println("----> JDK Queues <----");
        // about ConcurrentLinkedQueue and ConcurrentArrayQueue -- documentation
        // ConcurrentLinkedQueue::size() is not constant time

        // Deque interface -- Double ended queue

        // Queues challenge
        // Using a stack and a queue, determine whether a string is a palindrome
        // stirng may contain punctuation and spaces. They should be ignored.
        // Case should be ignore

        System.out.println("Challenge Queues: ");

        System.out.println("Check for palindrome using a stack and a queue: ");
        System.out.println("aabbaa: " + checkForPalindromeQueueAndStack("aabbaa"));
        System.out.println("dad: " + checkForPalindromeQueueAndStack("dad"));
        System.out.println("dade: " + checkForPalindromeQueueAndStack("dade"));

        System.out.println("----> Hash tables <----");

        // abstract data type
        // provide access to data using keys
        // key doesn't have to be an integer
        // consists of key/value pairs - data types don't have to match
        // optimized for retrieval (when you know the key)
        // associative array is one type of hash table


        // Hashing
        // Maps keys of any data type to an integer
        // Hash function maps keys to int
        // In Java, hash function is Object.hashCode()
        // Collision occurs when more than one value has the same hashed value

        // Load Factor
        // Tells us how full a hash table is
        // Load factor = # of items / capacity = size / capacity
        // Load factor is used to decide when to resize the array backing the hash table
        // Don't want load factor too low (lots of empty space)
        // Don't want load factor too high (will increase the likelihood of collisions)
        // Can play a role in determining the time complexity for retrieval

        // Add to a Hash Table backed by an array
        // 1) Provide a key/value pair
        // 2) Use a hash function to hash the key to an int value
        // 3) Store the value at the hashed key value - this is the index into the array

        // Retrieve a value from a hash table
        // 1) Provide the key
        // 2) Use the same hash function to hash the key to an int value
        // 3) Retrieve the value stored at the hashed key value


        // Add "Jane Jones" with key of "Jones"
        // 1) Use a hash function to map "Jones" to an int - let's assume we get the value 4
        // 2) Store "Jane "Jones" at array[4]

        // Retrieve the employee with key "Jones"
        // 1) Provide the key "Jones"
        // 2) Use the same hash function to map "Jones" to an int - let's assume we get the value 4
        // 3) Retrieve the value at array[4] -> "Jane Jones"

        // Array implementation of Singly Hash tables

        class StoredEmployee {
            public String key;
            public Employee employee;

            public StoredEmployee(String key, Employee employee) {
                this.key = key;
                this.employee = employee;
            }
        }

        class SimpleHashTable {
            private StoredEmployee[] hashtable;

            public SimpleHashTable(int capacity) {
                hashtable = new StoredEmployee[capacity];
            }

            public void put(String key, Employee employee) {
                int hashedKey = hashKey(key);
                if (occupied(hashedKey)) {
                    int stopIndex = hashedKey;
                    if (hashedKey == hashtable.length - 1) {
                        hashedKey = 0;
                    } else {
                        hashedKey++;
                    }

                    while (occupied(hashedKey) && hashedKey != stopIndex) {
                        hashedKey = (hashedKey + 1) % hashtable.length;
                    }
                }

                if (occupied(hashedKey)) {
                    System.out.println("Sorry, there's already an employee at position " + hashedKey);
                } else {
                    hashtable[hashedKey] = new StoredEmployee(key, employee);
                }
            }

            public Employee get(String key) {
                int hashedKey = findKey(key);
                //if (hashtable[hashedKey] == null) {
                //    System.out.println("Sorry, there's not any employee at this position");
                //    return null;
                //}

                if (hashedKey == -1) {
                    return null;
                }

                return hashtable[hashedKey].employee;
            }

            private int findKey(String key) {
                int hashedKey = hashKey(key);
                if (hashtable[hashedKey] != null
                && hashtable[hashedKey].key.equals(key)) {
                    return hashedKey;
                }

                int stopIndex = hashedKey;
                if (hashedKey == hashtable.length - 1) {
                    hashedKey = 0;
                } else {
                    hashedKey++;
                }

                while (hashedKey != stopIndex &&
                        !hashtable[hashedKey].key.equals(key)) {
                    hashedKey = (hashedKey + 1) % hashtable.length;
                }

                if (hashtable[hashedKey] != null && hashtable[hashedKey].key.equals(key)) {
                    return hashedKey;
                } else {
                    return -1;
                }
            }


            private int hashKey(String key) {
                return key.length() % hashtable.length;
            }

            private boolean occupied(int index) {
                return hashtable[index] != null;
            }

            public void printHashtable() {
                for (int i = 0; i < hashtable.length; i++) {
                    if (hashtable[i] == null) {
                        System.out.println("Position " + i + " is empty");
                    } else {
                        System.out.println("Position " + i + " " + hashtable[i].employee);
                    }
                }
            }

            public Employee remove(String key) {
                int hashedKey = findKey(key);
                if (hashedKey == -1) {
                    return null;
                }

                Employee employee = hashtable[hashedKey].employee;
                hashtable[hashedKey] = null;


                StoredEmployee[] oldHashtable = hashtable;
                hashtable = new StoredEmployee[oldHashtable.length];
                for (int i = 0; i < oldHashtable.length; i++) {
                    if (oldHashtable[i] != null) {
                        put(oldHashtable[i].key, oldHashtable[i].employee);
                    }
                }



                return employee;
            }
        }

        SimpleHashTable simpleHashTable = new SimpleHashTable(10);
        simpleHashTable.put("Jones", janeJones);
        simpleHashTable.put("Doe", johnDoe);
        simpleHashTable.put("Wilson", mikeWilson);
        //simpleHashTable.put("Smith", marySmith); -- error

        simpleHashTable.printHashtable();

        System.out.println("Retrieve key Wilson: " + simpleHashTable.get("Wilson"));


        System.out.println("----> (HashTables) Handling collisions <----");

        // Linear Probing

        simpleHashTable.put("Smith", marySmith);
        simpleHashTable.printHashtable();

        System.out.println("Retrieve key Smith: " + simpleHashTable.get("Smith"));


        //class StoredEmployee {
        //public String key;
        //public Employee employee;
        //
        //          public StoredEmployee(String key, Employee employee) {
        //        this.key = key;
        //        this.employee = employee;
        //    }
        //}

        // Linear Probing - removing items

        simpleHashTable.remove("Wilson");
        simpleHashTable.remove("Jones");
        simpleHashTable.printHashtable();

        // Rehashing

        simpleHashTable.remove("Doe");
        System.out.println("After rehashing: ");
        simpleHashTable.printHashtable();

        System.out.println("Retrieve key Smith: " + simpleHashTable.get("Smith"));


        System.out.println("HashTables Challenge 2)");
        // Hashtables Challenge 2)
        // Remove duplicate items from a linked list
        // Your solution must use the jdk's LinkedList class
        // Your solution must use a HashMap
        HashMap<Integer, Employee> employees1 = new HashMap<>();
        employees1.put(1, johnDoe);
        employees1.put(2, marySmith);
        employees1.put(3, janeJones);
        employees1.put(1, johnDoe);
        HashMap<Integer, Employee> hashMap = new HashMap<>();
        List<Employee> remove = new ArrayList<>();
        employees1.entrySet().forEach(entry -> {
            if (hashMap.containsKey(entry.getKey())) {
                remove.add(entry.getValue());
            } else {
                hashMap.put(entry.getKey(), entry.getValue());
            }
        });

        for (Employee emp : remove) {
            employees1.remove(emp);
        }

        employees1.values().forEach(System.out::println);

        System.out.println(recursiveF(3, 5));
//
        //int n = 841;
        //int x = 1;
        //for (int i = 0; i < 50; i++) {
        //    int nx = (x + n / x) / 2;
        //    x = nx;
        //}
        //System.out.println("X: " + x);
//
        //System.out.println("Count values for " + countValues(256));




        //class ItemSeparator {
        //    private String itemName;
        //    private double price;
        //    private int quantity;
//
        //    public ItemSeparator(String rawInput) {
        //        handleRawInput(rawInput);
        //    }
//
        //    public ItemSeparator(String itemName, double price, int quantity) {
        //        this.itemName = itemName;
        //        this.price = price;
        //        this.quantity = quantity;
        //    }
//
        //    public String getName() {
        //        return this.itemName;
        //    }
//
        //    public double getPrice() {
        //        return this.price;
        //    }
//
        //    public int getQuantity() {
        //        return this.quantity;
        //    }
//
        //    private void handleRawInput(String rawInput) {
        //        String[] stringSplitted = rawInput.split("$$##");
        //        this.itemName = stringSplitted[0];
        //        this.price = Double.parseDouble(stringSplitted[1]);
        //        this.quantity = Integer.parseInt(stringSplitted[2]);
        //    }
        //}

        //ItemSeparator itemData = new ItemSeparator("Bread$$##12.5$$##10");
        //System.out.println("Item Name: " + itemData.getName());
        //System.out.println("Item Price: " + itemData.getPrice());
        //System.out.println("Item Quantity: " + itemData.getQuantity());

        System.out.println("----> Search Algorithms <----");

        System.out.println("----> Linear Search Algorithm <----");
        System.out.println(linearSearch(arrayList(), 3));
        System.out.println(linearSearch(arrayList(), 10));
        System.out.println(linearSearch(arrayList(), -1));

        System.out.println("----> Binary Search Algorithm <----");

        // Data must be sorted!
        // Chooses the element in the middle of the array and compares it against the search value
        // if element is equal to the value, we're done
        // If element is greater than the value, search the left half of the array
        // If the element is less than the value, search the right half of the array

        System.out.println("iterative way");

        System.out.println(iterativeBinarySearch(Arrays.stream(arrayList()).sorted().toArray(), 4));
        System.out.println(iterativeBinarySearch(Arrays.stream(arrayList()).sorted().toArray(), 6));
        System.out.println(iterativeBinarySearch(Arrays.stream(arrayList()).sorted().toArray(), 10));

        System.out.println("Recursive way");
        int[] intarray = Arrays.stream(arrayList()).sorted().toArray();
        System.out.println(recursiveBinarySearch(intarray, 0, intarray.length, -1));
        System.out.println(recursiveBinarySearch(intarray, 0, intarray.length, 15));
        System.out.println(recursiveBinarySearch(intarray, 0, intarray.length, 6));

        System.out.println("----> Trees <----");
        // every circle is called a node
        // nodes can have childrens
        // a node can have only a parent
        // the node at the top of the tree is the root
        // a leaf node has no children
        // a singleton tree has only one node - the root
        // depth of a node is the number of edges
        // root have depth 0
        // and etc etc
        // heigth of a tree is the number of edges of the longest path from a root to a leaf
        // leaf nodes will have a heigth of 0

        System.out.println("----> Binary Search Trees <----");
        // every node has 0,1 or 2 children
        // children are referred to as left child and right child
        // in practice, we use binary search trees

        // complete tree - every level except the last level
        // is completly filled

        // complete binary tree - every level except the last must have 2 childrens

        // can perform insertions, deletions and retrievals in O(logn) time
        // the left child always has a smaller value  than its parent
        // the right child always has a larger value than its parent
        // this means everything to the left of the root is less than the
        // value of the root and everything to the right of the root is greater than the value of the root
        // because of that, we can do a binary search

        // AVL trees and red-black trees are the most common trees which are balancing automaticaly
        // they shift elements when they are going to whack

        // so: a good way for using a binary tree is when you don't have much difference between left side and right side
        // because if elements are ordered, you will have a linked list , so search will be in O(n) not O(logn), duh?

        // the maximum is on the right side and minimum on the left side


        class TreeNode {
            private int data;
            private TreeNode leftChild;
            private TreeNode rightChild;

            public TreeNode(int data) {
                this.data = data;
            }

            public TreeNode get(int value) {
                if (value == data) {
                    return this;
                }

                if (value < data) {
                    if (leftChild != null) {
                        return leftChild.get(value);
                    }
                } else {
                    if (rightChild != null) {
                        return rightChild.get(value);
                    }
                }

                return null;
            }

            public void insert(int value) {
                if (value == data) {
                    return;
                }

                if (value < data) {
                    if (leftChild == null) {
                        leftChild = new TreeNode(value);
                    } else {
                        leftChild.insert(value);
                    }
                } else {
                    if (rightChild == null) {
                        rightChild = new TreeNode(value);
                    } else {
                        rightChild.insert(value);
                    }
                }
            }

            public void traversalInOrder() {
                if (leftChild != null) {
                    leftChild.traversalInOrder();
                }
                System.out.print(", " + data);

                if (rightChild != null) {
                    rightChild.traversalInOrder();
                }
            }

            public int min() {
                if (leftChild == null) {
                    return data;
                } else {
                    return leftChild.min();
                }
            }

            public int max() {
                if (rightChild == null) {
                    return data;
                } else {
                    return rightChild.max();
                }
            }

            public int getData() {
                return data;
            }

            public void setData(int data) {
                this.data = data;
            }

            public TreeNode getLeftChild() {
                return leftChild;
            }

            public void setLeftChild(TreeNode leftChild) {
                this.leftChild = leftChild;
            }

            public TreeNode getRightChild() {
                return rightChild;
            }

            public void setRightChild(TreeNode rightChild) {
                this.rightChild = rightChild;
            }
        }

        class Tree {
            private TreeNode root;

            public void insert(int value) {
                if (root == null) {
                    root = new TreeNode(value);
                } else {
                    root.insert(value);
                }
            }

            public void traverseInOrder() {
                if (root != null) {
                    root.traversalInOrder();
                }
            }

            public TreeNode get(int value) {
                if (root != null) {
                    return root.get(value);
                }

                return null;
            }

            public int min() {
                if (root == null) {
                    return Integer.MIN_VALUE;
                } else {
                    return root.min();
                }
            }

            public int max() {
                if (root == null) {
                    return Integer.MAX_VALUE;
                } else {
                    return root.max();
                }
            }

            public void delete(int value) {
                root = delete(root, value);
            }

            private TreeNode delete(TreeNode subtreeRoot, int value) {
                if (subtreeRoot == null) {
                    return subtreeRoot;
                }
                if (value < subtreeRoot.getData()) {
                    subtreeRoot.setLeftChild(delete(subtreeRoot.getLeftChild(), value));
                } else if (value > subtreeRoot.getData()) {
                    subtreeRoot.setRightChild(delete(subtreeRoot.getRightChild(), value));
                } else {
                    // Cases 1 and 2: node to delete has 0 or 1 children
                    if (subtreeRoot.getLeftChild() == null) {
                        return subtreeRoot.getRightChild();
                    } else if (subtreeRoot.getRightChild() == null) {
                        return subtreeRoot.getLeftChild();
                    }
                    // Case 3: node to delete has 2 children

                    // Replace the value in the subtreeRoot node with the smallest value
                    // from the right subtree
                    subtreeRoot.setData(subtreeRoot.getRightChild().min());

                    // Delete the node that has the smallest value in the right subtree
                    subtreeRoot.setRightChild(delete(subtreeRoot.getRightChild(), subtreeRoot.getData()));
                }

                return subtreeRoot;
            }


        }

        Tree tree = new Tree();
        tree.insert(25);
        tree.insert(20);
        tree.insert(15);
        tree.insert(27);
        tree.insert(30);
        tree.insert(29);
        tree.insert(26);
        tree.insert(22);
        tree.insert(32);

        // traversal

        // Level - visit nodes on each level
        // Pre-order - visit the root of every subtree first
        // In-order - visit left child, then root, then right child
        // Post-order - visit the root of every subtree last


        // level : 25, 20, 27, 15, 22, 26, 30, 29, 32

        // pre order: 25, 20, 15, 22, 27, 26, 30, 29, 32

        // in order: 15, 20, 22, 25, 26, 27, 29, 30, 32

        // post order: 15, 22, 20, 26, 29, 32, 30, 27, 25
        System.out.println("== Traverse In-Order ==");
        tree.traverseInOrder();
        System.out.println();

        System.out.println(tree.get(27));
        System.out.println(tree.get(17));
        System.out.println(tree.get(8888));

        System.out.println();

        System.out.println("Min= " + tree.min());
        System.out.println("Max= " + tree.max());

        // Delete
        // 1. Node is a leaf
        // 2. Node has one child
        // 3. Node has two children



        // Delete node with two children
        // Need to figure out what the replacement node will be
        // Want minimal disruption to the existing tree structure
        // Can take the replacement node from the deleted node's left subtree
        // or right subtree
        // If taking it from the left subtree, we have to take the largest value in the left subtree
        // if taking it from the right subtree, we have to take the smallest value
        // in the right subtree
        // Choose one and stick to it


        System.out.println("=== Deleting ===");
        System.out.println("case 2");
        tree.delete(15);
        tree.traverseInOrder();
        System.out.println();

        System.out.println("case 1");
        tree.delete(27);
        tree.traverseInOrder();
        System.out.println();

        System.out.println("case 3");
        tree.delete(25);
        tree.traverseInOrder();
        System.out.println();

        System.out.println("case when node does not exist");
        tree.delete(8888);
        tree.traverseInOrder();
        System.out.println();


        // JDK Classes

        // TreeMap -- Red-Black Tree based
        // get,put,remove - log(n)
        // not syncronised - use collections

        // TreeSet - based on TreeMap




    }

    public static int recursiveBinarySearch(int[] input, int start, int end, int value) {
        if (start >= end) {
            return -1;
        }

        int midpoint = (start + end) / 2;
        System.out.println("midpoint = " + midpoint);

        if (input[midpoint] == value) {
            return midpoint;
        } else if (input[midpoint] < value) {
            recursiveBinarySearch(input, midpoint + 1, end, value);
        } else if (input[midpoint] > value) {
            recursiveBinarySearch(input, start, midpoint, value);
        }

        return -1;
    }

    public static int iterativeBinarySearch(int[] input, int value) {
        int start = 0;
        int end = input.length;

        while (start < end) {
            int midpoint = (start + end) / 2;
            System.out.println("midpoint = " + midpoint);
            if (input[midpoint] == value) {
                return midpoint;
            } else if (input[midpoint] < value) {
                start = midpoint + 1;
            } else if (input[midpoint] > value) {
                end = midpoint;
            }
        }
        return -1;
    }

    public static int linearSearch(int[] input, int value) {
        for (int i = 0; i < input.length; i++) {
            if (input[i] == value) {
                return i;
            }
        }
        return -1;
    }

    public static int countValues(int n) {
        int count = 0;
        for (int i = 0; i <= n; i++) {
            for (int j = i; j <= n; j++) {
                count++;
            }
        }
        return count;
    }


    public static int recursiveF(int a, int b) {
        if (b == 0) {
            return 1;
        }
        int temp = recursiveF(a, b / 2);
        if (b % 2 != 0) {
            return temp * temp * a;
        } else {
            return temp * temp;
        }
    }

    public static boolean checkForPalindromeQueueAndStack(String string) {
        String lowerCase = string.toLowerCase();

        LinkedList<Character> linkedStack = new LinkedList<>();
        LinkedList<Character> linkedQueue = new LinkedList<>();
        for (int i = 0; i < lowerCase.length(); i++) {
            char c = lowerCase.charAt(i);
            if (c >= 'a' && c <= 'z') {
                linkedStack.push(c);
                linkedQueue.add(c);
            }
        }

        for (int i = 0; i < lowerCase.length(); i++) {
            char c = lowerCase.charAt(i);
            if (c >= 'a' && c <= 'z') {
                if (!linkedStack.pop().equals(linkedQueue.remove())) {
                    return false;
                }
            }
        }

        return true;
    }

    public static boolean checkForPalindrome(String string) {
        StringBuilder stringBuilder = new StringBuilder(string.length());
        String lowerCase = string.toLowerCase();

        LinkedList<Character> stack = new LinkedList<>();

        for (int i = 0; i < lowerCase.length(); i++) {
            char c = lowerCase.charAt(i);
            if (c >= 'a' && c <= 'z') {
                stringBuilder.append(c);
                stack.push(c);
            }
        }

        StringBuilder reversedString = new StringBuilder(stack.size());
        while (!stack.isEmpty()) {
            reversedString.append(stack.pop());
        }

        return reversedString.toString().equals(stringBuilder.toString());
    }

    public static void radixSort(int[] input, int min, int max) {

    }

    // unstable implemntation
    public static void countingSort(int[] input, int min, int max) {
        int[] countingArray = new int[(max - min) + 1];

        for (int i = 0; i < input.length; i++) {
            countingArray[input[i] - min]++;
        }

        int j = 0;
        for (int i = min; i <= max; i++) {
            while (countingArray[i - min] > 0) {
                input[j++] = i;
                countingArray[i - min]--;
            }
        }

        Arrays.stream(input).forEach(System.out::println);
    }

    public static void quickSort(int[] input, int start, int end) {
        if (end - start < 2) {
            return;
        }

        int pivotIndex = partition(input, start, end);
        quickSort(input, start, pivotIndex);
        quickSort(input, pivotIndex + 1, end);

        Arrays.stream(input).forEach(System.out::println);
    }

    public static int partition(int[] input, int start, int end) {
        // This is using the first element as the pivot
        int pivot = input[start];
        int i = start;
        int j = end;

        while (i < j) {
            // NOTE: empty loop body
            while (i < j && input[--j] >= pivot);

            if (i < j) {
                input[i] = input[j];
            }

            // NOTE: empty loop body
            while (i < j && input[++i] <= pivot);

            if (i < j) {
                input[j] = input[i];
            }
        }

        input[j] = pivot;

        return j;
    }

    public static int[] mergeSort(int[] input, int start, int end, boolean reverse) {

        if (end - start < 2) {
            return input;
        }

        int mid = (start + end) / 2;
        if (!reverse) {
            mergeSort(input, start, mid, false);
            mergeSort(input, mid, end, false);
            merge(input, start, mid, end);
        } else {
            mergeSort(input, start, mid, true);
            mergeSort(input, mid, end, true);
            mergeReverse(input, start, mid, end);
        }

        return input;
    }

    public static void mergeReverse(int[] input, int start, int mid, int end) {
        if (input[mid - 1] >= input[mid]) {
            return;
        }

        int i = start;
        int j = mid;
        int tempIndex = 0;

        int[] temp = new int[end - start];
        while (i < mid && j < end) {
            temp[tempIndex++] = input[i] >= input[j] ? input[i++] : input[j++];
        }

        // ( 34, 32 ), ( 36, 33 )
        // ( 34, 32,
        System.arraycopy(input, i, input, start + tempIndex, mid - i);
        System.arraycopy(temp, 0, input, start, tempIndex);
    }

    public static void merge(int[] input, int start, int mid, int end) {
        if (input[mid - 1] <= input[mid]) {
            return;
        }

        int i = start;
        int j = mid;
        int tempIndex = 0;

        int[] temp = new int[end - start];
        while (i < mid && j < end) {
            temp[tempIndex++] = input[i] <= input[j] ? input[i++] : input[j++];
        }

        // ( 32, 34 ), ( 33, 36 )
        // ( 32, 33, 34, and 36 next but not needed bcs is the same position as original
        System.arraycopy(input, i, input, start + tempIndex, mid - i);
        System.arraycopy(temp, 0, input, start, tempIndex);

        //Arrays.stream(input).forEach(System.out::println);
    }

    public static int recursiveFactorial(int num) {
        if (num == 0) {
            return 1;
        }

        return num * recursiveFactorial(num - 1);
    }

    public static int calculateFactorial(int num) {
        if (num == 0) {
            return 1;
        }

        int factorial = 1;
        for (int i = 1; i <= num; i++) {
            factorial *= i;
        }

        return factorial;
    }

    public static void shellShort() {
        int[] intArray = arrayList();
        int i, length = intArray.length;

        for (int gap = length / 2; gap > 0; gap /= 2) {
            for (i = gap; i < length; i++) {

                int newElement = intArray[i];

                int j = i;

                while (j >= gap && intArray[j - gap] > newElement) {
                    intArray[j] = intArray[j - gap];
                    j -= gap;
                }

                intArray[j] = newElement;
            }

        }

        printList(intArray);
    }

    public static void insertionSortRecursive(int[] intArray, int numItems) {

        if (numItems < 2) {
            return;
        }

        insertionSortRecursive(intArray, numItems - 1);

        int newElement = intArray[numItems - 1];

        int i;

        for (i = numItems - 1; i > 0 && intArray[i - 1] > newElement; i--) {
            intArray[i] = intArray[i - 1];
        }

        intArray[i] = newElement;

        Arrays.stream(intArray).forEach(System.out::println);
    }

    public static void insertionSort() {
        int[] intArray = arrayList();
        int i, length = intArray.length;

        for (int firstUnsortedIndex = 1; firstUnsortedIndex < length;
        firstUnsortedIndex++) {
            int newElement = intArray[firstUnsortedIndex];

            for (i = firstUnsortedIndex; i > 0 &&
                    intArray[i - 1] > newElement; i--) {
                intArray[i] = intArray[i - 1];
            }

            intArray[i] = newElement;
        }

        printList(intArray);
    }

    public static void selectionSort() {
        int[] arrayList = new int[100];
        int i;
        int j;
        Random random = new Random();
        for (i = 0; i < 100; i++) {
            arrayList[i] = random.nextInt(100);

        }

        int length = arrayList.length;

        for (int lastUnsortedElement = length - 1; lastUnsortedElement > 0;
        lastUnsortedElement--) {

            int largetItem = 0;

            for (j = 1; j <= lastUnsortedElement; j++) {
                if (arrayList[j] > arrayList[largetItem]) {
                    largetItem = j;
                }
            }

            swap(arrayList, largetItem, lastUnsortedElement);
        }

        for (i = 0; i < length - 1; i++) {
            System.out.println(arrayList[i]);
        }
    }

    public static void bubbleSort() {
        int[] arrayList = new int[100];
        int i;
        int j;
        Random random = new Random();
        for (i = 0; i < 100; i++) {
            arrayList[i] = random.nextInt(100);
        }

        int length = arrayList.length;

        for (int lastUnsortedElement = length - 1;
             lastUnsortedElement > 0; lastUnsortedElement--) {
            for (i = 0; i < lastUnsortedElement;
                 i++) {
                if (arrayList[i] > arrayList[i + 1]) {
                    swap(arrayList, i, i + 1);
                }
            }
        }

        for (i = 0; i < 100; i++) {
            System.out.println(arrayList[i]);
        }
    }

    public static void printList(int[] arraylist) {
        for (int i = 0; i < arraylist.length; i++) {
            System.out.println(arraylist[i]);
        }
    }

    public static int[] arrayList() {
        int[] arrayList = new int[100];
        int i;
        Random random = new Random();
        for (i = 0; i < 100; i++) {
            arrayList[i] = random.nextInt(100);

        }

        return arrayList;
    }

    public static void swap(int[] array, int i, int j) {
         if (i == j) {
             return;
         }

         int temp = array[i];
         array[i] = array[j];
         array[j] = temp;
    }
}
