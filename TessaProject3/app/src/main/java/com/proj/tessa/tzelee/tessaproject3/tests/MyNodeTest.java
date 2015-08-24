package com.proj.tessa.tzelee.tessaproject3.tests;

import junit.framework.TestCase;
import com.proj.tessa.tzelee.tessaproject3.MyNode;
/**
 * Created by tzelee on 8/22/15.
 */
public class MyNodeTest extends TestCase {

    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }

    public void TestNode()
    {
        MyNode node = new MyNode(10);
        assertEquals(node.getValue(), 10);
    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }
}
