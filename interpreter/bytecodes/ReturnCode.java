package interpreter.bytecodes;

import interpreter.virtualmachine.VirtualMachine;
import java.util.List;
import java.util.ArrayList;

public class ReturnCode extends ByteCode
{
    private String label;

    public void init(List<String> s)
    {
        if(!s.isEmpty())
        {
            this.label = s.getFirst();
        }
    }

    public void execute(VirtualMachine vm)
    {
        int rVaL = vm.pop();
        vm.popFrame();
        vm.popReturnAddress();
    }

    public String toString()
    {
        String retVal = "RETURN ";

        if(label != null)
        {
            retVal = retVal + label + " EXIT " + label;
        }

        return retVal;
    }
}