package org.abhay.decompiler.entities;

import org.abhay.decompiler.main.Constants;

import java.util.ArrayList;
import java.util.List;

/**
 * User: Abhay
 * Date: 1/28/14
 * Time: 11:51 PM
 */
public class ConstantPool
{
    private List<CpInfo> constantPool;
    private int constantsRead = 0;

    public ConstantPool()
    {
        constantPool = new ArrayList<CpInfo>();
    }

    public void add( int tag, Integer index1, Integer index2, Object val )
    {
        constantPool.add( new CpInfo( tag, index1, index2, val ) );
        constantsRead++;
        if( tag == Constants.LONG_TAG || tag == Constants.DOUBLE_TAG )
        {
            constantPool.add( new CpInfo( -1, -1, -1, null ) );
            constantsRead++;
        }
    }

    public Object getValue( int index )
    {
        CpInfo cpInfo = constantPool.get( index - 1);
        if( cpInfo.getTag() == Constants.STRING_TAG )
            return getUtf8Value( cpInfo.getIndex1() );
        return constantPool.get( index - 1).getVal();
    }

    public String getUtf8Value( int index )
    {
        return ( String ) constantPool.get( index - 1 ).getVal();
    }

    public String getUtf8StringFromClassInfo( int index )
    {
        CpInfo classInfo = constantPool.get( index - 1 );
        return getUtf8Value( classInfo.getIndex1() );
    }

    public <T> T getValue( int index, Class<T> clazz)
    {
        return clazz.cast( constantPool.get( index - 1 ).getVal() );
    }

    public int getConstantsRead()
    {
        return constantsRead;
    }

    public void print()
    {
        int i = 1;
        for( CpInfo cpInfo : constantPool )
        {
            System.out.println(i++ + " - " + cpInfo.getTag() + " " + cpInfo.getIndex1() + " " +
                    cpInfo.getIndex2() + " " + cpInfo.getVal() );
        }
    }
}
