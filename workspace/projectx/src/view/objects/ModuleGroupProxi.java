package view.objects;

import view.*;
import viewClient.*;

import view.visitor.*;

public class ModuleGroupProxi extends ModuleAbstractProxi implements ModuleGroupView{
    
    public ModuleGroupProxi(long objectId, long classId, ExceptionAndEventHandler connectionKey) {
        super(objectId, classId, connectionKey);
    }
    
    @SuppressWarnings("unchecked")
    public ModuleGroupView getRemoteObject(java.util.HashMap<String,Object> resultTable, ExceptionAndEventHandler connectionKey) throws ModelException{
        String name = (String)resultTable.get("name");
        common.Fraction creditPoints = common.Fraction.parse((String)resultTable.get("creditPoints"));
        ViewProxi gradeSystem = null;
        String gradeSystem$String = (String)resultTable.get("gradeSystem");
        if (gradeSystem$String != null) {
            common.ProxiInformation gradeSystem$Info = common.RPCConstantsAndServices.createProxiInformation(gradeSystem$String);
            gradeSystem = view.objects.ViewProxi.createProxi(gradeSystem$Info,connectionKey);
            gradeSystem.setToString(gradeSystem$Info.getToString());
        }
        java.util.Vector<String> modules_string = (java.util.Vector<String>)resultTable.get("modules");
        java.util.Vector<ModuleAbstractView> modules = ViewProxi.getProxiVector(modules_string, connectionKey);
        ModuleGroupView result$$ = new ModuleGroup((String)name,(common.Fraction)creditPoints,(GradeSystemView)gradeSystem,modules, this.getId(), this.getClassId());
        ((ViewRoot)result$$).setToString((String) resultTable.get(common.RPCConstantsAndServices.RPCToStringFieldName));
        return result$$;
    }
    
    public int getRemoteDepth() {
        return RemoteDepth;
    }
    public ViewObjectInTree getChild(int originalIndex) throws ModelException{
        int index = originalIndex;
        if(index < this.getModules().size()) return new ModulesModuleGroupWrapper(this, originalIndex, (ViewRoot)this.getModules().get(index));
        index = index - this.getModules().size();
        return null;
    }
    public int getChildCount() throws ModelException {
        return 0 
            + (this.getModules().size());
    }
    public boolean isLeaf() throws ModelException {
        if (this.object == null) return this.getLeafInfo() == 0;
        return true 
            && (this.getModules().size() == 0);
    }
    public int getIndexOfChild(Object child) throws ModelException {
        int result = 0;
        java.util.Iterator<?> getModulesIterator = this.getModules().iterator();
        while(getModulesIterator.hasNext()){
            if(getModulesIterator.next().equals(child)) return result;
            result = result + 1;
        }
        return -1;
    }
    
    public java.util.Vector<ModuleAbstractView> getModules()throws ModelException{
        return ((ModuleGroup)this.getTheObject()).getModules();
    }
    public void setModules(java.util.Vector<ModuleAbstractView> newValue) throws ModelException {
        ((ModuleGroup)this.getTheObject()).setModules(newValue);
    }
    
    public void accept(ModuleAbstractVisitor visitor) throws ModelException {
        visitor.handleModuleGroup(this);
    }
    public <R> R accept(ModuleAbstractReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleModuleGroup(this);
    }
    public <E extends view.UserException>  void accept(ModuleAbstractExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleModuleGroup(this);
    }
    public <R, E extends view.UserException> R accept(ModuleAbstractReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleModuleGroup(this);
    }
    public void accept(AnythingVisitor visitor) throws ModelException {
        visitor.handleModuleGroup(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleModuleGroup(this);
    }
    public <E extends view.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleModuleGroup(this);
    }
    public <R, E extends view.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleModuleGroup(this);
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
