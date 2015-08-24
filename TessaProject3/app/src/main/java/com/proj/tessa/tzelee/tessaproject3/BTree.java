package com.proj.tessa.tzelee.tessaproject3;

import android.util.Log;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by tzelee on 8/15/15.
 */
public class BTree {

    private TreeNode rootNode;
    private final String debugTag = "BTree::";
    public BTree(int value)
    {
        this.rootNode = new TreeNode(value);
    }
    public TreeNode getRootNode()
    {
        return this.rootNode;
    }
    public void inOrderPrint(TreeNode currentNode)
    {
        if(currentNode != null)
        {
            Log.v(debugTag, " print node value: " + currentNode.getValue());
        }
        if(currentNode.getLeftNode() != null)
        {
            inOrderPrint(currentNode.getLeftNode());
        }
        if(currentNode.getRightNode() != null)
        {
            inOrderPrint(currentNode.getRightNode());
        }
    }
    public void breadthFirst()
    {

    }
    public void insertNode(int value, TreeNode currentNode)
    {
        if(value < currentNode.getValue())
        {
            if(currentNode.getLeftNode() == null)
            {
                currentNode.setLeftNode(new TreeNode(value));
                Log.v(debugTag, "value has been inserted on left node: " + value);
            }
            else
            {
                Log.v(debugTag, "recursion called " + currentNode.getValue() + " on left node with: " + value);
                insertNode(value, currentNode.getLeftNode());
            }
        }
        else
        {
            if(currentNode.getRightNode() == null)
            {
                currentNode.setRightNode(new TreeNode(value));
                Log.v(debugTag, "value has been inserted on right node: " + value);
            }
            else
            {
                Log.v(debugTag, "recursion called" + currentNode.getValue() + " on right node with: " + value);
                insertNode(value, currentNode.getRightNode());
            }
        }
    }
    public void depthFirstSearch()
    {
        // push the root node
        Stack<TreeNode> myStack = new Stack<TreeNode>();
        myStack.push(this.getRootNode());

        while(!myStack.empty())
        {
            TreeNode currentNode = myStack.pop();
            Log.v(debugTag, "depth value is " + currentNode.getValue());

            if(currentNode.getLeftNode() != null)
            {
                myStack.push(currentNode.getLeftNode());
            }
            if(currentNode.getRightNode() != null)
            {
                myStack.push(currentNode.getRightNode());
            }
        }
    }

    public void breadthFirstSearch()
    {
        // push the root node
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(this.getRootNode());

        while(queue.size() > 0)
        {
            TreeNode currentNode = queue.removeFirst();
            Log.v(debugTag, " breadth value is " + currentNode.getValue());

            if(currentNode.getLeftNode() != null)
            {
                queue.add(currentNode.getLeftNode());
            }
            if(currentNode.getRightNode() != null)
            {
                queue.add(currentNode.getRightNode());
            }
        }
    }

}
