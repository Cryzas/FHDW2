package view.objects;

import view.*;
import viewClient.*;

public abstract class ContaineeProxi extends ViewProxi implements ContaineeView{
    
    public ContaineeProxi(long objectId, long classId, ExceptionAndEventHandler connectionKey) {
        super(objectId, classId, connectionKey);
    }
    
    
    public String getName()throws ModelException{
        return ((Containee)this.getTheObject()).getName();
    }
    public void setName(String newValue) throws ModelException {
        ((Containee)this.getTheObject()).setName(newValue);
    }
    
    
    
    public javafx.scene.image.Image getImage(){
        return super.getImage();
    }

	/* Start of protected part that is not overridden by persistence generator */
    
    /* End of protected part that is not overridden by persistence generator */
    
}
