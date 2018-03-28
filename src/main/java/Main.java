import static common.ArrayUtils.fillMatrix;

import algorithm.HetmanBackward;
import algorithm.LatinSquareBackward;
import model.Hetman;
import model.LatinSquare;
import validator.HetmanValidator;
import validator.LatinSquareValidator;

/**
 *
 */
final class Main {
    public static void main(String[] args){
        //runHetmanBackward(8);
        runLatinSquareBackward(15);
    }

    private static void runHetmanBackward(int problemSize){
        boolean[][] matrix = new boolean[problemSize][];
        fillMatrix(matrix);
        Hetman hetman = new Hetman(matrix);

        HetmanValidator validator = new HetmanValidator(problemSize);
        HetmanBackward hetmanBackward = new HetmanBackward(problemSize, hetman, validator);

        hetmanBackward.run();
    }

    private static void runLatinSquareBackward(int problemSize){
        int[][] matrix = new int[problemSize][];
        fillMatrix(matrix);
        LatinSquare latinSquare = new LatinSquare(matrix);

        LatinSquareValidator validator = new LatinSquareValidator(problemSize);
        LatinSquareBackward latinSquareBackward = new LatinSquareBackward(problemSize, latinSquare, validator);

        latinSquareBackward.run();
        System.out.println("s");
    }

}
