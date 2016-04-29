import java.util.Scanner;
public class TicTacToe
	{
		static String arrayGame[][] = new String [3][3];
		static String playermark;
		static String compMark;
		static String playerMove;
		static int row = 0;
		static int column = 0;
		static int col = 0;
		static String compMove;
		static int compRow = 0;
		static int compCol = 0;
			
		public static void main(String[] args)
		
			{
				introducePlayer();
				fillWithBlanks();
				displayBoard();
				doIntroduction();
				playerMove();
				doMove();
					{
						boolean gameContinues = true;
						while (gameContinues)
							{
								compMove();
								//checkCompOpenSpace();
								playerMove();
								checkOwnOpenSpace();
							}		
					}	
			}
		public static void introducePlayer()
		{
			System.out.println("Hello there buddy, what's your name?");
			Scanner userInput = new Scanner(System.in);
			String name = userInput.nextLine();
			System.out.println();
			System.out.println("Okay then, " + name + ", I hope you're ready to play because we're getting right into this!");
		}
		public static void displayBoard()
		{
			System.out.println("  1   2   3  ");
			System.out.println("  -------------");
			System.out.println("A | " + arrayGame[0][0] + " | " + arrayGame[0][1] + " | " + arrayGame[0][2]  + " |");	
			System.out.println("  -------------");
			System.out.println("B | " + arrayGame[1][0] + " | " + arrayGame[1][1] + " | " + arrayGame[1][2]  + " |");
			System.out.println("  --------------");
			System.out.println("C | " + arrayGame[2][0] + " | " + arrayGame[2][1] + " | " + arrayGame[2][2]  + " |");
			System.out.println("  -------------");
		}
		public static void fillWithBlanks()
			{
				for(int i = 0; i<3; i++)
					{
						System.out.println(" ");
						for(int a = 0; a<3;a++)
							{
								System.out.print(arrayGame[i][a]=" ");
							}
					}
			}
		public static void doIntroduction()
		{		
			System.out.println();
			System.out.println("Ok, you are the X player, make your move!");
			System.out.println("For example, if you want to mark the top right spot, type A1 or a1.");
		
		}
		public static String playerMove()
		{
			Scanner move = new Scanner(System.in);
			playerMove = move.nextLine();
			switch (playerMove.substring(0,1))
			{
				case "A":
				case"a":
						{
							row = 0;
							break;
						}
				case "B":
				case "b":
						{
							row = 1;
							break;
						}
				case "C":
				case "c":
						{
							row = 2;
							break;
						}
			}
			col = Integer.parseInt(playerMove.substring(1))-1;
			return playerMove;
			}
		public static void doMove()
		{
			playerMove = "x";
			arrayGame[row][col] = playerMove;
			displayBoard();
		}
		public static void compMove()
		{
			compMove = "O";
			compRow = (int)(Math.random()*2+1);
			compCol = (int)(Math.random()*2+1);		
			//arrayGame[compRow][compCol]=compMove;
			//displayBoard();	
			if (arrayGame[compRow][compCol].equals(" "))
				{
					arrayGame[compRow][compCol]=compMove;
					displayBoard();
				}
			else 
				{
					compMove();
				}
				
		}
		public static void checkOwnOpenSpace()
		{
			if (arrayGame[row][col].equals("X"))
				{
					System.out.println("Can't take your own space twice, try again");
					playerMove();
				}
			else if  (arrayGame[row][col].equals("O"))
				{
					System.out.println("Can't take his space pal, try again");
					playerMove();
				}
			else 
				{
					doMove();
				}
			}
		
	}
	
	
	
