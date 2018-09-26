package hw3.hash;

import org.junit.Test;

import java.util.Set;
import java.util.TreeSet;
import java.util.ArrayList;
import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import java.util.HashSet;
import java.util.List;


public class TestSimpleOomage {


    @Test
    public void testHashCodeDeterministic() {
        SimpleOomage so = SimpleOomage.randomSimpleOomage();
        int hashCode = so.hashCode();
        for (int i = 0; i < 100; i += 1) {
            assertEquals(hashCode, so.hashCode());
        }
    }


    @Test
    public void testHashCodePerfect() {
        /*
          No two SimpleOomages should EVER have the same
          hashCode UNLESS they have the same red, blue, and green values!
         */
        Set<Integer> hashCodes = new TreeSet<>();
        for (int i = 0; i < 256; i += 5) {
            for (int j = 0; j < 256; j += 5) {
                for (int k = 0; k < 256; k += 5) {
                    SimpleOomage so = new SimpleOomage(i, j, k);
                    int code = so.hashCode();
                    //System.out.println(code);
                    assertFalse(hashCodes.contains(code));
                    hashCodes.add(code);
                }
            }
        }
    }


    //perms contains doubles.  Remove them with remDouble()
    private ArrayList permutations(int[] arr, int start, ArrayList perms) {
        for (int i = start; i < arr.length; i++) {
            int[] perm = arr.clone();
            swap(perm, start, i);
            perms.add(perm);
            permutations(perm, start + 1, perms);
        }
        return perms;
    }


    private void remDoubles(ArrayList<int[]> al) {
        for (int i = 0; i < al.size(); i++) {
            int[] elem1 = al.get(i);
            for (int j = 1; j < al.size(); j++) {
                int[] elem2 = al.get(j);
                if (equalIntArr(elem1, elem2)) {
                    al.remove(j);
                }
            }
        }
    }


    private boolean equalIntArr(int[] arr1, int[] arr2) {
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }


    private void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }


    @Test
    public void testEquals() {
        SimpleOomage ooA = new SimpleOomage(5, 10, 20);
        SimpleOomage ooA2 = new SimpleOomage(5, 10, 20);
        SimpleOomage ooB = new SimpleOomage(50, 50, 50);
        assertEquals(ooA, ooA2);
        assertNotEquals(ooA, ooB);
        assertNotEquals(ooA2, ooB);
        assertNotEquals(ooA, "ketchup");
    }


    @Test
    public void testHashCodeAndEqualsConsistency() {
        SimpleOomage ooA = new SimpleOomage(5, 10, 20);
        SimpleOomage ooA2 = new SimpleOomage(5, 10, 20);
        HashSet<SimpleOomage> hashSet = new HashSet<>();
        hashSet.add(ooA);
        assertTrue(hashSet.contains(ooA2));
    }


    @Test
    public void testRandomOomagesHashCodeSpread() {
        List<Oomage> oomages = new ArrayList<>();
        int N = 10000;

        for (int i = 0; i < N; i += 1) {
            oomages.add(SimpleOomage.randomSimpleOomage());
        }

        assertTrue(OomageTestUtility.haveNiceHashCodeSpread(oomages, 10));
    }


    /** Calls tests for SimpleOomage. */
    public static void main(String[] args) {
        jh61b.junit.textui.runClasses(TestSimpleOomage.class);
    }


}
