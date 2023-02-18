import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
	// steps counter
	private static int count = 1;
	
	public static void main(String[] args){
		
		// size of array
		int[][] n = new int[3][3];
		
		// show empty tic-tac-toe
		showTicTacToe(n);
		
		// loop for game
			for(; count <= 9; count++) {
				
				// set index of X or O, numbers must be from 1 to 3
				setXO(n);
				
				System.out.println();
				
				// show tic-tac-toe 
				showTicTacToe(n);
				
				
				// horizontally
				// first -
				if(n[0][0] == n[0][1] && n[0][0] == n[0][2] && n[0][0] != 0) {
					if(n[0][0] == 1) System.out.println("winner X");
					else System.out.println("winner O");
					break;
				}
				// second -
				else if(n[1][0] == n[1][1] && n[1][0] == n[1][2] && n[1][0] != 0) {
					if(n[1][0] == 1) System.out.println("winner X");
					else System.out.println("winner O");
					break;
				}
				// third -
				else if(n[2][0] == n[2][1] && n[2][0] == n[2][2] && n[2][0] != 0) {
					if(n[2][0] == 1) System.out.println("winner X");
					else System.out.println("winner O");
					break;
				}
				
				// vertically
				// first |
				else if(n[0][0] == n[1][0] && n[0][0] == n[2][0] && n[0][0] != 0) {
					if(n[0][0] == 1) System.out.println("winner X");
					else System.out.println("winner O");
					break;
				}
				// second |
				else if(n[0][1] == n[1][1] && n[0][1] == n[2][1] && n[0][1] != 0) {
					if(n[0][1] == 1) System.out.println("winner X");
					else System.out.println("winner O");
					break;
				}
				// third |
				else if(n[0][2] == n[1][2] && n[0][2] == n[2][2] && n[0][2] != 0) {
					if(n[0][2] == 1) System.out.println("winner X");
					else System.out.println("winner O");
					break;
				}
				
				// another correct ways
				// \
				else if(n[0][0] == n[1][1] && n[0][0] == n[2][2] && n[0][0] != 0) {
					if(n[0][0] == 1) System.out.println("winner X");
					else System.out.println("winner O");
					break;
				}
				// /
				else if(n[2][0] == n[1][1] && n[2][0] == n[0][2] && n[2][0] != 0) {
					if(n[2][0] == 1) System.out.println("winner X");
					else System.out.println("winner O");
					break;
				}
				
				// show counter of games
				System.out.println("counter: " + count + "\n");				
		}
			
			// if the loop has ended but no one has won, show a draw		
			if(count == 10) System.out.println("Game Draw!");
	}
	
	// method to set X or O
	public static void setXO(int n[][]) {
		
		Scanner sc = new Scanner(System.in);
				
			// odd its X
			if (count%2!=0) {
				int y,x;
				// check if user is entering unicue numbers
				while(true) {
					System.out.println("set X");
					
					System.out.print("1-3 [y x]: ");
					
					// check if users numbers is from 1 to 3
					try {
						 y = sc.nextInt();
						 x = sc.nextInt();
						
						// if all is well loop ends
						if(n[y-1][x-1] == 0) {
							n[y-1][x-1] = 1;
							break;
							}
						
						else System.out.println("this value already filled!!!");
						
					} catch(IndexOutOfBoundsException e) {
						System.out.println("try another nums");
						
					} catch(InputMismatchException e) {
						System.out.println("invalid type");
						count--;
						break;
						}
				}
			}
			
			// even its O
			else {
				
				// check if user is entering unicue numbers
				while(true) {
					System.out.println("set O");
					
					System.out.print("1-3 [y x]: ");
					// check if users numbers is from 1 to 3
					try {
						int y = sc.nextInt();
						int x = sc.nextInt();
						// if all is well loop ends
						if(n[y-1][x-1] == 0) {
							n[y-1][x-1] = 2;
							break;
							}
						
						else System.out.println("this value already filled!!!");
						
					} catch(IndexOutOfBoundsException e) {
						System.out.println("try another nums");

					} catch(InputMismatchException e) {
						System.out.println("invalid type");
						count--;
						break;
						}
				}
			}
	
	} 
	
	

	// show tic-tac-toe
	public static void showTicTacToe(int[][] n) {
		for(int i = 0 ; i < n.length ; i++) {
			for(int j = 0; j < n.length;j++) {

				if(j == 2) {
					if(n[i][j] == 1) System.out.printf("%2s","X");
					else if(n[i][j] == 2) System.out.printf("%2s","O");
				}
				
				else if(n[i][j] == 0) System.out.printf("%4s"," " +"|" );
				
				else { 
					if(n[i][j] == 1) System.out.printf("%4s","X " + "|");
					else if(n[i][j] == 2) System.out.printf("%4s","O " + "|");
				}
			}
			
			System.out.println();
			
			if(i != 2) {
				for(int j = 0; j <= n.length;j++) System.out.printf("%2s"," - ");
				System.out.println();
			}
		}
	}
}
