package com.nvi.identity.resources.request;

import com.nvi.identity.service.external.TCKimlikNoDogrula;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class IdentityVerificationRequest {

    @NotNull
    private Long identityNumber;

    @NotBlank
    private String firstName;

    @NotBlank
    private String lastName;

    @NotNull
    private LocalDate birthday;

    public TCKimlikNoDogrula toModel(){
        TCKimlikNoDogrula verificationRequest = new TCKimlikNoDogrula();
        verificationRequest.setTCKimlikNo(this.getIdentityNumber());
        verificationRequest.setAd(this.getFirstName());
        verificationRequest.setSoyad(this.getLastName());
        verificationRequest.setDogumYili(this.getBirthday().getYear());
        return verificationRequest;
    }

}
