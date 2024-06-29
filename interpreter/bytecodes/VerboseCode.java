package interpreter.bytecodes;

import interpreter.virtualmachine.VirtualMachine;
import java.util.List;
import java.util.ArrayList;

public class VerboseCode extends ByteCode
{
    private String value;
    private boolean onOff;

    public void init(List<String> s)
    {
        this.value = s.get(1);
    }

    public void execute(VirtualMachine vm)
    {
        if(value.equals("ON"))
        {
            this.onOff = true;
        }
        if(value.equals("OFF"))
        {
            this.onOff = false;
        }
        vm.setVerboseMode(onOff);
    }

    public String toString()
    {
        String retVal = "VERBOSE " + value;

        return retVal;
    }
}