package io.github.ricardofagodoy;

import io.github.ricardofagodoy.objects.Card;
import io.github.ricardofagodoy.objects.Person;
import io.github.ricardofagodoy.processor.IReflectionDiffer;
import io.github.ricardofagodoy.processor.ReflectionDiffer;

public class Main {

    public static void main(String[] args) throws IllegalAccessException {

        Person p1 = new Person("Ricardo");
        p1.addCard(new Card("123"));
        p1.addCard(new Card("456"));

        Person p2 = new Person("James");
        p2.addCard(new Card("123"));
        p2.addCard(new Card("456"));

        Person p3 = new Person("Ricardo");
        p3.addCard(new Card("123"));
        p3.addCard(new Card("456"));

        IReflectionDiffer reflectionDiffer = new ReflectionDiffer();

        System.out.println("are p1 and p1 different? " + reflectionDiffer.hasDifference(p1, p1));

        System.out.println("are p1 and p2 different? " + reflectionDiffer.hasDifference(p1, p2));

        System.out.println("are p1 and p3 different? " + reflectionDiffer.hasDifference(p1, p3));

        p3.addCard(new Card("111"));
        System.out.println("are p1 and p3 (with one more card) different? " + reflectionDiffer.hasDifference(p1, p3));

        p1.addCard(new Card("111"));
        System.out.println("are p1 and p3 (same cards again) different? " + reflectionDiffer.hasDifference(p1, p3));

        p3.blockCard("123");
        System.out.println("are p1 and p3 (p3 blocked one card) different? " + reflectionDiffer.hasDifference(p1, p3));
    }
}