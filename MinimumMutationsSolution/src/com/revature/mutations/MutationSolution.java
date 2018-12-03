package com.revature.mutations;

import java.util.LinkedList;
import java.util.Queue;

public class MutationSolution {

	public int minimumMutation(String start, String end, String[] bank) {

		int steps = 0;
		int mutations = 0;

		// create a queue to be able to pass in and out values cleaner than a string
		Queue<String> queue = new LinkedList<String>();
		// add our start string
		queue.add(start);
		// while our queue is not empty, begin attempting to mutate the string
		while (!queue.isEmpty()) {
			// create a new queue to be returned for next iteration
			Queue<String> mutationQueue = new LinkedList<String>();
			// create a string by removing word from our start queue
			while (!queue.isEmpty()) {
				String word = queue.poll();
				// if the string equals the end, return steps
				if (word == end) {
					return steps;
				}
				// check to see if one change to our sequence would equal something in the bank,
				// make the change, and begin while loop again until correct answer is returned
				// if step has been incremented, work from the right to left through the bank
				if (steps == 0) {
					for (int i = 0; i < bank.length; i++) {
						if (i != 0 && !mutationQueue.isEmpty()) {
							break;
						}
						for (int j = 0; j < word.length(); j++) {
							if (mutationQueue.contains(bank[i])) {
								break;

							}
							if (word.charAt(j) != bank[i].charAt(j)) {
								mutations++;
								mutationQueue.add(bank[i]);

							}
						}
					}
				} else if (steps > 0) {
					for (int i = bank.length - 1; i >= 0; i--) {
						if (!mutationQueue.isEmpty()) {
							break;
						}
						for (int j = 0; j < word.length(); j++) {
							if (mutationQueue.contains(bank[i])) {
								break;

							}
							if (word.charAt(j) != bank[i].charAt(j)) {
								mutations++;
								mutationQueue.add(bank[i]);

							}
						}
					}
				}
				// pass change back to start queue, which is now empty and increment steps
				queue = mutationQueue;
				steps++;
			}

		}
		return 0;
	}
}
