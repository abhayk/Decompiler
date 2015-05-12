package org.abhay.decompiler.attributes;

import org.abhay.decompiler.main.Settings;
import org.abhay.decompiler.entities.ExceptionInfo;
import org.abhay.decompiler.main.Constants;
import org.abhay.decompiler.util.ByteArrayIterator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * User: Abhay
 * Date: 2/23/14
 * Time: 11:34 PM
 */
public class CodeAttribute extends AbstractAttribute
{
    private int maxStack;
    private int maxLocals;
    private List<ExceptionInfo> exceptionInfos;
    private Map<String, Attribute> attributeNameAttributeMap;
    private byte[] code;

    @Override
    public void parseInfo() throws AttributeException
    {
        ByteArrayIterator iterator = new ByteArrayIterator( info );

        maxStack = iterator.nextUnsignedInt();

        maxLocals = iterator.nextUnsignedInt();

        int codeLength = iterator.nextInt();

        code = iterator.nextNBytes( codeLength );

        readExceptionsInfos( iterator );

        readAttributes( iterator );
    }

    @Override
    public String getPrintableString()
    {
        return Settings.getReverseEngine().process( this );
    }

    private void readExceptionsInfos(ByteArrayIterator iterator)
    {
        int exceptionTableLength = iterator.nextUnsignedInt();

        exceptionInfos = new ArrayList<ExceptionInfo>();

        for( int i=0; i<exceptionTableLength; i++ )
        {
            ExceptionInfo exceptionInfo = new ExceptionInfo( constantPool );
            int startPc = iterator.nextUnsignedInt();
            int endPc = iterator.nextUnsignedInt();
            int handlerPc = iterator.nextUnsignedInt();
            int catchTypeIndex = iterator.nextUnsignedInt();

            exceptionInfo.setParameters( startPc, endPc, handlerPc, catchTypeIndex );
            exceptionInfos.add( exceptionInfo );
        }
    }

    private void readAttributes( ByteArrayIterator iterator ) throws AttributeException
    {
        int attributesCount = iterator.nextUnsignedInt();

        attributeNameAttributeMap = new HashMap<String, Attribute>();

        for( int i=0; i<attributesCount; i++ )
        {
            int attributeNameIndex = iterator.nextUnsignedInt();
            int length = iterator.nextInt();
            byte[] info = iterator.nextNBytes( length );
            Attribute attribute = Attributes.formAttribute(constantPool, attributeNameIndex, length, info);
            attributeNameAttributeMap.put(attribute.getName(), attribute);
        }
    }

    public LocalVariableTableAttribute getLocalVariableTableAttribute()
    {
        return (LocalVariableTableAttribute) attributeNameAttributeMap.get(Constants.LOCAL_VARIABLE_TABLE_ATTRIBUTE_NAME );
    }

    public int getMaxStack()
    {
        return maxStack;
    }

    public int getMaxLocals()
    {
        return maxLocals;
    }

    public byte[] getCodeArray()
    {
        return code;
    }


}
