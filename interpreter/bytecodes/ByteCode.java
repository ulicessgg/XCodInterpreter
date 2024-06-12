package interpreter.bytecodes;

import interpreter.virtualmachine.VirtualMachine;

import java.util.ArrayList;


public abstract class ByteCode
{
    public abstract void init(ArrayList<String> s);

    public abstract void execute(VirtualMachine vm);
}
