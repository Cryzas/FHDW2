package view.objects;

import view.*;
import viewClient.*;

public abstract class ComponentProxi extends ViewProxi implements ComponentView{
    
    public ComponentProxi(long objectId, long classId, ExceptionAndEventHandler connectionKey) {
        super(objectId, classId, connectionKey);
    }
    
    
    public String getName()throws ModelException{
        return ((Component)this.getTheObject()).getName();
    }
    public void setName(String newValue) throws ModelException {
        ((Component)this.getTheObject()).setName(newValue);
    }
    public common.Fraction getPrice()throws ModelException{
        return ((Component)this.getTheObject()).getPrice();
    }
    public void setPrice(common.Fraction newValue) throws ModelException {
        ((Component)this.getTheObject()).setPrice(newValue);
    }
    public common.Fraction getOverAllPrice()throws ModelException{
        return ((Component)this.getTheObject()).getOverAllPrice();
    }
    
    
    
    public javafx.scene.image.Image getImage(){
        return super.getImage();
    }

	/* Start of protected part that is not overridden by persistence generator */
    
    /* End of protected part that is not overridden by persistence generator */
    
}
