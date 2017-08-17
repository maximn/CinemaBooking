package connection

import java.util

import domain.User
import org.hibernate.Session

class UserDAOImpl extends AbstractDAO with UserDAO {
  private def using[T](session: Session)(f: Session => T): T = {
    try {
      f(session)
    }
    catch {
      case ex: Exception =>
        ex.printStackTrace()
        throw ex;
    }
    finally {
      if ((session != null) && session.isOpen) session.close()
    }
  }

  private def using[T](session: Session, default: T)(f: Session => T): T = {
    try {
      using(session)(f)
    } catch {
      case ex: Exception => default
    }
  }

  private def withTx[T](f: Session => T)(session: Session): T = {
    session.beginTransaction()
    val result = f(session)
    session.getTransaction.commit()
    result
  }

  override def findId(id: Long): User =
    using(getSession, new User()) { session =>
      session.get(classOf[User], id)
    }


  override def findEmail(email: String): User =
    using(getSession, new User()) { session =>
      session
        .createQuery("FROM User E WHERE E.userEmail = :user_email")
        .setString("user_email", email)
        .uniqueResult
        .asInstanceOf[User]
    }


  override def list: util.List[User] =
    using(getSession, new util.ArrayList[User]()) { session =>
      session.createCriteria(classOf[User]).list.asInstanceOf[util.ArrayList[User]]
    }


  override def createUser(user: User): Unit =
    using(getSession) {
      withTx { session =>
        saveOrUpdateSession(user)
      }
    }


  override def updateUser(user: User): Unit =
    using(getSession) {
      withTx { session =>
        session.update(user)
      }
    }


  override def deleteByEmail(user: User): Unit =
    using(getSession) {
      withTx { session =>
        session.delete(user)
      }
    }

  override def existEmail(email: String): Boolean =
    using(getSession, false) { session =>
      val user = session.createQuery("FROM User E WHERE E.userEmail = :user_email").setString("user_email", email).uniqueResult.asInstanceOf[User]
      Option(user).isDefined
    }


  override def changePassword(user: User): Unit =
    using(getSession) {
      withTx { session =>
        session.update(user)
      }
    }
}