package org.abhay.decompiler.attributes;

import org.abhay.decompiler.entities.LineNumberInfo;

import java.util.List;

/**
 * User: Abhay
 * Date: 2/25/14
 * Time: 12:13 AM
 */
public class LineNumberTableAttribute extends AbstractAttribute
{
    private List<LineNumberInfo> lineNumberInfos;

    @Override
    public void parseInfo()
    {

    }

    @Override
    public String getPrintableString()
    {
        return null;
    }
}
