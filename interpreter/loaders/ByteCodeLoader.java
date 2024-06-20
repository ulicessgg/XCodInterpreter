package interpreter.loaders;

import interpreter.bytecodes.ByteCode;
import interpreter.loaders.Program;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

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

       try(BufferedReader lines = new BufferedReader(new FileReader(codSourceFileName)))
       {
            String line;

            while((line = lines.readLine()) != null)
            {
                String[] temp = line.split("\\s+");
                String token = temp[0];

                //switch statement or the use of the code table would go here i think
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
