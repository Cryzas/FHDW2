package view.objects;

import view.BFalseView;
import view.BTrueView;
import view.ModelException;
import view.visitor.MyBooleanReturnVisitor;

/* Additional import section end */

public class GroupsStudyGroupManagerWrapper extends AssociationInTreeWrapper {

	public GroupsStudyGroupManagerWrapper(ViewRoot parent, int index, ViewRoot object) {
		super(parent, index, object);
	}
    
    /*Start of protected part that is not overridden by persistence generator*/
	public javafx.scene.image.Image getImage() {
		this.getWrappedObject().setIconInfo(7);
    	return this.getWrappedObject().getImage();
    }
	
	
	public String toString(){
		String toBeAdded = "";
		try {
			toBeAdded = ((StudyGroup)this.getWrappedObject().getTheObject()).getFinished().accept(new MyBooleanReturnVisitor<String>() {

				@Override
				public String handleBFalse(BFalseView bFalse) throws ModelException {
					return "";
				}

				@Override
				public String handleBTrue(BTrueView bTrue) throws ModelException {
					return "[Abgeschlossen] ";
				}
			});
		} catch (ModelException e) {
			e.printStackTrace();
		}
    	return toBeAdded + this.getWrappedObject().toString();
    }

    /*End of protected part that is not overridden by persistence generator*/

}
