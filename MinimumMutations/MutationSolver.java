package com.revature.mutations;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class MutationSolver {

	public static void main(String[] args) throws UnsupportedEncodingException, IOException {
		String input = new String(Files.readAllBytes(Paths.get("C:\\GitRepos\\1810SPARK\\exercise-submissions\\MinimumMutationsSolution\\src\\com\\revature\\mutations\\input.txt")), "UTF-8");
		System.out.println(input);
		String[] inputs = input.split("\\s");
		System.out.println(inputs[2]);
		MutationSolution solver = new MutationSolution();
		String[] bank =  {inputs[2],inputs[3],inputs[4]};
		System.out.println(solver.minimumMutation(inputs[0], inputs[1], bank));

	}

}
