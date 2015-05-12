package org.abhay.decompiler.attributes;

import org.abhay.decompiler.entities.LocalVariableInfo;
import org.abhay.decompiler.util.ByteArrayIterator;

/**
 * User: Abhay
 * Date: 2/25/14
 * Time: 12:04 AM
 */
public class LocalVariableTableAttribute extends AbstractAttribute
{
    LocalVariableInfo[] localVariableInfos;

    @Override
    public void parseInfo()
    {
        ByteArrayIterator iterator = new ByteArrayIterator( info );

        int noOfLocalVariableInfos = iterator.nextUnsignedInt();

        localVariableInfos = new LocalVariableInfo[ noOfLocalVariableInfos ];

        for( int i=0; i< noOfLocalVariableInfos; i++ )
        {
            LocalVariableInfo localVariableInfo = new LocalVariableInfo( constantPool );

            int startPc = iterator.nextUnsignedInt();
            int length = iterator.nextUnsignedInt();
            int nameIndex = iterator.nextUnsignedInt();
            int descriptorIndex = iterator.nextUnsignedInt();
            int index = iterator.nextUnsignedInt();

            localVariableInfo.setParameters(startPc, length, nameIndex, descriptorIndex, index);

            localVariableInfos[ index ] = localVariableInfo;
        }
    }

    @Override
    public String getPrintableString()
    {
        return null;
    }

    public LocalVariableInfo[] getLocalVariableInfos()
    {
        return localVariableInfos;
    }
}
