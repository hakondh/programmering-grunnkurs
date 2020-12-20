import java.util.*;

class Sortere {
	public static void main (String[] args){




		int[] tall = {1,3,5,1,5,7,9,64,54,3,2,2,45,346,67,87,4,3,};

		//Orginalt
		System.out.println("Orginale ");
		for(int i =0; i < tall.length; i++){
			System.out.println(tall[i]);
		}


		//Sortere
		for (int start = 0; start < tall.length; start++){
			int hittilMinst = start;
			for (int i = start+1; i<tall.length; i++){
				if(tall[i] < tall[hittilMinst]) hittilMinst = i;
			}
			int hjelp = tall[hittilMinst];
			tall[hittilMinst] = tall[start];
			tall[start] = hjelp;
		}



		System.out.println("Nye");
		for(int i =0; i < tall.length; i++){
					System.out.println(tall[i]);
		}

		int[] nyeTall = {1,3,5,1,5,7,9,64,54,3,2,2,45,346,67,87,4,3,};

		ArrayList<Integer> tallMengde = new ArrayList<Integer>();
		for (int i = 0; i< tall.length; i++){
			tallMengde.add(nyeTall[i]);
		}

		System.out.println("NY ROTETE");

		System.out.println(tallMengde.toString());

		tallMengde.sort();

		System.out.println("NY SORTERT");

		System.out.println(tallMengde.toString());
	}
}