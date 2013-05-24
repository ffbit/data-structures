package com.ffbit.bst;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertFalse;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class BinarySearchTreeTest {

    private BinarySearchTree<Integer> bst;

    @Before
    public void setUp() throws Exception {
        bst = new BinarySearchTree<Integer>();
    }

    @Test
    public void itShouldBeEmptyWhenCreated() throws Exception {
        assertThat(bst.size(), is(0));
    }

    @Test
    public void itShouldNotBeEmptyWhenElementAdded() throws Exception {
        bst.add(1);

        assertThat(1, is(bst.size()));
    }

    @Test
    public void itShouldRemoveAllElements() throws Exception {
        bst.add(1);
        bst.clear();

        assertThat(bst.size(), is(0));
    }

    @Test
    public void itShouldNotAddDuplicates() throws Exception {
        assertTrue(bst.add(1));
        assertFalse(bst.add(1));
        assertThat(bst.size(), is(1));
    }

}
