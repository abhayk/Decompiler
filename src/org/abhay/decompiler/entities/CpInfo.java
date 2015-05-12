package org.abhay.decompiler.entities;

/**
 * User: Abhay
 * Date: 1/15/14
 * Time: 11:47 PM
 */
public class CpInfo
{
    private int tag;
    private Integer index1, index2;
    private Object val;

    public CpInfo( int tag, Integer index1, Integer index2, Object val )
    {
        this.tag = tag;
        this.index1 = index1;
        this.index2 = index2;
        this.val = val;
    }

    public CpInfo()
    {

    }

    public int getTag()
    {
        return tag;
    }

    public void setTag(int tag)
    {
        this.tag = tag;
    }

    public Integer getIndex1()
    {
        return index1;
    }

    public void setIndex1(Integer index1)
    {
        this.index1 = index1;
    }

    public Integer getIndex2()
    {
        return index2;
    }

    public void setIndex2(Integer index2)
    {
        this.index2 = index2;
    }

    public Object getVal()
    {
        return val;
    }

    public void setVal(Object val)
    {
        this.val = val;
    }
}
