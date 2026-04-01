/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pokemon;

/**
 *
 * @author maksym.klimov
 */
public class Pokemon {
    private String nome;
    private String tipo;
    private int livello;
    private int puntiVita;
    private String codicePokemon;
    
    private String[] mosse;
    private int[] danniMosse; 
    private int nMosse;
    
    private int[] puntiPartite; 
    private int nPartite;

    public Pokemon(String nome, String tipo, int livello, int puntiVita) {
        this.nome = nome;
        this.tipo = tipo;
        this.livello = livello;
        this.puntiVita = puntiVita;
        
        this.mosse = new String[4]; 
        this.danniMosse = new int[4]; 
        this.nMosse = 0;
        
        this.puntiPartite = new int[10]; 
        this.nPartite = 0;
        
        this.codicePokemon = generaCodice(); 
    }

    private String generaCodice() {
        String primeDueNome = nome.substring(0, 2);
        String ultimeDueTipo = tipo.substring(tipo.length() - 2);
        String codice = primeDueNome + ultimeDueTipo + livello;
        return codice.toUpperCase();
    }

    public String attacca(Pokemon other) {
        if (this.livello > other.livello) {
            return this.nome; 
        } else {
            return other.nome; 
        }
    }

    public void aggiungiMossa(String nomeMossa, int dannoMossa) {
        if (nMosse < 4) {
            mosse[nMosse] = nomeMossa;
            danniMosse[nMosse] = dannoMossa; 
            nMosse++;
        } else {
            System.out.println("Il Pokémon ha già 4 mosse!");
        }
    }

    public int potenzaAttacco(int indiceMossa) {
        if (indiceMossa >= 0 && indiceMossa < nMosse) {
            return livello + danniMosse[indiceMossa];
        } else {
            System.out.println("Indice mossa non valido!");
            return 0; 
        }
    }

    public int calcolaPuntiPartita(int potenza) {
        return potenza * 2;
    }

    public void stampaMosse() {
        for (int i = 0; i < nMosse; i++) {
            System.out.print(mosse[i] + " (Danno: " + danniMosse[i] + ")");
            if (i < nMosse - 1) {
                System.out.print(" | "); 
            }
        }
        System.out.println();
    }

    public void registraPartita(int punteggio) {
        if (nPartite < 10) {
            puntiPartite[nPartite] = punteggio;
            nPartite++;
        }
    }

    public String stampaStorico() {
        String storico = "";
        for (int i = 0; i < nPartite; i++) {
            storico += "Partita " + i + " -> " + puntiPartite[i] + "\n";
        }
        return storico;
    }

    public int migliorPunteggio() {
        int max = 0;
        for (int i = 0; i < nPartite; i++) {
            if (puntiPartite[i] > max) {
                max = puntiPartite[i];
            }
        }
        return max;
    }

    public double mediaPunti() {
        if (nPartite == 0) return 0;
        double somma = 0;
        for (int i = 0; i < nPartite; i++) {
            somma += puntiPartite[i];
        }
        return somma / nPartite;
    }

    public boolean haBattutoRecord(int punteggio) {
        return punteggio > migliorPunteggio();
    }

    public int partiteVinte() {
        int vinte = 0;
        for (int i = 0; i < nPartite; i++) {
            if (puntiPartite[i] > 50) { 
                vinte++;
            }
        }
        return vinte;
    }

    public String analisiPokemon() {
        return "Pokemon: " + nome + "\n" +
               "Miglior punteggio: " + migliorPunteggio() + "\n" +
               "Media punti: " + mediaPunti() + "\n" +
               "Partite vinte: " + partiteVinte();
    }
    
public void combatti(Pokemon avversario, int mossa1, int mossa2) {
    
    int miaPotenza = this.potenzaAttacco(mossa1);
    int suaPotenza = avversario.potenzaAttacco(mossa2);

    int mieiPunti = this.calcolaPuntiPartita(miaPotenza);
    int suoiPunti = avversario.calcolaPuntiPartita(suaPotenza);

    if (miaPotenza > suaPotenza) {
        mieiPunti += 20;
        System.out.println(this.nome + " vince il round!");
    } else if (suaPotenza > miaPotenza) {
        suoiPunti += 20;
        System.out.println(avversario.nome + " vince il round!");
    } else {
        System.out.println("Pareggio!");
    }

    this.registraPartita(mieiPunti);
    avversario.registraPartita(suoiPunti);
        
    }
}

