package common;

import expressions.RegularExpressionHandler;

public class RegularExpressionManager {

    public static RegularExpressionHandler gradesInSimpleOrThirdSUBTYPEName = new RegularExpressionHandler( "[(Bestanden)" + 
		"(3.7)" + 
		"(2.3)" + 
		"(5.0)" + 
		"(4.0)" + 
		"(1.3)" + 
		"(3.0)" + 
		"(2.0)" + 
		"(2.7)" + 
		"(1.7)" + 
		"(3.3)" + 
		"(Keine\\ Note)" + 
		"(Nicht\\ Bestanden)" + 
		"(1.0)]" );
    public static RegularExpressionHandler gradesInSimpleSUBTYPEName = new RegularExpressionHandler( "[(Bestanden)" + 
		"(Nicht\\ Bestanden)]" );
    public static RegularExpressionHandler gradesInThirdSUBTYPEName = new RegularExpressionHandler( "[(2.3)" + 
		"(5.0)" + 
		"(4.0)" + 
		"(1.3)" + 
		"(3.0)" + 
		"(2.0)" + 
		"(2.7)" + 
		"(1.7)" + 
		"(3.3)" + 
		"(3.7)" + 
		"(Keine\\ Note)" + 
		"(1.0)]" );
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
