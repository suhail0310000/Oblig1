package no.oslomet.cs.algdat.Oblig1;

import java.util.NoSuchElementException;

import static no.oslomet.cs.algdat.Oblig1.Oblig1Test.bytt;

public class Oblig1 {
     //Oppg1
    /* Når blir det flest ombyttinger?
    Det blir flest ombyttinger, dersom de høyeste tallene har en lav indeks i array. Da vil betingelsen for if-setningen gjelde:
    if(a[i]>a[i+1), og den vil kjøres inntil arrayet er sortert fra lavest til høyest verdi.

    Når blir det færrest ombyttinger?
    Det blir færrest ombyttinger, dersom de høyeste tallene har en høyere indeks. Siden betingelsen for if-setningen vil gjelde
    minimalt vil ikke tallene inverteres.


     */
    public static int maks(int[] a) {
        if (a.length < 1) {
            throw new NoSuchElementException("Tabellen er tom");
        }
        //Bruker hovedsaklig bubblesort metoden for å få siste tallet tilslutt, så returnerer denne
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
                antallOmbyttinger++; //Teller antall ombyttinger for hver gang det byttes
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
            if(a[i-1] > a[i]){ //Hvis noen av de mindre tallene er større enn de neste, er ikke arrayet sortert
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
                unikeElementer++; //plusser alle unike elemnter
            }
        }
        return unikeElementer;
    }

    //OPPGAVE4
    public static int partisjonering(int a[], int f, int s)
    {
        int pivot = a[s]; //skilleverdi, setter den tilslutt
        int i = (f-1);
        for (int j = f; j < s; j++) {

            if (a[j] < pivot) // Hvis det vi itererer med er mindre enn skilleverdi
            {
                i++;
                // invertering->nesten lik bubblesort -> bytter a[i] med a[j]
                int temp = a[i];
                a[i] = a[j];
                a[j] = temp;
            }
        }

        int temp = a[i+1]; //Setter skilleverdien tilbake
        a[i+1] = a[s];
        a[s] = temp;
        return i+1;
    }

    public static void partisjonering2(int[] a, int f, int s)
    {
        if (f >= s){
            return;
        }
        int k = partisjonering(a, f, s);
        partisjonering2(a, f, k - 1);     // sorterer venstre side av intervallet
        partisjonering2(a, k + 1, s);     // sorterer høyre side av intervallet
    }

    public static void delsortering(int[] a){
        int oddetall = 0;
        for(int i = 0; i < a.length; i++){
            if(a[i] % 2 != 0){ //mod operator, alt som deles med to og får rest er ikke partall
                bytt(a,i,oddetall);
                oddetall++;
            }
        }
        //kjører partisjoneringsmetodene
        partisjonering2(a,0,oddetall-1);
        partisjonering2(a,oddetall,a.length-1);
    }



    //oppg5
    public static void rotasjon(char[] a){
        if(a.length == 0){
            return;
        }
        char siste = a[a.length-1]; //Siste verdien

        for(int i = a.length-1; i>0; i--){
            a[i] = a[i-1];
        }
        a[0] = siste;//siste verdien blir den første

    }


}





