// =================================================================================================
// Copyright (c) 2017-2020 BMW Group. All rights reserved.
// =================================================================================================
package com.example.reportingbe.core.utils;


// todo: this should be an enum
    // a class with Strings is used as JAAS expects String values
    // can be refactored to enum and PermissionType.type will be of this enum
    // but adds additional method calls to role checks
public enum PermissionEnum {
    PERMISSION_MANAGEMENT, USER_MANAGEMENT, BUG_MANAGEMENT, BUG_CLOSE, BUG_UPDATED
}

