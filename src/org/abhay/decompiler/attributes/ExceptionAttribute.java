package org.abhay.decompiler.attributes;

import org.abhay.decompiler.util.ByteArrayIterator;

import java.util.ArrayList;
import java.util.List;

/**
 * User: Abhay
 * Date: 2/27/14
 * Time: 12:32 PM
 */
public class ExceptionAttribute extends AbstractAttribute
{
    List<String> exceptions;

    @Override
    public void parseInfo()
    {
        exceptions = new ArrayList<String>();

        ByteArrayIterator iterator = new ByteArrayIterator( info );

        int numberOfExceptions = iterator.nextUnsignedInt();

        for( int i=0; i< numberOfExceptions; i++ )
        {
            int exceptionIndexTable = iterator.nextUnsignedInt();

            exceptions.add( constantPool.getUtf8StringFromClassInfo( exceptionIndexTable ) );
        }

    }

    @Override
    public String getPrintableString()
    {
        StringBuilder sb = new StringBuilder();

        for( String exception : exceptions )
            sb.append( exception ).append(", ");

        sb.deleteCharAt( sb.length() - 2 );
        return sb.toString();
    }
}
