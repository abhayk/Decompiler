package org.abhay.decompiler.util;

/**
 * User: Abhay
 * Date: 3/6/14
 * Time: 11:05 PM
 */
public class Timer
{
    private static long start;

    public static void start()
    {
        start = System.nanoTime();
    }

    public static void stopAndPrintInNano()
    {
        long end = System.nanoTime();
        System.out.println("Completed in - " + (end - start) + " ns");
    }

    public static void stopAndPrintInMilli()
    {
        long end = System.nanoTime();
        System.out.println("Completed in - " + ((float)(end-start))/1000000F + " ms");
    }

}
