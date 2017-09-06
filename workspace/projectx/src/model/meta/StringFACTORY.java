package model.meta;

public class StringFACTORY{

    public static final String ModuleAbstractSGroup$FACTORY$ModuleGroupSGroup = "ModuleGroupSGroup";
    public static final String ModuleAbstractSGroup$FACTORY$ModuleAtomarSGroup = "ModuleAtomarSGroup";
    public static final String ModuleAbstractSGroup$FACTORY$ModuleWithUnitsSGroup = "ModuleWithUnitsSGroup";
    
    public static persistence.ModuleAbstractSGroup4Public createObjectBySubTypeNameForModuleAbstractSGroup(String name, ModuleAbstractSGroupSwitchPARAMETER switchAssistant) throws persistence.PersistenceException {
        if(name.equals(ModuleAbstractSGroup$FACTORY$ModuleGroupSGroup)) return switchAssistant.handleModuleGroupSGroup();
        if(name.equals(ModuleAbstractSGroup$FACTORY$ModuleAtomarSGroup)) return switchAssistant.handleModuleAtomarSGroup();
        if(name.equals(ModuleAbstractSGroup$FACTORY$ModuleWithUnitsSGroup)) return switchAssistant.handleModuleWithUnitsSGroup();
        throw new persistence.PersistenceException("No such type name!",0);
    }
    
    public static final String GradesInSimpleOrThird$FACTORY$Passed = "Bestanden";
    public static final String GradesInSimpleOrThird$FACTORY$T_3_7 = "3.7";
    public static final String GradesInSimpleOrThird$FACTORY$T_2_3 = "2.3";
    public static final String GradesInSimpleOrThird$FACTORY$T_5_0 = "5.0";
    public static final String GradesInSimpleOrThird$FACTORY$T_4_0 = "4.0";
    public static final String GradesInSimpleOrThird$FACTORY$T_1_3 = "1.3";
    public static final String GradesInSimpleOrThird$FACTORY$T_3_0 = "3.0";
    public static final String GradesInSimpleOrThird$FACTORY$T_2_0 = "2.0";
    public static final String GradesInSimpleOrThird$FACTORY$T_2_7 = "2.7";
    public static final String GradesInSimpleOrThird$FACTORY$T_1_7 = "1.7";
    public static final String GradesInSimpleOrThird$FACTORY$T_3_3 = "3.3";
    public static final String GradesInSimpleOrThird$FACTORY$NotPassed = "Nicht Bestanden";
    public static final String GradesInSimpleOrThird$FACTORY$T_1_0 = "1.0";
    public static final String GradesInSimpleOrThird$FACTORY$NoGradeThird = "Keine Note";
    
    public static persistence.GradesInSimpleOrThird4Public createObjectBySubTypeNameForGradesInSimpleOrThird(String name) throws persistence.PersistenceException {
        if(name.equals(GradesInSimpleOrThird$FACTORY$Passed)) return model.Passed.getThePassed();
        if(name.equals(GradesInSimpleOrThird$FACTORY$T_3_7)) return model.T_3_7.getTheT_3_7();
        if(name.equals(GradesInSimpleOrThird$FACTORY$T_2_3)) return model.T_2_3.getTheT_2_3();
        if(name.equals(GradesInSimpleOrThird$FACTORY$T_5_0)) return model.T_5_0.getTheT_5_0();
        if(name.equals(GradesInSimpleOrThird$FACTORY$T_4_0)) return model.T_4_0.getTheT_4_0();
        if(name.equals(GradesInSimpleOrThird$FACTORY$T_1_3)) return model.T_1_3.getTheT_1_3();
        if(name.equals(GradesInSimpleOrThird$FACTORY$T_3_0)) return model.T_3_0.getTheT_3_0();
        if(name.equals(GradesInSimpleOrThird$FACTORY$T_2_0)) return model.T_2_0.getTheT_2_0();
        if(name.equals(GradesInSimpleOrThird$FACTORY$T_2_7)) return model.T_2_7.getTheT_2_7();
        if(name.equals(GradesInSimpleOrThird$FACTORY$T_1_7)) return model.T_1_7.getTheT_1_7();
        if(name.equals(GradesInSimpleOrThird$FACTORY$T_3_3)) return model.T_3_3.getTheT_3_3();
        if(name.equals(GradesInSimpleOrThird$FACTORY$NotPassed)) return model.NotPassed.getTheNotPassed();
        if(name.equals(GradesInSimpleOrThird$FACTORY$T_1_0)) return model.T_1_0.getTheT_1_0();
        if(name.equals(GradesInSimpleOrThird$FACTORY$NoGradeThird)) return model.NoGradeThird.getTheNoGradeThird();
        throw new persistence.PersistenceException("No such type name!",0);
    }
    
    public static final String GradesInSimple$FACTORY$Passed = "Bestanden";
    public static final String GradesInSimple$FACTORY$NotPassed = "Nicht Bestanden";
    
    public static persistence.GradesInSimple4Public createObjectBySubTypeNameForGradesInSimple(String name) throws persistence.PersistenceException {
        if(name.equals(GradesInSimple$FACTORY$Passed)) return model.Passed.getThePassed();
        if(name.equals(GradesInSimple$FACTORY$NotPassed)) return model.NotPassed.getTheNotPassed();
        throw new persistence.PersistenceException("No such type name!",0);
    }
    
    public static final String ModuleAbstractStudent$FACTORY$ModuleWithUnitsStudent = "ModuleWithUnitsStudent";
    public static final String ModuleAbstractStudent$FACTORY$ModuleAtomarStudent = "ModuleAtomarStudent";
    public static final String ModuleAbstractStudent$FACTORY$ModuleGroupStudent = "ModuleGroupStudent";
    
    public static persistence.ModuleAbstractStudent4Public createObjectBySubTypeNameForModuleAbstractStudent(String name, ModuleAbstractStudentSwitchPARAMETER switchAssistant) throws persistence.PersistenceException {
        if(name.equals(ModuleAbstractStudent$FACTORY$ModuleWithUnitsStudent)) return switchAssistant.handleModuleWithUnitsStudent();
        if(name.equals(ModuleAbstractStudent$FACTORY$ModuleAtomarStudent)) return switchAssistant.handleModuleAtomarStudent();
        if(name.equals(ModuleAbstractStudent$FACTORY$ModuleGroupStudent)) return switchAssistant.handleModuleGroupStudent();
        throw new persistence.PersistenceException("No such type name!",0);
    }
    
    public static final String GradesInThird$FACTORY$T_2_3 = "2.3";
    public static final String GradesInThird$FACTORY$T_5_0 = "5.0";
    public static final String GradesInThird$FACTORY$T_4_0 = "4.0";
    public static final String GradesInThird$FACTORY$T_1_3 = "1.3";
    public static final String GradesInThird$FACTORY$T_3_0 = "3.0";
    public static final String GradesInThird$FACTORY$T_2_0 = "2.0";
    public static final String GradesInThird$FACTORY$T_2_7 = "2.7";
    public static final String GradesInThird$FACTORY$T_1_7 = "1.7";
    public static final String GradesInThird$FACTORY$T_3_3 = "3.3";
    public static final String GradesInThird$FACTORY$T_3_7 = "3.7";
    public static final String GradesInThird$FACTORY$T_1_0 = "1.0";
    public static final String GradesInThird$FACTORY$NoGradeThird = "Keine Note";
    
    public static persistence.GradesInThird4Public createObjectBySubTypeNameForGradesInThird(String name) throws persistence.PersistenceException {
        if(name.equals(GradesInThird$FACTORY$T_2_3)) return model.T_2_3.getTheT_2_3();
        if(name.equals(GradesInThird$FACTORY$T_5_0)) return model.T_5_0.getTheT_5_0();
        if(name.equals(GradesInThird$FACTORY$T_4_0)) return model.T_4_0.getTheT_4_0();
        if(name.equals(GradesInThird$FACTORY$T_1_3)) return model.T_1_3.getTheT_1_3();
        if(name.equals(GradesInThird$FACTORY$T_3_0)) return model.T_3_0.getTheT_3_0();
        if(name.equals(GradesInThird$FACTORY$T_2_0)) return model.T_2_0.getTheT_2_0();
        if(name.equals(GradesInThird$FACTORY$T_2_7)) return model.T_2_7.getTheT_2_7();
        if(name.equals(GradesInThird$FACTORY$T_1_7)) return model.T_1_7.getTheT_1_7();
        if(name.equals(GradesInThird$FACTORY$T_3_3)) return model.T_3_3.getTheT_3_3();
        if(name.equals(GradesInThird$FACTORY$T_3_7)) return model.T_3_7.getTheT_3_7();
        if(name.equals(GradesInThird$FACTORY$T_1_0)) return model.T_1_0.getTheT_1_0();
        if(name.equals(GradesInThird$FACTORY$NoGradeThird)) return model.NoGradeThird.getTheNoGradeThird();
        throw new persistence.PersistenceException("No such type name!",0);
    }
    
    public static final String ModuleAbstract$FACTORY$ModuleAtomar = "Atomar";
    public static final String ModuleAbstract$FACTORY$ModuleWithUnits = "Mit Units";
    public static final String ModuleAbstract$FACTORY$ModuleGroup = "Gruppe";
    
    public static persistence.ModuleAbstract4Public createObjectBySubTypeNameForModuleAbstract(String name, ModuleAbstractSwitchPARAMETER switchAssistant) throws persistence.PersistenceException {
        if(name.equals(ModuleAbstract$FACTORY$ModuleAtomar)) return switchAssistant.handleModuleAtomar();
        if(name.equals(ModuleAbstract$FACTORY$ModuleWithUnits)) return switchAssistant.handleModuleWithUnits();
        if(name.equals(ModuleAbstract$FACTORY$ModuleGroup)) return switchAssistant.handleModuleGroup();
        throw new persistence.PersistenceException("No such type name!",0);
    }
    
    
}
