
package model.visitor;

import persistence.*;

public abstract class programHierarchySGroupHIERARCHYStandardVisitor implements programHierarchySGroupHIERARCHYVisitor {
    
    public void handleProgramSGroup(ProgramSGroup4Public programSGroup) throws PersistenceException{
        this.standardHandling(programSGroup);
    }
    public void handleModuleGroupSGroup(ModuleGroupSGroup4Public moduleGroupSGroup) throws PersistenceException{
        this.standardHandling(moduleGroupSGroup);
    }
    public void handleModuleAtomarSGroup(ModuleAtomarSGroup4Public moduleAtomarSGroup) throws PersistenceException{
        this.standardHandling(moduleAtomarSGroup);
    }
    public void handleUnitSGroup(UnitSGroup4Public unitSGroup) throws PersistenceException{
        this.standardHandling(unitSGroup);
    }
    public void handleModuleWithUnitsSGroup(ModuleWithUnitsSGroup4Public moduleWithUnitsSGroup) throws PersistenceException{
        this.standardHandling(moduleWithUnitsSGroup);
    }
    protected abstract void standardHandling(programHierarchySGroupHIERARCHY programHierarchySGroupHIERARCHY) throws PersistenceException;
}
