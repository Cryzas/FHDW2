
package view.visitor;
import view.*;

public interface ModuleAbstractReturnVisitor<R> {
    
    public R handleModuleAtomar(ModuleAtomarView moduleAtomar) throws ModelException;
    public R handleModuleWithUnits(ModuleWithUnitsView moduleWithUnits) throws ModelException;
    
}
