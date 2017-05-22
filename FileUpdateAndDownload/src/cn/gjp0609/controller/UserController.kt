package cn.gjp0609.controller

import cn.gjp0609.entity.User
import org.springframework.web.bind.annotation.RequestMapping
import javax.servlet.http.HttpServletResponse
import javax.servlet.http.HttpSession

/**
 * Created by gjp06 on 17.5.22.
 */

@RequestMapping("/user")
class UserController {

    @RequestMapping("login")
    fun login(vcode: String, user: User, session: HttpSession, response: HttpServletResponse) {
        val out = response.writer
        val code = session.getAttribute("vcode")
        if (code == vcode)
            out.print("t")
        else
            out.print("f")
        if ("me" == user.getName())
        else
            out.print("username not exist")
        if ("123123" == user.getPassword()) {
            session.setAttribute("user", user)
            out.print("")
        } else
            out.print("password incorrect")
    }
}