package domain

import java.math.BigInteger
import java.security.{MessageDigest, NoSuchAlgorithmException}

import scala.beans.BeanProperty


case class User(@BeanProperty var userId: Long, @BeanProperty var userName: String,
                @BeanProperty var userPassword: String, @BeanProperty var userEmail: String,
                @BeanProperty var userRole: String) {
  def this() = this(0, "", "", "", "")
}

object User {
  def apply(userId: Long,
            userName: String,
            userPassword: String,
            userEmail: String,
            userRole: String): User =
    new User(userId, userName,  hashPassword(userPassword), userEmail, userRole)

  private def hashPassword(userPassword: String): String = {
    try {
      val m = MessageDigest.getInstance("MD5")
      m.reset()
      m.update(userPassword.getBytes)
      val digest = m.digest
      val bigInt = new BigInteger(1, digest)
      bigInt.toString(16)
    } catch {
      case e: NoSuchAlgorithmException =>
        e.printStackTrace()
        throw e
    }
  }
}