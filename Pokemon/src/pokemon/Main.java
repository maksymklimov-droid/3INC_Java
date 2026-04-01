/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pokemon;

/**
 *
 * @author maksym.klimov
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("TEST PARTE 1 & 2: Creazione e Attacco");
        Pokemon p1 = new Pokemon("Pikachu", "Elettro", 12, 100);
        Pokemon p2 = new Pokemon("Charmander", "Fuoco", 10, 90);
        
        System.out.println("Risultato attacco p1 vs p2: " + p1.attacca(p2)); 
        
        System.out.println("Risultato attacco p2 vs p1: " + p2.attacca(p1)); 


        System.out.println("\nTEST ESTENSIONE: Mosse");
        p1.aggiungiMossa("Tuono", 10);
        p1.aggiungiMossa("Fulmine", 15);
        p1.aggiungiMossa("Attacco rapido", 5);
        p1.aggiungiMossa("Codacciaio", 20);
        
        System.out.print("Mosse di Pikachu: ");
        p1.stampaMosse(); 
        
        System.out.print("Provo ad aggiungere la 5° mossa: ");
        p1.aggiungiMossa("Locomotore", 10); 


        System.out.println("\nTEST PARTE 3 & 4: Storico Partite");
        p1.registraPartita(50);
        p1.registraPartita(25);
        p1.registraPartita(80);
        p1.registraPartita(40);
        
        System.out.println("Storico:");
        System.out.print(p1.stampaStorico()); 
        
        System.out.println("Record: " + p1.migliorPunteggio()); 
        System.out.println("Media: " + p1.mediaPunti()); 
        System.out.println("Vittorie: " + p1.partiteVinte()); 
        

        System.out.println("\nTEST AGGIUNTIVI: Metodi rimanenti");  
        System.out.println("Il punteggio 90 ha battuto il record? " + p1.haBattutoRecord(90));
        System.out.println("Il punteggio 60 ha battuto il record? " + p1.haBattutoRecord(60));
        
        System.out.println("\nAnalisi riassuntiva:");
        System.out.println(p1.analisiPokemon());
        
        System.out.println("\nTEST PARTE 5: Il Grande Combattimento");
        p2.aggiungiMossa("Braciere", 15);
        p2.aggiungiMossa("Graffio", 10);

        System.out.println("Situazione pre-combattimento:");
        System.out.println("Media punti Pikachu: " + p1.mediaPunti());
        System.out.println("Media punti Charmander: " + p2.mediaPunti());

        System.out.println("\nInizia lo scontro!");
        p1.combatti(p2, 1, 0); 

        System.out.println("\nSituazione post-combattimento:");
        System.out.println("Nuovo storico Pikachu:\n" + p1.stampaStorico());
        System.out.println("Nuovo storico Charmander:\n" + p2.stampaStorico());

        System.out.println("\nTEST EXTRA: Potenza e Punti isolati");
        int potPikachu = p1.potenzaAttacco(3); 
        int puntiTeorici = p1.calcolaPuntiPartita(potPikachu); 
        
        System.out.println("Test manuale Pikachu - Mossa 'Codacciaio':");
        System.out.println("Potenza calcolata: " + potPikachu + " (Aspettato: 32)");
        System.out.println("Punti calcolati: " + puntiTeorici + " (Aspettato: 64)");
    }
    
}
