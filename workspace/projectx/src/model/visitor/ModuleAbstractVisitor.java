
package model.visitor;
import persistence.*;

public interface ModuleAbstractVisitor {
    
    public void handleModuleAtomar(ModuleAtomar4Public moduleAtomar) throws PersistenceException;
    public void handleModuleGroup(ModuleGroup4Public moduleGroup) throws PersistenceException;
    public void handleModuleWithUnits(ModuleWithUnits4Public moduleWithUnits) throws PersistenceException;
    
}
