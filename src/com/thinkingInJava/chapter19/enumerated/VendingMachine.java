package com.thinkingInJava.chapter19.enumerated;
//{Args:VendingMachineInput.txt}

import com.sun.tools.corba.se.idl.constExpr.Terminal;
import com.thinkingInJava.util.Generator;
import com.thinkingInJava.util.TextFile;

import javax.swing.plaf.nimbus.State;
import java.util.EnumMap;
import java.util.Iterator;

import static com.thinkingInJava.chapter19.enumerated.Input.*;

enum Category{
    MONEY(NICKEL,DIME,QUARTER,DOLLAR),
    ITEM_SELECTION(TOOTHPASTE,CHIPS,SODA,SOAP),
    QUIT_TRANSACTION(ABORT_TRANSACTION),
    SHUT_DOWN(STOP);
    private Input[] values;
    Category(Input... types){this.values=types;}
    private static EnumMap<Input,Category> categories=new EnumMap<Input, Category>(Input.class);
    static{
        for(Category c:Category.class.getEnumConstants()){
            for(Input type:c.values){
                categories.put(type,c);
            }
        }
    }
    public static Category categorize(Input input){
        return categories.get(input);
    }
}
public class VendingMachine {
    private static State state=State.RESTING;
    private static int amount=0;
    private static Input selection=null;
    enum StateDuration{TRANSIENT}//Tagging enum
    enum State{
        RESTING{
            void next(Input input){
                switch(Category.categorize(input)){
                    case MONEY:
                        amount+=input.amount();
                        state=ADDING_MONEY;
                        break;
                    case SHUT_DOWN:
                        state=TERMINAL;
                    default:
                }
            }
        },
        ADDING_MONEY{
            void next(Input input){
                switch(Category.categorize(input)){
                    case MONEY:
                        amount+=input.amount();
                        break;
                    case ITEM_SELECTION:
                        selection=input;
                        if(amount<selection.amount()){
                            System.out.println("Insufficient money for "+selection);
                        }else{
                            state=DISPENSING;
                        }
                        break;
                    case QUIT_TRANSACTION:
                        state=GIVING_CHANGE;
                        break;
                    case SHUT_DOWN:
                        state=TERMINAL;
                    default:
                }
            }
        },
        DISPENSING(StateDuration.TRANSIENT){
            void next(){
                System.out.println("here is your "+selection);
                amount-=selection.amount();
                state=GIVING_CHANGE;
            }
        },
        GIVING_CHANGE(StateDuration.TRANSIENT){
            void next(){
                if(amount>0){
                    System.out.println("Your change: "+amount);
                    amount=0;
                }
            }
        },
        TERMINAL{void output(){System.out.println("Halted");}};
        private boolean isTransient=false;
        State(){}
        State(StateDuration trans){isTransient=true;}
        void next(Input input){
            throw new RuntimeException("Only call next(Input input) for non-transient states");
        }
        void next(){
            throw new RuntimeException("Only call next() for StateDuration.TRANSIENT states");
        }
        void output(){System.out.println(amount);}
    }
    static void run(Generator<Input> gen){
        while(state!=State.TERMINAL){
            state.next(gen.next());
            while(state.isTransient){
                state.next();
            }
            state.output();
        }
    }
    public static void main(String[] args){
        Generator<Input> gen=new RandomInputGenerator();
        if(args.length==1){
            gen=new FileInputGenerator(args[0]);
        }
        run(gen);
    }
}

//For a basic sanity check:
class RandomInputGenerator implements Generator<Input>{
    public Input next(){
        return Input.randomSelection();
    }
}

//For a basic sanity check:
class FileInputGenerator implements Generator<Input>{
    private Iterator<String> input;
    public FileInputGenerator(String fileName){
        input=new TextFile(fileName,":").iterator();
    }
    public Input next(){
        if(!input.hasNext()){
            return null;
        }
        return Enum.valueOf(Input.class,input.next().trim());
    }
}