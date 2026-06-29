package cs271.lab.list;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestPerformance {

  // TODO run test and record running times for SIZE = 10, 100, 1000, 10000, ...
  // (choose in conjunction with REPS below up to an upper limit where the clock
  // running time is in the tens of seconds)
  // TODO Question: What conclusions can you draw about the performance of LinkedList vs. ArrayList when
  // comparing their running times for AddRemove vs. Access? Record those running times in README.txt!
  // TODO (optional) refactor to DRY
  // which of the two lists performs better as the size increases?
  private final int SIZE = 10;

  // TODO choose this value in such a way that you can observe an actual effect
  // for increasing problem sizes
  private final int REPS = 1000000;

  private List<Integer> arrayList;

  private List<Integer> linkedList;

  @BeforeEach
  public void setUp() throws Exception {
    arrayList = new ArrayList<Integer>(SIZE);
    linkedList = new LinkedList<Integer>();
    for (var i = 0; i < SIZE; i++) {
      arrayList.add(i);
      linkedList.add(i);
    }
  }

  @AfterEach
  public void tearDown() throws Exception {
    arrayList = null;
    linkedList = null;
  }

  private void testAddRemove(List<Integer> list) { // DRY for add-remove
    long start_time = System.currentTimeMillis();
    for (int r = 0; r < REPS; r++) {
      list.add(0, 77);
      list.remove(0);
    }
    long end_time = System.currentTimeMillis();
    long duration = end_time - start_time;
    System.out.println("testAddRemove duration for " + list.getClass().getName() + " = " + duration);
    System.out.println("testAddRemove duration for " + list.getClass().getName() + " = " + duration / 1000.0);
  }

  @Test
  public void testLinkedListAddRemove() {
    testAddRemove(linkedList);
  }

  @Test
  public void testArrayListAddRemove() {
    testAddRemove(arrayList);
  }

  private void testAccess(List<Integer> list) { // DRY for access
    long start_time = System.currentTimeMillis();
    long sum = 0;
    for (int r = 0; r < REPS; r++) {
      sum += list.get(r % SIZE);
    }
    long end_time = System.currentTimeMillis();
    long duration = end_time - start_time;
    System.out.println("testAccess duration for " + list.getClass().getName() + " = " + duration);
    System.out.println("testAccess duration for " + list.getClass().getName() + " = " + duration / 1000.0);
  }

  @Test
  public void testLinkedListAccess() {
    testAccess(linkedList);
  }

  @Test
  public void testArrayListAccess() {
    testAccess(arrayList);
  }
}
