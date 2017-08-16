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
