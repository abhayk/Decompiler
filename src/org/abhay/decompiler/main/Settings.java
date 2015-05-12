package org.abhay.decompiler.main;

import org.abhay.decompiler.reverseengine.Decompiler;
import org.abhay.decompiler.reverseengine.Disassembler;
import org.abhay.decompiler.reverseengine.ReverseEngine;
import org.abhay.decompiler.util.Helper;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * User: Abhay
 * Date: 3/16/14
 * Time: 6:13 PM
 */
public class Settings
{
    private static List<String> settings;

    private static final String DISASSEMBLE_ARG = "-da";
    private static final String PATH_ARG = "-path";

    private static boolean disassemble = false;
    private static List<String> paths;

    private Settings()
    {
    }

    public static void initializeSettings( String[] args )
    {
        settings = Arrays.asList( args );

        if( settings.contains( DISASSEMBLE_ARG ))
            disassemble = true;

        int indexOfPath = settings.indexOf( PATH_ARG );

        String root = settings.get( indexOfPath + 1 );
        File rootFile = new File( root );
        paths = new ArrayList<String>();
        if( rootFile.isDirectory() )
            Helper.getAllClassFilesInDirectory( rootFile, paths );
        else
            paths.add( rootFile.getAbsolutePath() );

    }

    public static ReverseEngine getReverseEngine()
    {
        if( disassemble )
            return new Disassembler();
        return new Decompiler();
    }

    public static List<String> getPaths()
    {
        return paths;
    }

}
