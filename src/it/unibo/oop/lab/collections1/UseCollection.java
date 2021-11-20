package it.unibo.oop.lab.collections1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Example class using {@link java.util.List} and {@link java.util.Map}.
 * 
 */
public final class UseCollection {
	
	private static final int ELEMS = 100_000;
	private static final int TO_MS = 1_000_000;
	private static final int READS = 10_000;
	private static final long AFRICA = 1_110_635_000L;
	private static final long AMERICAS = 972_005_000L;
	private static final long ANTARTICA = 0L;
	private static final long ASIA = 4_298_723_000L;
	private static final long EUROPE = 742_452_000L;
	private static final long OCEANIA = 38_304_000L;

    private UseCollection() {
    }

    /**
     * @param s
     *            unused
     */
    public static void main(final String... s) {
        /*
         * 1) Create a new ArrayList<Integer>, and populate it with the numbers
         * from 1000 (included) to 2000 (excluded).
         */
    	final List<Integer> list = new ArrayList<>();
    	for (int i = 0; i < 1000; i++ ) {
    		list.add(i+1000);
    	}
        /*
         * 2) Create a new LinkedList<Integer> and, in a single line of code
         * without using any looping construct (for, while), populate it with
         * the same contents of the list of point 1.
         */
    	final List<Integer> newList = new LinkedList<>(list);
    	System.out.println(newList);
        /*
         * 3) Using "set" and "get" and "size" methods, swap the first and last
         * element of the first list. You can not use any "magic number".
         * (Suggestion: use a temporary variable)
         */
    	final Integer swap = list.get(0);
    	final Integer ultimo = list.size()-1;
    	list.set(0, list.get(ultimo));
    	list.set(ultimo, swap);
    	
        /*
         * 4) Using a single for-each, print the contents of the arraylist.
         */
    	System.out.print("[");
    	for (final var down: list) {
    		System.out.print(down + " , ");
    	}
    	System.out.println("]");
        /*
         * 5) Measure the performance of inserting new elements in the head of
         * the collection: measure the time required to add 100.000 elements as
         * first element of the collection for both ArrayList and LinkedList,
         * using the previous lists. In order to measure times, use as example
         * TestPerformance.java.
         */
    	long time = System.nanoTime();        
    	for (int i = 0; i < ELEMS; i++) {
    		list.add(0 , i);
    	}
    	
    	time = System.nanoTime() - time;
    	System.out.println("Inserting " + ELEMS + " elements as first element"
    			+ " in ArrayList took "+ time + 
    			"ns (" + time / TO_MS + "ms)");
    	
    	time = System.nanoTime();
    	for (int i = 0; i < ELEMS; i++) {
    		newList.add(0 , i);
    	}
    	time = System.nanoTime() - time;
    	System.out.println("Inserting " + ELEMS + " elements as first element"
    			+ " in LinkedList took "+ time + 
    			"ns (" + time / TO_MS + "ms)");
    	/*
         * 6) Measure the performance of reading 1000 times an element whose
         * position is in the middle of the collection for both ArrayList and
         * LinkedList, using the collections of point 5. In order to measure
         * times, use as example TestPerformance.java.
         */
    	time = System.nanoTime();
    	for (int i = 0; i < READS; i++ ) {
    		list.get(list.size()/2);
    	}
    	time = System.nanoTime() - time;
    	System.out.println("Reading " + READS + " times middle element"
    			+ " in ArrayList took "+ time + 
    			"ns (" + time / TO_MS + "ms)");
    	
    	time = System.nanoTime();
    	for (int i = 0; i < READS; i++ ) {
    		newList.get(newList.size()/2);
    	}
    	time = System.nanoTime() - time;
    	System.out.println("Reading " + READS + " times middle element"
    			+ " in LinkedList took "+ time + 
    			"ns (" + time / TO_MS + "ms)");
    	/*
         * 7) Build a new Map that associates to each continent's name its
         * population:
         * 
         * Africa -> 1,110,635,000
         * 
         * Americas -> 972,005,000
         * 
         * Antarctica -> 0
         * 
         * Asia -> 4,298,723,000
         * 
         * Europe -> 742,452,000
         * 
         * Oceania -> 38,304,000
         */
    	final Map<String,Long> world = new HashMap<>();
    	world.put("Africa", AFRICA);
    	world.put("Americas", AMERICAS);
    	world.put("Antartica", ANTARTICA);
    	world.put("Asia", ASIA);
    	world.put("Europe", EUROPE);
    	world.put("Oceania", OCEANIA);

    	
        /*
         * 8) Compute the population of the world
         */
    	long totPopulation = 0;
    	for (final long population : world.values()) {
    		totPopulation += population;
    	}
    	System.out.println(
                "We are ~" + totPopulation + " human beings on this pale blue dot"
                + " (enough people to overflow integers :D)."
            );
    }
}
