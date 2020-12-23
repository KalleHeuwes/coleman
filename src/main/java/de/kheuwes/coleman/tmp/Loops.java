package de.kheuwes.coleman.tmp;

public class Loops {
	public static void main(String[] args) {
		for (int l = 0; l < 3; l++) {
			for (int k = 0; k < 3; k++) {
				for (int i = 0; i < 3; i++) {
					for (int j = 0; j < 3; j++) {
						System.out.print(nextSudokuNr() + " " + (j == 2 ? " ": "") );
					}
				}
				System.out.println("");
			}
			System.out.println("");
		}
	}
	
	private static String nextSudokuNr() {
		return String.valueOf( Math.round(1 + Math.random() * 8) );
	}
}
