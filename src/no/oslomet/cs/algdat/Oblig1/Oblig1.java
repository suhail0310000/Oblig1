package no.oslomet.cs.algdat.Oblig1;

import java.util.NoSuchElementException;

public class Oblig1 {

    public static int maks(int[] a) {
        if (a.length < 1) {
            throw new NoSuchElementException("Tabellen er tom");
        }

        int begin = 0;
        int end = a.length - 1;

        for (int i = begin; i < end; i++) {
            if (a[i] > a[i + 1]) {
                //BYTT-> INVERSJON
                int temp = a[i];
                a[i] = a[i + 1];
                a[i + 1] = temp;
            } else {
                //ingen inversjon
            }
        }

        return a[a.length - 1];
    }

    public static int ombyttinger(int[] a) {
        int antallOmbyttinger = 0;
        for (int i = 0; i < a.length - 1; i++) {
            if (a[i] > a[i + 1]) {
                //BYTT-> INVERSJON
                int temp = a[i];
                a[i] = a[i + 1];
                a[i + 1] = temp;
                antallOmbyttinger++;
            }
        }

        return antallOmbyttinger;
    }

    ///// Oppgave 2 //////////////////////////////////////
    public static int antallUlikeSortert(int[] a) {
        if(a.length == 0){
            return 0;
        }
        int unik = 1;
        for(int i = 1; i<a.length; i++){
            if(a[i-1] > a[i]){
                throw new IllegalStateException("Arrayet er ikke sortert!");
            }
            else if(a[i-1] != a[i]){
                unik++;
            }
        }
        return unik;

    }


    ///// Oppgave 3 //////////////////////////////////////
    public static int antallUlikeUsortert(int[] a) {
        if(a.length == 0){
            return 0;
        }
        int unikeElementer = 0;
        for(int i = 0; i<a.length; i++){
            boolean unik = false;
            for(int j = 0; j<i; j++){
                if(a[i] == a[j]){
                    unik = true;
                    break;
                }
            }
            if(!unik){
                unikeElementer++;
            }
        }
        return unikeElementer;
    }

    public static void delsortering(){

    }

    public static void rotasjon(char[] a){
        if(a.length == 0){
            return;
        }
        char siste = a[a.length-1];

        for(int i = a.length-1; i>0; i--){
            a[i] = a[i-1];
        }
        a[0] = siste;

    }
}




