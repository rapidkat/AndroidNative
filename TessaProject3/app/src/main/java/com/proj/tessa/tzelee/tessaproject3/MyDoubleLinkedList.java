package com.proj.tessa.tzelee.tessaproject3;

import android.util.Log;

/**
 * Created by tzelee on 8/2/15.
 */
public class MyDoubleLinkedList {

    final private String debugTag = "MyDoubleLinkedList";
    private MyNode rootNode = null;
    private MyNode headNode = null;

    public boolean addNode(int value)
    {
        MyNode tempNode = new MyNode(value);

        if(this.rootNode == null)
        {
            // first time we are adding this
            headNode = tempNode;
            rootNode = tempNode;
            Log.v(debugTag, "ADDED - MyNodepass - root set with" + tempNode.getValue());
        }
        else
        {
            headNode.nextNode = tempNode;
            headNode = tempNode;
            Log.v(debugTag, "ADDED - Head " + tempNode.getValue());
        }
        return true;
        // Add the node to the begining of the node list.
    }
    // Remove a node, but only the first found node.
    public boolean removeNode(int value)
    {
        // Check if it's an empty tree
        if(isEmpty())
        {
            return false;
        }
        MyNode currentNode = this.rootNode;
        MyNode previousNode = null;

        // Loop it all
        while(currentNode != null)
        {
            if(currentNode.getValue() == value)
            {
                // test case 1: if the root is the frist item
                if(currentNode == this.rootNode)
                {
                    rootNode = currentNode.nextNode;
                    currentNode.nextNode = null;
                    return true;
                }
                else
                {
                    previousNode.nextNode = currentNode.nextNode;
                    currentNode = null;
                    return true;
                }
            }
            if(currentNode.nextNode == null)
            {
                break;
            }
            previousNode = currentNode;  // TODO: CRASHING HERE
            currentNode = currentNode.nextNode;
        }
        return false;

    }
    public int printNodes()
    {
        String allValues = "";
        Log.v(debugTag, "Printing value called");
        int length = 0;
        if(!isEmpty()) {
            MyNode currentNode = rootNode;

            while(currentNode != null)
            {
                Log.v(debugTag, "Printing value is: " + currentNode.getValue());
                currentNode = currentNode.nextNode;
                length++;
            }
            Log.v(debugTag, "length: " + length);
        }
        return length;
    }

    public boolean isEmpty()
    {
        return rootNode == null && headNode == null;
    }

    public void clear(){
        this.rootNode = null;
        this.headNode = null;

    }
}
