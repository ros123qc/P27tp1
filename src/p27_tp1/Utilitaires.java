package p27_tp1;

/**
 *
 * @author Antoine Tardif
 * @author Rostand Prud'Homme
 */
public class Utilitaires {
    
    public static int[] GenererTabIndex(int[][] tab2d) {
        /**
         * Générer un tableau d'index simple, non trié
         * @param tab2d Tableau 2d à indexer
         */
        
        //Tab d'index vide
        int[] tabIndex = null;
        
        //Générer le tableau
        for (int i = 0; i < tab2d.length; i++){
            tabIndex[i] = i;
        }
        
        return tabIndex;
    }
    
    public static int CalculerNoteFinale(int[] tabLigne) {
        /**
         * Calcule la note finale en tenant compte des pondérations
         * Retourne un int
         * @param tabLigne Tableau contenant les infos d'examen 
         */
        
        int ex1 = tabLigne[1] / 4;          //Exam1 (25% note finale)
        int ex2 = tabLigne[2] / 100 * 30;   //Exam2 (30% note finale)
        int tp1 = tabLigne[3] / 5;          //TP1 (20% note finale)
        int tp2 = tabLigne[4] / 4;          //TP2 (25% note finale)
        
        return ex1 + ex2 + tp1 + tp2;
    }
    
    public static int SupprimerLigneTab2D(int[][] tab2d, int index, int nbEleves) {
        /**
         * Écraser la ligne à l'index sélectionné
         * @param tab2d Tableau 2D de notes (avec DA)
         * @param index Index de la ligne à supprimer
         * @param nbEleves Nombres d'élèves dans le tableau
         */
        
        //Déplacer les lignes de 1 vers le haut
        for (int i = index; i < nbEleves - 1; i++) {
            for (int j = 0; j <= 5; j++) {
                tab2d[i][j] = tab2d[i+1][j];
            }
        }
        
        //Décrémenter le nombre d'élèves
        nbEleves--;
        
        return nbEleves;
    }
    
    public static int AjouterLigneTab2D(int[][] tab2d, int[] tabLigne, int nbEleves) {
        /**
         * Ajouter une ligne dans un tab 2D
         * @param tab2d Tableau dans lequel la ligne sera ajoutée
         * @param tabLigne Tableau contenant les données à ajouter
         * @param nbEleves Nombre d'élèves dans le tableau
         */
        
        //Ajouter les nouvelles données dans le tableau
        for (int i = 0; i <= 5; i++) {
            tab2d[nbEleves][i] = tabLigne[i];
        }
        
        //Incrémenter le nombre d'élèves
        nbEleves++;
        
        return nbEleves;
    }
    
    public static void ModifierLigneTab2D(int[][] tab2d, int[] tabLigne, int index) {
        /**
         * Modifier un ligne d'un tab 2D
         * @param tab2d Tableau dans lequel la ligne sera modifiée
         * @param tabLigne Tableau contenant les données à ajouter 
         * @param index Index de la ligne à modifier
         */
        
        //Modifier les données du tableau
        for (int i = 0; i <= 5; i++) {
            tab2d[index][i] = tabLigne[i];
        }
    }
    
    public static float moyenneEval(int[][] tab2d, int indEval, int nbElements) {
        /**
         * Moyenne d'une éval sur les n premiers éléments
         * @param tab2d Tableau de notes
         * @param indEval Évaluation pour laquelle la moyenne est calculée
         * @param nbElements Nombres d'éleves sur lequels calculer la moyenne
         */
        
        if (nbElements != 0) {
            float somme = 0;

            //Calculer la somme des éléments
            for (int indLig = 0; indLig < nbElements; indLig++) {
                somme = somme + tab2d[indLig][indEval];
            }

            //Calculer la moyenne
            return somme / nbElements;

        } else {
            return -1;
        }
    }
    
    public static int minEval(int[][] tab2d, int indEval, int nbElements) {
        int min = -1;

        if (nbElements != 0) {
            min = tab2d[0][indEval];
            
            //Parcourir le tab et calculer le minimum
            for (int indLig = 0; indLig < nbElements; indLig++) {
                if (tab2d[indLig][indEval] < min) {
                    min = tab2d[indLig][indEval];
                }
            }
        }

        return min;
    }
    
    public static int maxEval(int[][] tab2d, int indEval, int nbElements) {
        int max = -1;
        
        if (nbElements != 0) {
            max = tab2d[0][indEval];
            
            //Parcourir le tab et calculer le maximum
            for (int indLig = 0; indLig < nbElements; indLig++) {

                if (tab2d[indLig][indEval] > max) {
                    max = tab2d[indLig][indEval];
                }
            }
        }
        
        return max;
    }
}
