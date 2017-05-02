package view.objects;

import view.*;
import viewClient.*;

import view.visitor.*;

public class PartsListManagerProxi extends ViewProxi implements PartsListManagerView{
    
    public PartsListManagerProxi(long objectId, long classId, ExceptionAndEventHandler connectionKey) {
        super(objectId, classId, connectionKey);
    }
    
    @SuppressWarnings("unchecked")
    public PartsListManagerView getRemoteObject(java.util.HashMap<String,Object> resultTable, ExceptionAndEventHandler connectionKey) throws ModelException{
        java.util.Vector<String> currentComponents_string = (java.util.Vector<String>)resultTable.get("currentComponents");
        java.util.Vector<ComponentView> currentComponents = ViewProxi.getProxiVector(currentComponents_string, connectionKey);
        PartsListManagerView result$$ = new PartsListManager(currentComponents, this.getId(), this.getClassId());
        ((ViewRoot)result$$).setToString((String) resultTable.get(common.RPCConstantsAndServices.RPCToStringFieldName));
        return result$$;
    }
    
    public int getRemoteDepth() {
        return RemoteDepth;
    }
    public ViewObjectInTree getChild(int originalIndex) throws ModelException{
        int index = originalIndex;
        if(index < this.getCurrentComponents().size()) return new CurrentComponentsPartsListManagerWrapper(this, originalIndex, (ViewRoot)this.getCurrentComponents().get(index));
        index = index - this.getCurrentComponents().size();
        return null;
    }
    public int getChildCount() throws ModelException {
        return 0 
            + (this.getCurrentComponents().size());
    }
    public boolean isLeaf() throws ModelException {
        if (this.object == null) return this.getLeafInfo() == 0;
        return true 
            && (this.getCurrentComponents().size() == 0);
    }
    public int getIndexOfChild(Object child) throws ModelException {
        int result = 0;
        java.util.Iterator<?> getCurrentComponentsIterator = this.getCurrentComponents().iterator();
        while(getCurrentComponentsIterator.hasNext()){
            if(getCurrentComponentsIterator.next().equals(child)) return result;
            result = result + 1;
        }
        return -1;
    }
    
    public java.util.Vector<ComponentView> getCurrentComponents()throws ModelException{
        return ((PartsListManager)this.getTheObject()).getCurrentComponents();
    }
    public void setCurrentComponents(java.util.Vector<ComponentView> newValue) throws ModelException {
        ((PartsListManager)this.getTheObject()).setCurrentComponents(newValue);
    }
    
    public void accept(AnythingVisitor visitor) throws ModelException {
        visitor.handlePartsListManager(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handlePartsListManager(this);
    }
    public <E extends view.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handlePartsListManager(this);
    }
    public <R, E extends view.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handlePartsListManager(this);
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
