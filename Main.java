/*
Author: Liam O'Shea
Date: November 25 2018
File: Main.java
Description: This is program reads a number of Processes from a text file, and simulates
the priority behaviour of a CPU triaging processes using a Heap data structure.

Output is shown for before, during, and after the time step.
 */


import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;


public class Main {

    public static void main(String[] args) throws IOException{

        //Declare variables
        int t = 1, id, procTime, priority, arivTime;                //Timestep and Process variables
        Process temp;                                           //Temporary variable to manipulate Processes
        Heap<Process> heap = new Heap<Process>();               //Priority heap to store processes
        ArrayList<Process> allProc = new ArrayList<Process>();  //List of all processes from text file

        //Create file for processes and instantiate scanner using this file.
        File processes = new File("processes.txt");
        Scanner proc = new Scanner(processes);

        //Creating and storing Processes
        while(proc.hasNext()){
            //Get process data
            id = proc.nextInt();
            procTime = proc.nextInt();
            priority = proc.nextInt();
            arivTime = proc.nextInt();

            //Create process
            temp = new Process(id, procTime, priority, arivTime);

            //Put process in list
            allProc.add(temp);
        }


        //Program loop (Ends when both list and heap are empty)
        while(allProc.size() > 0 || heap.size() > 0){

            //Check list of processes for processes arriving at this time step, add them to heap.
            while (allProc.size() > 0 && allProc.get(0).getTimeArrival() == t) {
                heap.add(allProc.remove(0));
            }

            //Beginning Output--------
            System.out.println("\n********************\nTime Unit: " + t + "\n");

            System.out.println("BEGINNING ------------");
            System.out.print("Heap Contents: ");
            heap.enumerate();
            System.out.println("CPU Contents: \n");
            //------------------------


            //Get process to be worked on by CPU (top of heap)
            temp = heap.deleteMax();


            //During Output-----------
            System.out.println("DURING ------------");
            System.out.print("Heap Contents: ");
            heap.enumerate();
            System.out.println("CPU Contents: [" + temp + "]\n");
            //------------------------


            //Decrement time required by 1.
            temp.setTimeReqd(temp.getTimeReqd() - 1);

            //If process still requires more time, send back to heap
            if(temp.getTimeReqd() > 0) heap.add(temp);


            //After Output-------------
            System.out.println("AFTER ------------");
            System.out.print("Heap Contents: ");
            heap.enumerate();
            System.out.println("CPU Contents: ");
            //-------------------------

            //Increment time step
            t++;
        }
    }
}
