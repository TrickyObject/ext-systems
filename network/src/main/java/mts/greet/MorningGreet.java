package mts.greet;

import mts.net.Greetable;

public class MorningGreet extends Greetable {

    public String buildResponse(String userName) {
        return "Good morning, " + userName;
    }


}
