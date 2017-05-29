package view.objects;

import view.*;
import viewClient.*;

import view.visitor.*;

public class FilledCBStateProxi extends ClipBoardStateProxi implements FilledCBStateView{
    
    public FilledCBStateProxi(long objectId, long classId, ExceptionAndEventHandler connectionKey) {
        super(objectId, classId, connectionKey);
    }
    
    public FilledCBStateView getRemoteObject(java.util.HashMap<String,Object> resultTable, ExceptionAndEventHandler connectionKey) throws ModelException{
        ViewProxi contents = null;
        String contents$String = (String)resultTable.get("contents");
        if (contents$String != null) {
            common.ProxiInformation contents$Info = common.RPCConstantsAndServices.createProxiInformation(contents$String);
            contents = view.objects.ViewProxi.createProxi(contents$Info,connectionKey);
            contents.setToString(contents$Info.getToString());
        }
        FilledCBStateView result$$ = new FilledCBState((ContaineeView)contents, this.getId(), this.getClassId());
        ((ViewRoot)result$$).setToString((String) resultTable.get(common.RPCConstantsAndServices.RPCToStringFieldName));
        return result$$;
    }
    
    public int getRemoteDepth() {
        return RemoteDepth;
    }
    public ViewObjectInTree getChild(int originalIndex) throws ModelException{
        int index = originalIndex;
        if(index == 0 && this.getContents() != null) return new ContentsFilledCBStateWrapper(this, originalIndex, (ViewRoot)this.getContents());
        if(this.getContents() != null) index = index - 1;
        return null;
    }
    public int getChildCount() throws ModelException {
        return 0 
            + (this.getContents() == null ? 0 : 1);
    }
    public boolean isLeaf() throws ModelException {
        if (this.object == null) return this.getLeafInfo() == 0;
        return true 
            && (this.getContents() == null ? true : false);
    }
    public int getIndexOfChild(Object child) throws ModelException {
        int result = 0;
        if(this.getContents() != null && this.getContents().equals(child)) return result;
        if(this.getContents() != null) result = result + 1;
        return -1;
    }
    
    public ContaineeView getContents()throws ModelException{
        return ((FilledCBState)this.getTheObject()).getContents();
    }
    public void setContents(ContaineeView newValue) throws ModelException {
        ((FilledCBState)this.getTheObject()).setContents(newValue);
    }
    
    public void accept(ClipBoardStateVisitor visitor) throws ModelException {
        visitor.handleFilledCBState(this);
    }
    public <R> R accept(ClipBoardStateReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleFilledCBState(this);
    }
    public <E extends view.UserException>  void accept(ClipBoardStateExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleFilledCBState(this);
    }
    public <R, E extends view.UserException> R accept(ClipBoardStateReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleFilledCBState(this);
    }
    public void accept(AnythingVisitor visitor) throws ModelException {
        visitor.handleFilledCBState(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleFilledCBState(this);
    }
    public <E extends view.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleFilledCBState(this);
    }
    public <R, E extends view.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleFilledCBState(this);
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
