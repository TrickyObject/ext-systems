package mts.greet;


import mts.net.Greetable;

public class DayGreet extends Greetable {

    public String buildResponse(String userName) {
        return "Good day, " + userName;
    }

}
