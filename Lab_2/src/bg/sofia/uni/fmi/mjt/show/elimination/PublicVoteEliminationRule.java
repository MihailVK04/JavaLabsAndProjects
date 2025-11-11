package bg.sofia.uni.fmi.mjt.show.elimination;

import bg.sofia.uni.fmi.mjt.show.ergenka.Ergenka;

import java.lang.reflect.Array;
import java.util.Arrays;

public class PublicVoteEliminationRule implements EliminationRule{
    private static final int HALF = 2;
    private static final String NO_NAME = "none";
    private String[] votes;

    private String findEliminated(){
        int threshold = Math.floorDiv(votes.length, HALF) + 1;
        int size = votes.length;
        Arrays.sort(votes);
        String name = NO_NAME;
        int count = 0;

        for ( int i = 0; i < size; i++ ) {
            if ( votes[i].equals(name) ) {
                count++;
                if ( count >= threshold ) {
                    return name;
                }
            }
            else {
                name = votes[i];
                count = 1;
            }
        }
        return NO_NAME;
    }

    public PublicVoteEliminationRule(String[] votes){
        this.votes = votes;
    }

    public Ergenka[] eliminateErgenkas(Ergenka[] ergenkas) {
        String eliminated = findEliminated();
        if ( eliminated.equals(NO_NAME) ){
            return ergenkas;
        }
        else{
            int newIndex = 0;
            Ergenka[] result = new Ergenka[ergenkas.length];
            for ( int i = 0; i < ergenkas.length; i++) {
                if ( eliminated.equals(ergenkas[i].getName()) ) {
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
}
