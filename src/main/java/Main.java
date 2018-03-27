import static common.ArrayUtils.fillMatrix;

import algorithm.HetmanBackward;
import model.Hetman;
import validator.HetmanValidator;

/**
 *
 */
final class Main {
    public static void main(String[] args){
        int problemSize=8;
        boolean[][] matrix = new boolean[problemSize][];
        fillMatrix(matrix);
        Hetman hetman = new Hetman(matrix);

        HetmanValidator hetmanValidator = new HetmanValidator(problemSize);
        HetmanBackward hetmanBackward = new HetmanBackward(hetman, hetmanValidator, problemSize);

        hetmanBackward.run();

        System.out.println("sd");
    }

}
