
package model.visitor;
import persistence.*;

public interface ModuleAbstractReturnExceptionVisitor<R, E extends model.UserException> {
    
    public R handleModuleAtomar(ModuleAtomar4Public moduleAtomar) throws PersistenceException, E;
    public R handleModuleWithUnits(ModuleWithUnits4Public moduleWithUnits) throws PersistenceException, E;
    
}
