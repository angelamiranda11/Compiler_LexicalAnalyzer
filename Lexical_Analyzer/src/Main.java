import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class Main {
	public static void main(String args[]){
		try {
			File in=new File(JOptionPane.showInputDialog("Enter Filename:")+".txt");
			System.out.println(" --SOF-- ");
			Scanner sc=new Scanner(new FileReader(in.getPath()));
			int move=0;
			System.out.println("Move No.	Move");
			progBlock(sc, move);
		} catch (FileNotFoundException e) {
			System.out.println("File Not Found\n --EOF--");
		}
	}
	
	public static void progBlock(Scanner sc, int i){
		try{
			while(sc.hasNextLine()){
				i++;
				switch(sc.next()){
				case "START_GAME":System.out.println(i+"		Game Started");gameBlock(sc, i);break;
					default: throw new Exception();
				}
			}
		}catch(Exception e){
			System.out.println(" --EOF--");
		}
	}
	
	public static void gameBlock(Scanner sc, int i){
		//Game block scanner + interpret
		while(sc.hasNextLine()){
			i++;
			switch(sc.next()){
			case "MOVE": move(sc, i);break;
			case "COUNT": count(sc, i);break;
			case "PASS": pass(sc, i);break;
			case "DISPLAY_BOARD": display(sc, i);break;
			case "DISPLAY_WINNER": displayW(sc, i);break;
			case "CHECK": check(sc,i);break;
			case "END_GAME": System.out.println(i+"		Game Ended");progBlock(sc, i);break;
			}
		}
	}
	
	private static void displayW(Scanner sc, int i) {
		System.out.println(i+"		DISPLAY WINNER");		
	}

	private static void check(Scanner sc, int i) {
		String check=sc.nextLine();
		String[] checkA=check.split(" ");
		if((check.contains("WHITE") || check.contains("BLACK")) && (check.contains("RECTANGLE") || check.contains("LINE"))){
			System.out.println(i+"		PASS "+ checkA[1]+" "+checkA[2]);
			gameBlock(sc, i);
		}else{
			System.out.println(i+"		ERROR\n --EOF--");
			System.exit(0);
		}
		
	}

	private static void count(Scanner sc, int i) {
		String count=sc.nextLine();
		String[] countA=count.split(" ");
		if((count.contains("WHITE")|| count.contains("BLACK"))){
			System.out.println(i+"		PASS "+ countA[1]);
			gameBlock(sc, i);
		}else{
			System.out.println(i+"		ERROR\n --EOF--");
			System.exit(0);
		}	
	}

	private static void display(Scanner sc, int i) {
		System.out.println(i+"		DRAWBOARD");
		sc.nextLine();
		gameBlock(sc, i);
		
	}

	public static void move(Scanner sc, int i){
		String move=sc.nextLine();
		String[] moveA=move.split(" ");
		if((move.contains("WHITE")||move.contains("BLACK")) && move.contains("TO")){
			System.out.println(i+"		MOVE "+ moveA[1]+" CELL");
			gameBlock(sc, i);
		}else{
			System.out.println(i+"		ERROR\n --EOF--");
			System.exit(0);
		}		
	}
	
	public static void pass(Scanner sc, int i){
		String pass=sc.nextLine();
		String[] passA=pass.split(" ");
		if((pass.contains("WHITE")|| pass.contains("BLACK"))){
			System.out.println(i+"		PASS "+ passA[1]);
			gameBlock(sc, i);
		}else{
			System.out.println(i+"		ERROR\n --EOF--");
			System.exit(0);
		}	
	}
}