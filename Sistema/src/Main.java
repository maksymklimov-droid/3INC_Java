/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author Maksym
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        int[] dati = {0, 0, 0, 0, 1, 1, 1};
        Sistema mioSistema = new Sistema(dati);
        int indiceAccensione0 = mioSistema.accensione();           
        if (indiceAccensione0 > -1) {
            System.out.println("Il sistema si accende all'indice: " + indiceAccensione0);
        } else {
            System.out.println("Non acceso!");
        }
    }
}
