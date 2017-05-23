package cn.gjp0609.controller

import cn.gjp0609.entity.User
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.multipart.MultipartFile
import java.io.File
import javax.servlet.http.HttpServletResponse
import javax.servlet.http.HttpSession

/**
 * UserController
 * Created by gjp06 on 17.5.22.
 */

@Controller
@RequestMapping("/user")
class UserController {

    @RequestMapping("/login")
    fun login(name: String, password: String, vcode: String, session: HttpSession, response: HttpServletResponse) {
        val out = response.writer
        // 从session 中取出 验证码
        val code = session.getAttribute("vcode") as String
        if (vcode.equals(code, true)) {
            if ("me" != name) {
                out.print("username not exist")
            } else if ("123123" == password) {
                val user: User = User()
                user.setId(1)
                user.setName(name)
                user.setPassword(password)
                user.setRealname(name)
                session.setAttribute("user", user)
                out.print("")
            } else
                out.print("password incorrect")
        } else {
            out.print("vcode incorrect")
        }
    }

    @RequestMapping("/upload")
    fun upload(userImg: MultipartFile, session: HttpSession): String {
        // 获得文件名
        var fileName = userImg.originalFilename
        val index = fileName.lastIndexOf('.')
        val type = fileName.substring(index)
        val user = session.getAttribute("user") as User
        fileName = "" + user.getId() + type
        user.setImgPath(fileName)
        session.setAttribute("user", user)
        // 获取服务器真实路径
        val realPath = session.servletContext.getRealPath("/userImg")
        // 创建所需文件夹
        File(realPath).mkdir()
        // 拼接得到完整文件路径
        val filePath = realPath + "\\" + fileName
        // 把文件存入服务器
        userImg.transferTo(File(filePath))
        return "index"
    }
}