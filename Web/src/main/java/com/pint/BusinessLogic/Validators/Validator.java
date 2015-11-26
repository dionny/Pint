package com.pint.BusinessLogic.Validators;

/**
 * Created by Dionny on 11/26/2015.
 */
public abstract class Validator {
    public boolean Validate() {
        return validPermissions() && validObject();
    }

    protected abstract boolean validObject();
    protected abstract boolean validPermissions();
}
