package com.university.java.app.status;

import java.io.Serializable;

public enum StudentStatus implements Serializable {

    WaitingForAResponse,
    Enlisted,
    Sleep,
    GetMark;
}
