
package model.visitor;

import persistence.*;

public abstract class programHierarchyHIERARCHYStandardVisitor implements programHierarchyHIERARCHYVisitor {
    
    public void handleProgram(Program4Public program) throws PersistenceException{
        this.standardHandling(program);
    }
    public void handleModuleAtomar(ModuleAtomar4Public moduleAtomar) throws PersistenceException{
        this.standardHandling(moduleAtomar);
    }
    public void handleModuleWithUnits(ModuleWithUnits4Public moduleWithUnits) throws PersistenceException{
        this.standardHandling(moduleWithUnits);
    }
    public void handleModuleGroup(ModuleGroup4Public moduleGroup) throws PersistenceException{
        this.standardHandling(moduleGroup);
    }
    public void handleUnit(Unit4Public unit) throws PersistenceException{
        this.standardHandling(unit);
    }
    protected abstract void standardHandling(programHierarchyHIERARCHY programHierarchyHIERARCHY) throws PersistenceException;
}
