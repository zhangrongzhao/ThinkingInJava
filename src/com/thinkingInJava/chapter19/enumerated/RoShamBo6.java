package com.thinkingInJava.chapter19.enumerated;

import static com.thinkingInJava.chapter19.enumerated.Outcome.DRAW;
import static com.thinkingInJava.chapter19.enumerated.Outcome.LOSE;
import static com.thinkingInJava.chapter19.enumerated.Outcome.WIN;

public enum RoShamBo6 implements Competitor<RoShamBo6> {
    PAPER,SCISSORS,ROCK;
    private static Outcome[][] table={
            {DRAW,LOSE,WIN},//PAPER
            {WIN,DRAW,LOSE},//SCISSORS
            {LOSE,WIN,DRAW}//ROCK
    };
    public Outcome compete(RoShamBo6 other){
        return table[this.ordinal()][other.ordinal()];
    }
    public static void main(String[] args){
        RoShamBo.play(RoShamBo6.class,20);
    }
}
