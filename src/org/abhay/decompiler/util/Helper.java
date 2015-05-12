package org.abhay.decompiler.util;

import org.abhay.decompiler.main.Constants;

import java.io.File;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Abhay.mr
 * Date: 15/01/14
 * Time: 12:31
 */
public class Helper
{
    public static int getInt( byte b )
    {
        return b & 0xFF;
    }

    public static boolean[] convertToBooleanArray( int i )
    {
        boolean[] buf = new boolean[32];
        int charPos = 0;
        do
        {
            buf[charPos++] = ((i & 1) == 1);
            i >>>= 1;
        }
        while (i != 0);
        return buf;
    }

    public static StringBuilder printableValue( Object value )
    {
        StringBuilder sb = new StringBuilder();

        if( value instanceof Long)
            sb.append(value).append("L");
        else if( value instanceof String)
            sb.append("\"").append(value).append("\"");
        else
            sb.append( value );
        return sb;
    }

    public static String getParsedType( String typeStr )
    {
        int dimension = typeStr.lastIndexOf( "[" ) + 1;
        String type = getType( dimension, typeStr );
        return appendDimensions( dimension, type ).toString();
    }

    private static StringBuilder appendDimensions( int dimension, String type )
    {
        StringBuilder descriptorStr = new StringBuilder();
        descriptorStr.append( type );
        for( int i=0; i<dimension; i++)
            descriptorStr.append("[]");
        return descriptorStr;
    }

    private static String getType(int dimension, String typeStr)
    {
        String type = typeStr;
        if( dimension != -1)
            type = typeStr.substring( dimension );
        if( type.startsWith("L"))
            type = type.replace(";", "");
        else
            type = Constants.getBaseTypeMap().get(type);
        return type;
    }

    public static void getAllClassFilesInDirectory( File file, List<String> files )
    {
        for( File subFile : file.listFiles() )
        {
            if( subFile.isDirectory() )
                getAllClassFilesInDirectory(subFile, files);
            else
            {
                if( isClassFile( subFile.getName() ) )
                    files.add(subFile.getAbsolutePath());
            }
        }
    }
     private static boolean isClassFile( String name )
    {
        String[] splitValues = name.split("\\.");
        if( splitValues.length > 1 && splitValues[1].equals("class") )
            return true;
        return false;
    }
}
