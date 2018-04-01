/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package patos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author Sergio
 */
public class Patos
{

    private static ArrayList<Integer> patos = new ArrayList<>();


    public static void inserta(int pato)
    {
        int pos = Collections.binarySearch(patos, pato); // vemos la posicion
        pos = -pos - 1;

        patos.add(pos, pato);

//      patos.add(pato); // Añadimos la pareja
    }

    public static void main(String[] args) throws IOException
    {

        BufferedReader bi = new BufferedReader(new InputStreamReader(System.in));

        boolean continuar = true;

        while (continuar)
        {
            int primerpato;
            int numparejas;
            int patoencabeza = 1; // el primer elemento a mostrar es el que ocupa la poscion 1
    
            /**
             * Leo dos números, el primero es el primer elemento de la banda de patos y el siguiente el número de parejas de la
             * bandada
             */
            String s[] = bi.readLine().split(" ");
            primerpato = Integer.parseInt(s[0]);
            numparejas =  Integer.parseInt(s[1]);
            
            if (primerpato == 0 || numparejas == 0)
            // Si leemos 0 0 finalizamos
            {
                continuar = false;
            } else
            {
               String ss = bi.readLine();
               int initpos = 0, endpos = ss.indexOf(' ');
                /**
                 * Creamos un Array list para guardar la bandada
                 */
                patos.clear();
                patos.add(primerpato); // Añadimos el primer pato
                for (int i = 0; i < numparejas; i++)
                {
                    // Aquí leemos las numparejas especificadas
                    int i1 = Integer.parseInt(ss.substring(initpos, endpos));
                    initpos = endpos +1;
                    endpos = ss.indexOf(' ', initpos);
                    if (endpos < 0 )
                    {
                        endpos = ss.length();
                    } 
                    int i2 = Integer.parseInt(ss.substring(initpos, endpos));
                    initpos = endpos + 1;
                    endpos = ss.indexOf(' ', initpos);
                    if (endpos < 0 )
                    {
                        endpos = ss.length();
                    } 
                    
                    
                    inserta(i1);
                    inserta(i2);
                    System.out.print(patos.get(patoencabeza) + " "); // Imprimimos el pato central
                    patoencabeza++; // El siguiente pato central
                }
                System.out.println("");
            }
        } // while
    } // main
} // Clase patos