package view.objects;

import view.*;
import viewClient.*;

public abstract class EntryProxi extends ViewProxi implements EntryView{
    
    public EntryProxi(long objectId, long classId, ExceptionAndEventHandler connectionKey) {
        super(objectId, classId, connectionKey);
    }
    
    
    public String getDescription()throws ModelException{
        return ((Entry)this.getTheObject()).getDescription();
    }
    public void setDescription(String newValue) throws ModelException {
        ((Entry)this.getTheObject()).setDescription(newValue);
    }
    public common.Fraction getAmount()throws ModelException{
        return ((Entry)this.getTheObject()).getAmount();
    }
    public void setAmount(common.Fraction newValue) throws ModelException {
        ((Entry)this.getTheObject()).setAmount(newValue);
    }
    public AccountView getOtherAcc()throws ModelException{
        return ((Entry)this.getTheObject()).getOtherAcc();
    }
    public void setOtherAcc(AccountView newValue) throws ModelException {
        ((Entry)this.getTheObject()).setOtherAcc(newValue);
    }
    
    
    
    public javafx.scene.image.Image getImage(){
        return super.getImage();
    }

	/* Start of protected part that is not overridden by persistence generator */
    
    /* End of protected part that is not overridden by persistence generator */
    
}
