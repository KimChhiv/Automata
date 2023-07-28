package Automata;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import Automata.DfaAndNfaChecker;
public class FiniteAutomata {

	public static void main(String[] args) {
		
		
		Scanner input = new Scanner(System.in);
		
		int st, alp, option;
		
		String start, finals, in, currentst, ch;
		int k=0, a=0, b=0, c=0, l=0;
		String transition[][]= new String [15][15];
// States 
		System.out.println("Enter the number of states: ");
		st = input.nextInt();
		String state[]= new String[st];
		System.out.println("Enter the states: ");
		for (int i=0; i<st; i++) {
			state[i]= input.next();
		} for(int i=0; i<st; i++) {
			System.out.print(state[i]+ ", ");
		} System.out.println();
// Alphabet 
		System.out.println("Enter the number of alphabet: ");
		alp = input.nextInt();
		String alpha[]= new String[alp];
		System.out.println("Enter alphabet: ");
		for (int i=0; i<alp ;i++) {
			alpha[i]= input.next();
			
		}for (int i=0; i<alp; i++) {
			System.out.print(alpha[i]+ ", ");
		}System.out.println();
		//Ask the user for the start state
	    while(true) {
	      System.out.print("Input start state: ");
	      start = input.next();
	      
	      // Check if the start state exists in the state array
	      boolean foundState = false;
	      for(int i = 0; i < state.length; i++) {
	        if(state[i].equals(start)) {
	          foundState = true;
	          break;
	        }
	      }
	      // If the start state does not exist in the state array, prompt the user to choose again
	          if (!foundState) {
	              System.out.println("The element you chose does not exist in the array. Please choose again.");
	          } else {
	              System.out.println("You chose the element " + start);
	              break;
	          } 
	    }
	  //Ask the user for the start state
	    while(true) {
	      System.out.print("Input final state: ");
	      finals = input.next();
	      
	      // Check if the start state exists in the state array
	      boolean foundState = false;
	      for(int i = 0; i < state.length; i++) {
	        if(state[i].equals(finals)) {
	          foundState = true;
	          break;
	        }
	      }
	      // If the start state does not exist in the state array, prompt the user to choose again
	          if (!foundState) {
	              System.out.println("The element you chose does not exist in the array. Please choose again.");
	          } else {
	              System.out.println("You chose the element " + finals);
	              break;
	          } 
	    }
		currentst = start; 
// Transition
		System.out.println("Enter the transitions: ");
		for(int i=0; i<st; i++) {
			for (int z=0; z<alp; z++) {
				System.out.println("Enter "+state[i]+ " with '" + alpha[z] + "' transition");
				transition[i][z]= input.next();
			}
		}
		for(int i=0; i<alp; i++) {
			System.out.print(" "+ alpha[i]);
		}System.out.println();
		for (int i=0; i<st; i++) {
			System.out.print(state[i]+ " ");
		
		for (int z=0; z<alp; z++) {
			System.out.print(transition[i][z] + " ");
		}System.out.println();
		}
		
		DfaAndNfaChecker checker = new DfaAndNfaChecker();
		boolean isNfa = checker.isNFA(transition, state, alpha);
		boolean isDfa = checker.isDFA(transition, state, alpha);

		if (isNfa) {
		    System.out.println("The automaton is an NFA.");
		} else if (isDfa) {
		    System.out.println("The automaton is a DFA.");
		} else {
		    System.out.println("The automaton is neither an NFA nor a DFA.");
		}

//Input from user 
		String ins;
		
		ins = input.nextLine();
		
		String[] inArray = ins.split("");
	do {
		System.out.println("Enter the input: ");
			in = input.next();
			String in1[]= in.split("");
			for ( a=0; a<in1.length; a++) {
			for (b=0; b<alpha.length; b++) {
				if (in1[a].equals(alpha[b]))
		k = b;
		break;
		}
			}
		
	for (c=0 ;c<state.length; c++) {
		if (currentst.equals(state[c])) {
			l=c;
			break;
		}
	}
	currentst = transition[l][k];
	
//// Checking 
	

	if (currentst.equals(finals)) {
		System.out.println("The automata is accepted.");
	
	}else {
		System.out.println("The automata is not accepted.");
	}
	System.out.println("Do you want to enter another string? (1/0)");
	option= input.nextInt();
	
	}while (option ==1);
	

	}
}



	   

