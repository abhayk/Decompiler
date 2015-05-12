package org.abhay.decompiler.attributes;

import org.abhay.decompiler.util.ByteArrayIterator;
import org.abhay.decompiler.util.Helper;

/**
 * User: Abhay
 * Date: 2/2/14
 * Time: 6:24 PM
 */
public class ConstantValueAttribute extends AbstractAttribute
{
    private Object value;

    @Override
    public void parseInfo()
    {
        ByteArrayIterator iterator = new ByteArrayIterator( info );

        int constantValueIndex = iterator.nextUnsignedInt();

        this.value = constantPool.getValue( constantValueIndex );
    }

    @Override
    public String getPrintableString()
    {
        StringBuilder sb = new StringBuilder();
        return sb.append(" = ").append(Helper.printableValue(value)).toString();
    }

    public Object getValue()
    {
        return value;
    }
}
