//LEGGERE LE ISTRUZIONI NEL FILE README.md

//Import di Classi Java necessarie al funzionamento del programma
import java.util.Scanner;
import java.util.Random;

// Classe principale, con metodo main
class Esercizio {

    public static Scanner in = new Scanner(System.in);

    public static void bubbleSort(int[] V, int N){

        int i = 0;
        int j;
        int temp;
        boolean scambio = true;

        while(i < N-1 && scambio){
            scambio = false;
            j = i + 1;
            while(j < N){
                if(V[i] > V[j]){
                    temp = V[i];
                    V[i] = V[j];
                    V[j] = temp;
                    scambio = true;
                }
                ++j;
            }
            ++i;
        }

    }

    public static int ricercaBinaria(int[] V, int N, int e){
        int inizio = 0;
        int fine = N - 1;
        int medio;
        int posizione = -1;
        boolean trovato = false;

        while(inizio <= fine && !trovato){
            medio = inizio + (fine - inizio) / 2;
            if(V[medio] == e){
                posizione = medio;
                trovato  = true;
            }else if(V[medio] < e){
                inizio = medio + 1;
            }else{
                fine = medio - 1;
            }
        }

        return posizione;
    }

    public static int merge(int[] V, int Nv, int[] W, int Nw, int[] Vm){
        int i = 0;
        int j = 0;
        int k = 0;

        while(i < Nv && j < Nw){
            if(V[i] <= W[j]){
                Vm[k] = V[i];
                ++i;
            }else{
                Vm[k] = W[j];
                ++j;
            }
            ++k;
        }

        while(i < Nv){
            Vm[k] = V[i];
            ++k;
            ++i;
        }

        while(j < Nw){
            Vm[k] = W[j];
            ++k;
            ++j;
        }
        
        return k;
    }

    public static void visualizzaVettore(int[] V, int N){
        int i = 0;

        while(i < N){
            System.out.println(i + 1 + "° elemento: " + V[i]);
        }
    
    }

    public static int sceltaOperazione(){
        int scelta;
        do{
            System.out.print("Scegli operazione: /n1.BubbleSort /n2.RicercaBinaria /n3.Merge /n4.VisualizzaVettore /n5.Esci /nOpzione: ");
            scelta = Integer.parseInt(in.nextLine());
            if(scelta <= 0 || scelta > 5){
                System.out.println("Scegliere un opzione valida!");
            }
        }while(scelta <= 0 || scelta > 5);

        return scelta;
           
    }

    public static void main(String args[]){

       Random rand = new Random();
    
       int N, i, num;

       do {
            System.out.print("Inserire la dimensione del vettore: ");
            N = Integer.parseInt(in.nextLine());
            if(N <= 0){
                System.out.println("Inserire un valore maggiore di 0!");
            }
       } while (N <= 0);

       int[] Vp = new int[N];
       int[] Vd = new int[N];
       int[] Vm = new int[N*2];
       int Nm = 0;
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

       int scelta;
       int tipo;
       int valore;

        do{
            scelta = sceltaOperazione();

            if(scelta == 1){
                do{
                    System.out.print("Su quale vettore vuoi agire (1/2): ");
                    tipo = Integer.parseInt(in.nextLine());
                    if(tipo < 1 || tipo > 2){
                        System.out.println("Inserire un valore valido!");
                    }
                }while(tipo < 1 || tipo > 2);

                if(tipo == 1){
                    bubbleSort(Vp, Np);
                }else{
                    bubbleSort(Vd, Nd);
                }

            }else if(scelta == 2){

                System.out.print("Inserire valore da ricercare: ");
                valore = Integer.parseInt(in.nextLine());

                do{
                    System.out.print("Su quale vettore vuoi agire (1/2): ");
                    tipo = Integer.parseInt(in.nextLine());
                    if(tipo < 1 || tipo > 2){
                        System.out.println("Inserire un valore valido!");
                    }
                }while(tipo < 1 || tipo > 2);

                if(tipo == 1){
                    valore = ricercaBinaria(Vp, Np, valore);
                }else{
                    valore = ricercaBinaria(Vd, Nd, valore);
                }

                if(valore != -1){
                    System.out.println("Elemento trovato alla posizione: " + valore);
                }else{
                    System.out.println("Elemento non trovato!");
                }


            }else if(scelta == 3){
                Nm = merge(Vp, N, Vd, N, Vm);
            }else if(scelta == 4){
                do{
                    System.out.print("Su quale vettore vuoi agire (1/2/3): ");
                    tipo = Integer.parseInt(in.nextLine());
                    if(tipo < 1 || tipo > 3){
                        System.out.println("Inserire un valore valido!");
                    }
                }while(tipo < 1 || tipo > 3);

                if(tipo == 1){
                    visualizzaVettore(Vp, Np);
                }else if(tipo == 2){
                    visualizzaVettore(Vd, Nd);
                }else{
                    visualizzaVettore(Vm, Nm);
                }
            }
        }while(scelta != 5);
    }
}

//LEGGERE LE ISTRUZIONI NEL FILE README.md