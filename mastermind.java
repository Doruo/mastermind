
import java.util.*;
import java.lang.*;

public class Main { // à renommer "MasterMindBase" lors du rendu
    
    public static void main(String[] args) 
    { 
        initMasterMind();
    }
    
    // Fonctions Pratiques à réutiliser ///////////////////////////////////////////////////////////
    
    public static void clearConsole() 
    {
        // Action : efface la console (le terminal)
        System.out.print("\033[H\033[2J");
    }
   
    // Met en pause le programme
    public static void pause (int timeMilli) {
	// Action : suspend le processus courant pendant timeMilli millisecondes
	try {
	    Thread.sleep(timeMilli); 
	} catch(InterruptedException ex) {
	    ex.printStackTrace();
	}
    }
    
    public static void sautLigne()
    {System.out.println("");}
    
    public static void DoubleSautLigne() 
    {sautLigne();sautLigne();}
    
    // ////////////////////////////////////////////////////////////////////////////////////////////
    
    public static char[] saisieCouleur()
    {
        Scanner input = new Scanner(System.in);
        System.out.println("Saisir le nombre de couleurs possibles");
        int nbCouleurs = input.nextInt();
        char[] tabCoul = new char[nbCouleurs];
        
        if (nbCouleurs>0) 
        {
            for (int i =0 ; i<(tabCoul.length);i++) // Saisie tableau couleurs
            {
                System.out.println("Saisir une couleur souhaitée");
                String coul = input.next(); 
                tabCoul[i]= coul.charAt(0);
            }
            
            System.out.print("Couleurs choisis: ");
            for (int i =0 ; i<(tabCoul.length);i++) // Affichage tableau couleurs
            {
                System.out.print(tabCoul[i]+" ");
            }
        }
        return tabCoul;
    }
    
    /** pré-requis : aucun
	action : demande au joueur humain de saisir un entier pair strictement positif, 
    avec re-saisie éventuelle jusqu'à ce qu'elle soit correcte
	résultat : l'entier pair strictement positif saisi*/
    public static int saisirEntierPairPositif()
    {
        Scanner input = new Scanner (System.in);
        int saisie=0;
        
        System.out.println("Saisir un entier pair positif");
        saisie = input.nextInt();
            
        // si impaire ou pas inferieur ou égale à 0
        if (saisie %2!=0 || saisie <=0) // recommancer saisie
        {
            System.out.println("Saisir un entier pair positif");
            saisie = input.nextInt();
        }
        return saisie;
    }
    
    
    /** pré-requis : aucun
	action : demande au joueur humain de saisir un entier strictement positif, 
    avec re-saisie éventuelle jusqu'à ce qu'elle soit correcte
	résultat : l'entier strictement positif saisi
    */
    public static int saisirEntierPositif() 
    {
        Scanner scanner = new Scanner (System.in);
        int saisie=0;
        
        System.out.println("Saisir un entier positif");
        saisie = scanner.nextInt();
        
        if (saisie <=0) // si impaire ou pas inferieur ou égale à 0
        {
            System.out.println("Saisir un entier positif");
            saisie = scanner.nextInt();
        }
        return saisie;	
    }
    
    /** pré-requis : nb >= 0
	résultat : un tableau de nb entiers égaux à val
    */
    public static int[] initTab(int nb, int val) 
    {   // nb : nombre d'entiers | val : valeur dans tableau
        int tab[];
        tab = new int[nb]; 
		
		// attribue longueur lorsque nb est correct
        if (nb >=0) 
        {
            for (int i=0; i<tab.length;i++)
            {
                tab[i]=val;
            }
        }
        return tab;
    }	
    
        /** pré-requis : aucun
	résultat : une copie de tab
    */
    public static int[] copieTab(int[] tab)
    {
	    int tabCopie[];
	    tabCopie = new int [tab.length];
	    
	    for (int i=0;i<tab.length;i++)
	    {
	        tabCopie[i]=tab[i];
	    }
	    return tabCopie;
    }
	
	    /** pré-requis : aucun
	résultat : la liste des éléments de t entre parenthèses et séparés par des virgules */
    public static String listElem(char[] t)
    
	{	
		String listElem=null;	
		
		for (int i=0;i<t.length;i++)
		{
			listElem="("+t[i]+"),";
			System.out.print(listElem);
		}
		return listElem;
    }
    
    /** pré-requis : aucun
	résultat : le plus grand indice d'une case de t contenant c s'il existe, -1 sinon*/
    public static int plusGrandIndice(char[] t, char c)
    {
        int plusGrandIndice=0;
        for (int i=0; i<t.length;i++)
        {
            if(t[i]=='c')
            {
                plusGrandIndice=i;
            }
            else 
            {
                plusGrandIndice--;
            }
        }
        return plusGrandIndice;
    }
    
        /** pré-requis : aucun
	résultat : vrai ssi c est un élément de t
	stratégie : utilise la fonction plusGrandIndice
    */
    public static boolean estPresent(char[] t, char c)
    {
        boolean estPresent=false;     
        
        for (int i=0; i<t.length;i++)
        {
            if (plusGrandIndice(t,c)>0) // c est un élément de t
            {
                estPresent=true;
            }
            else
            {
                estPresent=false;
            }
        }
         return estPresent;
    }
    
    public static void initMasterMind ()
    {
        System.out.println("Bienvenue dans le jeu du MasterMind !"); sautLigne();
        
        System.out.println("Nombre de pions du code secret");
        int lgCode = saisirEntierPositif(); 
        sautLigne();
        
        char[] nbCouleurs = saisieCouleur();
        sautLigne();
        
        System.out.println("Nombre de manches");
        int nbManches = saisirEntierPairPositif();
        sautLigne();
        
        System.out.println("Nombre d'essais");
        int nbEssaisMax = saisirEntierPositif(); 
        sautLigne();
        
        System.out.print("Initialisation terminée");
    }
}
