package view.objects;

import view.*;
import viewClient.*;

import view.visitor.*;

public class ComponentLstProxi extends ViewProxi implements ComponentLstView{
    
    public ComponentLstProxi(long objectId, long classId, ExceptionAndEventHandler connectionKey) {
        super(objectId, classId, connectionKey);
    }
    
    @SuppressWarnings("unchecked")
    public ComponentLstView getRemoteObject(java.util.HashMap<String,Object> resultTable, ExceptionAndEventHandler connectionKey) throws ModelException{
        java.util.Vector<String> parts_string = (java.util.Vector<String>)resultTable.get("parts");
        java.util.Vector<QuantifiedComponentView> parts = ViewProxi.getProxiVector(parts_string, connectionKey);
        ComponentLstView result$$ = new ComponentLst(parts, this.getId(), this.getClassId());
        ((ViewRoot)result$$).setToString((String) resultTable.get(common.RPCConstantsAndServices.RPCToStringFieldName));
        return result$$;
    }
    
    public int getRemoteDepth() {
        return RemoteDepth;
    }
    public ViewObjectInTree getChild(int originalIndex) throws ModelException{
        int index = originalIndex;
        if(index < this.getParts().size()) return new PartsComponentLstWrapper(this, originalIndex, (ViewRoot)this.getParts().get(index));
        index = index - this.getParts().size();
        return null;
    }
    public int getChildCount() throws ModelException {
        return 0 
            + (this.getParts().size());
    }
    public boolean isLeaf() throws ModelException {
        if (this.object == null) return this.getLeafInfo() == 0;
        return true 
            && (this.getParts().size() == 0);
    }
    public int getIndexOfChild(Object child) throws ModelException {
        int result = 0;
        java.util.Iterator<?> getPartsIterator = this.getParts().iterator();
        while(getPartsIterator.hasNext()){
            if(getPartsIterator.next().equals(child)) return result;
            result = result + 1;
        }
        return -1;
    }
    
    public java.util.Vector<QuantifiedComponentView> getParts()throws ModelException{
        return ((ComponentLst)this.getTheObject()).getParts();
    }
    public void setParts(java.util.Vector<QuantifiedComponentView> newValue) throws ModelException {
        ((ComponentLst)this.getTheObject()).setParts(newValue);
    }
    
    public void accept(AnythingVisitor visitor) throws ModelException {
        visitor.handleComponentLst(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleComponentLst(this);
    }
    public <E extends view.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleComponentLst(this);
    }
    public <R, E extends view.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleComponentLst(this);
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
