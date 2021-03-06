package view.objects;

import view.*;
import viewClient.*;

public abstract class ModuleAbstractSGroupProxi extends ViewProxi implements ModuleAbstractSGroupView{
    
    public ModuleAbstractSGroupProxi(long objectId, long classId, ExceptionAndEventHandler connectionKey) {
        super(objectId, classId, connectionKey);
    }
    
    
    public String getName()throws ModelException{
        return ((ModuleAbstractSGroup)this.getTheObject()).getName();
    }
    public common.Fraction getCreditPoints()throws ModelException{
        return ((ModuleAbstractSGroup)this.getTheObject()).getCreditPoints();
    }
    public ModuleAbstractView getModuleCopy()throws ModelException{
        return ((ModuleAbstractSGroup)this.getTheObject()).getModuleCopy();
    }
    public void setModuleCopy(ModuleAbstractView newValue) throws ModelException {
        ((ModuleAbstractSGroup)this.getTheObject()).setModuleCopy(newValue);
    }
    public MyBooleanView getFinished()throws ModelException{
        return ((ModuleAbstractSGroup)this.getTheObject()).getFinished();
    }
    public void setFinished(MyBooleanView newValue) throws ModelException {
        ((ModuleAbstractSGroup)this.getTheObject()).setFinished(newValue);
    }
    
    
    
    public javafx.scene.image.Image getImage(){
        return super.getImage();
    }

	/* Start of protected part that is not overridden by persistence generator */
    
    /* End of protected part that is not overridden by persistence generator */
    
}
