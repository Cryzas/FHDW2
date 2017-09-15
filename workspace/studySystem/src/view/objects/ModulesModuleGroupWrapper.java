package view.objects;

import view.ModelException;
import view.ModuleAtomarView;
import view.ModuleGroupView;
import view.ModuleWithUnitsView;
import view.visitor.ModuleAbstractReturnVisitor;
import view.visitor.ModuleAbstractVisitor;

/* Additional import section end */

public class ModulesModuleGroupWrapper extends AssociationInTreeWrapper {

	public ModulesModuleGroupWrapper(ViewRoot parent, int index, ViewRoot object) {
		super(parent, index, object);
	}
    
    /*Start of protected part that is not overridden by persistence generator*/
	public javafx.scene.image.Image getImage() {
		try {
			ModuleAbstract module = (ModuleAbstract)getWrappedObject().getTheObject();
			module.accept(new ModuleAbstractVisitor() {
				
				@Override
				public void handleModuleWithUnits(ModuleWithUnitsView moduleWithUnits) throws ModelException {
					getWrappedObject().setIconInfo(13);
				}
				
				@Override
				public void handleModuleGroup(ModuleGroupView moduleGroup) throws ModelException {
					getWrappedObject().setIconInfo(12);
				}
				
				@Override
				public void handleModuleAtomar(ModuleAtomarView moduleAtomar) throws ModelException {
					getWrappedObject().setIconInfo(14);
				}
			});
		} catch (ModelException e) {
			e.printStackTrace();
		}
    	return this.getWrappedObject().getImage();
    }
	
	
	public String toString(){
		String toBeAdded = "";
		try {
			ModuleAbstract module = (ModuleAbstract)getWrappedObject().getTheObject();
			toBeAdded = module.accept(new ModuleAbstractReturnVisitor<String>() {

				@Override
				public String handleModuleAtomar(ModuleAtomarView moduleAtomar) throws ModelException {
					return "Atomares Modul: ";
				}

				@Override
				public String handleModuleGroup(ModuleGroupView moduleGroup) throws ModelException {
					return "Modulgruppe: ";
				}

				@Override
				public String handleModuleWithUnits(ModuleWithUnitsView moduleWithUnits) throws ModelException {
					return "Modul mit Units: ";
				}
			});
		} catch (ModelException e) {
			e.printStackTrace();
		}
    	return toBeAdded + this.getWrappedObject().toString();
    }

    /*End of protected part that is not overridden by persistence generator*/

}
