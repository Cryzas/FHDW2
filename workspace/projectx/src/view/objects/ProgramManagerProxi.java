package view.objects;

import view.*;
import viewClient.*;

import view.visitor.*;

public class ProgramManagerProxi extends ViewProxi implements ProgramManagerView{
    
    public ProgramManagerProxi(long objectId, long classId, ExceptionAndEventHandler connectionKey) {
        super(objectId, classId, connectionKey);
    }
    
    @SuppressWarnings("unchecked")
    public ProgramManagerView getRemoteObject(java.util.HashMap<String,Object> resultTable, ExceptionAndEventHandler connectionKey) throws ModelException{
        java.util.Vector<String> programs_string = (java.util.Vector<String>)resultTable.get("programs");
        java.util.Vector<ProgramView> programs = ViewProxi.getProxiVector(programs_string, connectionKey);
        ProgramManagerView result$$ = new ProgramManager(programs, this.getId(), this.getClassId());
        ((ViewRoot)result$$).setToString((String) resultTable.get(common.RPCConstantsAndServices.RPCToStringFieldName));
        return result$$;
    }
    
    public int getRemoteDepth() {
        return RemoteDepth;
    }
    public ViewObjectInTree getChild(int originalIndex) throws ModelException{
        int index = originalIndex;
        if(index < this.getPrograms().size()) return new ProgramsProgramManagerWrapper(this, originalIndex, (ViewRoot)this.getPrograms().get(index));
        index = index - this.getPrograms().size();
        return null;
    }
    public int getChildCount() throws ModelException {
        return 0 
            + (this.getPrograms().size());
    }
    public boolean isLeaf() throws ModelException {
        if (this.object == null) return this.getLeafInfo() == 0;
        return true 
            && (this.getPrograms().size() == 0);
    }
    public int getIndexOfChild(Object child) throws ModelException {
        int result = 0;
        java.util.Iterator<?> getProgramsIterator = this.getPrograms().iterator();
        while(getProgramsIterator.hasNext()){
            if(getProgramsIterator.next().equals(child)) return result;
            result = result + 1;
        }
        return -1;
    }
    
    public java.util.Vector<ProgramView> getPrograms()throws ModelException{
        return ((ProgramManager)this.getTheObject()).getPrograms();
    }
    public void setPrograms(java.util.Vector<ProgramView> newValue) throws ModelException {
        ((ProgramManager)this.getTheObject()).setPrograms(newValue);
    }
    
    public void accept(AnythingVisitor visitor) throws ModelException {
        visitor.handleProgramManager(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleProgramManager(this);
    }
    public <E extends view.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleProgramManager(this);
    }
    public <R, E extends view.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleProgramManager(this);
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
