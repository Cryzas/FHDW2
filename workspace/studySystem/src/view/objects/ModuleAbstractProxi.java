package view.objects;

import view.*;
import viewClient.*;

public abstract class ModuleAbstractProxi extends ViewProxi implements ModuleAbstractView{
    
    public ModuleAbstractProxi(long objectId, long classId, ExceptionAndEventHandler connectionKey) {
        super(objectId, classId, connectionKey);
    }
    
    
    public String getName()throws ModelException{
        return ((ModuleAbstract)this.getTheObject()).getName();
    }
    public void setName(String newValue) throws ModelException {
        ((ModuleAbstract)this.getTheObject()).setName(newValue);
    }
    public common.Fraction getCreditPoints()throws ModelException{
        return ((ModuleAbstract)this.getTheObject()).getCreditPoints();
    }
    public java.util.Vector<ModuleGroupView> getParentGroup()throws ModelException{
        return ((ModuleAbstract)this.getTheObject()).getParentGroup();
    }
    public java.util.Vector<ProgramView> getParentProgram()throws ModelException{
        return ((ModuleAbstract)this.getTheObject()).getParentProgram();
    }
    
    
    
    public javafx.scene.image.Image getImage(){
        return super.getImage();
    }

	/* Start of protected part that is not overridden by persistence generator */
    
    /* End of protected part that is not overridden by persistence generator */
    
}
