package algorithm;

import lombok.Value;
import model.Hetman;
import validator.HetmanValidator;

/**
 *
 */
@Value
public final class HetmanBackward {

    int problemSize;

    Hetman hetman;
    HetmanValidator validator;

    public void run(){
        run(0);
    }

    private boolean run(int row){
        if(row==problemSize){
            return true;
        }

        int temp;
        for(int column = 0; column < problemSize; column++){
            temp = tryToInsertHetmanToRow(row, column, problemSize);
            if(temp != -1){
                column = temp;
                if(run(++row)){
                    return true;
                }
            }
        }
        return false;
    }

    private int tryToInsertHetmanToRow(int row, int start, int end){
        for(int column=start; column<end; column++){
            hetman.getMatrix()[row][column] = true;
            if(validator.isPartialValid(hetman, 0, row+1)){
                return column;
            }
            else{
                hetman.getMatrix()[row][column] = false;
            }
        }
        return -1;
    }

}
