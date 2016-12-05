package br.com.cwi.crescer.aula5.mbean;

import br.com.cwi.crescer.aula5.bean.UserBean;
import static br.com.cwi.crescer.aula5.utils.UserDetails.USER_AUTH;

import br.com.cwi.crescer.aula5.entity.User;
import br.com.cwi.crescer.aula5.infraestrutura.ServicoDeCriptografia;
import br.com.cwi.crescer.aula5.utils.FacesUtils;
import br.com.cwi.crescer.aula5.utils.UserDetails;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 * @author Carlos H. Nonnemacher
 */
@ManagedBean
@ViewScoped
public class LoginMBean implements Serializable {

    private User user;

    @EJB
    private UserBean userBean;

    @PostConstruct
    public void init() {
        this.user = new User();
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getLoggedUsername() {
        final UserDetails userDetails;
        userDetails = (UserDetails) FacesUtils.getSession().getAttribute(USER_AUTH);
        return userDetails == null ? null : userDetails.getUsername();
    }

    public String login() {
        User userFound = userBean.getDao().findByEmail(user.getDsEmail());
        String senhaCriptografada = ServicoDeCriptografia.criptografar(user.getDsSenha());
        if (userFound == null || !userFound.getDsSenha().equals(senhaCriptografada)) {
            FacesUtils.addMessage(new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    "E-mail ou senha inválidos.", ""));
            return "login";
        } else {
            FacesUtils.getSession().setAttribute(USER_AUTH, this.user);
            return "index";
        }
    }

    public String logout() {
        FacesUtils.getSession().invalidate();
        return "login";
    }
}
