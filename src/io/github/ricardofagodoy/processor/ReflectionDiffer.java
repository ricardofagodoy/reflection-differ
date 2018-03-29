package io.github.ricardofagodoy.processor;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class ReflectionDiffer implements IReflectionDiffer {

    private final List<Class> PRIMITIVES_TYPES = Arrays.asList(Integer.class, String.class, Boolean.class);

    @Override
    public boolean hasDifference(final Object a, final Object b) throws IllegalAccessException {

        if (a == b)
            return false;

        if (a.getClass() != b.getClass())
            throw new IllegalArgumentException("Wrong instance class received.");

        Class base = a.getClass();

        if (PRIMITIVES_TYPES.contains(base))
            return !a.equals(b);

        if (Collection.class.isAssignableFrom(base)) {

            Collection collectionA = (Collection) a;
            Collection collectionB = (Collection) b;

            return collectionA.size() != collectionB.size() ||
                    !collectionA.containsAll(collectionB);
        }

        for (Field field : base.getDeclaredFields()) {

            field.setAccessible(true);

            Object newA = field.get(a);
            Object newB = field.get(b);

            if (hasDifference(newA, newB))
                return true;
        }

        return false;
    }
}