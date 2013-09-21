import com.leveldatainc.SecRole
import com.leveldatainc.SecUser
import com.leveldatainc.SecUserSecRole

class BootStrap {

   def init = { servletContext ->

      def adminRole = new SecRole(authority: 'ROLE_ADMIN').save(flush: true)
      def userRole = new SecRole(authority: 'ROLE_USER').save(flush: true)

      def testUser = new SecUser(username: 'larstest', enabled: true, password: 'test')
      testUser.save(flush: true)

      SecUserSecRole.create testUser, adminRole, true

      assert SecUser.count() == 1
      assert SecRole.count() == 2
      assert SecUserSecRole.count() == 1
   }
}