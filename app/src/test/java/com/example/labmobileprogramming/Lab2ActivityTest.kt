package com.example.labmobileprogramming

import junit.framework.Assert
import junit.framework.Assert.assertEquals
import org.junit.Test

class Lab2Test{

    @Test
    fun getValue() {
        val counter = Lab2Activity()
        counter.initCounter()
        Assert.assertNotNull(counter.getValue())
    }

    @Test
    fun test_init_value() {
        val counter = Lab2Activity()
        counter.initCounter()
        println(counter.getValue())
        assertEquals(0, counter.getValue())
    }

    @Test
    fun test_increment() {
        val counter = Lab2Activity()
        counter.incrementCounter()
        println(counter.getValue())
        assertEquals(1, counter.getValue())
    }

    @Test
    fun test_decrement() {
        val counter = Lab2Activity()
        counter.decrementCounter()
        println(counter.getValue())
        assertEquals(-1, counter.getValue())
    }
}