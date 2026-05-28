package CajeroAutomatico.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
    
    @Autowired
    private JavaMailSender mailSender;
    
    public void enviarCredenciales(String destino, String nombre, String numeroTarjeta, int nip){
        SimpleMailMessage mensaje = new SimpleMailMessage();
        
        mensaje.setTo(destino);
        mensaje.setSubject("Credenciales de tu cuenta bancaria");
        
        mensaje.setText(
                "Hola " + nombre + "\n\n" +
                "Tu cuenta ha sido creada correctamente.\n\n" + 
                "Número de tarjeta: " + numeroTarjeta + "\n" +
                "NIP: " + nip + "\n\n" +
                "Por tu segurar este nip es de un solo uso, deberas cambiar una vez iniciando sesión.\n\n" +
                "Gracias por utilizar cajero automatico"
        );
        mailSender.send(mensaje);
    }
}
