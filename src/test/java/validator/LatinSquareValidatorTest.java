package validator;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;

import model.LatinSquare;
import org.junit.Test;

/**
 *
 */
public class LatinSquareValidatorTest {

    @Test
    public void latinSquareIsValid(){
        int[][] matrix = new int[][]{
                {1,4,2,5,3,6},
                {6,3,4,2,5,1},
                {2,1,5,6,4,3},
                {4,2,6,3,1,5},
                {3,5,1,4,6,2},
                {5,6,3,1,2,4}
        };
        LatinSquare latinSquare = new LatinSquare(matrix);
        LatinSquareValidator validator = new LatinSquareValidator(matrix.length);
        assertTrue(validator.isValid(latinSquare));
    }

    @Test
    public void latinSquareIsNotValid(){
        int[][] matrix = new int[][]{
                {1,4,2,5,3,6},
                {6,3,4,2,5,1},
                {6,1,5,6,4,3},
                {4,2,6,3,1,5},
                {3,5,1,4,6,2},
                {5,6,3,1,2,4}
        };
        LatinSquare latinSquare = new LatinSquare(matrix);
        LatinSquareValidator validator = new LatinSquareValidator(matrix.length);
        assertFalse(validator.isValid(latinSquare));
    }
}
