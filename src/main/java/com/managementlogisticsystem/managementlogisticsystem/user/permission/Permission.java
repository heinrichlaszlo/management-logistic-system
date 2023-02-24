package com.managementlogisticsystem.managementlogisticsystem.user.permission;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public enum Permission {
    NONE,
    READ_ONLY,
    MODIFY,
    ADD,
    DELETE
}
