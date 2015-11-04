package Presentation.ViewStrategies;

import ECore.EJavaObject;

public abstract class ViewModelStrategy {

	/**
	 * Creates a View Model
	 * @param model The data that will populate the view model
	 */
	public abstract void createViewModel(EJavaObject model); 

}
