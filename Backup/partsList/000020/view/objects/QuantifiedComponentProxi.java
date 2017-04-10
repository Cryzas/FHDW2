package view.objects;

import view.*;
import viewClient.*;

import view.visitor.*;

public class QuantifiedComponentProxi extends ViewProxi implements QuantifiedComponentView{
    
    public QuantifiedComponentProxi(long objectId, long classId, ExceptionAndEventHandler connectionKey) {
        super(objectId, classId, connectionKey);
    }
    
    public QuantifiedComponentView getRemoteObject(java.util.HashMap<String,Object> resultTable, ExceptionAndEventHandler connectionKey) throws ModelException{
        long quantity = new Long((String)resultTable.get("quantity")).longValue();
        ViewProxi component = null;
        String component$String = (String)resultTable.get("component");
        if (component$String != null) {
            common.ProxiInformation component$Info = common.RPCConstantsAndServices.createProxiInformation(component$String);
            component = view.objects.ViewProxi.createProxi(component$Info,connectionKey);
            component.setToString(component$Info.getToString());
        }
        QuantifiedComponentView result$$ = new QuantifiedComponent((long)quantity,(ComponentView)component, this.getId(), this.getClassId());
        ((ViewRoot)result$$).setToString((String) resultTable.get(common.RPCConstantsAndServices.RPCToStringFieldName));
        return result$$;
    }
    
    public int getRemoteDepth() {
        return RemoteDepth;
    }
    public ViewObjectInTree getChild(int originalIndex) throws ModelException{
        int index = originalIndex;
        if(index == 0 && this.getComponent() != null) return new ComponentQuantifiedComponentWrapper(this, originalIndex, (ViewRoot)this.getComponent());
        if(this.getComponent() != null) index = index - 1;
        return null;
    }
    public int getChildCount() throws ModelException {
        return 0 
            + (this.getComponent() == null ? 0 : 1);
    }
    public boolean isLeaf() throws ModelException {
        if (this.object == null) return this.getLeafInfo() == 0;
        return true 
            && (this.getComponent() == null ? true : false);
    }
    public int getIndexOfChild(Object child) throws ModelException {
        int result = 0;
        if(this.getComponent() != null && this.getComponent().equals(child)) return result;
        if(this.getComponent() != null) result = result + 1;
        return -1;
    }
    
    public long getQuantity()throws ModelException{
        return ((QuantifiedComponent)this.getTheObject()).getQuantity();
    }
    public void setQuantity(long newValue) throws ModelException {
        ((QuantifiedComponent)this.getTheObject()).setQuantity(newValue);
    }
    public ComponentView getComponent()throws ModelException{
        return ((QuantifiedComponent)this.getTheObject()).getComponent();
    }
    public void setComponent(ComponentView newValue) throws ModelException {
        ((QuantifiedComponent)this.getTheObject()).setComponent(newValue);
    }
    
    public void accept(AnythingVisitor visitor) throws ModelException {
        visitor.handleQuantifiedComponent(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleQuantifiedComponent(this);
    }
    public <E extends view.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleQuantifiedComponent(this);
    }
    public <R, E extends view.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleQuantifiedComponent(this);
    }
    
    public boolean hasTransientFields(){
        return false;
    }
    
    public javafx.scene.image.Image getImage(){
        return super.getImage();
    }

	/* Start of protected part that is not overridden by persistence generator */
    
    private final int RemoteDepth = 1;
    
    /* End of protected part that is not overridden by persistence generator */
    
}
