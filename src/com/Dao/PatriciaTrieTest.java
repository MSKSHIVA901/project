package com.Dao;

import java.util.Scanner;

/** Class PatriciaNode **/
class PatriciaNode
{
    int bitNumber;
    int data;
    PatriciaNode leftChild, rightChild;
}
 
/* Class PatriciaTrie */
class PatriciaTrie
{
    private PatriciaNode root;
    private static final int MaxBits = 10;
 
    /** Constructor **/
    public PatriciaTrie()
    {
        root = null;        
    }
    /** function to check if empty **/
    public boolean isEmpty()
    {
        return root == null;
    }
    /** function to clear **/
    public void makeEmpty()
    {
        root = null;        
    }
    /** function to get ith bit of key k from left **/
    private boolean bit(int k, int i)
    {
        String binary = Integer.toString(k, 2);    
        while (binary.length() != MaxBits)
            binary = "0" + binary;    
        if (binary.charAt(i - 1) == '1')
            return true ;
        return false;
    }
    /** function to search for an element **/
    public boolean search(int k)
    {
        int numOfBits = (int) (Math.log(k)/Math.log(2)) + 1;
        if (numOfBits > MaxBits)
        {
            System.out.println("Error : Number too large");
            return false;
        }
        PatriciaNode searchNode = search(root, k);
        if (searchNode.data == k)
            return true;
        else
            return false;
    }
    /** function to search for an element **/
    private PatriciaNode search(PatriciaNode t, int k)
    {
        PatriciaNode currentNode = null, nextNode;
        if (t == null)
        {
            return null;
        }
        nextNode = t.leftChild;
        
        System.out.println(nextNode.data);
        
        System.out.println(nextNode.data);
        currentNode = t;
        while (nextNode.bitNumber > currentNode.bitNumber)
        {
            currentNode = nextNode;
            nextNode = (bit(k, nextNode.bitNumber)) ? nextNode.rightChild : nextNode.leftChild;
        }
        return nextNode;
    }
    /** function to insert and element **/
    public void insert(int ele)
    {
        int numOfBits = (int) (Math.log(ele)/Math.log(2)) + 1;
        if (numOfBits > MaxBits)
        {
            System.out.println("Error : Number too large");
            return;
        }
        root = insert(root, ele);        
    }
    /** function to insert and element **/
    private PatriciaNode insert(PatriciaNode t, int ele)
    {
        PatriciaNode current, parent, lastNode, newNode;
        int i;
 
        if (t == null)
        {
            t = new PatriciaNode();
            t.bitNumber = 0;
            t.data = ele;
            t.leftChild = t;
            t.rightChild = null;    
            return t;        
        }
 
        lastNode = search(t, ele);
 
        if (ele == lastNode.data)
        {
            System.out.println("Error : key is already present\n");
            return t;
        }
 
        for (i = 1; bit(ele, i) == bit(lastNode.data, i); i++);
 
        current = t.leftChild; parent = t;
        while (current.bitNumber > parent.bitNumber && current.bitNumber < i)
        {
            parent = current;
            current = (bit(ele, current.bitNumber)) ? current.rightChild : current.leftChild;
        }
 
        newNode = new PatriciaNode();
        newNode.bitNumber = i;
        newNode.data = ele;
        newNode.leftChild = bit(ele, i) ? current : newNode;
        newNode.rightChild = bit(ele, i) ? newNode : current;        
 
        if (current == parent.leftChild)
            parent.leftChild = newNode;
        else
            parent.rightChild = newNode;
 
        return t;
    }        
}
 
/* Class PatriciaTrie Test */
public class PatriciaTrieTest
{
    public static void main(String[] args)
    {            
        Scanner scan = new Scanner(System.in);
 
        /* Creating object of PatriciaTrie */
        PatriciaTrie pt = new PatriciaTrie(); 
        System.out.println("Patricia Trie Test\n"); 
 
        char ch;
        /*  Perform trie operations  */
        do    
        {
            System.out.println("\nPatricia Trie Operations\n");
            System.out.println("1. insert ");
            System.out.println("2. search");
            System.out.println("3. check emepty");
            System.out.println("4. make emepty");
 
            int choice = scan.nextInt();            
            switch (choice)
            {
            case 1 : 
                System.out.println("Enter key element to insert");
                pt.insert( scan.nextInt() );                     
                break;                          
            case 2 : 
                System.out.println("Enter key element to search");
                System.out.println("Search result : "+ pt.search( scan.nextInt() ));
                break;  
            case 3 : 
                System.out.println("Empty Status : "+ pt.isEmpty() );                
                break;    
            case 4 : 
                System.out.println("Patricia Trie cleared"); 
                pt.makeEmpty();               
                break;                                        
            default : 
                System.out.println("Wrong Entry \n ");
                break;   
            }
 
            System.out.println("\nDo you want to continue (Type y or n) \n");
            ch = scan.next().charAt(0);                        
        } while (ch == 'Y'|| ch == 'y');               
    }
}