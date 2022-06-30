package com.nvi.identity.resources.controller;

import com.nvi.identity.resources.request.IdentityVerificationRequest;
import com.nvi.identity.resources.response.IdentityVerificationResponse;
import com.nvi.identity.service.internal.VerifyService;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/nvi")
public class IdentityVerificationController {

    private final VerifyService verifyService;

    @PostMapping("/verify")
    public ResponseEntity<IdentityVerificationResponse> verifyIdentity(@RequestBody @Valid IdentityVerificationRequest identityVerificationRequest) {
        return new ResponseEntity<>(verifyService.verifyIdentity(identityVerificationRequest), HttpStatus.OK);
    }

}
