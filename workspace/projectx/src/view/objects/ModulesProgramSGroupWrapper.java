package view.objects;

import view.ModelException;
import view.ModuleAtomarSGroupView;
import view.ModuleGroupSGroupView;
import view.ModuleWithUnitsSGroupView;

/* Additional import section end */

public class ModulesProgramSGroupWrapper extends AssociationInTreeWrapper {

	public ModulesProgramSGroupWrapper(ViewRoot parent, int index, ViewRoot object) {
		super(parent, index, object);
	}
    
    /*Start of protected part that is not overridden by persistence generator*/
	public javafx.scene.image.Image getImage() {
		try {
			ModuleAbstractSGroup module = (ModuleAbstractSGroup)getWrappedObject().getTheObject();
			module.accept(new view.visitor.ModuleAbstractSGroupVisitor() {
				
				@Override
				public void handleModuleWithUnitsSGroup(ModuleWithUnitsSGroupView moduleWithUnitsSGroup) throws ModelException {
					getWrappedObject().setIconInfo(13);
				}
				
				@Override
				public void handleModuleGroupSGroup(ModuleGroupSGroupView moduleGroupSGroup) throws ModelException {
					getWrappedObject().setIconInfo(12);
				}
				
				@Override
				public void handleModuleAtomarSGroup(ModuleAtomarSGroupView moduleAtomarSGroup) throws ModelException {
					getWrappedObject().setIconInfo(14);
				}
			});
		} catch (ModelException e) {
			e.printStackTrace();
		}
    	return this.getWrappedObject().getImage();
    }
	
	
	public String toString(){
    	return this.getWrappedObject().toString();
    }

    /*End of protected part that is not overridden by persistence generator*/

}
