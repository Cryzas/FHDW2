package common;

import expressions.RegularExpressionHandler;

public class RegularExpressionManager {

    public static RegularExpressionHandler gradeSystemSUBTYPEName = new RegularExpressionHandler( "[(Einfach)" + 
		"(Zehntelnoten)" + 
		"(Drittelnoten)]" );
    public static RegularExpressionHandler moduleAbstractSGroupSUBTYPEName = new RegularExpressionHandler( "[(ModuleGroupSGroup)" + 
		"(ModuleAtomarSGroup)" + 
		"(ModuleWithUnitsSGroup)]" );
    public static RegularExpressionHandler moduleAbstractSUBTYPEName = new RegularExpressionHandler( "[(Atomar)" + 
		"(Mit\\ Units)" + 
		"(Gruppe)]" );
    public static RegularExpressionHandler moduleAbstractStudentSUBTYPEName = new RegularExpressionHandler( "[(ModuleWithUnitsStudent)" + 
		"(ModuleAtomarStudent)" + 
		"(ModuleGroupStudent)]" );
    

}
