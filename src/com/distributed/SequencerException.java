package com.distributed;
import java.io.*;
public class SequencerException extends Exception implements Serializable
{
    public SequencerException(String s)
    {
        super(s);
    }
}
