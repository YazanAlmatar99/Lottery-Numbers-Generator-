// http://www.yazanalmatar.com

import java.util.Arrays;
import java.util.*;
import Randomizer;



public class LottoQuickPicker {
	
	// constants  specific to current game - BUT NOT ALL GAMES 
	public final static int DEFAULT_GAME_COUNT = 1; 
	private final static String GAME_NAME = "Lotto"; 
	private final static int SELECTION_POOL_SIZE = 59; 
	private final static int SELECTION_COUNT = 6; 
	private static int GAME_COUNT = 1;


	public LottoQuickPicker() {
		init(DEFAULT_GAME_COUNT); 
	}
	
	public LottoQuickPicker(int games) {
		GAME_COUNT=games;
		init(games); 
	}
	
	private void printNumbers(int [] numbersArr,int j) {
		Arrays.sort(numbersArr);
		System.out.printf("%-2s", "("+(j+1) + ") ");
		for (int i = 0; i <numbersArr.length; i ++) {
			System.out.printf("%-4s", numbersArr[i]);
		}
	}
	
	private void generateNumbers() {
		for (int j = 0; j < GAME_COUNT; j++) {
			int [] numbersArr = new int[SELECTION_COUNT];
			for (int i = 0; i < SELECTION_COUNT; i++) {
				int temp = Randomizer.generateInt(1, SELECTION_POOL_SIZE);
				numbersArr[i] = temp;
				
			}
			printNumbers(numbersArr,j);
			System.out.println();
		}
		
	}

	public void displayTicket() {

		displayHeading(); 
		generateNumbers();
		displayFooter(); 
		
		return;
	}
	
	protected void displayHeading() {
	 Date date = new Date();
	 System.out.println("----------------------------");
	 System.out.println("-----------"+GAME_NAME+"-----------");
	 System.out.println(date);
	 
	}
	
	protected void displayFooter() {
		 System.out.println("--------Lottery--------");
		 System.out.println("-------------------------");
		
	}


	/**
	 * @param args 
	 */
	public static void main(String[] args) {
		// takes an optional command line parameter specifying number of QP games to be generated
		//  By default, generate 1  
		int numberOfGames  = DEFAULT_GAME_COUNT; 
		
		if(args.length > 0) {  // if user provided an arg, assume it to be a game count
			numberOfGames = Integer.parseInt(args[0]);  // [0] is the 1st element!
		}
		
		LottoQuickPicker lotto = new LottoQuickPicker(numberOfGames);
		// now what 
		 
		lotto.displayTicket(); 


	}

}
