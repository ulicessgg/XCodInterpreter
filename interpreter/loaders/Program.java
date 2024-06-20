package interpreter.loaders;

import java.util.ArrayList;
import java.util.List;

import interpreter.bytecodes.*;
import java.util.Map;
import java.util.HashMap;
public class Program {

    private List<ByteCode> program;

    /**
     * Instantiates a program object using an
     * ArrayList
     */
    public Program()
    {
        program = new ArrayList<>();
    }

    /**
     * Gets the size of the current program.
     * @return size of program
     */
    public int getSize()
    {
        return program.size();
    }

    /**
     * Grabs an instance of a bytecode at an index.
     * @param programCounter index of bytecode to get.
     * @return a bytecode.
     */
    public ByteCode getCode(int programCounter)
    {
        return program.get(programCounter);
    }

    /**
     * Adds a bytecode instance to the Program List.
     * @param c bytecode to be added
     */
    public void addCode(ByteCode c)
    {
        program.add(c);
    }

    /**
     * Makes multiple passes through the program ArrayList
     * resolving addrss for Goto,Call and FalseBranch
     * bytecodes. These bytecodes can only jump to Label
     * codes that have a matching label value.
     * HINT: make note of what type of data-structure
     * ByteCodes are stored in.
     * **** METHOD SIGNATURE CANNOT BE CHANGED *****
     */
    public void resolveAddress() //need to ask about this one for future implementation
    {
        Map<String, Integer> labels = new HashMap<>();

        // First pass: record all label positions
        for (int i = 0; i < program.size(); i++)
        {
            if (program.get(i) instanceof LabelCode)
            {
                LabelCode label = (LabelCode) program.get(i);
                labels.put(label.getLabel(), i);
            }
        }

        // Second pass: resolve addresses for Goto, Call, and FalseBranch codes
        for (ByteCode byteCode : program)
        {
            if (byteCode instanceof GoToCode)
            {
                GoToCode goTo = (GoToCode) byteCode;
                goTo.setAddress(labels.get(goTo.getLabel()));
            } else if (byteCode instanceof CallCode)
            {
                CallCode call = (CallCode) byteCode;
                call.setAddress(labels.get(call.getLabel()));
            } else if (byteCode instanceof FalseBranchCode)
            {
                FalseBranchCode falseBranch = (FalseBranchCode) byteCode;
                falseBranch.setAddress(labels.get(falseBranch.getLabel()));
            }
        }
    }
}   