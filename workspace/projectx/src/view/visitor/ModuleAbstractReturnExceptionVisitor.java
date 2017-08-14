
package view.visitor;
import view.*;

public interface ModuleAbstractReturnExceptionVisitor<R, E extends view.UserException> {
    
    public R handleModuleAtomar(ModuleAtomarView moduleAtomar) throws ModelException, E;
    public R handleModuleWithUnits(ModuleWithUnitsView moduleWithUnits) throws ModelException, E;
    
}
