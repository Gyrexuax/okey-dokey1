package OkeyDokey.service;

import OkeyDokey.dto.request.PasswordResetRequest;
import OkeyDokey.dto.response.MessageResponse;

public interface AuthenticationService {

    MessageResponse sendPasswordResetCode(String email);

    String getEmailByPasswordResetCode(String code);

    MessageResponse resetPassword(PasswordResetRequest request);
}
