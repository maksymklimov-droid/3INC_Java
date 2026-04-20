/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Maksym
 */
public class Sistema {

    private int[] stati;

    public Sistema(int[] stati) {
        this.stati = stati;
    }

    public int accensione() {
        int ris =-1;
        int right = stati.length-1;
        int left = 0;
        int mid;
        
        while(left<=right){
            mid=(left+right)/2;
            if(stati[mid]==1){
                ris=mid;
                right=mid-1;
            }else{
                left=mid+1;
            }
        }
        return ris; 
    }

    public int[] getStati() {
        return stati;
    }

}
