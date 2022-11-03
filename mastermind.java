import java.util.*;
import java.lang.*;

public class mastermind {
    public static void main(String[] args) {
        char[] couleurs = saisieCouleur(); 
    }

    public static char[] saisieCouleur()
    {
        Scanner input = new Scanner(System.in);
        System.out.println("saisir le nombre de couleurs possibles");
        int nbCoul = input.nextInt();
        char[] tabCoul = new char[nbCoul];
        for (int i =0 ; i< (tabCoul.length);i++)
        {
            String coul = input.next();
            tabCoul[i]= coul.charAt(0);
        }
        for (int i =0 ; i< (tabCoul.length);i++)
        {
            System.out.print(tabCoul[i]+" ");
        }
        input.close();
        return tabCoul;
    }
    
    public static int saisirEntierPairPositif()
    {
        Scanner scanner = new Scanner (System.in);
        int saisie=0; // valeur à retourner
        boolean estSaisieCorrect=false; 
        
        System.out.println("Saisir un entier pair strictement positif");
        
        while(estSaisieCorrect!=true)
        {
            saisie = scanner.nextInt();
            
            if (saisie %2!=0 || saisie <=0) // si impaire ou pas inferieur ou égale à 0
            {
                System.out.println("Saisir un entier pair strictement positif");
            }
            else
            {
                estSaisieCorrect=true;
            }
        }
        return saisie;
    }
    
    public static int saisirEntierPositif()
    {
        Scanner scanner = new Scanner (System.in);
        int saisie=0; // valeur à retourner
        boolean estSaisieCorrect=false; 
        
        System.out.println("Saisir un entier strictement positif");
        
        while(estSaisieCorrect!=true)
        {
            saisie = scanner.nextInt();
            
            if (saisie <=0) // si impaire ou pas inferieur ou égale à 0
            {
                System.out.println("Saisir un entier strictement positif");
            }
            else
            {
                estSaisieCorrect=true;
            }
        }
        return saisie;	
    }
    
    public static int[] initTab(int nb, int val) 
    {   // nb : nombre d'entiers | val : valeur dans tableau
        int tab[];
        tab = new int[nb]; // attribue longueur lorsque nb est correct
        
        if (nb >=0) 
        {
            for (int i=0; i<tab.length;i++)
            {
                tab[i]=val;
            }
        }
        else
        {
            System.out.println("Erreur init tableau : nombre d'entier doit etre supérieur ou égale à zéro.");
        }
        return tab;
    }
    
    public static int[] copieTab(int[] tab)
    {
	    int tabCopie[];
	    tabCopie = new int [tab.length];
	    
	    for (int i=0;i<tabCopie.length;i++)
	    {
	        tabCopie[i]=tab[i];
	    }
	    return tabCopie;
    }
