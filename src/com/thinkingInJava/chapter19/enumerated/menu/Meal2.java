package com.thinkingInJava.chapter19.enumerated.menu;

import com.thinkingInJava.util.Enums;

public enum Meal2 {
    APPETIZER(Food.Appetizer.class),
    MAINCOURSE(Food.MainCourse.class),
    DESSERT(Food.Dessert.class),
    COFFEE(Food.Coffee.class);
    private Food values[];
    private Meal2(Class<? extends Food> kind){
        values=kind.getEnumConstants();
    }
    public interface Food{
        enum Appetizer implements Food{
            SALAD,SOUP,SPRING_ROLLS;
        }
        enum MainCourse implements Food{
            LASAGNE,BURRITO,PAD_THAI,LENTILS,HUMMOUS,VINDALOO;
        }
        enum Dessert implements Food{
            TIRAMISU,GELATO,BLACK_FOREST_CAKE,FRUIT,CREME_CARAMEL;
        }
        enum Coffee implements Food{
            BLACK_COFFEE,DECAF_COFFEE,ESPERSSO,LATTE,CAPPUCCINO,HERB_TEA;
        }
    }
    public Food randomSelection(){
        return Enums.random(values);
    }
    public static void main(String[] args){
        for(int i=0;i<5;i++){
            for(Meal2 meal:Meal2.values()){
                Food food=meal.randomSelection();
                System.out.println(food);
            }
            System.out.println("----");
        }
    }
}
