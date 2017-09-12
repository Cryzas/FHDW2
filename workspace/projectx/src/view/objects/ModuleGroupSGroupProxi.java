package view.objects;

import view.*;
import viewClient.*;

import view.visitor.*;

public class ModuleGroupSGroupProxi extends ModuleAbstractSGroupProxi implements ModuleGroupSGroupView{
    
    public ModuleGroupSGroupProxi(long objectId, long classId, ExceptionAndEventHandler connectionKey) {
        super(objectId, classId, connectionKey);
    }
    
    @SuppressWarnings("unchecked")
    public ModuleGroupSGroupView getRemoteObject(java.util.HashMap<String,Object> resultTable, ExceptionAndEventHandler connectionKey) throws ModelException{
        String name = (String)resultTable.get("name");
        common.Fraction creditPoints = common.Fraction.parse((String)resultTable.get("creditPoints"));
        ViewProxi moduleCopy = null;
        String moduleCopy$String = (String)resultTable.get("moduleCopy");
        if (moduleCopy$String != null) {
            common.ProxiInformation moduleCopy$Info = common.RPCConstantsAndServices.createProxiInformation(moduleCopy$String);
            moduleCopy = view.objects.ViewProxi.createProxi(moduleCopy$Info,connectionKey);
            moduleCopy.setToString(moduleCopy$Info.getToString());
        }
        ViewProxi finished = null;
        String finished$String = (String)resultTable.get("finished");
        if (finished$String != null) {
            common.ProxiInformation finished$Info = common.RPCConstantsAndServices.createProxiInformation(finished$String);
            finished = view.objects.ViewProxi.createProxi(finished$Info,connectionKey);
            finished.setToString(finished$Info.getToString());
        }
        java.util.Vector<String> modules_string = (java.util.Vector<String>)resultTable.get("modules");
        java.util.Vector<ModuleAbstractSGroupView> modules = ViewProxi.getProxiVector(modules_string, connectionKey);
        ModuleGroupSGroupView result$$ = new ModuleGroupSGroup((String)name,(common.Fraction)creditPoints,(ModuleAbstractView)moduleCopy,(MyBooleanView)finished,modules, this.getId(), this.getClassId());
        ((ViewRoot)result$$).setToString((String) resultTable.get(common.RPCConstantsAndServices.RPCToStringFieldName));
        return result$$;
    }
    
    public int getRemoteDepth() {
        return RemoteDepth;
    }
    public ViewObjectInTree getChild(int originalIndex) throws ModelException{
        int index = originalIndex;
        if(index < this.getModules().size()) return new ModulesModuleGroupSGroupWrapper(this, originalIndex, (ViewRoot)this.getModules().get(index));
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
    
    public java.util.Vector<ModuleAbstractSGroupView> getModules()throws ModelException{
        return ((ModuleGroupSGroup)this.getTheObject()).getModules();
    }
    public void setModules(java.util.Vector<ModuleAbstractSGroupView> newValue) throws ModelException {
        ((ModuleGroupSGroup)this.getTheObject()).setModules(newValue);
    }
    
    public void accept(ModuleAbstractSGroupVisitor visitor) throws ModelException {
        visitor.handleModuleGroupSGroup(this);
    }
    public <R> R accept(ModuleAbstractSGroupReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleModuleGroupSGroup(this);
    }
    public <E extends view.UserException>  void accept(ModuleAbstractSGroupExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleModuleGroupSGroup(this);
    }
    public <R, E extends view.UserException> R accept(ModuleAbstractSGroupReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleModuleGroupSGroup(this);
    }
    public void accept(AnythingVisitor visitor) throws ModelException {
        visitor.handleModuleGroupSGroup(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleModuleGroupSGroup(this);
    }
    public <E extends view.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleModuleGroupSGroup(this);
    }
    public <R, E extends view.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleModuleGroupSGroup(this);
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
