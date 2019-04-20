package eg.edu.alexu.csd.datastructure.linkedList;

import static org.junit.Assert.*;

import org.junit.Test;

public class SingleTest {
	Single test = new Single();

	@Test
	public void testAddIntObject() {
		test.add(0);
		test.add(1);
		test.add(2);
		test.add(3);
		test.add(4);
		Object object = new Object();
		object = 5;
		test.add(4, 5);
		assertEquals(object, test.get(4));
	}

	@Test
	public void testAddObject() {
		test.add(0);
		test.add(1);
		test.add(2);
		test.add(3);
		test.add(4);
		Object object1 = new Object();
		object1 = 5;
		Object object2 = new Object();
		object2 = 6;
		Object object3 = new Object();
		object3 = 7;
		test.add(object1);
		test.add(object2);
		test.add(object3);
		assertEquals(object1, test.get(5));
		assertEquals(object2, test.get(6));
		assertEquals(object3, test.get(7));
		assertEquals(null, test.get(8));
	}

	@Test
	public void testSet() {
		test.add(0);
		test.add(1);
		test.add(2);
		test.add(3);
		test.add(4);

		Object A = new Object();
		A = 3;

		test.set(3, A);

		assertEquals(A, test.get(3));

	}

	@Test
	public void testIsEmpty() {

		test.add(0);
		test.add(1);
		test.add(2);
		test.add(3);
		test.add(4);
		test.add(5);

		test.clear();

		assertEquals(0, test.size());

	}

	@Test
	public void testRemove() {

		test.add(0);
		test.add(1);
		test.add(2);
		test.add(3);
		test.add(4);
		test.add(5);
		test.add(6);
		test.add(7);
		test.add(8);
		test.add(9);
		test.add(10);

		Object A = new Object();
		A = 4;
		test.remove(4);

		assertEquals(10, test.size());
		assertNotEquals(A, test.get(4));

	}

	@Test
	public void testSize() {
		test.add(0);
		test.add(1);
		test.add(2);
		test.add(3);
		test.add(4);
		test.add(5);
		test.add(6);
		test.add(7);
		test.add(8);
		test.add(9);
		test.add(10);
		assertEquals(11, test.size());
	}

	@Test
	public void testSublist() {
		test.add(0);
		test.add(1);
		test.add(2);
		test.add(3);
		test.add(4);
		test.add(5);
		test.add(6);
		test.add(7);
		test.add(8);
		test.add(9);
		test.add(10);
		test.sublist(2, 7);
		Single sub = new Single();

		sub.add(2);
		sub.add(3);
		sub.add(4);
		sub.add(5);
		sub.add(6);
		sub.add(7);
		assertEquals(sub.get(0), test.sublist(2, 7).get(0));
		assertEquals(sub.get(1), test.sublist(2, 7).get(1));
		assertEquals(sub.get(2), test.sublist(2, 7).get(2));
		assertEquals(sub.get(3), test.sublist(2, 7).get(3));
		assertEquals(sub.get(4), test.sublist(2, 7).get(4));
		assertEquals(sub.get(5), test.sublist(2, 7).get(5));
	}

	@Test
	public void testContains() {
		test.add(0);
		test.add(1);
		test.add(2);
		test.add(3);
		test.add(4);
		test.add(5);
		test.add(6);
		test.add(7);
		test.add(8);
		test.add(9);
		test.add(10);
		assertEquals(false, test.contains(11));
		assertEquals(true, test.contains(0));

	}

}