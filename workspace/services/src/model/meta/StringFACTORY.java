package model.meta;

public class StringFACTORY{

    public static final String Service$FACTORY$Administrator = "Administrator";
    public static final String Service$FACTORY$Customer = "Customer";
    public static final String Service$FACTORY$Register = "Register";
    public static final String Service$FACTORY$UserManager = "UserManager";
    
    public static persistence.Service4Public createObjectBySubTypeNameForService(String name, ServiceSwitchPARAMETER switchAssistant) throws persistence.PersistenceException {
        if(name.equals(Service$FACTORY$Administrator)) return switchAssistant.handleAdministrator();
        if(name.equals(Service$FACTORY$Customer)) return switchAssistant.handleCustomer();
        if(name.equals(Service$FACTORY$Register)) return switchAssistant.handleRegister();
        if(name.equals(Service$FACTORY$UserManager)) return switchAssistant.handleUserManager();
        throw new persistence.PersistenceException("No such type name!",0);
    }
    
    
}
