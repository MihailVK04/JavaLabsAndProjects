package bg.sofia.uni.fmi.mjt.show.elimination;

import bg.sofia.uni.fmi.mjt.show.ergenka.Ergenka;

import java.lang.reflect.Array;
import java.util.Arrays;

public class LowestRatingEliminationRule implements EliminationRule{
    private static final int MAX_RATING = 10;

    public Ergenka[] eliminateErgenkas(Ergenka[] ergenkas) {
        int size = Array.getLength(ergenkas);
        int minRating = MAX_RATING;

        for ( int i = 0; i < size; i++ ) {
            int rating = ergenkas[i].getRating();
            if ( rating < minRating ) {
                minRating = rating;
            }
        }

        Ergenka[] result = new Ergenka[size];
        int newIndex = 0;

        for ( int i = 0; i < size; i++ ) {
            if ( ergenkas[i].getRating() == minRating){
                continue;
            }
            else {
                result[newIndex] = ergenkas[i];
                newIndex++;
            }
        }

        return result;
    }
}