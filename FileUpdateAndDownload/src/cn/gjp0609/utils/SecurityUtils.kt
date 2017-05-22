package cn.gjp0609.utils

import java.awt.Color
import java.awt.Font
import java.awt.image.BufferedImage
import java.util.*


/**
 * sec
 * Created by gjp06 on 17.5.22.
 */
object SecurityUtils {
    private val SRC = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890"
    private val FONTS = arrayOf("Chiller", "Mistral")
    private val COLORS = arrayOf<Color>(Color.decode("#66cc00"), Color.decode("#008888"), Color.decode("#880088"), Color.decode("#888800"), Color.decode("#000088"), Color.decode("#0088ff"), Color.decode("#880000"), Color.decode("#000000"))

    /**
     * 获取指定长度的随机码

     * @param length 要获得的随机码的长度
     * *
     * @return 指定长度的随机码
     */
    fun getRandomCode(length: Int): String {
        // 获取随机类对象
        val random = Random()
        val chs = CharArray(length)
        // 从随机源中随机获取字符拼装成随机码
        for (i in 0..length - 1) {
            chs[i] = SRC[random.nextInt(SRC.length)]
        }
        return String(chs)
    }

    /**
     * 获取指定字符串生成的验证码图片
     * @param vcode  验证码
     * @param height 验证码图片高度
     * @param width  验证码图片宽度
     * @return BufferedImage 类型的指定验证码图片
     */
    fun getVerifiyImg(vcode: String, height: Int, width: Int): BufferedImage {
        // 创建指定宽高的透明图片
        val img = BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB)
        val random = Random()
        // 获取对应画笔
        val g = img.graphics

        // 循环写入验证码文本
        for (i in 0..vcode.length - 1) {
            // 设置随机颜色
            g.color = COLORS[random.nextInt(COLORS.size)]
            // 设置随机字体
            g.font = Font(FONTS[random.nextInt(FONTS.size)], Font.ITALIC + Font.BOLD, height)
            // 在图片中写入文本
            g.drawString(vcode[i] + "", width / vcode.length * i, height / 4 * 3)
        }
        // 生成图片
        g.dispose()
        return img
    }
}