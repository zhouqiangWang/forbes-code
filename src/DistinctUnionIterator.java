import java.util.*;

/**
 * An Iterator that takes in two Iterator sources and emits the
 * distinct items in the union of the sources.
 *
 * Example: source1 is an iterator that emits [2, 5, 2, 2, 6, 1] and
 * source2 is an iterator that emits [3, 3, 1, 7, 2]. A
 * DistinctUnionIterator with these two sources should emit
 * [7, 1, 2, 5, 3, 6] (though not necessarily in that order).
 */
public class DistinctUnionIterator implements Iterator<Integer> {

    private Iterator<Integer> sourceA;
    private Iterator<Integer> sourceB;
    private Set<Integer> distincSet;
    private int nextI = Integer.MIN_VALUE;

    public DistinctUnionIterator(
            Iterator<Integer> sourceA,
            Iterator<Integer> sourceB) {
        this.sourceA = sourceA;
        this.sourceB = sourceB;
        distincSet = new HashSet();
    }

    /**
     * Set<Integer> set -
     *
     *
     * while (sourceA.hasNext()) {

     }

     sourceA

     *
     */
    @Override
    public boolean hasNext() {
        if (nextI != Integer.MIN_VALUE) {
            return true;
        }
        while (sourceA.hasNext()) {
            nextI = sourceA.next();
            if (!distincSet.contains(nextI)) {
                return true;
            }
        }

        while (sourceB.hasNext()) {
            nextI = sourceB.next();
            if (!distincSet.contains(nextI)) {
                return true;
            }
        }
        nextI = Integer.MIN_VALUE; // invalid statue.

        return false;
    }

    @Override
    public Integer next() throws NoSuchElementException {
        if (nextI == Integer.MIN_VALUE) {
            if (!hasNext()) {
                throw new NoSuchElementException("no elements");
            }
        }
        int ret = nextI;
        nextI = Integer.MIN_VALUE; // consumered statues
        distincSet.add(ret);

        return ret;
    }

    public static void main(String[] args) {
        Iterator<Integer> iter1 = Arrays.asList(2).iterator();
        Iterator<Integer> iter2 = Arrays.asList(3).iterator();

        DistinctUnionIterator distinctUnionIter = new DistinctUnionIterator(iter1, iter2);
        System.out.println(distinctUnionIter.hasNext());
        System.out.println(distinctUnionIter.hasNext());
        System.out.println(distinctUnionIter.next());
        while (distinctUnionIter.hasNext()) {
            System.out.println(distinctUnionIter.next());
        }
        System.out.println(distinctUnionIter.hasNext());
        System.out.println(distinctUnionIter.next());

    }
}
