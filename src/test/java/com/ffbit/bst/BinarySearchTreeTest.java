package com.ffbit.bst;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class BinarySearchTreeTest {

    @Test
    public void itShouldBeEmptyWhenCreated() throws Exception {
        BinarySearchTree bst = new BinarySearchTree();
        assertThat(bst.size(), is(0));
    }

}
