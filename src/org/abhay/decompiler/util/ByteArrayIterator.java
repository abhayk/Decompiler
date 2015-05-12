package org.abhay.decompiler.util;

import java.util.NoSuchElementException;

/**
 * Created with IntelliJ IDEA.
 * User: Abhay.mr
 * Date: 15/01/14
 * Time: 11:59
 */
public class ByteArrayIterator
{
    private byte[] a;
    private int i = 0;

    public ByteArrayIterator( byte[] a)
    {
        this.a = a;
    }

    public boolean hasNext()
    {
        return i < a.length;
    }

    public int next()
    {
        return Helper.getInt( nextByte() );
    }

    public byte nextByte()
    {
        if( i == a.length)
            throw new NoSuchElementException("No more bytes");
        return a[ i++ ] ;
    }

    public byte[] nextNBytes( int n )
    {
        byte[] b = new byte[ n ];
        for(int i=0; i<n; i++)
            b[i] = nextByte();
        return b;
    }

    public int nextUnsignedInt()
    {
//        int ch1 = next();
//        int ch2 = next();
//        return (ch1 << 8) + (ch2 << 0);
        return Integer.parseInt( getHexString( nextNBytes ( 2 ) ), 16 );
    }

    public int nextInt()
    {
//        int ch1 = next();
//        int ch2 = next();
//        int ch3 = next();
//        int ch4 = next();
//        return ((ch1 << 24) + (ch2 << 16) + (ch3 << 8) + (ch4 << 0));
        return Integer.parseInt( getHexString( nextNBytes ( 4 ) ), 16 );
    }

    public String nextString( int len )
    {
        byte[] b = nextNBytes( len );
        StringBuilder sb = new StringBuilder();
        for( int a : b)
            sb.append(a);
        return sb.toString();
    }

    private String getHexString( byte[] b )
    {
        StringBuilder sb = new StringBuilder();
        for( byte a : b )
            sb.append( getHexString(a) );
        return sb.toString();
    }

    private String getHexString( byte b )
    {
        return Integer.toHexString( Helper.getInt( b ) );
    }

    public int getCurrentPosition()
    {
        return i;
    }

}
