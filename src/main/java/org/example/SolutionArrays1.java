package org.example;

public class SolutionArrays1 {
	public static int findMaxConsecutiveOnes(int[] nums) {
		//List<Integer> l = new ArrayList<>(Arrays.stream(nums).boxed().collect(Collectors.toList()));
		
		
		/*int n = l
				.stream()
				.reduce(0,
						(subtotal, element) -> {
							if (element == 1) subtotal++;
							else {
								if (max < subtotal) max = subtotal;
								subtotal = 0;
							}
							return subtotal;
						}
				);*/
		//if (max < n) max = n;
		int max = 0;
		int current = 0;
		for (int num : nums) {
			if (num == 1) {
				current++; //sequence starts or continues
				if (current > max) max = current;
			}
			else { //sequence is ended
				current = 0;
			}
		}
		
		return max;
	}
	
	public static int findMaxConsecutiveOnesWithStreams(int[] nums) {
		//List<Integer> l = new ArrayList<>(Arrays.stream(nums).boxed().collect(Collectors.toList()));
		
		
		/*int n = l
				.stream()
				.reduce(0,
						(subtotal, element) -> {
							if (element == 1) subtotal++;
							else {
								if (max < subtotal) max = subtotal;
								subtotal = 0;
							}
							return subtotal;
						}
				);*/
		//if (max < n) max = n;
		int max = 0;
		int current = 0;
		for (int num : nums) {
			if (num == 1) {
				current++; //sequence starts or continues
				if (current > max) max = current;
			}
			else { //sequence is ended
				current = 0;
			}
		}
		
		return max;
	}
}


