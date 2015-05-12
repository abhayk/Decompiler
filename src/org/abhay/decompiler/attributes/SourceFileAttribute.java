package org.abhay.decompiler.attributes;

import org.abhay.decompiler.util.ByteArrayIterator;

/**
 * User: Abhay
 * Date: 2/27/14
 * Time: 2:10 PM
 */
public class SourceFileAttribute extends AbstractAttribute
{
    private String sourceFileName;

    @Override
    public void parseInfo()
    {
        ByteArrayIterator iterator = new ByteArrayIterator( info );

        sourceFileName = constantPool.getUtf8Value( iterator.nextUnsignedInt() );
    }

    @Override
    public String getPrintableString()
    {
        return sourceFileName;
    }
}
