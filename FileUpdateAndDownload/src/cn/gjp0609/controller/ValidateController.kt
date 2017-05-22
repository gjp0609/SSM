package cn.gjp0609.controller

import cn.gjp0609.utils.SecurityUtils
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import javax.imageio.ImageIO
import javax.servlet.http.HttpServletResponse
import javax.servlet.http.HttpSession

/**
 * code
 * Created by gjp06 on 17.5.22.
 */
@Controller("validateController")
@RequestMapping("/vcode")
class ValidateController {

    @RequestMapping("/getValidateImg")
    fun getValidateImg(session: HttpSession, response: HttpServletResponse) {
        val code = SecurityUtils.getRandomCode(4)
        session.setAttribute("vcode", code)
        val img = SecurityUtils.getVerifiyImg(code, 40, 150)
        ImageIO.write(img, "png", response.outputStream)
    }
}


