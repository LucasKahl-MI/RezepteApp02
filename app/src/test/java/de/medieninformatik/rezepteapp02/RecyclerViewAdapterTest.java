package de.medieninformatik.rezepteapp02;

import android.content.Context;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)

class RecyclerViewAdapterTest {

    List<Rezepte> rezepteList;
    RecyclerViewAdapter recyclerViewAdapter;

    @ParameterizedTest
    @BeforeEach
    void setUp(){
        rezepteList = new ArrayList<>();

        rezepteList.add(new Rezepte("Schnitzel", "Fleisch, 2 Eier, Paniermehl", "Lecker Lecker", "Braten", 0));
        rezepteList.add(new Rezepte("Lachs", "200g Lachs", "Lecker Lecker", "Braten", 0));
        rezepteList.add(new Rezepte("Schnitzel", "Fleisch, 2 Eier, Paniermehl", "Lecker Lecker", "Braten", 0));
        Context ct=null;

        recyclerViewAdapter = new RecyclerViewAdapter(ct, rezepteList);
    }

    @org.junit.jupiter.api.Test
    void onCreateViewHolder() {
    }

    @org.junit.jupiter.api.Test
    void onBindViewHolder() {

    }

    @org.junit.jupiter.api.Test
    void getItemCount() {
        assertEquals(rezepteList.size(), 3);
    }


    @ParameterizedTest

    @ValueSource(doubles ={2,4,6,8,246,98178})
    public void istGerade(double wert){
        assertTrue(RecyclerViewAdapter.istGerade(wert));
    }

    public static int[][] data() {
        return new int[][] { { 1 , 2, 2 }, { 5, 3, 15 }, { 121, 4, 484 } };
    }

    @ParameterizedTest
    @MethodSource(value =  "data")
    void testWithStringParameter(int[] data) {
        Multiplikation test = new Multiplikation();
        int m1 = data[0];
        int m2 = data[1];
        int expected = data[2];
        assertEquals(expected, test.multiply(m1, m2));
    }

    // Klasse die getestet werden soll
    class Multiplikation {
        public int multiply(int i, int j) {
            return i * j;
        }
    }


}