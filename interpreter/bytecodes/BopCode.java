package interpreter.bytecodes;

import interpreter.virtualmachine.VirtualMachine;
import java.util.List;
import java.util.ArrayList;

public class BopCode extends ByteCode
{
    private String operator;

    public void init(List<String> s)
    {
        if(!s.isEmpty())
        {
            operator = s.get(1);
        }
    }

    public void execute(VirtualMachine vm)
    {
        int num2 = vm.pop();
        int num1 = vm.pop();
        int result = 0;

        switch(operator)
        {
            case "+":
                result = num1 + num2;
                break;
            case "-":
                result = num1 - num2;
                break;
            case "/":
                result = num1 / num2;
                break;
            case "*":
                result = num1 * num2;
                break;
            case "==":
                if(num1 == num2)
                {
                    result = 1;
                }

                break;
            case "!=":
                if(num1 != num2)
                {
                    result = 1;
                }

                break;
            case "<=":
                if(num1 <= num2)
                {
                    result = 1;
                }

                break;
            case "<":
                if(num1 < num2)
                {
                    result = 1;
                }

                break;
            case ">=":
                if(num1 >= num2)
                {
                    result = 1;
                }

                break;
            case ">":
                if(num1 > num2)
                {
                    result = 1;
                }

                break;
            case "&":
                if(num1 == 1 && num2 == 1)
                {
                    result = 1;
                }

                break;
            case "|":
                if(num1 == 1 || num2 == 1)
                {
                    result = 1;
                }

                break;
            default:
                break;
        }
        vm.push(result);
    }

    public String toString()
    {
        String retVal = "BOP " + operator;

        return retVal;
    }
}