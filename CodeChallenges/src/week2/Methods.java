package week2;

public class Methods {
	
	public static int findMinMutations (String start, String end, String[] bank) {
		
		int numMutations = 0;
		int count = 0;
		for (int a = 0; a < start.length(); a++) {
			if (start.charAt(a) == end.charAt(a)) {
				count++;
			}
			if (count == 8) {
				numMutations = 0;
			} else if (count == 7) {
				numMutations = 1;
			} else {
				count = 0;
				for (int b = 0; b < bank.length; b++) {
					for (int c = 0; c < start.length(); c++) {
						if (end.charAt(c) == bank[b].charAt(c)) {
							count++;
						}
						if (count != 8) {
							numMutations = 0;
							break;
						}
						if (start.charAt(c) == bank[b].charAt(c)) {
							count++;
						}
						if (count == 7) {
							count = 0;
							for (int d = 0; d < end.length(); d++) {
								if (bank[b].charAt(d) == end.charAt(d)) {
									count++;
								}
								if (count == 7) {
									numMutations = 2;
								} else {
									count = 0;
									for (int e = 0; e < b; e++) {
										for (int g = 0; g < start.length(); g++) {
											if (bank[e].charAt(g) == bank[b].charAt(g)) {
												count++;
											}
											if (count == 7) {
												count = 0;
												for (int h = 0; h < end.length(); h++) {
													if (bank[e].charAt(h) == end.charAt(h)) {
														count++;
													}
													if (count == 7) {
														numMutations = 3;
													}
												}
											}
										}
									}
									for (int f = b+1; f < bank.length; f++) {
										for (int g = 0; g < start.length(); g++) {
											if (bank[f].charAt(g) == bank[b].charAt(g)) {
												count++;
											}
											if (count == 7) {
												count = 0;
												for (int h = 0; h < end.length(); h++) {
													if (bank[f].charAt(h) == end.charAt(h)) {
														count++;
													}
													if (count == 7) {
														numMutations = 3;
										}
									}
								}
							}
						} 
					}
				}
			}
		}
		return numMutations;
	}
}
