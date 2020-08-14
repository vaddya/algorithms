package com.vaddya.stepik.algorithms;

import java.util.Comparator;
import java.util.List;

public class ContinuousBackpack {

    /**
     * Первая строка содержит количество предметов 1≤n≤10^3 и вместимость рюкзака 0≤W≤2⋅106.
     * Каждая из следующих n строк задаёт стоимость 0≤ci≤2⋅10^6 и объём 0<wi≤2⋅10^6 предмета
     * (n, W, ci, wi — целые числа). Выведите максимальную стоимость частей предметов
     * (от каждого предмета можно отделить любую часть, стоимость и объём при этом пропорционально уменьшатся),
     * помещающихся в данный рюкзак, с точностью не менее трёх знаков после запятой.
     */
    public static double maximizeCost(List<Thing> things, int capacity) {
        things.sort(Comparator.comparing((Thing thing) -> (double) thing.cost / thing.capacity).reversed());

        double totalCost = 0.0;
        double leftCapacity = capacity;
        while (leftCapacity > 0) {
            if (things.isEmpty()) break;
            Thing thing = things.get(0);
            if (thing.capacity > leftCapacity) {
                totalCost += thing.cost * leftCapacity / thing.capacity;
                leftCapacity = 0;
            } else {
                totalCost += thing.cost;
                leftCapacity -= thing.capacity;
            }
            things.remove(thing);
        }

        return totalCost;
    }

    public static class Thing {
        public int cost;
        public int capacity;

        public static Thing from(int cost, int volume) {
            Thing thing = new Thing();
            thing.cost = cost;
            thing.capacity = volume;
            return thing;
        }
    }
}
