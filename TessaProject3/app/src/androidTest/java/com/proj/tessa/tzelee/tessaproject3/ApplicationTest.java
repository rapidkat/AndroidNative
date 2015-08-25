package com.proj.tessa.tzelee.tessaproject3;

import android.app.Application;
import android.test.ApplicationTestCase;
import java.util.ArrayList;

import android.util.Log;
import junit.framework.TestCase;


/**
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing Fundamentals</a>
 */
public class ApplicationTest extends ApplicationTestCase<Application> {
    public ApplicationTest() {
        super(Application.class);
        testNode();
        testStack();
        testQueue();
        testLinkedList();
        testMyHash();
        testTree();
    }
    public void testNode() {
        MyNode node = new MyNode(10);
        assertEquals(node.getValue(), 10);
    }
    public void testStack() {
        MyStack tzeStack = new MyStack();
        assertEquals(tzeStack.push("T"), true);
        assertEquals(tzeStack.length(), 1);
        assertEquals(tzeStack.push("E"), true);
        assertEquals(tzeStack.push("S"), true);
        assertEquals(tzeStack.push("S"), true);
        assertEquals(tzeStack.push("A"), true);
        assertEquals(tzeStack.length(), 5);
        assertEquals(tzeStack.pop(), "A");
        assertEquals(tzeStack.length(), 4);
        assertEquals(tzeStack.pop(), "S");
        assertEquals(tzeStack.pop(), "S");
        assertEquals(tzeStack.length(), 2);
        tzeStack.clear();
        assertEquals(tzeStack.length(), 0);
    }
    public void testQueue() {
        MyStack tzeStack = new MyStack();
        assertEquals(tzeStack.push("ABBA"), true);
        assertEquals(tzeStack.push("1"), true);
        assertEquals(tzeStack.push("2"), true);
        assertEquals(tzeStack.length(), 3);
        assertEquals(tzeStack.dequeue(), "ABBA");
        assertEquals(tzeStack.dequeue(), "1");
        assertEquals(tzeStack.length(), 1);
    }
    public void testLinkedList() {
        MyDoubleLinkedList myLinkedList = new MyDoubleLinkedList();
        assertEquals(myLinkedList.addNode(1), true);

        assertEquals(myLinkedList.addNode(100), true);
        assertEquals(myLinkedList.addNode(10), true);
        assertEquals(myLinkedList.printNodes(), 3);

        assertEquals(myLinkedList.removeNode(100), true);
        assertEquals(myLinkedList.printNodes(), 2);

        assertEquals(myLinkedList.addNode(34), true);
        assertEquals(myLinkedList.addNode(23), true);

        assertEquals(myLinkedList.printNodes(), 4);
        //myLinkedList.printNodes();
        myLinkedList.removeNode(1);
        assertEquals(myLinkedList.printNodes(), 3);
        assertEquals(myLinkedList.isEmpty(), false);
        myLinkedList.clear();
        assertEquals(myLinkedList.isEmpty(), true);
    }

    public void testMyHash() {
        MyHashTable myHash = new MyHashTable();
        assertEquals(myHash.add("Roger", "Rabbit"), true);
        assertEquals(myHash.add("John", "Denver"), true);
        assertEquals(myHash.add("Porsche", "Cayman"), true);
        assertEquals(myHash.add("", "Failed"), false);
        assertEquals(myHash.printHashTable(), 3);
        assertEquals(myHash.remove("JKL"), false);
        assertEquals(myHash.printHashTable(), 3);
        assertEquals(myHash.remove(""), false);
        assertEquals(myHash.remove("Roger"), true);
        assertTrue(myHash.add("John", "Rocket"));
        assertEquals(myHash.printHashTable(), 3);
    }
    public void testTree() {
        BTree myTree = new BTree(9);
        myTree.insertNode(3, myTree.getRootNode());
        myTree.insertNode(1, myTree.getRootNode());
        myTree.insertNode(20, myTree.getRootNode());
        myTree.insertNode(11, myTree.getRootNode());
        myTree.insertNode(15, myTree.getRootNode());
        myTree.insertNode(6, myTree.getRootNode());
        myTree.insertNode(100, myTree.getRootNode());

        ArrayList depthList = myTree.depthFirstSearch();
        String depthString = depthList.toString();
        assertEquals(depthString, depthBuilder().toString());
        // TODO need to finish this part.

        ArrayList breadthList = myTree.breadthFirstSearch();
        assertEquals(breadthList.toString(), breadthBuilder().toString());
    }
    /*
    Helpers to verify the test
     */
    private ArrayList depthBuilder() {
        ArrayList tempArray = new ArrayList();
        tempArray.add(9);
        tempArray.add(20);
        tempArray.add(100);
        tempArray.add(11);
        tempArray.add(15);
        tempArray.add(3);
        tempArray.add(6);
        tempArray.add(1);
        return tempArray;
    }
    /*
    Helpers to verify the test
     */
    private ArrayList breadthBuilder()
    {
        ArrayList tempArray = new ArrayList();
        tempArray.add(9);
        tempArray.add(3);
        tempArray.add(20);
        tempArray.add(1);
        tempArray.add(6);
        tempArray.add(11);
        tempArray.add(100);
        tempArray.add(15);
        return tempArray;

    }

}