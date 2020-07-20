package mts.marriage.view;

import java.io.Serializable;

public class ParentsResponse implements Serializable {

    private boolean existing;

    public boolean isExisting() {
        return existing;
    }

    public void setExisting(boolean existing) {
        this.existing = existing;
    }

}
