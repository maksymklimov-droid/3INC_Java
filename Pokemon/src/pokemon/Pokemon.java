/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pokemon;

/**
 *
 * @author maksym.klimov asdasdasdasdasdasd
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

    public String attacca(Pokemon avversario) {
        String attaco;
        if (this.livello > avversario.livello) {
            attaco = nome; 
        } else {
            attaco = avversario.nome; 
        }
        return attaco;
    }

    public boolean aggiungiMossa(String nomeMossa, int dannoMossa) {
        boolean prova=false;
        if (nMosse < 4) {
            mosse[nMosse] = nomeMossa;
            danniMosse[nMosse] = dannoMossa; 
            nMosse++;
            prova=true;
        }
        return prova;
    }

    public int potenzaAttacco(int indiceMossa) {
        int npotenza=0;
        if (indiceMossa >= 0 && indiceMossa < nMosse) {
            npotenza = livello + danniMosse[indiceMossa];
        }
        return npotenza;
    }

    public int calcolaPuntiPartita(int potenza) {
        int potenzaNuovo = potenza * 2;
        return potenzaNuovo;
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
            storico += "Partita " + i + " - " + puntiPartite[i] + "\n";
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
    
public String combatti(Pokemon avversario, int mossa1, int mossa2) {
    
    int miaPotenza = potenzaAttacco(mossa1);
    int suaPotenza = avversario.potenzaAttacco(mossa2);
    int mieiPunti = calcolaPuntiPartita(miaPotenza);
    int suoiPunti = avversario.calcolaPuntiPartita(suaPotenza);
    String msg="Pareggio";
    
    if (miaPotenza > suaPotenza) {
        mieiPunti += 20;
        msg = nome + " vince il round!";
    } else if (suaPotenza > miaPotenza) {
        suoiPunti += 20;
        msg = avversario.nome + " vince il round!";
    }

    registraPartita(mieiPunti);
    avversario.registraPartita(suoiPunti);
    return msg;
    }
}

