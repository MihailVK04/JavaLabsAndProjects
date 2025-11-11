package bg.sofia.uni.fmi.mjt.show.elimination;

import bg.sofia.uni.fmi.mjt.show.ergenka.Ergenka;

import java.lang.reflect.Array;

public class LowAttributeSumEliminationRule implements EliminationRule{
    private int threshold;

    public LowAttributeSumEliminationRule(int threshold){
        if (threshold < 0){
            this.threshold = 0;
        }
        this.threshold = threshold;
    }

    public Ergenka[] eliminateErgenkas(Ergenka[] ergenkas) {
        int size = Array.getLength(ergenkas);
        Ergenka[] result = new Ergenka[size];
        int attributeSum, newIndex = 0;

        for ( int i = 0; i < size; i++ ) {
            attributeSum = ergenkas[i].getHumorLevel() + ergenkas[i].getRomanceLevel();
            if ( attributeSum < threshold ) {
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
