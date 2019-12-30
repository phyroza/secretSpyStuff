package com.tomslab.aspect;

import java.util.logging.Level;
import java.io.PrintStream;
import java.util.logging.Logger;
import java.time.Instant;

public aspect SecurityAspect
{
    Logger logger = Logger.getGlobal();

    pointcut callCurse(String name, PrintStream stream, LogicClass lc) :
        call(public String LogicClass.curseDude(String, PrintStream)) && target(lc) && args(name, stream);

    String around(String name, PrintStream stream, LogicClass lc) : callCurse(name, stream, lc)
    {
        System.out.println("before advice");
        logger.log(Level.WARNING, Instant.now() + "ohhhhh.. someone be cursin'");
        String curse = proceed(name, stream, lc);
        logger.log(Level.WARNING, "Curse be like: " + curse);
        System.out.println("after advice");

        return curse;
    }

}