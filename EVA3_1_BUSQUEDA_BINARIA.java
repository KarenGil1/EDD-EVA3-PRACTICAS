/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eva3_1_busqueda_binaria;

import java.util.Scanner;

/**
 *
 * @author vane_
 */
public class EVA3_1_BUSQUEDA_BINARIA {

   /**
    * @param args the command line arguments
    */
   public static void main(String[] args) {
      // TODO code application logic here
      int [] datos = new int [1000];
      llenar(datos);//envio el arreglo a llenar con valores aleatorios
      //imprimir(datos);
      selectionSort(datos);
     // imprimir(datos);
      Scanner input= new Scanner(System.in);
      System.out.println("Valor a Buscar: ");
      int valor = input.nextInt();
      int iResu = binarySearch(datos, valor);
      System.out.println("El elemento esta en la posicion: " + iResu);
   }
   //LlENADO DE AREGLOS CON VALORES ALEATORIOS
   public static void llenar(int[] datos){
      for (int i = 0; i < datos.length; i++) {
         datos[i] = (int)(Math.random()*1000);
         
      }
   }
   public static void imprimir (int[] datos){
     
      for (int i = 1; i < datos.length; i++) {
         System.out.print("[" + datos[i] + "]");
      }   
       System.out.println("");
   }
     public static void selectionSort (int[] datos){
    
      for (int i = 0; i < datos.length; i++) {
         int iMin = i;//EMPIEZA 
         for (int j = i + 1; j < datos.length; j++) {
           if(datos[j]< datos[iMin]){
              iMin = j;
           } 
         }
         //INTERCAMBIO
         if(i  != iMin){
           //RESPALDAR UN VALOR 
         int iTemp = datos[i];
         //INTERCAMBIAR UN VALOR
         datos[i] = datos[iMin];
        //REPONER EL VALOR RESPALDADO 
         datos[iMin] = iTemp;
      }
      }    
   }
     public static int binarySearch(int[] datos, int valBuscar){
        return binarySearchRecu(datos, valBuscar, 0, datos.length-1);
     }
     private static int binarySearchRecu(int[] datos, int valBuscar, int ini, int fin){
        int iMid, iResu;
        iMid= ini + ((fin - ini)/2);
        iResu = -1;
        if(fin>= ini){
          if(valBuscar == datos[iMid] ){//ELVALOR ESTA A LA MITAD
             iResu = iMid;//aqui esta el valor, y lo regresamos
          } else if(valBuscar<datos[iMid]){//NO ESTA A LA MITAD, PERO PUEDE ESTARA A LA IZQUIERDA 
         //Llamamos recursivamente a la busqueda binaria
         iResu = binarySearchRecu(datos, valBuscar, ini, iMid - 1);
          }else{//NO ESTA, PERO PUEDE ESTAR A LA DERECHA
              iResu = binarySearchRecu(datos, valBuscar, iMid + 1, fin);
          }
        }// se detiene el proceso
        
        return iResu;
     }
   
}
