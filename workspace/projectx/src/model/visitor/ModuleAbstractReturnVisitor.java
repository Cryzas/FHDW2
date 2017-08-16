
package model.visitor;
import persistence.*;

public interface ModuleAbstractReturnVisitor<R> {
    
    public R handleModuleAtomar(ModuleAtomar4Public moduleAtomar) throws PersistenceException;
    public R handleModuleGroup(ModuleGroup4Public moduleGroup) throws PersistenceException;
    public R handleModuleWithUnits(ModuleWithUnits4Public moduleWithUnits) throws PersistenceException;
    
}
