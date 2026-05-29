package CajeroAutomatico.Service;

import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    public void enviarCredenciales(String destino, String nombreCompleto, String numeroTarjeta, int nip, String banco) {

        try {

            String colorBanco = "#1e40af";

            switch (banco.toUpperCase()) {
                case "BBVA":
                    colorBanco = "#004481";
                    break;

                case "COPPEL":
                    colorBanco = "#ffdd00";
                    break;

                case "SANTANDER":
                    colorBanco = "#ec0000";
                    break;

                case "BANAMEX":
                    colorBanco = "#1f4fa3";
                    break;
            }

            MimeMessage mensaje = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mensaje, true);
            helper.setTo(destino);
            helper.setSubject("Credenciales de tu cuenta bancaria");

            String html = """

        <div style="
            font-family:Arial;
            background:#f1f5f9;
            padding:40px;
        ">

            <div style="
                max-width:600px;
                margin:auto;
                background:white;
                border-radius:20px;
                overflow:hidden;
                box-shadow:0px 0px 20px rgba(0,0,0,0.2);
            ">

                <div style="
                    background:%s;
                    color:white;
                    padding:30px;
                    text-align:center;
                ">

                    <h1 style="margin:0;">
                        %s
                    </h1>

                    <p style="
                        margin-top:10px;
                        font-size:18px;
                    ">
                        Cajero Automático
                    </p>

                </div>

                <div style="padding:40px;">

                    <h2 style="color:#111827;">
                        Hola %s
                    </h2>

                    <p style="
                        color:#374151;
                        font-size:16px;
                    ">

                        Tu cuenta bancaria ha sido creada correctamente.

                    </p>

                    <div style="
                        background:#111827;
                        color:white;
                        padding:25px;
                        border-radius:15px;
                        margin-top:30px;
                    ">

                        <p style="margin:0;">
                            Número de tarjeta
                        </p>

                        <h2 style="
                            letter-spacing:3px;
                            margin-top:10px;
                        ">
                            %s
                        </h2>

                        <p style="
                            margin-top:20px;
                            margin-bottom:0;
                        ">
                            NIP temporal
                        </p>

                        <h1 style="
                            color:#22c55e;
                            margin-top:10px;
                        ">
                            %s
                        </h1>

                    </div>

                    <p style="
                        margin-top:30px;
                        color:#dc2626;
                        font-weight:bold;
                    ">

                        Por seguridad este NIP es temporal.
                        Deberás cambiarlo después
                        de iniciar sesión.

                    </p>

                    <hr style="margin-top:30px;">

                    <p style="
                        color:#6b7280;
                        font-size:14px;
                        text-align:center;
                    ">

                        Gracias por utilizar nuestros servicios.

                    </p>

                </div>

            </div>

        </div>

        """.formatted(
                    colorBanco,
                    banco,
                    nombreCompleto,
                    numeroTarjeta,
                    nip
            );

            helper.setText(html, true);
            mailSender.send(mensaje);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
