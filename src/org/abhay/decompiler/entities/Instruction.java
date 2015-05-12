package org.abhay.decompiler.entities;

import org.abhay.decompiler.util.ByteArrayIterator;

/**
 * User: Abhay
 * Date: 2/26/14
 * Time: 8:56 PM
 */
public class Instruction
{
    private OpCode opCode;
    private int otherBytesLength;
    private byte[] otherBytes;

    public Instruction(OpCode opCode, int otherBytesLength)
    {
        this.opCode = opCode;
        this.otherBytesLength = otherBytesLength;
    }

    public String getPrintableString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append( opCode.toString() );
        for( byte b : otherBytes )
            sb.append(" ").append( b );
        return sb.toString();
    }

    public Instruction newInstance()
    {
        return new Instruction( this.opCode, this.otherBytesLength );
    }

    public int getOtherBytesLength()
    {
        return otherBytesLength;
    }

    public int getOtherBytesLengthForVariableLength( ByteArrayIterator iterator )
    {
        switch( opCode )
        {
            case LOOKUPSWITCH:
            {
                //TODO: Implement
                System.out.println("LOOKUPSWITCH found !!!");
            }
            case TABLESWITCH:
            {
                int length = 3 - ( iterator.getCurrentPosition() % 4 );
                for( int i=0; i< length; i++ )
                    iterator.nextByte();

                iterator.nextInt(); //default val
                length += 4;
                int high = iterator.nextInt();
                length += 4;
                int low = iterator.nextInt();
                length += 4;

                length += ( 4 * ( high - low + 1) );

                otherBytesLength = length;
            }
            case WIDE:
            {
                Instruction instruction = Instructions.getInstruction( iterator.next() );
                OpCode wideOpCode = instruction.getOpCode();

                switch ( wideOpCode )
                {
                    case ILOAD:
                    case FLOAD:
                    case ALOAD:
                    case LLOAD:
                    case DLOAD:
                    case ISTORE:
                    case FSTORE:
                    case ASTORE:
                    case LSTORE:
                    case DSTORE:
                    case RET:
                    {
                        otherBytesLength = instruction.getOtherBytesLength() + 1;
                    }
                    case IINC:
                    {
                        otherBytesLength = instruction.getOtherBytesLength() + 2;
                    }
                }
            }
        }
        return otherBytesLength;
    }

    public OpCode getOpCode()
    {
        return opCode;
    }

    public byte[] getOtherBytes()
    {
        return otherBytes;
    }

    public void setOtherBytes( byte[] bytes )
    {
        this.otherBytes = bytes;
    }

    public int getOffset()
    {
        return otherBytes[0] << 8 | otherBytes[1];
    }
}
