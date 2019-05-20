package utils.session;

import com.blizi.blog.entity.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class SessionUtils {
    public void updateSession(HttpServletRequest request, User user){
        HttpSession session = request.getSession();
        session.setMaxInactiveInterval(30*60);
        user.setPassword("lueluelue");
        session.setAttribute("user",user);
    }
    public void deleteSession(HttpServletRequest request){
        HttpSession session = request.getSession();
        session.invalidate();
    }
}
