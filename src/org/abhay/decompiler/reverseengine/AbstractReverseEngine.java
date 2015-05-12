package org.abhay.decompiler.reverseengine;

import org.abhay.decompiler.entities.Instruction;
import org.abhay.decompiler.entities.Instructions;
import org.abhay.decompiler.main.Constants;
import org.abhay.decompiler.main.Printer;
import org.abhay.decompiler.util.ByteArrayIterator;

/**
 * User: Abhay
 * Date: 3/16/14
 * Time: 6:23 PM
 */
public abstract class AbstractReverseEngine implements ReverseEngine
{
    protected Printer printer;

    public AbstractReverseEngine()
    {
        printer = new Printer();
    }

    protected Instruction getInstruction( ByteArrayIterator iterator )
    {
        int opCode = iterator.next();
        Instruction instruction = Instructions.getInstruction(opCode);

        int otherBytesLength = instruction.getOtherBytesLength();
        if( otherBytesLength == Constants.VARIABLE_BYTES )
            otherBytesLength = instruction.getOtherBytesLengthForVariableLength( iterator );
        byte[] otherBytes = iterator.nextNBytes( otherBytesLength );

        Instruction currentInstruction = instruction.newInstance();
        currentInstruction.setOtherBytes( otherBytes );

        return currentInstruction;
    }
}
