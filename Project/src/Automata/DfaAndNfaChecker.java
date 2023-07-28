package Automata;
import java.util.ArrayList;
import java.util.List;


	public class DfaAndNfaChecker {

		public static boolean isNFA(String[][] transition, String[] state, String[] alpha) {
	        // Check if there are any epsilon transitions.
	        for (int i = 0; i < state.length; i++) {
	            for (int j = 0; j < alpha.length; j++) {
	                if (transition[i][j].equals("e")) {
	                    return true;
	                }
	            }
	        }

	        return false;
	    }

	    public static boolean isDFA(String[][] transition, String[] state, String[] alpha) {
	        // Check if there are any states with multiple transitions for the same input symbol.
	        for (int i = 0; i < state.length; i++) {
	            for (int j = 0; j < alpha.length; j++) {
	                List<String> destinations = new ArrayList<>();
	                for (int k = 0; k < state.length; k++) {
	                    if (transition[i][j].equals(state[k])) {
	                        destinations.add(state[k]);
	                    }
	                }

	                if (destinations.size() > 1) {
	                    return false;
	                }
	            }
	        }

	        return true;
	    }
}


