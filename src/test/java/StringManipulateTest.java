import org.junit.jupiter.api.Test;

import java.util.Stack;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringManipulateTest {

    @Test
    public void getStackOfString(String string){
        StringManipulator manipulator = new StringManipulator(string);
        Stack<Integer> integerStack = manipulator.getIntegerStack();
        Stack<Character> operatorStack = manipulator.getOperatorStack();

        assertEquals(getTestIntegerStack(string),integerStack);
        assertEquals(getTestOperatorStack(string), operatorStack);
    }

    public Stack<Integer> getTestIntegerStack(String string){
        Stack<Integer> integerStack = new Stack<>();
        for (int i = 0; i<string.length(); i++){
            char nowChar = string.charAt(i);
            if ('0' <= nowChar && nowChar<='9'){
                integerStack.push(Character.getNumericValue(nowChar));
            }
        }
        return integerStack;
    }

    public Stack<Character> getTestOperatorStack(String string){
        Stack<Character> operatorStack = new Stack<>();
        for (int i = 0; i<string.length(); i++){
            char nowChar = string.charAt(i);
            if ('0' > nowChar || nowChar >'9'){
                operatorStack.push(nowChar);
            }
        }
        return operatorStack;
    }
}