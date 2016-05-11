# evoline-api
Evoline Java API
http://evoline.com.br

### Version
1.0.0 [Download] (https://github.com/danielkist/evoline-api/blob/master/evoline-api/build/evoline-api-1.0.0.jar?raw=true)

### Dependencies
* Google Gson (2.6+)
* Apache HttpComponents (4+)
* Apache Commons IO (2.4+)

#Send SMS Sample
```
import br.com.evoline.api.model.ApiResponse;
import br.com.evoline.api.model.Authorization;
import br.com.evoline.api.model.SMS;
import br.com.evoline.api.service.SmsService;

public class EvolineSMSMain {
	
	public static void main(String[] args) {
		
		String SMS_TOKEN = "{YOUR_TOKEN}";
		SmsService service = new SmsService(Authorization.getInstance(SMS_TOKEN));
		
		SMS sms = new SMS();
		sms.setMensagem("Mensagem enviada pela API Java. Data: " + new SimpleDateFormat("dd/MM HH:mm").format(new Date()));
		sms.setNumeroDestino("{PHONE_NUMBER}");
		sms.setRespostaUsuario(true);
		
		ApiResponse response = service.send(sms);
		System.out.println(response.getSucesso());
	}
}
```
