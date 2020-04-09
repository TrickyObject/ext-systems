package mts.greet;

import mts.net.Greetable;

public class EveningGreet extends Greetable {

    public String buildResponse(String userName) {
        return "Good evening, " + userName;
    }

}
