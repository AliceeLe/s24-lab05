package edu.cmu.cs.cs214.rec04;

/*
 * We have provided an empty DelegationSortedIntList class where you should 
 * implement your composition-based solution.

Hints:

Make sure you check that getTotalAdded works with both add and addAll.
After you have implemented the DelegationSortedIntList class, test the 
instrumentation you just added using tests in DelegationSortedIntListTest class.
Run the tests and make sure your instrumentation passes all the tests. (You might want 
to use the printList helper we provided you and read the documentation for addAll in 
the AbstractIntList class.)
 */

/**
 * DelegationSortedIntList -- a variant of a SortedIntList that keeps
 * count of the number of attempted element insertions (not to be confused
 * with the current size, which goes down when an element is removed)
 * and exports an accessor (totalAdded) for this count.
 *
 * @author Nora Shoemaker
 *
 */

public class DelegationSortedIntList implements IntegerList{
    // Write your implementation below with API documentation
    private SortedIntList list = new SortedIntList();
    private int count;

    public DelegationSortedIntList() {
        this.list = list;
        this.count = 0;
    }

    public boolean add(int num) {
        count++;
        return list.add(num);
    }

    public boolean addAll(IntegerList intList) {
        int size = intList.size(); 
        for (int i = 0; i < size; i++) {
            count++;
            list.add(list.get(i));
        }
        return true;
    }

    public int get(int index) {
        return list.get(index);
    }

    public boolean remove(int num) {
        return list.remove(num);
    }

    public boolean removeAll(IntegerList list) {
        return list.removeAll(list);
    }

    public int size() {
        return list.size();
    }

    public int getTotalAdded() {
        return this.count;
    }
}