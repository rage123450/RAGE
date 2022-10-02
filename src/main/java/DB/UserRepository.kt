package DB

import Users
import org.jetbrains.exposed.sql.StdOutSqlLogger
import org.jetbrains.exposed.sql.addLogger
import org.jetbrains.exposed.sql.select
import org.jetbrains.exposed.sql.transactions.transaction

class UserRepository {

    fun CheckLogin(acc: String, pw: String) {
        transaction {
            addLogger(StdOutSqlLogger)
            Users
                .select { Users.name eq acc }
                .forEach {
                    if (pw.equals(it[Users.password])) {
                        return@transaction
                    }
                }
        }
    }
}