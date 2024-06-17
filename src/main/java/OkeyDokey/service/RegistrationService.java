package OkeyDokey.service;

import OkeyDokey.dto.response.MessageResponse;
import OkeyDokey.dto.request.UserRequest;

public interface RegistrationService {

    MessageResponse registration(String captchaResponse, UserRequest user);

    MessageResponse activateEmailCode(String code);
}
