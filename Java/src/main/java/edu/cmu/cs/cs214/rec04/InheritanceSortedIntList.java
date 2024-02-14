package edu.cmu.cs.cs214.rec04;

/**
 * InheritanceSortedIntList -- a variant of a SortedIntList that keeps
 * count of the number of attempted element insertions (not to be confused
 * with the current size, which goes down when an element is removed)
 * and exports an accessor (totalAdded) for this count.
 *
 * @author Nora Shoemaker
 *
 */

public class InheritanceSortedIntList extends SortedIntList {
    private int count;

    // Write your implementation below with API documentation

    /**
     * Adds the specified int to the list. Increase the counter.
     *
     * @param num an integer to be added to the list
     * @return true if the list is changed as a result of the call
     */
    @Override 
    public boolean add (int num) {
        count++;
        return super.add(num);
    }

    /**
     * Adds all of the elements of the IntegerList to the list.
     * Increase the counter.
     * @param list IntegerList containing elements to be added to the list
     * @return true if the list changed as a result of the call
     */
    @Override 
    public boolean addAll(IntegerList list) {
        int size = list.size(); 
        for (int i = 0; i < size; i++) {
            count++;
            super.add(super.get(i));
        }
        return true;
    }

    /**
     * Gets the counter.
     * @return the number of attempted element insertions
     */
    public int getTotalAdded() {
        return this.count;
    }


}