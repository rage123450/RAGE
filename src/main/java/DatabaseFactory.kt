import com.zaxxer.hikari.HikariConfig
import com.zaxxer.hikari.HikariDataSource
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.transactions.transaction

object DatabaseFactory {
    fun init() {
        Database.connect(hikari())
    }

    fun createTable(){
        transaction {
            SchemaUtils.create(Users)
        }
    }

    private fun hikari(): HikariDataSource {
        val config = HikariConfig().apply {
            jdbcUrl         = "jdbc:mariadb://localhost:3307/rage"
//        driverClassName = "org.mariadb.jdbc.Driver"
            username        = "root"
            password        = ""
            maximumPoolSize = 10
//            validate()
        }
        return HikariDataSource(config)
    }
}