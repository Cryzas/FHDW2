package common;

import expressions.RegularExpressionHandler;

public class RegularExpressionManager {

    public static RegularExpressionHandler moduleAbstractSGroupSUBTYPEName = new RegularExpressionHandler( "[(ModuleGroupSGroup)" + 
		"(ModuleAtomarSGroup)" + 
		"(ModuleWithUnitsSGroup)]" );
    public static RegularExpressionHandler moduleAbstractSUBTYPEName = new RegularExpressionHandler( "[(Atomar)" + 
		"(Mit\\ Units)" + 
		"(Gruppe)]" );
    

}
