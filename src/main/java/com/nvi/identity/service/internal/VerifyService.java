package com.nvi.identity.service.internal;

import com.nvi.identity.resources.request.IdentityVerificationRequest;
import com.nvi.identity.resources.response.IdentityVerificationResponse;

public interface VerifyService {
    IdentityVerificationResponse verifyIdentity(IdentityVerificationRequest identityVerificationRequest);
}
