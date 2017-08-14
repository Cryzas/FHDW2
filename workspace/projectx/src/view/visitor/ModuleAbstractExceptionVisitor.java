
package view.visitor;
import view.*;

public interface ModuleAbstractExceptionVisitor<E extends view.UserException> {
    
    public void handleModuleAtomar(ModuleAtomarView moduleAtomar) throws ModelException, E;
    public void handleModuleWithUnits(ModuleWithUnitsView moduleWithUnits) throws ModelException, E;
    
}
