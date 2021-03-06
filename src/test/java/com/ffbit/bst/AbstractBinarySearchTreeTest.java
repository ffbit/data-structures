package com.ffbit.bst;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public abstract class AbstractBinarySearchTreeTest {

    BinarySearchTree<Integer> bst;

    @Before
    public void setUp() throws Exception {
        bst = getBst();
    }

    abstract BinarySearchTree<Integer> getBst();

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
        assertThat(bst.toString(), containsString("[]"));
    }

    @Test
    public void itShouldNotAddDuplicates() throws Exception {
        assertTrue(bst.add(1));
        assertThat(bst.add(1), is(false));
        assertThat(bst.size(), is(1));
    }

    @Test
    public void itShouldNotContainElement() throws Exception {
        bst.add(1);
        bst.add(0);

        assertThat(bst.contains(2), is(false));
    }

    @Test
    public void itShouldContainElement() throws Exception {
        bst.add(2);
        bst.add(3);
        bst.add(1);

        assertThat(bst.size(), is(3));
        assertThat(bst.contains(1), is(true));
        assertThat(bst.contains(2), is(true));
        assertThat(bst.contains(3), is(true));
    }

    @Test
    public void itShouldNotRemoveNonExistElement() throws Exception {
        bst.add(1);

        assertThat(bst.remove(2), is(false));
        assertThat(bst.size(), is(1));
    }

    @Test
    public void itShouldRemoveElementFromFirstLeaf() throws Exception {
        bst.add(2);
        bst.add(1);
        bst.add(3);

        assertThat(bst.remove(1), is(true));
        assertThat(bst.contains(1), is(false));
        assertThat(bst.size(), is(2));
    }

    @Test
    public void itShouldRemoveElementFromSecondLeaf() throws Exception {
        bst.add(2);
        bst.add(1);
        bst.add(3);

        assertThat(bst.remove(3), is(true));
        assertThat(bst.contains(3), is(false));
        assertThat(bst.size(), is(2));
    }

    @Test
    public void itShouldRemoveFromRoot() throws Exception {
        bst.add(2);
        bst.add(1);
        bst.add(3);

        assertThat(bst.remove(2), is(true));
        assertThat(bst.contains(2), is(false));
        assertThat(bst.size(), is(2));
    }

    @Test
    public void itShouldRemoveRegularNode() throws Exception {
        bst.add(3);
        bst.add(1);
        bst.add(0);
        bst.add(2);
        bst.add(5);
        bst.add(4);
        bst.add(6);

        assertThat(bst.size(), is(7));

        assertThat(bst.remove(1), is(true));
        assertThat(bst.contains(1), is(false));
        assertThat(bst.size(), is(6));

        assertThat(bst.remove(5), is(true));
        assertThat(bst.contains(5), is(false));
        assertThat(bst.size(), is(5));

        assertThat("it should contain 0 but doesn't", bst.contains(0), is(true));
        assertThat("it should contain 2 but doesn't", bst.contains(2), is(true));
        assertThat("it should contain 3 but doesn't", bst.contains(3), is(true));
        assertThat("it should contain 4 but doesn't", bst.contains(4), is(true));
        assertThat("it should contain 6 but doesn't", bst.contains(6), is(true));
    }

}
