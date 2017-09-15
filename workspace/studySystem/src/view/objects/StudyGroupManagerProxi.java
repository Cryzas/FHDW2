package view.objects;

import view.*;
import viewClient.*;

import view.visitor.*;

public class StudyGroupManagerProxi extends ViewProxi implements StudyGroupManagerView{
    
    public StudyGroupManagerProxi(long objectId, long classId, ExceptionAndEventHandler connectionKey) {
        super(objectId, classId, connectionKey);
    }
    
    @SuppressWarnings("unchecked")
    public StudyGroupManagerView getRemoteObject(java.util.HashMap<String,Object> resultTable, ExceptionAndEventHandler connectionKey) throws ModelException{
        java.util.Vector<String> groups_string = (java.util.Vector<String>)resultTable.get("groups");
        java.util.Vector<StudyGroupView> groups = ViewProxi.getProxiVector(groups_string, connectionKey);
        StudyGroupManagerView result$$ = new StudyGroupManager(groups, this.getId(), this.getClassId());
        ((ViewRoot)result$$).setToString((String) resultTable.get(common.RPCConstantsAndServices.RPCToStringFieldName));
        return result$$;
    }
    
    public int getRemoteDepth() {
        return RemoteDepth;
    }
    public ViewObjectInTree getChild(int originalIndex) throws ModelException{
        int index = originalIndex;
        if(index < this.getGroups().size()) return new GroupsStudyGroupManagerWrapper(this, originalIndex, (ViewRoot)this.getGroups().get(index));
        index = index - this.getGroups().size();
        return null;
    }
    public int getChildCount() throws ModelException {
        return 0 
            + (this.getGroups().size());
    }
    public boolean isLeaf() throws ModelException {
        if (this.object == null) return this.getLeafInfo() == 0;
        return true 
            && (this.getGroups().size() == 0);
    }
    public int getIndexOfChild(Object child) throws ModelException {
        int result = 0;
        java.util.Iterator<?> getGroupsIterator = this.getGroups().iterator();
        while(getGroupsIterator.hasNext()){
            if(getGroupsIterator.next().equals(child)) return result;
            result = result + 1;
        }
        return -1;
    }
    
    public java.util.Vector<StudyGroupView> getGroups()throws ModelException{
        return ((StudyGroupManager)this.getTheObject()).getGroups();
    }
    public void setGroups(java.util.Vector<StudyGroupView> newValue) throws ModelException {
        ((StudyGroupManager)this.getTheObject()).setGroups(newValue);
    }
    
    public void accept(AnythingVisitor visitor) throws ModelException {
        visitor.handleStudyGroupManager(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleStudyGroupManager(this);
    }
    public <E extends view.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleStudyGroupManager(this);
    }
    public <R, E extends view.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleStudyGroupManager(this);
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
