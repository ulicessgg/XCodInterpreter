package interpreter.bytecodes;

import interpreter.virtualmachine.VirtualMachine;
import java.util.List;
import java.util.ArrayList;


public abstract class ByteCode
{
    public abstract void init(List<String> s);

    public abstract void execute(VirtualMachine vm);

    public abstract String toString();
}
