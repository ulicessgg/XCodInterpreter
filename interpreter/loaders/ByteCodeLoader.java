package interpreter.loaders;

import interpreter.bytecodes.*;
import interpreter.loaders.Program;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public final class ByteCodeLoader {
    private String codSourceFileName;
    
    /**
     * Constructs ByteCodeLoader object given a COD source code
     * file name
     * @param fileName name of .cod File to load.
     */
    public ByteCodeLoader(String fileName){
        this.codSourceFileName = fileName;
    }
    
    /**
     * Loads a program from a .cod file.
     * @return a constructed Program Object.
     * @throws InvalidProgramException thrown when 
     * loadCodes fails.
     */
    public Program loadCodes() throws InvalidProgramException
    {
       Program exe = new Program();

       CodeTable.init();

       try(BufferedReader lines = new BufferedReader(new FileReader(codSourceFileName)))
       {
            String line;
            
            while((line = lines.readLine()) != null)
            {
                String[] temp = line.split("\\s+");
                String token = temp[0];
                ArrayList<String> args = new ArrayList<>();

                for (int i = 0; i < temp.length; i++)
                {
                    args.add(temp[i]);
                }

                ByteCode newByte;

                switch(token)
                {
                    case "ARGS":
                        newByte = new ArgsCode();
                        break;
                    case "BOP":
                        newByte = new BopCode();
                        break;
                    case "CALL":
                        newByte = new CallCode();
                        break;
                    case "FALSEBRANCH":
                        newByte = new FalseBranchCode();
                        break;
                    case "GOTO":
                        newByte = new GoToCode();
                        break;
                    case "HALT":
                        newByte = new HaltCode();
                        break;
                    case "LABEL":
                        newByte = new LabelCode();
                        break;
                    case "LIT":
                        newByte = new LitCode();
                        break;
                    case "LOAD":
                        newByte = new LoadCode();
                        break;
                    case "POP":
                        newByte = new PopCode();
                        break;
                    case "READ":
                        newByte = new ReadCode();
                        break;
                    case "RETURN":
                        newByte = new ReturnCode();
                        break;
                    case "STORE":
                        newByte = new StoreCode();
                        break;
                    case "VERBOSE":
                        newByte = new VerboseCode();
                        break;
                    case "WRITE":
                        newByte = new WriteCode();
                        break;
                    default:
                        throw new InvalidProgramException("ERROR");
                }

                newByte.init(args);
                exe.addCode(newByte);
            }
       }
       catch(IOException e)
       {
           throw new InvalidProgramException("Error");
       }

       exe.resolveAddress();
       return exe;
    }
}
