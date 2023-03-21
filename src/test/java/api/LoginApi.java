package api;

import api.specs.Specs;
import io.qameta.allure.Step;

public class LoginApi {
    private Specs specs = new Specs();

    @Step("It is possible to log in and get token")
    public void logIn() {
        specs.getToken();
    }

}
