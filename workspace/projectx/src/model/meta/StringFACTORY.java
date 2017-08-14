package model.meta;

public class StringFACTORY{

    public static final String ModuleAbstract$FACTORY$ModuleAtomar = "ModuleAtomar";
    public static final String ModuleAbstract$FACTORY$ModuleWithUnits = "ModuleWithUnits";
    
    public static persistence.ModuleAbstract4Public createObjectBySubTypeNameForModuleAbstract(String name, ModuleAbstractSwitchPARAMETER switchAssistant) throws persistence.PersistenceException {
        if(name.equals(ModuleAbstract$FACTORY$ModuleAtomar)) return switchAssistant.handleModuleAtomar();
        if(name.equals(ModuleAbstract$FACTORY$ModuleWithUnits)) return switchAssistant.handleModuleWithUnits();
        throw new persistence.PersistenceException("No such type name!",0);
    }
    
    
}
