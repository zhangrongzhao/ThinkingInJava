package com.thinkingInJava.chapter19.enumerated;

public enum RoShamBo2 implements Competitor<RoShamBo2> {
    PAPER(Outcome.DRAW,Outcome.LOSE,Outcome.WIN),
    SCISSORS(Outcome.WIN,Outcome.DRAW,Outcome.LOSE),
    ROCK(Outcome.LOSE,Outcome.WIN,Outcome.DRAW);
    private Outcome vPAPER,vSCISSORS,vROCK;
    RoShamBo2(Outcome paper,Outcome scissors,Outcome rock){
        this.vPAPER=paper;
        this.vSCISSORS=scissors;
        this.vROCK=rock;
    }

    public Outcome compete(RoShamBo2 it){
        switch (it){
            default:
            case PAPER:return vPAPER;
            case SCISSORS:return vSCISSORS;
            case ROCK:return vROCK;
        }
    }
    public static void main(String[] args){
        RoShamBo.play(RoShamBo2.class,20);
    }
}
