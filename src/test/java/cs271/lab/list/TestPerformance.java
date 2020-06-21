package cs271.lab.list;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestPerformance {

  // TODO run test and record running times for SIZE = 10, 100, 1000, 10000, ...
  // (choose in conjunction with REPS below up to an upper limit where the clock
  // running time for some methods is in the order of seconds, probably around 10_000)
  // TODO (optional) refactor to DRY
  // TODO answer: which of the two lists performs better for each method as the size increases?

  private final int SIZE = 10;

  // TODO choose this value in such a way that you can observe an actual effect
  // for increasing problem sizes - 1_000_000 is probably sufficient

  private final int REPS = 1_000_000;

  private List<Integer> arrayList;

  private List<Integer> linkedList;

  @Before
  public void setUp() {
    arrayList = new ArrayList<Integer>(SIZE);
    linkedList = new LinkedList<Integer>();
    for (int i = 0; i < SIZE; i++) {
      arrayList.add(i);
      linkedList.add(i);
    }
  }

  @After
  public void tearDown() {
    arrayList = null;
    linkedList = null;
  }

  @Test
  public void testLinkedListAddRemove() {
    for (int r = 0; r < REPS; r++) {
      linkedList.add(0, 77);
      linkedList.remove(0);
    }
  }

  @Test
  public void testArrayListAddRemove() {
    for (int r = 0; r < REPS; r++) {
      arrayList.add(0, 77);
      arrayList.remove(0);
    }
  }

  @Test
  public void testLinkedListAccess() {
    long sum = 0;
    for (int r = 0; r < REPS; r++) {
      sum += linkedList.get(r % SIZE);
    }
  }

  @Test
  public void testArrayListAccess() {
    long sum = 0;
    for (int r = 0; r < REPS; r++) {
      sum += arrayList.get(r % SIZE);
    }
  }
}
