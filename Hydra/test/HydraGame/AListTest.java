/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HydraGame;

/**
 *
 * @author Abdelkader
 */

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class AListTest extends AList{

    @Test
    public void testAdd_GenericType() {
        System.out.println("add");
        Object newEntry = null;
        AList instance = new AList();
        instance.add(newEntry);

    }

    @Test (expected=IndexOutOfBoundsException.class)
    public void testAdd_int_GenericType() {
        System.out.println("add");
        int newPosition = 0;
        Object newEntry = null;
        AList instance = new AList();
        instance.add(newPosition, newEntry);
    }

        @Test
    public void testAdd_SomeData() {
        System.out.println("add some data");
        AList instance = new AList();
        instance.add("A");
        instance.add("B");
        instance.add("C");
        instance.add("D");
        instance.add("E");
        instance.add("F");
        instance.add("G");
    }
    @Test (expected=IndexOutOfBoundsException.class)
    public void testRemove() {
        System.out.println("remove");
        int givenPosition = 0;
        AList instance = new AList();
        Object result = instance.remove(givenPosition);
        System.out.println(result);
    }

     public void testClear() {
        System.out.println("clear");
        AList instance = new AList();
        instance.clear();
    }

    @Test (expected=IndexOutOfBoundsException.class)
    public void testReplace() {
        System.out.println("replace");
        int givenPosition = 0;
        Object newEntry = null;
        AList instance = new AList();
        Object result = instance.replace(givenPosition, newEntry);
        System.out.println(result);
    }

    @Test(expected=IndexOutOfBoundsException.class)
    public void testGetEntry() {
        System.out.println("getEntry");
        int givenPosition = 0;
        AList instance = new AList();
        Object result = instance.getEntry(givenPosition);
        System.out.println(result);
    }

    @Test
    public void testGetLength() {
        System.out.println("getLength");
        AList instance = new AList();
        int expResult = 0;
        int result = instance.getLength();
        assertEquals(expResult, result);
    }

    @Test
    public void testIsEmpty() {
        System.out.println("isEmpty");
        AList instance = new AList();
        boolean expResult = true;
        boolean result = instance.isEmpty();
        assertEquals(expResult, result);
    }

    @Test
    public void testToArray() {
        System.out.println("toArray");
        AList instance = new AList();
        Object[] expResult = new Object[0];
        Object[] result = instance.toArray();
        assertArrayEquals(expResult, result);
    }

    @Test
    public void testContains() {
        System.out.println("contains");
        Object anEntry = null;
        AList instance = new AList();
        boolean expResult = false;
        boolean result = instance.contains(anEntry);
        assertEquals(expResult, result);
    }

    @Test
    public void testGetPosition() {
        System.out.println("getPosition");
        Object anEntry = "Null";
        AList instance = new AList();
        int expResult = 0;
        int result = instance.getPosition(anEntry);
        assertEquals(expResult, result);
    }

}
