package view.objects;

import view.*;
import viewClient.*;

public abstract class abstractAccProxi extends ViewProxi implements abstractAccView{
    
    public abstractAccProxi(long objectId, long classId, ExceptionAndEventHandler connectionKey) {
        super(objectId, classId, connectionKey);
    }
    
    
    public String getName()throws ModelException{
        return ((abstractAcc)this.getTheObject()).getName();
    }
    public void setName(String newValue) throws ModelException {
        ((abstractAcc)this.getTheObject()).setName(newValue);
    }
    
    
    
    public javafx.scene.image.Image getImage(){
        return super.getImage();
    }

	/* Start of protected part that is not overridden by persistence generator */
    
    /* End of protected part that is not overridden by persistence generator */
    
}
