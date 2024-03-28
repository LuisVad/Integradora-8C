package utez.edu.mx.foodster.services.twilio;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import utez.edu.mx.foodster.utils.Response;

@Service
@Transactional
public class TwilioServices {
    @Value("${TWILIO_ACCOUNT_SID}")
    String sid;
    @Value("${TWILIO_AUTH_TOKEN}")
    String token;
    @Value("${TWILIO_NUMBER}")
    String phoneNumber;

    public Response<String> sendSMS(String number){
        Twilio.init(sid, token);
        Message.creator(
                new PhoneNumber(number),
                new PhoneNumber(phoneNumber),
                "Probando"
        ).create();
        return new Response<>(
                "Enviado",
                false,
                200,
                "OK"
        );
    }
}
