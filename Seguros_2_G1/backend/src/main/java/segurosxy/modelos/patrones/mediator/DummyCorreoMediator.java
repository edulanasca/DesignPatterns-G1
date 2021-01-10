package segurosxy.modelos.patrones.mediator;

import segurosxy.cliente.model.Cliente;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Locale;
import java.util.Properties;

public class DummyCorreoMediator implements ICorredorMediator {

  private static final String username = "seguros@pacifico.com";
  private final Session session;
  private final Properties props = new Properties();

  public DummyCorreoMediator() {

    props.put("mail.smtp.port", "435");

    session = Session.getInstance(props, null);
    session.setDebug(false);
  }

  @Override
  public void setServidorCorreoSMTP(String servidorIP) {
    props.put("mail.smtp.host", servidorIP);
  }

  @Override
  public void enviaCorreoSMTP(Cliente cliente) {
    System.out.println("[CorreoMediator] Enviando mensaje por Correo, servidor IP: "
        + props.getProperty("mail.smtp.host") +
        "\n[CorreoMediator]                                  Cliente: " + cliente.getNombre());

    try {

      Message message = new MimeMessage(session);
      message.setFrom(new InternetAddress(username));
      message.setRecipients(Message.RecipientType.TO,
          InternetAddress.parse(cliente.getNombre().toLowerCase(Locale.ROOT) + "@gmail.com"));

      message.setSubject("Afiliacion a Seguros");

      StringBuilder content = new StringBuilder();
      content
          .append("<p>Ud ha sido afiliado a los sgtes seguros: </p>")
          .append("<table style=\"border-collapse: collapse; width: auto;\" border=\"1\">")
          .append("<tbody>");

      cliente.getSeguros().forEach(
          seguro -> content
          .append("<tr>")
          .append("<td style=\"width: 50%;\">").append(seguro.getClass().getSimpleName()).append("</td>")
          .append("</tr>")
      );

      content
          .append("</tbody>")
          .append("</table>")
          .append("<p>Gracias por confiar en nosotros.</p>");

      message.setContent(content.toString(), "text/html; charset=utf-8");

      Transport.send(message);

      System.out.println("[EmailUtil] message sent successfully");
    } catch (MessagingException e) {
      System.out.println("[CorreoMediator][Error] "+ e.toString());
    }
  }
}
