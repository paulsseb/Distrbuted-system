import java. util.*;
/*public class Sample {
    public static void main(String args[]) {
        // create an array list
        ArrayList al = new ArrayList();
        System.out.println("Initial size of al: " + al.size());
        // add elements to the array list
        al.add("C");
        al.add("A");
        al.add("E");
        al.add("B");
        al.add("D");
        al.add("F");
        al.add(1, "A2");
        al.add(0, "B2");
        System.out.println("Size of al after additions: " + al.size());
        // display the array list
        System. out. println("Contents of al: " + al);
        // Remove elements from the array list
        al. remove("F");
        al. remove(2);
        System. out. println("Size of al after deletions: " + al. size());
        System. out. println("Contents of al: " + al);
    }}*/

// Demonstrate iterators.

class Sample {
    public static void main(String args[]) {
        // create an array list
        ArrayList al = new ArrayList();
        // add elements to the array list
        al.add("C");
        al.add("A");
        al.add("E");
        al.add("B");
        al.add("D");
        al.add("F");
        // use iterator to display contents of al
        System.out.print("Original contents of al: ");
        Iterator itr = al.iterator();
        while(itr.hasNext()) {
            Object element = itr.next();
            System.out.print(element + " ");
        }
        System.out.println();
        // modify objects being iterated
        ListIterator litr = al.listIterator();
        while(litr.hasNext()) {
            Object element = litr.next();
            litr.set(element + "+");
        }
        System.out.print("Modified contents of al: ");
        itr = al.iterator();
        while(itr.hasNext()) {
            Object element = itr.next();
            System.out.print(element + " ");
        }
        System.out.println();
        // now, display the list backwards
        System.out.print("Modified list backwards: ");
        while(litr.hasPrevious()) {
            Object element = litr.previous();
            System.out.print(element + " ");
        }
        System.out.println();
    }
}