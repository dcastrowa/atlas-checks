package org.openstreetmap.atlas.checks.event;

import java.util.concurrent.atomic.AtomicInteger;

import com.google.common.eventbus.Subscribe;

/**
 * Sample {@link Processor} for testing.
 *
 * @author mkalender
 */
public class TestProcessor implements Processor<TestEvent>
{
    private String lastMessage;
    private final AtomicInteger completeCount = new AtomicInteger(0);
    private final AtomicInteger processCount = new AtomicInteger(0);

    @Override
    @Subscribe
    public void process(final ShutdownEvent event)
    {
        this.completeCount.incrementAndGet();
    }

    @Override
    @Subscribe
    public void process(final TestEvent event)
    {
        this.lastMessage = event.getMessage();
        this.processCount.incrementAndGet();
    }

    int getCompleteCount()
    {
        return this.completeCount.get();
    }

    String getLastEventMessage()
    {
        return this.lastMessage;
    }

    int getProcessCount()
    {
        return this.processCount.get();
    }
}
