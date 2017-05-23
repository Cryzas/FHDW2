package view.objects;

import view.*;
import viewClient.*;

public abstract class MailProxi extends ViewProxi implements MailView{
    
    public MailProxi(long objectId, long classId, ExceptionAndEventHandler connectionKey) {
        super(objectId, classId, connectionKey);
    }
    
    
    public java.util.Vector<AccountWrapperView> getReceivers()throws ModelException{
        return ((Mail)this.getTheObject()).getReceivers();
    }
    public void setReceivers(java.util.Vector<AccountWrapperView> newValue) throws ModelException {
        ((Mail)this.getTheObject()).setReceivers(newValue);
    }
    public String getSubject()throws ModelException{
        return ((Mail)this.getTheObject()).getSubject();
    }
    public void setSubject(String newValue) throws ModelException {
        ((Mail)this.getTheObject()).setSubject(newValue);
    }
    public String getText()throws ModelException{
        return ((Mail)this.getTheObject()).getText();
    }
    public void setText(String newValue) throws ModelException {
        ((Mail)this.getTheObject()).setText(newValue);
    }
    
    
    
    public javafx.scene.image.Image getImage(){
        return super.getImage();
    }

	/* Start of protected part that is not overridden by persistence generator */
    
    private final int RemoteDepth = 1;
    
    /* End of protected part that is not overridden by persistence generator */
    
}
