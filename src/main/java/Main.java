import static common.ArrayUtils.fillMatrix;

import algorithm.HetmanBackward;
import algorithm.HetmanForward;
import algorithm.LatinSquareBackward;
import algorithm.LatinSquareForward;
import model.Hetman;
import model.LatinSquare;
import validator.HetmanValidator;
import validator.LatinSquareValidator;

/**
 *
 */
final class Main {
    public static void main(String[] args){
        //runHetmanBackward(80);
        //runLatinSquareBackward(10);
        runHetmanForward(80);
        //runLatinSquareForward(10);
    }

    private static void runHetmanBackward(int problemSize){
        boolean[][] matrix = new boolean[problemSize][];
        fillMatrix(matrix);
        Hetman hetman = new Hetman(matrix);

        HetmanValidator validator = new HetmanValidator(problemSize);
        HetmanBackward hetmanBackward = new HetmanBackward(problemSize, hetman, validator);

        hetmanBackward.run();

        System.out.println(validator.isValid(hetman));
    }

    private static void runLatinSquareBackward(int problemSize){
        int[][] matrix = new int[problemSize][];
        fillMatrix(matrix);
        LatinSquare latinSquare = new LatinSquare(matrix);

        LatinSquareValidator validator = new LatinSquareValidator(problemSize);
        LatinSquareBackward latinSquareBackward = new LatinSquareBackward(problemSize, latinSquare, validator);

        latinSquareBackward.run();

        System.out.println(validator.isValid(latinSquare));
    }

    private static void runHetmanForward(int problemSize){
        boolean[][] matrix = new boolean[problemSize][];
        fillMatrix(matrix);
        Hetman hetman = new Hetman(matrix);

        HetmanForward hetmanForward = new HetmanForward(problemSize, hetman);

        hetmanForward.run();

        HetmanValidator validator = new HetmanValidator(problemSize);
        System.out.println(validator.isValid(hetman));
    }

    private static void runLatinSquareForward(int problemSize){
        int[][] matrix = new int[problemSize][];
        fillMatrix(matrix);
        LatinSquare latinSquare = new LatinSquare(matrix);

        LatinSquareForward latinSquareForward = new LatinSquareForward(problemSize, latinSquare);

        latinSquareForward.run();

        LatinSquareValidator validator = new LatinSquareValidator(problemSize);
        System.out.println(validator.isValid(latinSquare));
    }

}
