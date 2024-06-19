package interpreter.bytecodes;

import interpreter.virtualmachine.VirtualMachine;

import java.util.ArrayList;

public class VerboseCode extends ByteCode
{
    private String status;

    public void init(ArrayList<String> s)
    {
        if(s.size() > 0)
        {
            status = s.get(0).toUpperCase();
        }
    }

    public void execute(VirtualMachine vm)
    {
        switch(status)
        {
            case "ON":
                vm.setVerboseMode(true);
            case "OFF":
                vm.setVerboseMode(false);
            default:
                vm.setVerboseMode(false);
        }
        System.out.println("VERBOSE" + status);
    }
}