import java.util.Arrays;

public class Quicksort {
	public static void main (String[] args){
		int[] a = {1,2,3,4,5,6,7,8,9,10};
		sorter(a, 0, a.length-1);
	}

	public static void sorter(int[] t, int v, int h){
			        if(h-v > 2){
			            int delepos = splitt(t, v, h);
			            sorter(t, v, delepos - 1);
			            sorter(t, delepos + 1, h);
			        } else median3sort(t, v, h);
			    }

			    private static int splitt(int[] t, int v, int h){
			        int iv, ih;
			        int m = median3sort(t,v, h);
			        int dv = t[m];
			        bytt(t, m, h -1);
			        for(iv = v, ih = h - 1;;){
			            while(t[iv++] < dv);
			            while(t[ih--] > dv);
			            if(iv >= ih) break;
			            bytt(t, iv, ih);
			        }
			        bytt(t, iv, h-1);
			        return iv;
			    }

			    private static int median3sort(int[] t, int v, int h){
			        int m = (v + h)/2;
					System.out.println("m: " + m);
					System.out.println("v: " + v);
			        if(t[v] > t[m]) bytt(t, v, m);
			        if(t[m] > t[h]){
			            bytt(t, m, h);
			            if(t[v] > t[m]) bytt(t, v, m);
			        }
			        return m;
			    }

		    public static void bytt(int[] t, int i, int j){
	       		int k = t[j];
	 			t[j] = t[i];
	        	t[i] = k;
	    	}
}