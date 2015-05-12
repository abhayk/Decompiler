package org.abhay.decompiler.entities;

/**
 * User: Abhay
 * Date: 2/25/14
 * Time: 12:14 AM
 */
public class LineNumberInfo
{
    private int startPc;
    private int lineNumber;

    public LineNumberInfo( int startPc, int lineNumber )
    {
        this.startPc = startPc;
        this.lineNumber = lineNumber;
    }

}
