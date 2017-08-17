package connection

import domain.User
import java.util

trait UserDAO {
  def findId(id: Long): User

  def findEmail(email: String): User

  def list: util.List[User]

  def createUser(user: User): Unit

  def updateUser(user: User): Unit

  def deleteByEmail(user: User): Unit

  def existEmail(email: String): Boolean

  def changePassword(user: User): Unit
}