import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class TicTacToe {
	
	public static ArrayList playerPos=new ArrayList();
	public static ArrayList cpuPos=new ArrayList();
	
	
	public static void main(String[] args) {
		char[][] gameBoard= {{' ','|',' ','|',' '},
				             {'-','+','-','+','-'},
				             {' ','|',' ','|',' '},
				             {'-','+','-','+','-'},
				             {' ','|',' ','|',' '},
		                     };
				while(true) {
					printGameBoard(gameBoard);
					System.out.println("Enter the position (1-9)");
					Scanner scan=new Scanner(System.in);
					int playerPosition=scan.nextInt();
					while(playerPos.contains(playerPosition) || cpuPos.contains(playerPosition)) {
						System.out.println("Position taken! enter a new position ");
						playerPosition=scan.nextInt();
					}
					piecePlacement(gameBoard,playerPosition,"player");
					String ans=checkwinner();
					System.out.println(ans);
					Random rand=new Random();
					int cpuPosition=rand.nextInt(9)+1;
					while(playerPos.contains(cpuPosition) || cpuPos.contains(cpuPosition)) {
						
						cpuPosition=rand.nextInt(9)+1;
					}
					piecePlacement(gameBoard,cpuPosition,"cpu");
					System.out.println();
					printGameBoard(gameBoard);
					ans=checkwinner();
					System.out.println(ans);
				}
				
			
		
	}
	
	public static void printGameBoard(char[][] gameBoard) {
		for(char row[]:gameBoard) {
			for(char c: row) {
				System.out.print(c);
			}
			System.out.println();
		}
		
	}
	
	public static String checkwinner() {
		
		List topRow=Arrays.asList(1,2,3);
		List midRow=Arrays.asList(4,5,6);
		List botRow=Arrays.asList(7,8,9);
		List leftCol=Arrays.asList(1,4,7);
		List midCol=Arrays.asList(2,4,8);
		List rightCol=Arrays.asList(3,6,9);
		List firstDig=Arrays.asList(1,5,9);
		List secondDig=Arrays.asList(3,5,7);
		
		List<List> winning=new ArrayList<List>();
		
		winning.add(topRow);
		winning.add(midRow);
		winning.add(botRow);
		winning.add(leftCol);
		winning.add(midCol);
		winning.add(rightCol);
		winning.add(firstDig);
		winning.add(secondDig);
		
		
		for(List l:winning) {
			
			if(playerPos.containsAll(l)) {
				return "Player wins";
			}
			else if(cpuPos.containsAll(l)) {
				return "CPU wins you lose";
			}
			
		}
		if(playerPos.size()+cpuPos.size()==9) {
		return "this is a tie";
		
		}		
		
		
		return "";
		
		
	}
	
	
	
	public static void piecePlacement(char[][] gameBoard,int pos,String user) {
		char symbol=' ';
		if(user.equals("player")) {
			symbol='X';
			playerPos.add(pos);
		}else if(user.equals("cpu")) {
			symbol='O';
			cpuPos.add(pos);
		}
		switch(pos) {
		case 1:
			gameBoard[0][0]=symbol;
			break;
		case 2:
			gameBoard[0][2]=symbol;
			break;
		case 3:
			gameBoard[0][4]=symbol;
			break;
		case 4:
			gameBoard[2][0]=symbol;
			break;
		case 5:
			gameBoard[2][2]=symbol;
			break;
		case 6:
			gameBoard[2][4]=symbol;
			break;
		case 7:
			gameBoard[4][0]=symbol;
			break;
		case 8:
			gameBoard[4][2]=symbol;
			break;
		case 9:
			gameBoard[4][4]=symbol;
			break;
			default:
				break;
		}
		
		
	}
}
