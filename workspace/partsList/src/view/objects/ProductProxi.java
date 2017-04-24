package view.objects;

import view.*;
import viewClient.*;

import view.visitor.*;

public class ProductProxi extends ComponentProxi implements ProductView{
    
    public ProductProxi(long objectId, long classId, ExceptionAndEventHandler connectionKey) {
        super(objectId, classId, connectionKey);
    }
    
    public ProductView getRemoteObject(java.util.HashMap<String,Object> resultTable, ExceptionAndEventHandler connectionKey) throws ModelException{
        String name = (String)resultTable.get("name");
        common.Fraction overAllPrice = common.Fraction.parse((String)resultTable.get("overAllPrice"));
        ViewProxi components = null;
        String components$String = (String)resultTable.get("components");
        if (components$String != null) {
            common.ProxiInformation components$Info = common.RPCConstantsAndServices.createProxiInformation(components$String);
            components = view.objects.ViewProxi.createProxi(components$Info,connectionKey);
            components.setToString(components$Info.getToString());
        }
        ProductView result$$ = new Product((String)name,(common.Fraction)overAllPrice,(ComponentLstView)components, this.getId(), this.getClassId());
        ((ViewRoot)result$$).setToString((String) resultTable.get(common.RPCConstantsAndServices.RPCToStringFieldName));
        return result$$;
    }
    
    public int getRemoteDepth() {
        return RemoteDepth;
    }
    public ViewObjectInTree getChild(int originalIndex) throws ModelException{
        int index = originalIndex;
        if(index == 0 && this.getComponents() != null) return new ComponentsProductWrapper(this, originalIndex, (ViewRoot)this.getComponents());
        if(this.getComponents() != null) index = index - 1;
        return null;
    }
    public int getChildCount() throws ModelException {
        return 0 
            + (this.getComponents() == null ? 0 : 1);
    }
    public boolean isLeaf() throws ModelException {
        if (this.object == null) return this.getLeafInfo() == 0;
        return true 
            && (this.getComponents() == null ? true : false);
    }
    public int getIndexOfChild(Object child) throws ModelException {
        int result = 0;
        if(this.getComponents() != null && this.getComponents().equals(child)) return result;
        if(this.getComponents() != null) result = result + 1;
        return -1;
    }
    
    public ComponentLstView getComponents()throws ModelException{
        return ((Product)this.getTheObject()).getComponents();
    }
    public void setComponents(ComponentLstView newValue) throws ModelException {
        ((Product)this.getTheObject()).setComponents(newValue);
    }
    
    public void accept(ComponentVisitor visitor) throws ModelException {
        visitor.handleProduct(this);
    }
    public <R> R accept(ComponentReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleProduct(this);
    }
    public <E extends view.UserException>  void accept(ComponentExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleProduct(this);
    }
    public <R, E extends view.UserException> R accept(ComponentReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleProduct(this);
    }
    public void accept(AnythingVisitor visitor) throws ModelException {
        visitor.handleProduct(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleProduct(this);
    }
    public <E extends view.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleProduct(this);
    }
    public <R, E extends view.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleProduct(this);
    }
    
    public boolean hasTransientFields(){
        return true;
    }
    
    public javafx.scene.image.Image getImage(){
        return super.getImage();
    }

	/* Start of protected part that is not overridden by persistence generator */
    
    private final int RemoteDepth = 1;
    
    /* End of protected part that is not overridden by persistence generator */
    
}
