package com.thinkingInJava.chapter19.enumerated.menu;
//Subcategorization of enums within interfaces.
public interface Food {
    enum Appetizer implements Food{
        SALAD,SOUP,SPRING_ROLLS;
    }
    enum MainCourse implements Food{
        LASAGNE,BURRITO,PAD_THAI,LENTILS,HUMMOUS,VINDALOO;
    }
    enum Dessert implements Food{
        TIRAMISU,GELATO,BLACK_FOREST_CAKE,TRUIT,CREME_CARAMEL;
    }
    enum Coffee implements Food{
        BLACK_COFFEE,DECAF_COFFEE,ESPRESSO,TATTE,CAPPUCCINO,TEA,HERB_TEA;
    }
}
