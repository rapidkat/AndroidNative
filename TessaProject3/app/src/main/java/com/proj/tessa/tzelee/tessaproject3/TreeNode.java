package com.proj.tessa.tzelee.tessaproject3;

/**
 * Created by tzelee on 8/15/15.
 */
public class TreeNode {

    private int value = 0;
    private TreeNode leftNode;
    private TreeNode rightNode;

    public TreeNode(int value)
    {
        this.value = value;
    }
    public boolean setLeftNode(TreeNode treeNode)
    {
        if(treeNode != null)
        {
            this.leftNode = treeNode;
            return true;
        }
        else
        {
            return false;
        }
    }
    public boolean setRightNode(TreeNode treeNode)
    {
        if(treeNode != null)
        {
            this.rightNode = treeNode;
            return true;
        }
        else
        {
            return false;
        }
    }
    public TreeNode getLeftNode()
    {
        return this.leftNode;
    }
    public TreeNode getRightNode()
    {
        return this.rightNode;
    }
    public void setValue(int value)
    {
        this.value = value;
    }
    public int getValue()
    {
        return this.value;
    }
}
