import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Teste {
	

	public static void main(String[] args) throws IOException {
	
	   ArrayList numeros = new ArrayList();
	          
	    Scanner inputFile  = new Scanner( new FileReader("C:\\Users\\Crisdavid\\Downloads\\Ordenacao\\teste_10000_3.dat"));
	          
	      while(inputFile.hasNextInt()) {
	      numeros.add(inputFile.nextInt());
	        }
	      int cont = 0;
			   for(int i = 0; i<numeros.size(); i++) {
			     cont++;
			      }
	       int [] aux = new int[cont - 1];
	       for(int j = 0; j<aux.length; j++) {
        		aux[j] = (int) numeros.get(j); 	 
	         }
	         
	         inputFile.close();
	         
	         long tempoInicio = System.currentTimeMillis(); 
	         mergeSort(aux, aux.length);
	         System.out.println("Tempo Total: "+(System.currentTimeMillis()-tempoInicio));      
	}

	private static void mergeSort(int [] a, int n) {
		
       	    if (n < 2) {
       	        return;
       	    }
       	    int mid = n / 2;
       	    int[] l = new int[mid];
       	    int[] r = new int[n - mid];
       	 
       	    for (int i = 0; i < mid; i++) {
       	        l[i] = a[i];
       	    }
       	    for (int i = mid; i < n; i++) {
       	        r[i - mid] = a[i];
       	    }
       	    mergeSort(l, mid);
       	    mergeSort(r, n - mid);
       	 
       	    merge(a, l, r, mid, n - mid);
       	    
	}
	
	public static void merge(
			  int[] a, int[] l, int[] r, int left, int right) {
		
			    int i = 0, j = 0, k = 0;
			    while (i < left && j < right) {
			        if (l[i] <= r[j]) {
			            a[k++] = l[i++];
			        }
			        else {
			            a[k++] = r[j++];
			        }
			    }
			    while (i < left) {
			        a[k++] = l[i++];
			    }
			    while (j < right) {
			        a[k++] = r[j++];
			    }
			
		int cont = 0;
		 for (int w = 0; w<a.length; w++) {
			 System.out.println(a[w]);
			 cont++;
		 }
		 System.out.println("Número de elementos ordenados: " + cont);
			}

}
