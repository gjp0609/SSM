package cn.gjp0609.entity

/**
 * Created by gjp06 on 17.5.22.
 */

class User {
    private var id: Int? = null
    private var name: String? = null
    private var password: String? = null
    private var realname: String? = null

    override fun toString(): String {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", realname='" + realname + '\'' +
                '}'
    }

    fun getId(): Int? {
        return id
    }

    fun setId(id: Int?) {
        this.id = id
    }

    fun getName(): String? {
        return name
    }

    fun setName(name: String) {
        this.name = name
    }

    fun getPassword(): String? {
        return password
    }

    fun setPassword(password: String) {
        this.password = password
    }

    fun getRealname(): String? {
        return realname
    }

    fun setRealname(realname: String) {
        this.realname = realname
    }


}
