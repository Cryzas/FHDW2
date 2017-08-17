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
    public GradeSystemView getGradeSystem()throws ModelException{
        return ((ModuleAbstract)this.getTheObject()).getGradeSystem();
    }
    public void setGradeSystem(GradeSystemView newValue) throws ModelException {
        ((ModuleAbstract)this.getTheObject()).setGradeSystem(newValue);
    }
    
    
    
    public javafx.scene.image.Image getImage(){
        return super.getImage();
    }

	/* Start of protected part that is not overridden by persistence generator */
    
    /* End of protected part that is not overridden by persistence generator */
    
}
