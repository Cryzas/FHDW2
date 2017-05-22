package view.objects;

import view.*;
import viewClient.*;

public abstract class BookableProxi extends ViewProxi implements BookableView{
    
    public BookableProxi(long objectId, long classId, ExceptionAndEventHandler connectionKey) {
        super(objectId, classId, connectionKey);
    }
    
    
    public String getSubject()throws ModelException{
        return ((Bookable)this.getTheObject()).getSubject();
    }
    public void setSubject(String newValue) throws ModelException {
        ((Bookable)this.getTheObject()).setSubject(newValue);
    }
    
    
    
    public javafx.scene.image.Image getImage(){
        return super.getImage();
    }

	/* Start of protected part that is not overridden by persistence generator */
    
    /* End of protected part that is not overridden by persistence generator */
    
}
