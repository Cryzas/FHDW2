package view.objects;


/* Additional import section end */

public class UsersUserManagerServiceWrapper extends AssociationInTreeWrapper {

	public UsersUserManagerServiceWrapper(ViewRoot parent, int index, ViewRoot object) {
		super(parent, index, object);
	}
    public boolean isLeaf() {
		return true;
	}

    /*Start of protected part that is not overridden by persistence generator*/
	public javafx.scene.image.Image getImage() {
    	 return this.getWrappedObject().getImage();
    }
	
	
	public String toString(){
    	return this.getWrappedObject().toString();
    }

    /*End of protected part that is not overridden by persistence generator*/

}
