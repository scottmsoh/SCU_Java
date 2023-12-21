import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

// GenericList class define
class GenericList<T> {
    private List<T> list = new ArrayList<>();

    // Add an element to the list
    public void add(T element) {
        list.add(element);
    }

    // Retrieve an element
    public T get(int index) {
        return list.get(index);
    }

    // Return the number of elements in the list
    public int size() {
        return list.size();
    }

    // Remove an element from the list by its value
    public void remove(T element) {
        list.remove(element);
    }

    // Reverse the order of elements in the list
    public void reverse() {
        List<T> reversedList = new ArrayList<>();
        for (int i = list.size() - 1; i >= 0; i--) {
            reversedList.add(list.get(i));
        }
        list = reversedList;
    }

    // Find and return the maximum element in the list
    public T findMax(Comparator<T> comparator) {
        if (list.isEmpty()) {
            return null;
        }
        T maxElement = list.get(0);
        for (T element : list) {
            if (comparator.compare(element, maxElement) > 0) {
                maxElement = element;
            }
        }
        return maxElement;
    }

    // Helper method to print the list elements
    public void printList() {
        for (T element : list) {
            System.out.println(element);
        }
    }
}

// Test class definition
public class OhMinseokA6 {
    public static void main(String[] args) {
        // Integer list operations
        GenericList<Integer> integerList = new GenericList<>();
        integerList.add(5);
        integerList.add(3);
        integerList.add(8);
        integerList.add(2);
        integerList.add(10);
        System.out.println("Original Integer List:");
        integerList.printList();

        integerList.remove(3);
        System.out.println("List after removing '3':");
        integerList.printList();

        integerList.reverse();
        System.out.println("Reversed Integer List:");
        integerList.printList();

        // String list operations
        GenericList<String> stringList = new GenericList<>();
        stringList.add("apple");
        stringList.add("banana");
        stringList.add("cherry");
        stringList.add("date");
        stringList.add("fig");
        System.out.println("Original String List:");
        stringList.printList();

        String maxString = stringList.findMax(String::compareTo);
        System.out.println("Maximum String: " + maxString);


        System.out.println("\nProgram Completed.");
    }
}
