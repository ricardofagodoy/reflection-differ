package io.github.ricardofagodoy.processor;

public interface IReflectionDiffer {

    boolean hasDifference(Object a, Object b) throws IllegalAccessException;
}