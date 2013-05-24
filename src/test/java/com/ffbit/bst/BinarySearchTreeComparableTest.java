package com.ffbit.bst;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertThat;

public class BinarySearchTreeComparableTest extends AbstractBinarySearchTreeTest {

    @Override
    BinarySearchTree<Integer> getBst() {
        return new BinarySearchTreeImpl<Integer>();
    }

    @Test
    public void itShouldSupportNaturalOrdering() throws Exception {
        bst.add(3);
        bst.add(1);
        bst.add(0);
        bst.add(2);
        bst.add(5);
        bst.add(4);
        bst.add(6);

        assertThat(bst.toString(), containsString("[0, 1, 2, 3, 4, 5, 6]"));
    }

}
