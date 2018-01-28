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
import java.util.Arrays;

public class AList<T> implements ListInterface<T> {

    private T[] list;
    private int numberOfEntries;
    private static final int DEFAULT_CAPACITY=25;
    private static final int MAX_CAPACITY=10000;
    private boolean initialized=false;
    
    public AList() {
        this(DEFAULT_CAPACITY);
    } // end default constructor
    public AList(int initialCapacity) {
        if(initialCapacity< DEFAULT_CAPACITY) initialCapacity= DEFAULT_CAPACITY;
        else checkCapacity(initialCapacity);
        
    T[] tempList= (T[])new Object[initialCapacity+ 1];
    list = tempList;
    numberOfEntries= 0;
    initialized = true;
    }
    
    private void checkCapacity(int cap){
        if (cap>MAX_CAPACITY) throw new IllegalStateException("Attempt to create a list of capacity greater than allowed maximum");
    }
    
    private void checkInitialization(){
        if (!initialized) throw new SecurityException("AList object is not properly initialized.");
    }
    
    private void ensureCapacity(){
        int capacity = list.length-1;
        if (numberOfEntries == capacity){
            int newCapacity = 2*capacity;
            checkCapacity(newCapacity);
            list = Arrays.copyOf(list,newCapacity+1);
        }
    }
    
    private void listAlloc(int newPos){
        assert (newPos >= 1) && (newPos <- numberOfEntries + 1);
        
        int newIndex =  newPos;
        int lastIndex = numberOfEntries;
        
        for (int index = lastIndex; index >=newIndex; index--) list [index+1]=list[index];
    }
    
    private void removeGap(int givenPos){
        assert (givenPos>=1)&&(givenPos<numberOfEntries);
        int removed = givenPos;
        int last = numberOfEntries;
        for (int index = removed; index<last; index++) list [index] = list [index+1];
    }
    
    public void add(T newEntry){
            checkInitialization();
            list[numberOfEntries+1]=newEntry;
            numberOfEntries++;
            ensureCapacity();
    }

    public void add(int newPosition, T newEntry){
            checkInitialization();
            if ((newPosition>=1)&&(newPosition<=numberOfEntries+1)){
                if (newPosition<=numberOfEntries){
                    listAlloc(newPosition);
                }
                list[newPosition]=newEntry;
                numberOfEntries++;
                ensureCapacity();
            }
            else throw new IndexOutOfBoundsException("Given position of entry is out of bounds of list.");
    }
    
    public T remove(int givenPos){
        checkInitialization();
        if ((givenPos>=1)&&(givenPos <= numberOfEntries)){
            assert !isEmpty();
            T result = list [givenPos];
            if (givenPos<numberOfEntries) removeGap(givenPos);
            
            numberOfEntries--;
            return result;
        } else throw new IndexOutOfBoundsException("Illegal position for removal");
    }

    public void clear(){
        checkInitialization();
        for (int index = 1; index <= numberOfEntries; index++) list[index]=null;
        numberOfEntries = 0;
    }

    public T replace(int givenPos, T newEntry){
        checkInitialization();
        if ((givenPos>=1)&&(givenPos<=numberOfEntries)){
            assert !isEmpty();
            T originalEntry = list[givenPos];
            list[givenPos]= newEntry;
            return originalEntry;
        } else throw new IndexOutOfBoundsException("Illegal position for replacement");        
    }

    public T getEntry(int givenPos){
       checkInitialization();
        if ((givenPos>=1)&&(givenPos<=numberOfEntries)){ 
            assert !isEmpty();
            return list[givenPos];
        } else throw new IndexOutOfBoundsException("Illegal position for retrieving entry");
    }

    public T[] toArray(){
       checkInitialization();
       @SuppressWarnings ("unchecked")
       T[] result = (T[])new Object[numberOfEntries];
       
       for (int index = 0; index < numberOfEntries; index++) result[index]=list[index+1];
       return result;
    }

    public boolean contains(T anEntry){
        checkInitialization();
        boolean found = false;
        int index = 1; 
        while ((!found)&&(index<=numberOfEntries)){
            if (anEntry.equals(list[index])) found = true;
            index++;
        }
        return found;
    }

    public int getLength(){
        return numberOfEntries;    
    }

    public boolean isEmpty(){
        return (numberOfEntries == 0);    
    }
        
    public int getPosition(T anEntry){
       checkInitialization();
        int result=-1;
        int index = 1; 
        if (contains(anEntry)){
            while ((result==-1)&&(index<=numberOfEntries)){
                if (anEntry.equals(list[index])) result = index;
                index++;
            }
            return result;
        } else throw new IndexOutOfBoundsException("Illegal position for retrieving index");
    }
}
