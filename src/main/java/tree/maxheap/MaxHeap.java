/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tree.maxheap;

/**
 *
 * @author DELL
 */
public class MaxHeap {

    class Student implements Comparable<Student> {

        int id;
        String name;
        double score;

        public Student(int id, String name, double score) {
            this.id = id;
            this.name = name;
            this.score = score;
        }

        @Override
        public String toString() {
            return "Student{" + "id=" + id + ", name=" + name + ", score=" + score + '}';
        }

        @Override
        public int compareTo(Student other) {
            return Integer.compare(this.id, other.id);
        }

    }
    Student[] arr;
    int lastIndex;
    int capacity;

    public MaxHeap(int capacity) {
        this.capacity = capacity;
        this.lastIndex = -1;
        this.arr = new Student[capacity];
    }

    public MaxHeap() {
        this(10);
    }

    boolean isEmpty() {
        return lastIndex == -1;
    }

    boolean isFull() {
        return (lastIndex == capacity - 1);
    }

    int parent(int i) {
        return (i - 1) / 2;
    }

    int leftChild(int i) {
        return 2 * i + 1;
    }

    int rightChild(int i) {
        return 2 * i + 2;
    }

    void increaseCap() {
        int newCapacity = 2 * capacity;
        Student temp[] = new Student[newCapacity];
        for (int i = 0; i < capacity; i++) {
            temp[i] = arr[i];
        }
        arr = temp;
        capacity = newCapacity;
    }

    void insert(int id, String name, double score) {
        if (isFull()) {
            increaseCap();
        }
        arr[++lastIndex] = new Student(id, name, score);
        int parentIndex = parent(lastIndex);
        int childIndex = lastIndex;
        while (arr[childIndex].compareTo(arr[parentIndex]) > 0) {
            swap(arr, childIndex, parentIndex);
            childIndex = parentIndex;
            parentIndex = parent(childIndex);
        }
    }

    void heapifyUp(Student[] arr, int childIdx) {
        if (childIdx <= 0) {
            return;
        }
        int parentIdx = (childIdx - 1) / 2;
        if (arr[childIdx].id > arr[parentIdx].id) {
            swap(arr, parentIdx, childIdx);
            childIdx = parentIdx;
            heapifyUp(arr, childIdx);
        }

    }

    public Student poll() {
        if (isEmpty()) {
            return null;
        }
        Student item = arr[0];
        arr[0] = arr[lastIndex];
        lastIndex--;
        heapifyDown(arr, 0);
        return item;
    }

    void swap(Student[] students, int i, int j) {
        Student temp = students[i];
        students[i] = students[j];
        students[j] = temp;
    }

    void preOrderRec(int root) {
        if (root > lastIndex) {
            return;
        }
        if (isEmpty()) {
            System.out.println("the tree is empty");
        } else {
            //visit root
            System.out.println(arr[root] + " ");
            preOrderRec(2 * root + 1);
            preOrderRec(2 * root + 2);
        }
    }

    void preOrder() {
        preOrderRec(0);
    }

    void delete(int id) {
        deleteRec(arr, id);
    }

    void deleteRec(Student[] arr, int id) {
        int deleteIndex = -1;
        for (int i = 0; i <= lastIndex; i++) {
            if (arr[i].id == id) {
                deleteIndex = i;
                break;
            }
        }
        if (deleteIndex != -1) {
            arr[deleteIndex] = arr[lastIndex--];
            heapifyDown(arr, deleteIndex);
        }
    }

    void heapifyDown(Student[] arr, int parentIdx) {
        int largest = parentIdx;
        int left = leftChild(parentIdx);
        int right = rightChild(parentIdx);
        if (left <= lastIndex && arr[largest].id < arr[left].id) {
            largest = left;
        }
        if (right <= lastIndex && arr[largest].id < arr[right].id) {
            largest = right;
        }

        if (parentIdx == largest) {
            return;
        }
        swap(arr, parentIdx, largest);
        heapifyDown(arr, largest);

    }

    void heapifyHeapSort(Student arr[], int n, int i) {
        int largest = i;
        int left = leftChild(i);
        int right = rightChild(i);

        if (left < n && arr[left].score > arr[largest].score) {
            largest = left;
        }
        if (right < n && arr[right].score > arr[largest].score) {
            largest = right;
        }
        if (largest != i) {
            swap(arr, i, largest);
            heapifyHeapSort(arr, n, largest);
        }
    }

    void heapSort() {
        int n = lastIndex + 1;
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapifyHeapSort(arr, n, i);
        }
        for (int i = n - 1; i >= 0; i--) {
            swap(arr, 0, i);
            heapifyHeapSort(arr, i, 0);
        }
    }

    void displaySortedArray() {
        for (int i = 0; i <= lastIndex; i++) {
            System.out.println(arr[i]);
        }
    }

    public static void main(String[] args) {
        MaxHeap heap = new MaxHeap(5);
        heap.insert(3, "Alice", 85);
        heap.insert(2, "Bob", 92);
        heap.insert(4, "Charlie", 78);
        heap.insert(1, "Dave", 9);
        heap.insert(5, "Eve", 88);
        heap.insert(6, "Eve", 88);
        heap.insert(7, "Eve", 88);

        System.out.println("Max heap: ");
        heap.preOrder();

        System.out.println("\nPoll student: " + heap.poll());
        heap.preOrder();

        heap.delete(4);
        System.out.println("\nAfter deleting 4: ");
        heap.preOrder();

        System.out.println("\nSorted by score:");
        heap.heapSort();
        heap.displaySortedArray();
    }
}
