/**
 * Project 2
 * 
 * @author abey95, bpaul5
 * @version 2018.03.17
 * 
 */
import java.util.*;
import java.io.*;

public class Project2_Astar
{
    public static void main(String[] args) throws FileNotFoundException 
    {        
        File file = new File("test6Astar.in");
        Scanner scanner = new Scanner(file);
        
        while (scanner.hasNextInt())
        {
            int numVertices = scanner.nextInt();
            int numEdges = scanner.nextInt();
            
            ArrayList<LinkedList<Node>> arrayList = new ArrayList<LinkedList<Node>>();

            //assigning nodes and distances
            for (int i = 0; i < numVertices; i++)
            {
                int xCoord = scanner.nextInt();
                int yCoord = scanner.nextInt();
                int zCoord = scanner.nextInt();

                Node newNode = new Node(xCoord, yCoord, zCoord, i+1);
                
                LinkedList<Node> linkedList = new LinkedList<Node>();
                linkedList.add(0, newNode);
                arrayList.add(i, linkedList);              
                
            }           
          
            //adjacency list formation
            for (int i = 0; i < numEdges; i++)
            {
                int node1 = scanner.nextInt();
                int node2 = scanner.nextInt();
                Node end = arrayList.get(node2-1).getFirst();
                arrayList.get(node1 - 1).add(end);
            }  
            
            ArrayMinHeap<Double> heap = new ArrayMinHeap<Double>(numVertices);

            int[] parent = new int[1+numVertices];
            double[] distance = new double[1+numVertices];
            boolean[] discovered = new boolean[1+numVertices];
            double[] estimated = new double[1+numVertices];

            //initialization
            for (int i = 1; i <= numVertices; i++)
            {
                parent[i] = -1;
                distance[i] = Double.MAX_VALUE; 
                heap.insert(Double.MAX_VALUE);                
            }
            distance[1] = 0;
            parent[1] = 0;
            
            heap.decreaseKey(1, 0);           
            
            Node targetNode = arrayList.get(numVertices - 1).getFirst();
            
            while (!discovered[numVertices])
            {              
                int current = heap.getLocation();
                double min = heap.remove();                
                discovered[current] = true;                   
                
                for (int i = 1; i < arrayList.get(current-1).size(); i++)
                {         
                    Node adjacentNode = arrayList.get(current-1).get(i);
                    Node currentNode = arrayList.get(current-1).getFirst();
                    int adjacent = adjacentNode.getName();
                    double dist = currentNode.getDistance(adjacentNode);
                    
                            
                    if (!discovered[adjacent] && distance[adjacent] > distance[current] + dist)
                    {
                        distance[adjacent] = distance[current] + dist;
                        estimated[adjacent] = distance[adjacent] + adjacentNode.getDistance(targetNode);
                        heap.decreaseKey(adjacent, estimated[adjacent]);
                        parent[adjacent] = current;
                    }
                }   

            }         
            System.out.println(distance[numVertices]);
        }
    } 
    
    
}

