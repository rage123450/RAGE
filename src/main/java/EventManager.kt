import java.util.concurrent.Callable
import java.util.concurrent.ScheduledExecutorService
import java.util.concurrent.ScheduledFuture
import java.util.concurrent.TimeUnit

object EventManager {
    private val scheduler: ScheduledExecutorService = CatchingScheduledThreadPoolExecutor(10)

    /**
     * Adds and returns an event that executes after a given delay.
     *
     * @param callable The method that should be called
     * @param delay    The delay (in ms) after which the call should start
     * @param <V>      Return type of the given callable
     * @return The created event (ScheduledFuture)
    </V> */
    fun <V> addEvent(callable: Callable<V>?, delay: Long): ScheduledFuture<V> {
        return scheduler.schedule(callable, delay, TimeUnit.MILLISECONDS)
    }

    /**
     * Adds and returns an event that executes after a given delay.
     *
     * @param callable The method that should be called
     * @param delay    The delay after which the call should start
     * @param timeUnit The time unit of the delay
     * @param <V>      The return type of the given callable
     * @return The created event (ScheduledFuture)
    </V> */
    fun <V> addEvent(callable: Callable<V>?, delay: Long, timeUnit: TimeUnit?): ScheduledFuture<V> {
        return scheduler.schedule(callable, delay, timeUnit)
    }

    /**
     * Adds and returns an event that executes after a given initial delay, and then after every delay.
     * See https://stackoverflow.com/questions/24649842/scheduleatfixedrate-vs-schedulewithfixeddelay for difference
     * between this method and addFixedDelayEvent.
     *
     * @param runnable     The method that should be run
     * @param initialDelay The time that it should take before the first execution should start
     * @param delay        The time it should (in ms) take between the start of execution n and execution n+1
     * @return The created event (ScheduledFuture)
     */
    fun addFixedRateEvent(runnable: Runnable?, initialDelay: Long, delay: Long): ScheduledFuture<*> {
        return scheduler.scheduleAtFixedRate(runnable, initialDelay, delay, TimeUnit.MILLISECONDS)
    }

    /**
     * Adds and returns an event that executes after a given initial delay, and then after every delay.
     * See https://stackoverflow.com/questions/24649842/scheduleatfixedrate-vs-schedulewithfixeddelay for difference
     * between this method and addFixedDelayEvent.
     *
     * @param runnable     The method that should be run
     * @param initialDelay The time that it should take before the first execution should start
     * @param delay        The time it should (in ms) take between the start of execution n and execution n+1
     * @param executes     The amount of times the
     * @return The created event (ScheduledFuture)
     */
    fun addFixedRateEvent(runnable: Runnable?, initialDelay: Long, delay: Long, executes: Int): ScheduledFuture<*> {
        val sf = scheduler.scheduleAtFixedRate(runnable, initialDelay, delay, TimeUnit.MILLISECONDS)
        addEvent<Boolean>({ sf.cancel(false) }, 10 + initialDelay + delay * executes)
        return sf
    }

    /**
     * Adds and returns an event that executes after a given initial delay, and then after every delay.
     * See https://stackoverflow.com/questions/24649842/scheduleatfixedrate-vs-schedulewithfixeddelay for difference
     * between this method and addFixedDelayEvent.
     *
     * @param runnable     The method that should be run
     * @param initialDelay The time that it should take before the first execution should start
     * @param delay        The time it should take between the start of execution n and execution n+1
     * @param timeUnit     The time unit of the delays
     * @return The created event (ScheduledFuture)
     */
    fun addFixedRateEvent(
        runnable: Runnable?,
        initialDelay: Long,
        delay: Long,
        timeUnit: TimeUnit?
    ): ScheduledFuture<*> {
        return scheduler.scheduleAtFixedRate(runnable, initialDelay, delay, timeUnit)
    }

    /**
     * Adds and returns an event that executes after a given initial delay, and then after every delay after the task has finished.
     * See https://stackoverflow.com/questions/24649842/scheduleatfixedrate-vs-schedulewithfixeddelay for difference
     * between this method and addFixedDelayEvent.
     *
     * @param runnable     The method that should be run
     * @param initialDelay The time that it should take before the first execution should start
     * @param delay        The time it should (in ms) take between the start of execution n and execution n+1
     * @return The created event (ScheduledFuture)
     */
    fun addFixedDelayEvent(runnable: Runnable?, initialDelay: Long, delay: Long): ScheduledFuture<*> {
        return scheduler.scheduleWithFixedDelay(runnable, initialDelay, delay, TimeUnit.MILLISECONDS)
    }

    /**
     * Adds and returns an event that executes after a given initial delay, and then after every delay.
     * See https://stackoverflow.com/questions/24649842/scheduleatfixedrate-vs-schedulewithfixeddelay for difference
     * between this method and addFixedDelayEvent.
     *
     * @param runnable     The method that should be run
     * @param initialDelay The time that it should take before the first execution should start
     * @param delay        The time it should take between the start of execution n and execution n+1
     * @param timeUnit     The time unit of the delay
     * @return The created event (ScheduledFuture)
     */
    fun addFixedDelayEvent(
        runnable: Runnable?,
        initialDelay: Long,
        delay: Long,
        timeUnit: TimeUnit?
    ): ScheduledFuture<*> {
        return scheduler.scheduleWithFixedDelay(runnable, initialDelay, delay, timeUnit)
    }

    /**
     * Adds and returns an event that executes after a given delay.
     *
     * @param runnable The method that should be run
     * @param delay    The delay (in ms) after which the call should start
     * @return The created event (ScheduledFuture)
     */
    fun addEvent(runnable: Runnable?, delay: Long): ScheduledFuture<*> {
        return scheduler.schedule(runnable, delay, TimeUnit.MILLISECONDS)
    }

    /**
     * Adds and returns an event that executes after a given delay.
     *
     * @param runnable The method that should be run
     * @param delay    The delay after which the call should start
     * @param timeUnit The time unit of the delay
     * @return The created event (ScheduledFuture)
     */
    fun addEvent(runnable: Runnable?, delay: Long, timeUnit: TimeUnit?): ScheduledFuture<*> {
        return scheduler.schedule(runnable, delay, timeUnit)
    }
}