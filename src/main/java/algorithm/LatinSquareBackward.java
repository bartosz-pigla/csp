package algorithm;

import lombok.Value;
import model.LatinSquare;
import validator.LatinSquareValidator;

/**
 *
 */
@Value
public final class LatinSquareBackward {

    int problemSize;

    LatinSquare latinSquare;
    LatinSquareValidator validator;

}
