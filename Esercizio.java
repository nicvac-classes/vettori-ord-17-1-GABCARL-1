//LEGGERE LE ISTRUZIONI NEL FILE README.md

//Import di Classi Java necessarie al funzionamento del programma
import java.util.Scanner;
import java.util.Random;

// Classe principale, con metodo main
class Esercizio {

    public static void main(String args[]){

       
       Scanner in = new Scanner(System.in);
       Random rand = new Random();
    
       int N, i, num;

       do {
            System.out.print("Inserire la dimensione del vettore: ");
            N = Integer.parseInt(in.nextLine());
            if(N <= 0){
                System.out.println("Inserire un valore superiore di 0!");
            }
       } while (N <= 0);

       int[] Vp = new int[N];
       int[] Vd = new int[N];
       int Np = 0;
       int Nd = 0;

       i = 0;
       while(i < N){
            num = rand.nextInt(N*10) + 1;
            if(num % 2 == 0){
                Vp[Np] = num;
                ++Np;
            }else{
                Vd[Nd] = num;
                ++Nd;
            }
            ++i;
       }
    }
}

//LEGGERE LE ISTRUZIONI NEL FILE README.md