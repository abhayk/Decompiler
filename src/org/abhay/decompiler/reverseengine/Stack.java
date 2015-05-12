package org.abhay.decompiler.reverseengine;

import org.abhay.decompiler.entities.LocalVariableInfo;

import java.util.EmptyStackException;

/**
 * User: Abhay
 * Date: 2/28/14
 * Time: 7:40 PM
 */
public class Stack
{
    private Object[] stack;
    private int maxSize = 0;
    private int size = 0;
    private boolean resize;

    public Stack( int maxSize, boolean resize )
    {
        stack = new Object[ maxSize ];
        this.maxSize = maxSize;
        this.resize = resize;
    }

    public void push( Object a )
    {
        if( size == maxSize )
        {
            if( resize )
                resize();
            else
                throw new ArrayIndexOutOfBoundsException("Stack full !!");
        }
        stack[ size++ ] = a;
    }

    private void resize()
    {
        Object[] newStack = new Object[ stack.length * 2 ];
        for( int i=0; i<stack.length; i++)
            newStack[i] = stack[i];
        stack = newStack;
    }

    public Object pop()
    {
        if( size == 0 )
            throw new EmptyStackException();
        Object item = stack[ --size ];
        stack[ size ] = null;
        if( item instanceof LocalVariableInfo )
            return ((LocalVariableInfo) item).getName();
        return item;
    }

    public Object peek()
    {
        return stack[ size - 1 ];
    }

    public Integer peekInt()
    {
        Object item = peek();
        return item == null ? -1 : (Integer) item;
    }

    public <T> T pop( Class<T> clazz )
    {
        return clazz.cast( pop() );
    }

    public int size()
    {
        return size;
    }
}
