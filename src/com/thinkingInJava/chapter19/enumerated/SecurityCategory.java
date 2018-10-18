package com.thinkingInJava.chapter19.enumerated;

import com.thinkingInJava.util.Enums;

import java.security.Security;
//More succinct subcategorization of enums
public enum SecurityCategory {
    STOCK(Security.Stock.class),BOND(Security.Bond.class);
    Security[] values;
    SecurityCategory(Class<? extends Security> kind){
        values=kind.getEnumConstants();
    }
    interface Security{
        enum Stock implements Security{SHORT,LONG,MARGIN}
        enum Bond implements Security{MUNICIPAL,JUNK}
    }

    public Security randomSelection(){
        return Enums.random(values);
    }

    public static void main(String[] args){
        for(int i=0;i<10;i++){
            SecurityCategory category=Enums.random(SecurityCategory.class);
            System.out.println(category+": "+category.randomSelection());
        }
    }
}
