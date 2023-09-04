package ml.work.demo.core

import org.springframework.beans.factory.config.ConfigurableBeanFactory
import org.springframework.context.annotation.Scope
import org.springframework.stereotype.Component

/**
 * Counts
 */
@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
class FunCounter {
    var hits = 0
}