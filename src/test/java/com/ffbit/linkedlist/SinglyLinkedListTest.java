package com.ffbit.linkedlist;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class SinglyLinkedListTest {
    private SinglyLinkList<Integer> list;

    @Before
    public void setUp() throws Exception {
        list = new SinglyLinkedListImpl<Integer>();
    }

    @Test
    public void itShouldBeEmptyWhenCreated() throws Exception {
        assertThat(list.size(), is(0));
    }

    @Test
    public void itShouldNotBeEmptyWhenElementAdded() throws Exception {
        list.add(2);

        assertThat(list.size(), is(1));
    }

    @Test
    public void itShouldContainAddedElement() throws Exception {
        list.add(1);

        assertThat(list.contains(1), is(true));
    }

    @Test
    public void itShouldNotContainNonExistentElement() throws Exception {
        assertThat(list.contains(1), is(false));
    }

}
