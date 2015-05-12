package org.abhay.decompiler.main;

/**
 * User: Abhay
 * Date: 3/3/14
 * Time: 9:47 PM
 */
public class Printer
{
    StringBuilder sb;

    int indentLevel = 0;

    public Printer()
    {
        sb = new StringBuilder();
    }

    public void printLine( String line )
    {
        for( String s : line.split("\n") )
        {
            indent();
            sb.append( s ).append("\n");
        }
    }

    public void append( CharSequence line )
    {
        sb.append( line );
    }

    public void appendWithIndentation( CharSequence line )
    {
        indent();
        append( line );
    }

    public void printLine( StringBuilder line )
    {
        printLine( line.toString() );
    }

    public void openBrace()
    {
        indent();
        sb.append("{\n");
        indentLevel++;
    }

    public void closeBrace()
    {
        indentLevel--;
        indent();
        sb.append("}\n");
    }

    public String get()
    {
        return sb.toString();
    }

    private void indent()
    {
        for(int i=0; i<indentLevel; i++)
            sb.append("\t");
    }
}
