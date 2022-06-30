package com.nvi.identity.service.internal;

import com.nvi.identity.resources.request.IdentityVerificationRequest;
import com.nvi.identity.resources.response.IdentityVerificationResponse;
import com.nvi.identity.service.external.TCKimlikNoDogrula;
import com.nvi.identity.service.external.TCKimlikNoDogrulaResponse;
import com.nvi.identity.service.external.client.SOAPConnector;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class VerifyServiceImpl implements VerifyService {

    private final SOAPConnector soapConnector;

    @Override
    public IdentityVerificationResponse verifyIdentity(IdentityVerificationRequest identityVerificationRequest) {
        try {
            TCKimlikNoDogrulaResponse tcKimlikNoDogrulaResponse = (TCKimlikNoDogrulaResponse) soapConnector.callWebService(identityVerificationRequest.toModel());
            return IdentityVerificationResponse.builder()
                                               .identityNumber(identityVerificationRequest.getIdentityNumber())
                                               .result(tcKimlikNoDogrulaResponse.isTCKimlikNoDogrulaResult())
                                               .build();
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
    }

}
