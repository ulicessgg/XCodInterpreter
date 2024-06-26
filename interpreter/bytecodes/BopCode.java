package interpreter.bytecodes;

import interpreter.virtualmachine.VirtualMachine;
import java.util.List;
import java.util.ArrayList;

public class BopCode extends ByteCode
{
    private String operator;

    public void init(List<String> s)
    {

    }

    public void execute(VirtualMachine vm)
    {

    }

    public String toString()
    {
        String retVal = "BOP " + operator;

        return retVal;
    }
}