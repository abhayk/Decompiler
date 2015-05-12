package org.abhay.decompiler.entities;

/**
 * User: Abhay
 * Date: 2/27/14
 * Time: 12:59 PM
 */
public class ExceptionInfo
{
    private int startPc;
    private int endPc;
    private int handlerPc;
    private String catchType;

    private ConstantPool constantPool;

    public ExceptionInfo( ConstantPool constantPool )
    {
        this.constantPool = constantPool;
    }

    public void setParameters( int startPc, int endPc, int handlerPc, int catchTypeIndex )
    {
        this.startPc = startPc;
        this.endPc = endPc;
        this.handlerPc = handlerPc;
        this.catchType = constantPool.getUtf8StringFromClassInfo( catchTypeIndex );
    }


}
