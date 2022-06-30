package com.nvi.identity.resources.response;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@Builder
public class IdentityVerificationResponse implements Serializable {

    private Long identityNumber;

    private Boolean result;

}
