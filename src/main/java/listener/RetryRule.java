package listener;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

public class RetryRule implements TestRule {
    protected final Logger logger = LogManager.getLogger(RetryRule.class);
    private int retryCount;

    public RetryRule(int retryCount) {
        this.retryCount = retryCount;
    }

//    @Override
    public Statement apply(final Statement base, final Description description) {
        return new Statement() {
            @Override
            public void evaluate() throws Throwable {
                Throwable caughtThrowable = null;

                for (int i = 0; i < retryCount; i++) {
                    try {
                        base.evaluate();
                        return;
                    } catch (Throwable t) {
                        caughtThrowable = t;
                        logger.info("ТЕСТ " + description.getDisplayName() + " ЗАЕВРШИЛСЯ НЕУДАЧНО НА ПОПЫТКЕ " + (i + 1));
                    }
                }
                logger.info(description.getDisplayName() + "ПЕРЕЗАПУСК ПРЕКРАЩЕН ПОСЛЕ " + retryCount + " НЕУДАЧ");
                throw caughtThrowable;
            }
        };
    }
}
