package model.meta;

public class StringFACTORY{

    public static final String Containee$FACTORY$File = "File";
    public static final String Containee$FACTORY$Directory = "Directory";
    
    public static persistence.Containee4Public createObjectBySubTypeNameForContainee(String name, ContaineeSwitchPARAMETER switchAssistant) throws persistence.PersistenceException {
        if(name.equals(Containee$FACTORY$File)) return switchAssistant.handleFile();
        if(name.equals(Containee$FACTORY$Directory)) return switchAssistant.handleDirectory();
        throw new persistence.PersistenceException("No such type name!",0);
    }
    
    
}
