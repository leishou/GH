package com.cs.ghdemo.GH.NationalSpecial;
import com.cs.ghdemo.entity.Baggage;
import com.cs.ghdemo.entity.Info;
import com.cs.ghdemo.entity.Ticket;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.*;

import static org.testng.Assert.assertEquals;

public class testCase9 {
    @DataProvider(name = "testCase9")
    public Info[][] testCase9() {
        Info[][] object;
//        List<Baggage>tmp = new List<Baggage>() {
//            @Override
//            public int size() {
//                return 0;
//            }
//
//            @Override
//            public boolean isEmpty() {
//                return false;
//            }
//
//            @Override
//            public boolean contains(Object o) {
//                return false;
//            }
//
//            @Override
//            public Iterator<Baggage> iterator() {
//                return null;
//            }
//
//            @Override
//            public Object[] toArray() {
//                return new Object[0];
//            }
//
//            @Override
//            public <T> T[] toArray(T[] a) {
//                return null;
//            }
//
//            @Override
//            public boolean add(Baggage baggage) {
//                return false;
//            }
//
//            @Override
//            public boolean remove(Object o) {
//                return false;
//            }
//
//            @Override
//            public boolean containsAll(Collection<?> c) {
//                return false;
//            }
//
//            @Override
//            public boolean addAll(Collection<? extends Baggage> c) {
//                return false;
//            }
//
//            @Override
//            public boolean addAll(int index, Collection<? extends Baggage> c) {
//                return false;
//            }
//
//            @Override
//            public boolean removeAll(Collection<?> c) {
//                return false;
//            }
//
//            @Override
//            public boolean retainAll(Collection<?> c) {
//                return false;
//            }
//
//            @Override
//            public void clear() {
//
//            }
//
//            @Override
//            public Baggage get(int index) {
//                return null;
//            }
//
//            @Override
//            public Baggage set(int index, Baggage element) {
//                return null;
//            }
//
//            @Override
//            public void add(int index, Baggage element) {
//
//            }
//
//            @Override
//            public Baggage remove(int index) {
//                return null;
//            }
//
//            @Override
//            public int indexOf(Object o) {
//                return 0;
//            }
//
//            @Override
//            public int lastIndexOf(Object o) {
//                return 0;
//            }
//
//            @Override
//            public ListIterator<Baggage> listIterator() {
//                return null;
//            }
//
//            @Override
//            public ListIterator<Baggage> listIterator(int index) {
//                return null;
//            }
//
//            @Override
//            public List<Baggage> subList(int fromIndex, int toIndex) {
//                return null;
//            }
//        };
//        tmp.add(new Baggage("????????????", 100, 60, 40, 71));
//        tmp.add(new Baggage("????????????", 100, 60, 40, 71));
        return object = new Info[][]{

                {new Info(new Ticket("????????????", "0", "?????????", "?????????", "???", 1000),
                        Arrays.asList(new Baggage("?????????", 0, 0, 0, 20),new Baggage("??????", 0, 0, 0, 10)))
                }
        };
    }

    @Test(dataProvider = "testCase9")
    public void test07(Info info ) throws Exception{
        Assert.assertEquals(info.calculate(info),0,0.001);
    }
}
