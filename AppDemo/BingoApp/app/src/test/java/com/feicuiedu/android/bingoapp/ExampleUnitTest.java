package com.feicuiedu.android.bingoapp;

import android.util.Log;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {

    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
    }

    // Map list Set

    @Test
    public void testRandom() {
        String[] names = {"王金飞","于坤巧","立言","随海波","宅起炒"};

        List<Integer> listNamesIndex = new ArrayList<Integer>();

        Random random = new Random();

        while(true) {
            int tmpIndex = random.nextInt(5);

            if (!listNamesIndex.contains(tmpIndex)) {

                listNamesIndex.add(tmpIndex);
            }

            if (listNamesIndex.size() == 5) {
                break;
            }
        }

        List<String> listNames = new ArrayList<String>();

        for (int index:listNamesIndex) {
            listNames.add(names[index]);
        }
        
        System.out.println(listNames.toString());
    }
}