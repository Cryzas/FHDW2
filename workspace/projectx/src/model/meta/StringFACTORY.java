package model.meta;

public class StringFACTORY{

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
