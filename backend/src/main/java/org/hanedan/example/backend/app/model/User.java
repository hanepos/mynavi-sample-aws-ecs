package org.hanedan.example.backend.app.model;

import lombok.Builder;
import lombok.Getter;

import java.io.Serializable;

@Builder
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @Getter
    private String userId;

    @Getter
    private String userName;


}
