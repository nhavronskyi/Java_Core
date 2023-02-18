import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

import bin.Converter;
import bin.Renamer;

// I used this program when I was a warehouse worker, 
// every day I needed to convert photos from .heic to .jpeg,
// also rename folders with photos to the correct form

// this program has a little problem with the converter, 
// because converter works with ImageMagick, and this program is on my pc;)

public class hector {
	public static void main(String[] args) throws IOException, InterruptedException {
		String pathData = "/workspaces/Java_Core/RenameAndConvert/data.txt";
		// declared a date of invoice
		String month = Files
				.readAllLines(Paths.get(pathData))
				.get(1);
		String year = Files
				.readAllLines(Paths.get(pathData))
				.get(4);

		// choosing way doing of program
		System.out.println("1 -> start renamer\n" + "2 -> start converter");
		System.out.print("your choose: ");
		
		// input from keyboard
		Scanner scanner = new Scanner(System.in);
		int x = scanner.nextInt();
		scanner.close();
		
		// switcher
		switch (x) {
			case 1 -> renamer(month, year);
			case 2 -> converter();
		}
	}

	// renaming numbered folders to the correct form
	static void renamer(String month, String year) {
		Renamer ren = new Renamer(month, year);
		ren.start();
	}

	// converter of photos
	static void converter() throws IOException {
		Converter con = new Converter();
		con.start();
	}
}