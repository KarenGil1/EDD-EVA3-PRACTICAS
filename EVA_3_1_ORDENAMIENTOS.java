/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eva_3_1_ordenamientos;

import java.util.Arrays;

/**
 *
 * @author vane_
 */
public class EVA_3_1_ORDENAMIENTOS {

   public class EVA3_2_ORDENAMIENTOS {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int[] datos = new int[10];
        int[] copiaSel = new int[datos.length];
        int[] copiaIns = new int[datos.length];
        int[] copiaBubble = new int[datos.length];
        int[] copiaQuickS = new int[datos.length];
        long iniT, finT;
        llenar(datos);//envio el arreglo a llenar

        duplicar(datos, copiaSel);
        Arrays.sort(copiaSel);
        System.out.println("PRUEBA CON SELECTION SORT: ");
        duplicar(datos, copiaSel);
        //imprimir); 
        iniT = System.nanoTime();
        selectionSort(copiaSel);
        finT = System.nanoTime();//tiempo al terminar
        //imprimir - Imprimir contenido
        System.out.println("Tiempo en Ordenar: " + (finT - iniT));

        System.out.println("PRUEBA CON INSERTION SORT: ");
        duplicar(datos, copiaIns);
        //imprimir copiaIns - imprimir contenido
        iniT = System.nanoTime();
        insertionSort(copiaIns);
        finT = System.nanoTime();//tiempo al terminar el metodo
        //imprimir copiaIns - Imprimir contenido
        System.out.println("Tiempo en Ordenar: " + (finT - iniT));

        System.out.println("PRUEBA CON BUBBLE SORT: ");
        duplicar(datos, copiaBubble);
        //imprimir copiaBubble - imprimir contenido
        iniT = System.nanoTime();
        bubbleSort(copiaBubble);
        finT = System.nanoTime();//tiempo al terminar el metodo
        //imprimir - Imprimir contenido
        System.out.println("Tiempo en Ordenar: " + (finT - iniT));

        System.out.println("PRUEBA CON QUICKSORT: ");
        duplicar(datos, copiaQuickS);
        //imprimir copiaQuickS - imprimir contenido
        iniT = System.nanoTime();
        quickSort(copiaQuickS);
        finT = System.nanoTime();//tiempo al terminar el metodo
        //imprimir copiaQuickS - Imprimir contenido
        System.out.println("Tiempo en Ordenar: " + (finT - iniT));

        System.out.println("PRUEBA CON ARRAYS SORT: ");
        duplicar(datos, copiaSel);
        //imprimir copiaSel - imprimir contenido
        iniT = System.nanoTime();
        Arrays.sort(copiaSel);
        finT = System.nanoTime();//tiempo al terminar el metodo
        //imprimir copiaSel - Imprimir contenido
        System.out.println("Tiempo en Ordenar: " + (finT - iniT));

    }

    public static void llenar(int[] datos) {
        for (int i = 0; i < datos.length; i++) {
            datos[i] = (int) (Math.random() * 100);
        }
    }

    //DUPLICAR ARREGLO(ARREGLOS DEL MISMO TAMAÑO)
    public static void duplicar(int[] datos, int[] copia) {
        for (int i = 0; i < datos.length; i++) {
            copia[i] = datos[i];
        }
    }
//COPIA DE ARREGLO

    //IMPRIMIR ARREGLO
    public static void imprimir(int[] datos) {

        for (int i = 1; i < datos.length; i++) {
            System.out.print("[" + datos[i] + "]");
        }
        System.out.println("");
    }

    public static void selectionSort(int[] datos) {

        for (int i = 0; i < datos.length; i++) {
            int iMin = i;//EMPIEZA 
            for (int j = i + 1; j < datos.length; j++) {
                if (datos[j] < datos[iMin]) {
                    iMin = j;
                }
            }
            //INTERCAMBIO
            if (i != iMin) {
                //3 PASOS
                //RESPALDAR UN VALOR 
                int iTemp = datos[i];
                //INTERCAMBIAR UN VALOR
                datos[i] = datos[iMin];
                //REPONER EL VALOR RESPALDADO 
                datos[iMin] = iTemp;
            }
        }
    }

    public static void insertionSort(int[] datos) {
        for (int i = 1; i < datos.length; i++) {
            int temp = datos[i];//valor a insertar
            int insP = i;//posicion donde vamos a insertar
            for (int prev = i - 1; prev >= 0; prev--) {
                if (datos[prev] > temp) {
                    datos[insP] = datos[prev];//movemos valor de prev hasta la posicion de insP        
                    insP--;//retrocede una posicion
                } else {
                    break;
                }
            }
            //insertamos
            datos[insP] = temp;
        }
    }

    public static void bubbleSort(int[] datos) {
        for (int i = 0; i < datos.length; i++) {
            for (int j = 0; j < (datos.length - 1); j++) {
                if (datos[j] > datos[j + 1]) { //comparamos j (j +1)
                    //Intercambiamos
                    int temp = datos[j];
                    datos[j] = datos[j + 1];
                    datos[j + 1] = temp;

                }

            }
        }
    }
    //QUICKSORT

    public static void quickSort(int[] datos) {
        quickSortRecu(datos, 0, datos.length - 1);//quickSort a todo el arreglo
    }

    private static void quickSortRecu(int[] datos, int ini, int fin) {
        int iPivote;//inicio
        int too_big;//busca a los mas grandes del pivote
        int too_small;//busca a los mas pequeños del pivote
        boolean stopBig = false, stopSmall = false;
//Controlar
        int tama = fin - ini + 1;
        if (tama > 1) {//¿Cuando SI puedo realizar un quickSort?
            iPivote = ini;
            too_big = ini + 1;
            too_small = fin;
            for (int i = ini + 1; i <= fin; i++) {//numero de veces que se recorre
                if ((datos[too_big] < datos[iPivote]) && (!stopBig)) {
                    too_big++;
                } else {
                    stopBig = true;//me detengo cuando encuentro uno mas grande

                }
                if ((datos[too_small] >= datos[iPivote]) && (!stopSmall)) {
                    too_small--;//Retrocedemos
                } else {
                    stopSmall = true;//me detengo cuando encuentro uno mas pequeño
                }
                if (stopBig && stopSmall) {//ambos indices se detuvieron
                    if (too_big < too_small) {
                        int temp = datos[too_big];
                        datos[too_big] = datos[too_small];
                        datos[too_small] = temp;
                        stopBig = false;
                        stopSmall = false;
                    } else {
                        break;//termino el ciclo
                    }

                }
                //intercambio del pivote
                int temp = datos[iPivote];
                datos[iPivote] = datos[too_small];
                datos[too_small] = temp;
                iPivote = too_small;

            }

        }

    }


