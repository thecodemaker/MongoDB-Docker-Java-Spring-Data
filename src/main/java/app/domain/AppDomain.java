package app.domain;

import org.springframework.data.annotation.Id;

public class AppDomain {

    @Id
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
