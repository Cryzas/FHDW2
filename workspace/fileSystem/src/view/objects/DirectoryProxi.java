package view.objects;

import view.*;
import viewClient.*;

import view.visitor.*;

public class DirectoryProxi extends ContaineeProxi implements DirectoryView{
    
    public DirectoryProxi(long objectId, long classId, ExceptionAndEventHandler connectionKey) {
        super(objectId, classId, connectionKey);
    }
    
    @SuppressWarnings("unchecked")
    public DirectoryView getRemoteObject(java.util.HashMap<String,Object> resultTable, ExceptionAndEventHandler connectionKey) throws ModelException{
        String name = (String)resultTable.get("name");
        java.util.Vector<String> contents_string = (java.util.Vector<String>)resultTable.get("contents");
        java.util.Vector<ContaineeView> contents = ViewProxi.getProxiVector(contents_string, connectionKey);
        DirectoryView result$$ = new Directory((String)name,contents, this.getId(), this.getClassId());
        ((ViewRoot)result$$).setToString((String) resultTable.get(common.RPCConstantsAndServices.RPCToStringFieldName));
        return result$$;
    }
    
    public int getRemoteDepth() {
        return RemoteDepth;
    }
    public ViewObjectInTree getChild(int originalIndex) throws ModelException{
        int index = originalIndex;
        if(index < this.getContents().size()) return new ContentsDirectoryWrapper(this, originalIndex, (ViewRoot)this.getContents().get(index));
        index = index - this.getContents().size();
        return null;
    }
    public int getChildCount() throws ModelException {
        return 0 
            + (this.getContents().size());
    }
    public boolean isLeaf() throws ModelException {
        if (this.object == null) return this.getLeafInfo() == 0;
        return true 
            && (this.getContents().size() == 0);
    }
    public int getIndexOfChild(Object child) throws ModelException {
        int result = 0;
        java.util.Iterator<?> getContentsIterator = this.getContents().iterator();
        while(getContentsIterator.hasNext()){
            if(getContentsIterator.next().equals(child)) return result;
            result = result + 1;
        }
        return -1;
    }
    
    public java.util.Vector<ContaineeView> getContents()throws ModelException{
        return ((Directory)this.getTheObject()).getContents();
    }
    public void setContents(java.util.Vector<ContaineeView> newValue) throws ModelException {
        ((Directory)this.getTheObject()).setContents(newValue);
    }
    
    public void accept(ContaineeVisitor visitor) throws ModelException {
        visitor.handleDirectory(this);
    }
    public <R> R accept(ContaineeReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleDirectory(this);
    }
    public <E extends view.UserException>  void accept(ContaineeExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleDirectory(this);
    }
    public <R, E extends view.UserException> R accept(ContaineeReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleDirectory(this);
    }
    public void accept(AnythingVisitor visitor) throws ModelException {
        visitor.handleDirectory(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleDirectory(this);
    }
    public <E extends view.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleDirectory(this);
    }
    public <R, E extends view.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleDirectory(this);
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
