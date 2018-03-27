package validator;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;

import model.Hetman;
import org.junit.Test;

/**
 *
 */
public class HetmanValidatorTest {

    @Test
    public void hetmanIsValid(){
        boolean[][] matrix = new boolean[][]{
                {false,false,false,false,true,false,false,false},
                {false,false,true,false,false,false,false,false},
                {true,false,false,false,false,false,false,false},
                {false,false,false,false,false,true,false,false},
                {false,false,false,false,false,false,false,true},
                {false,true,false,false,false,false,false,false},
                {false,false,false,true,false,false,false,false},
                {false,false,false,false,false,false,true,false},
        };
        Hetman hetman = new Hetman(matrix);
        HetmanValidator validator = new HetmanValidator(matrix.length);
        assertTrue(validator.isValid(hetman));
    }

    @Test
    public void hetmanIsNotValidWhenInvalidColumnsAndRows(){
        boolean[][] matrix = new boolean[][]{
                {true,false,false,false,false,false,false,false},
                {false,false,true,false,false,false,false,false},
                {true,false,false,false,false,false,false,false},
                {false,false,false,false,false,true,false,false},
                {false,false,false,false,false,false,false,true},
                {false,true,false,false,false,false,false,false},
                {false,false,false,true,false,false,false,false},
                {false,false,false,false,false,false,true,false},
        };
        Hetman hetman = new Hetman(matrix);
        HetmanValidator validator = new HetmanValidator(matrix.length);
        assertFalse(validator.isValid(hetman));
    }

    @Test
    public void hetmanIsNotValidWhenInvalidLeftDiagonal(){
        boolean[][] matrix = new boolean[][]{
                {true,false,false,false,false,false,false,false},
                {false,true,false,false,false,false,false,false},
                {false,false,false,false,false,false,false,false},
                {false,false,false,false,false,false,false,false},
                {false,false,false,false,false,false,false,false},
                {false,false,false,false,false,false,false,false},
                {false,false,false,false,false,false,false,false},
                {false,false,false,false,false,false,false,false},
        };
        Hetman hetman = new Hetman(matrix);
        HetmanValidator validator = new HetmanValidator(matrix.length);
        assertFalse(validator.isValid(hetman));
    }

    @Test
    public void hetmanIsNotValidWhenInvalidRightDiagonal(){
        boolean[][] matrix = new boolean[][]{
                {false,false,false,false,false,false,false,false},
                {false,false,false,false,false,false,true,false},
                {false,false,false,false,false,false,false,false},
                {false,false,false,false,false,false,false,false},
                {false,false,false,false,false,false,false,false},
                {false,false,false,false,false,false,false,false},
                {false,false,false,false,false,false,false,false},
                {true,false,false,false,false,false,false,false},
        };
        Hetman hetman = new Hetman(matrix);
        HetmanValidator validator = new HetmanValidator(matrix.length);
        assertFalse(validator.isValid(hetman));
    }

    @Test
    public void hetmanIsNotValidWhenInvalidDiagonalAndRow(){
        boolean[][] matrix = new boolean[][]{
                {true,false,false,false,false,false,false,true},
                {false,false,true,false,false,false,true,false},
                {false,false,false,false,false,false,false,false},
                {false,false,false,false,false,false,false,false},
                {false,false,false,false,false,false,false,false},
                {false,false,false,false,false,false,false,false},
                {false,false,false,false,false,false,false,false},
                {false,false,false,false,false,false,false,false},
        };
        Hetman hetman = new Hetman(matrix);
        HetmanValidator validator = new HetmanValidator(matrix.length);
        assertFalse(validator.isValid(hetman));
    }
}
