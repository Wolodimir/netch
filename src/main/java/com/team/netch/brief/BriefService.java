package com.team.netch.brief;

import com.team.netch.progress.Progress;
import com.team.netch.progress.ProgressRepo;
import com.team.netch.regLogAdminSecurity.email.EmailService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

@Service
public class BriefService {

    private final BriefRepo briefRepo;
    private final ProgressRepo progressRepo;
    private final BriefEmailService briefEmailService;

    public BriefService(BriefRepo briefRepo, ProgressRepo progressRepo, BriefEmailService briefEmailService) {
        this.briefRepo = briefRepo;
        this.progressRepo = progressRepo;
        this.briefEmailService = briefEmailService;
    }

    public String save(Brief brief) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss dd-MM-yyyy", Locale.US);
        LocalDateTime strLocalDate = LocalDateTime.now().plusHours(4);
        String localDate = strLocalDate.format(formatter);
        brief.setCreatedAt(localDate);

        Progress progress = new Progress();
        progress.setUserBrief(brief);
        progress.setBrief(true);

        briefRepo.save(brief);

        progressRepo.save(progress);


        /*
            This for future emailing every user about brief
        emailService.send(brief.getEmail(), emailBuilder(brief.getName(), brief.getId()));
        */

        briefEmailService.send("netchweb@gmail.com", "Заполнили новый бриф.");
        briefEmailService.send("netch-web@mail.ru", "Заполнили новый бриф.");

        return  progress.getId().toString();
    }

    private String emailBuilder(String name, Long briefId){
        return "<link rel=\"preconnect\" href=\"https://fonts.gstatic.com\">\n" +
                "<link href=\"https://fonts.googleapis.com/css2?family=Lexend+Zetta&family=Montserrat:wght@100&display=swap\" rel=\"stylesheet\">\n" +
                "\n" +
                "<div style=\"width: 100%;\n" +
                "min-height: 130vh;\n" +
                "background: #222F3E;\n" +
                "font-family: 'Montserrat', sans-serif;\" class=\"email-wrapper\">\n" +
                "<div style=\"display: flex;\n" +
                "justify-content: center;\n" +
                "align-items: center;\n" +
                "width: 100%;\n" +
                "height: 65px;\n" +
                "background: rgba(0, 0, 0, 0.5);\" class=\"email-header\">\n" +
                "<h1 style=\"margin: 0;\n" +
                "font-family: 'Lexend Zetta', sans-serif;\n" +
                "font-weight: 400;\n" +
                "color: white;\">NETCH</h1>\n" +
                "</div>\n" +
                "<div style=\"display: flex;\n" +
                "justify-content: flex-start;\n" +
                "align-items: center;\n" +
                "flex-direction: column;\n" +
                "width: 100%;\n" +
                "height: auto;\" class=\"email-body\">\n" +
                "<h2 style=\"margin: 0;\n" +
                "margin-top: 5rem;\n" +
                "font-weight: 500;\n" +
                "color: white;\">Благодарим вас за доверие оказанное нашей веб-студии</h2>\n" +
                "<div style=\"width: 100%;\n" +
                "min-height: 650px;\" class=\"email-logo-box\">\n" +
                "<svg style=\"display: block; margin: 0 auto\" width=\"650\" height=\"650\" viewBox=\"0 0 650 650\" fill=\"none\" xmlns=\"http://www.w3.org/2000/svg\">\n" +
                "<g style=\"mix-blend-mode:hard-light\">\n" +
                "<g style=\"mix-blend-mode:lighten\">\n" +
                "<path d=\"M449.365 150.811L335.47 535.604L112.938 374.71L449.365 150.811Z\" fill=\"#48DBFB\" fill-opacity=\"0.5\"/>\n" +
                "</g>\n" +
                "</g>\n" +
                "<path d=\"M483.522 137.202L302.122 495.788L112.134 298.287L483.522 137.202Z\" fill=\"#5F27CD\" fill-opacity=\"0.75\"/>\n" +
                "<path d=\"M504.858 127.232L277.571 459.282L115.347 238.909L504.858 127.232Z\" fill=\"#EE5253\" fill-opacity=\"0.75\"/>\n" +
                "<g style=\"mix-blend-mode:hard-light\">\n" +
                "<g style=\"mix-blend-mode:hard-light\">\n" +
                "<g style=\"mix-blend-mode:hard-light\">\n" +
                "<path d=\"M382.627 230.999H216.06V278.045H382.627V230.999Z\" fill=\"#FFFCDC\"/>\n" +
                "</g>\n" +
                "</g>\n" +
                "</g>\n" +
                "<path d=\"M265.865 247.828H268.081V262.029H265.844L254.374 250.871C254.455 251.751 254.538 252.63 254.62 253.508C254.716 254.374 254.763 255.247 254.763 256.126V262.029H252.548V247.828H254.743L266.214 259.27C266.118 258.607 266.043 257.884 265.988 257.099C265.947 256.315 265.913 255.531 265.886 254.746C265.872 253.949 265.865 253.197 265.865 252.494V247.828ZM275.552 247.828H287.475V249.938H277.769V253.691H286.347V255.801H277.769V259.919H287.475V262.029H275.552V247.828ZM298.266 262.029V249.938H292.808V247.828H306.064V249.938H300.482V262.029H298.266ZM324.931 259.919C324.548 260.23 324.028 260.568 323.371 260.933C322.715 261.298 321.962 261.609 321.114 261.866C320.266 262.11 319.363 262.231 318.405 262.231C317.242 262.231 316.155 262.062 315.143 261.724C314.145 261.373 313.268 260.879 312.516 260.243C311.763 259.608 311.175 258.844 310.752 257.952C310.327 257.045 310.115 256.038 310.115 254.929C310.115 253.887 310.334 252.927 310.771 252.048C311.209 251.169 311.811 250.405 312.578 249.756C313.357 249.107 314.247 248.606 315.245 248.255C316.244 247.89 317.298 247.707 318.405 247.707C319.336 247.707 320.225 247.822 321.073 248.052C321.921 248.281 322.687 248.579 323.371 248.944C324.069 249.309 324.623 249.688 325.034 250.08L323.721 251.926C322.981 251.331 322.161 250.838 321.258 250.446C320.355 250.053 319.336 249.857 318.2 249.857C317.475 249.857 316.764 249.979 316.066 250.222C315.368 250.452 314.739 250.79 314.178 251.237C313.631 251.67 313.193 252.197 312.865 252.819C312.536 253.442 312.372 254.144 312.372 254.929C312.372 255.781 312.544 256.532 312.886 257.181C313.228 257.816 313.686 258.357 314.26 258.803C314.849 259.236 315.512 259.561 316.25 259.777C317.003 259.994 317.776 260.101 318.57 260.101C319.391 260.101 320.122 260 320.766 259.798C321.408 259.581 321.983 259.318 322.489 259.006C322.996 258.695 323.454 258.391 323.864 258.094L324.931 259.919ZM333.58 247.828V253.975H343.614V247.828H345.83V262.029H343.614V256.085H333.58V262.029H331.364V247.828H333.58Z\" fill=\"black\"/>\n" +
                "</svg>\n" +
                "</div>\n" +
                "<div style=\"width: 70%;\n" +
                "height: auto;\n" +
                "padding: 2rem;\n" +
                "margin-top: 5rem;\n" +
                "border-radius: 1rem;\n" +
                "background: rgba(0, 0, 0, 0.3);\" class=\"email-box\">\n" +
                "<blockquote style=\"text-align: center;\n" +
                "font-size: 3rem;\n" +
                "margin: 0 auto;\n" +
                "color: white;\" class=\"track\">\n" +
                "Номер вашего заказа\n" +
                "</blockquote>\n" +
                "<span style=\"display: block;\n" +
                "text-align: center;\n" +
                "margin: 0 auto;\n" +
                "margin-top: 2rem;\n" +
                "font-size: 2rem;\n" +
                "color: white;\">NETCH-23</span>\n" +
                "<a style=\"\n" +
                "display: flex;\n" +
                "justify-content: center;\n" +
                "align-items: center;\n" +
                "height: 50px;\n" +
                "padding: 0 20px;\n" +
                "margin: 0 auto;\n" +
                "margin-top: 2rem;\n" +
                "text-decoration: none;\n" +
                "background: #5f27cd;\n" +
                "border: none; outline: none; border-radius: 1rem;\n" +
                "color: white;\n" +
                "font-weight: 500;\n" +
                "font-size: 1rem;\n" +
                "font-family: inherit;\n" +
                "transition: 0.2s;\n" +
                "cursor: pointer;\" class=\"btn\" target=\"_blank\" href=\"http://netch.com.s3-website.eu-central-1.amazonaws.com/tracking\">Отслеживание</a>\n" +
                "</div>\n" +
                "</div>\n" +
                "</div>";


        /*"<div style=\"font-family:Helvetica,Arial,sans-serif;font-size:16px;margin:0;color:#0b0c0c\">\n" +
                "\n" +
                "<span style=\"display:none;font-size:1px;color:#fff;max-height:0\"></span>\n" +
                "\n" +
                "  <table role=\"presentation\" width=\"100%\" style=\"border-collapse:collapse;min-width:100%;width:100%!important\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\">\n" +
                "    <tbody><tr>\n" +
                "      <td width=\"100%\" height=\"53\" bgcolor=\"#0b0c0c\">\n" +
                "        \n" +
                "        <table role=\"presentation\" width=\"100%\" style=\"border-collapse:collapse;max-width:580px\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\" align=\"center\">\n" +
                "          <tbody><tr>\n" +
                "            <td width=\"70\" bgcolor=\"#0b0c0c\" valign=\"middle\">\n" +
                "                <table role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"border-collapse:collapse\">\n" +
                "                  <tbody><tr>\n" +
                "                    <td style=\"padding-left:10px\">\n" +
                "                  \n" +
                "                    </td>\n" +
                "                    <td style=\"font-size:28px;line-height:1.315789474;Margin-top:4px;padding-left:10px\">\n" +
                "                      <span style=\"font-family:Helvetica,Arial,sans-serif;font-weight:700;color:#ffffff;text-decoration:none;vertical-align:top;display:inline-block\">Netch company</span>\n" +
                "                    </td>\n" +
                "                  </tr>\n" +
                "                </tbody></table>\n" +
                "              </a>\n" +
                "            </td>\n" +
                "          </tr>\n" +
                "        </tbody></table>\n" +
                "        \n" +
                "      </td>\n" +
                "    </tr>\n" +
                "  </tbody></table>\n" +
                "  <table role=\"presentation\" class=\"m_-6186904992287805515content\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"border-collapse:collapse;max-width:580px;width:100%!important\" width=\"100%\">\n" +
                "    <tbody><tr>\n" +
                "      <td width=\"10\" height=\"10\" valign=\"middle\"></td>\n" +
                "      <td>\n" +
                "        \n" +
                "                <table role=\"presentation\" width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"border-collapse:collapse\">\n" +
                "                  <tbody><tr>\n" +
                "                    <td bgcolor=\"#1D70B8\" width=\"100%\" height=\"10\"></td>\n" +
                "                  </tr>\n" +
                "                </tbody></table>\n" +
                "        \n" +
                "      </td>\n" +
                "      <td width=\"10\" valign=\"middle\" height=\"10\"></td>\n" +
                "    </tr>\n" +
                "  </tbody></table>\n" +
                "\n" +
                "\n" +
                "\n" +
                "  <table role=\"presentation\" class=\"m_-6186904992287805515content\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"border-collapse:collapse;max-width:580px;width:100%!important\" width=\"100%\">\n" +
                "    <tbody><tr>\n" +
                "      <td height=\"30\"><br></td>\n" +
                "    </tr>\n" +
                "    <tr>\n" +
                "      <td width=\"10\" valign=\"middle\"><br></td>\n" +
                "      <td style=\"font-family:Helvetica,Arial,sans-serif;font-size:19px;line-height:1.315789474;max-width:560px\">\n" +
                "        \n" +
                "            <p style=\"Margin:0 0 20px 0;font-size:19px;line-height:25px;color:#0b0c0c\">Здравствуйте " + name + ",</p><p style=\"Margin:0 0 20px 0;font-size:19px;line-height:25px;color:#0b0c0c\"> Спасибо, что заказали у нас сайт. Номер заказа: </p><blockquote style=\"Margin:0 0 20px 0;border-left:10px solid #b1b4b6;padding:15px 0 0.1px 15px;font-size:19px;line-height:25px\"><p style=\"Margin:0 0 20px 0;font-size:19px;line-height:25px;color:#0b0c0c\"> <h1>" + briefId + "</h1> </p></blockquote>\n Вы всегда можете отследить его у нас на сайте <p>Удачи</p>" +
                "        \n" +
                "      </td>\n" +
                "      <td width=\"10\" valign=\"middle\"><br></td>\n" +
                "    </tr>\n" +
                "    <tr>\n" +
                "      <td height=\"30\"><br></td>\n" +
                "    </tr>\n" +
                "  </tbody></table><div class=\"yj6qo\"></div><div class=\"adL\">\n" +
                "\n" +
                "</div></div>";*/
    }

    public List<Brief> getAll() {
        return briefRepo.findAll();
    }

    public List<Brief> getActive(){
        return briefRepo.findByStatusEquals(true);
    }

    public List<Brief> getNotActive(){
        return briefRepo.findByStatusEquals(false);
    }

    public void deactivate(Long id) {
        Optional<Brief> briefById = briefRepo.findById(id);
        Brief brief = briefById.get();
        brief.setStatus(false);
        briefRepo.save(brief);
    }

    public Brief getById(Long id) {
        return briefRepo.findById(id).orElseThrow(() -> new IllegalStateException("brief not found"));
    }
}
