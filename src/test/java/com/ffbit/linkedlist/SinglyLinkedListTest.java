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

    @Test
    public void itShouldRemoveElementFromTheEnd() throws Exception {
        list.add(1);
        list.add(2);

        assertThat("it should remove 1", list.remove(1), is(true));
        assertThat("1 should not be in the list", list.contains(1), is(false));
        assertThat("size should be reduced to 1", list.size(), is(1));
    }

    @Test
    public void itShouldRemoveElementFromTheMiddle() throws Exception {
        list.add(1);
        list.add(2);
        list.add(3);

        assertThat("it should remove 2", list.remove(2), is(true));
        assertThat("2 should not be in the list", list.contains(2), is(false));
        assertThat("size should be reduced to 2", list.size(), is(2));
    }

    @Test
    public void itShouldRemoveElementFromTheHead() throws Exception {
        list.add(1);
        list.add(2);

        assertThat("it should remove 2", list.remove(2), is(true));
        assertThat("2 should not be in the list", list.contains(2), is(false));
        assertThat("size should be reduced to 1", list.size(), is(1));
    }

}
