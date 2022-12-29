import java.util.concurrent.Callable
import java.util.concurrent.ScheduledFuture
import java.util.concurrent.ScheduledThreadPoolExecutor
import java.util.concurrent.TimeUnit

/**
 * @author Sjonnie
 * Created on 7/27/2018.
 *
 * Class that wraps every callable/runnable inside a try/catch block to ensure that Exceptions are caught.
 * http://code.nomad-labs.com/2011/12/09/mother-fk-the-scheduledexecutorservice/
 */
class CatchingScheduledThreadPoolExecutor(corePoolSize: Int) : ScheduledThreadPoolExecutor(corePoolSize) {
    override fun <V> schedule(callable: Callable<V>, delay: Long, timeUnit: TimeUnit): ScheduledFuture<V> {
        return super.schedule<V>(wrapCallable<V>(callable), delay, timeUnit)
    }

    override fun schedule(command: Runnable, delay: Long, unit: TimeUnit): ScheduledFuture<*> {
        return super.schedule(wrapRunnable(command), delay, unit)
    }

    override fun scheduleAtFixedRate(
        command: Runnable,
        initialDelay: Long,
        period: Long,
        unit: TimeUnit
    ): ScheduledFuture<*> {
        return super.scheduleAtFixedRate(wrapRunnable(command), initialDelay, period, unit)
    }

    override fun scheduleWithFixedDelay(
        command: Runnable,
        initialDelay: Long,
        delay: Long,
        unit: TimeUnit
    ): ScheduledFuture<*> {
        return super.scheduleWithFixedDelay(wrapRunnable(command), initialDelay, delay, unit)
    }

    private fun wrapRunnable(command: Runnable): Runnable {
        return LogOnExceptionRunnable(command)
    }

    private fun <V> wrapCallable(command: Callable<V>): Callable<V> {
        return LogOnExceptionCallable<V>(command)
    }

    private inner class LogOnExceptionRunnable(private val runnable: Runnable) : Runnable {
        override fun run() {
            try {
                runnable.run()
            } catch (e: Exception) {
//                log.error(String.format("error in executing: %s. It will no longer be run!", runnable))
                e.printStackTrace()
                throw RuntimeException(e)
            }
        }
    }

    private inner class LogOnExceptionCallable<V>(callable: Callable<V>) : Callable<V> {
        private val callable: Callable<V>

        init {
            this.callable = callable
        }

        @Throws(Exception::class)
        override fun call(): V {
            return try {
                callable.call()
            } catch (e: Exception) {
//                log.error(String.format("error in executing: %s. It will no longer be run!", callable))
                e.printStackTrace()
                throw RuntimeException(e)
            }
        }
    }
}