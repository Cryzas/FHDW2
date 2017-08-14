
package model.visitor;
import persistence.*;

public interface ModuleAbstractExceptionVisitor<E extends model.UserException> {
    
    public void handleModuleAtomar(ModuleAtomar4Public moduleAtomar) throws PersistenceException, E;
    public void handleModuleWithUnits(ModuleWithUnits4Public moduleWithUnits) throws PersistenceException, E;
    
}
