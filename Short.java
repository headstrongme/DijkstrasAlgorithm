/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author sarthak
 */

import java.util.*;
import java.lang.*;
import java.io.*;
 
class ShortestPath
{
    // A utility function to find the vertex with minimum distance value,
    // from the set of vertices not yet included in shortest path tree
    static final int V=12;
    int minDistance(int dist[], Boolean sptSet[])
    {
        // Initialize min value
        int min = Integer.MAX_VALUE, min_index=-1;
 
        for (int v = 0; v < V; v++)
            if (sptSet[v] == false && dist[v] <= min)
            {
                min = dist[v];
                min_index = v;
            }
 
        return min_index;
    }
 
    // A utility function to print the constructed distance array
    void printSolution(int dist[], int n)
    {
        System.out.println("Vertex   Distance from Source");
        for (int i = 0; i < V; i++)
            System.out.println((i+1)+" tt "+dist[i]);
    }
 
  
    void dijkstra(int graph[][], int src)
    {
        int dist[] = new int[V]; 
 
      
        Boolean sptSet[] = new Boolean[V];
 
        // Initialize all distances as INFINITE and stpSet[] as false
        for (int i = 0; i < V; i++)
        {
            dist[i] = Integer.MAX_VALUE;
            sptSet[i] = false;
        }
 
        // Distance of source vertex from itself is always 0
        dist[src] = 0;
 
        // Find shortest path for all vertices
        for (int count = 0; count < V-1; count++)
        {
            // Pick the minimum distance vertex from the set of vertices
            // not yet processed. u is always equal to src in first
            // iteration.
            int u = minDistance(dist, sptSet);
 
            // Mark the picked vertex as processed
            sptSet[u] = true;
 
            
            for (int v = 0; v < V; v++)
 
                
                if (!sptSet[v] && graph[u][v]!=0 &&
                        dist[u] != Integer.MAX_VALUE &&
                        dist[u]+graph[u][v] < dist[v])
                    dist[v] = dist[u] + graph[u][v];
        }
 
        // print the constructed distance array
        printSolution(dist, V);
    }
 
    // Driver method
    public static void main (String[] args) throws Exception
    {
        int b;
        
        Scanner input = new Scanner(new File("test.txt"));
        int m = 12;
        int n = 12;
        int[][] a = new int[m][n];
        while (input.hasNextLine()) {
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                   try{//    System.out.println("number is ");
                    a[i][j] = input.nextInt();
                     // System.out.println("number is "+ a[i][j]);
                    }
                   catch (java.util.NoSuchElementException e) {
                       // e.printStackTrace();
                    }
                    //System.out.println("");
                }
            }         //print the input matrix
            //System.out.println("The input sorted matrix is : ");
            //for (int i = 0; i < m; i++) {
               // for (int j = 0; j < n; j++) {
                   // System.out.println(a[i][j]);
 Scanner sobj = new Scanner(System.in);
            System.out.println("Please enter source node:");
       b= sobj.nextInt();
        ShortestPath t = new ShortestPath();
       // t.dijkstra(graph, (b-1));
       t.dijkstra(a, (b-1));
       
                }
            }
        }
  
   
        //
     /*  int graph[][] = new int[][]{{0, 5, 0, 6, 0, 0, 0, 0, 0, 0, 0, 0},
{5, 0, 8, 0, 9, 8, 0, 0, 0, 0, 0, 0},
{0, 8, 0, 0, 6, 0, 0, 15, 0, 0, 0, 0},
{6, 0, 0, 0, 0, 4, 9, 0, 0, 0, 0, 0},
{0, 9, 6, 0, 0, 0, 0, 0, 13, 0, 0, 0},
{0, 8, 0, 4, 0, 0, 6, 14, 9, 0, 0, 0},
{0, 0, 0, 9, 0, 6, 0, 0, 11, 0, 0, 0},
{0, 0, 15, 0, 0, 14, 0, 0, 9, 9, 0, 0},
{0, 0, 0, 0, 13, 0, 11, 9, 0, 6, 5, 12},
{0, 0, 0, 0, 0, 0, 0, 9, 6, 0, 0, 0},
{0, 0, 0, 0, 0, 0, 0, 0, 5, 0, 0, 0},
{0, 0, 0, 0, 0, 0, 0, 0, 12, 0, 0, 0}
}; */
      
