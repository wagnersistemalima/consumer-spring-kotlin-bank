package com.sistemalima.bank.adapters.client.metrics

import io.micrometer.core.instrument.MeterRegistry
import io.micrometer.core.instrument.Tags
import org.springframework.stereotype.Component
import kotlin.time.Duration
import kotlin.time.toJavaDuration

@Component
class MetricsCollector(
    private val meterRegistry: MeterRegistry
) {

    /**
     *
     * Use esse método para gerar métricas do tipo contador (incrementará o valor 1 a cada chamada).
     *
     * @param metricName defina em inglês o nome da métrica que será exposta.
     * @param tags tags complementares que podem ser utilizadas para filtro das métricas expostas.
     *
     */
    fun withCountMetric(metricName: String, tags: Tags = Tags.empty()) {
        meterRegistry.counter(metricName, tags).increment()
    }

    /**
     *
     * Use esse método para gerar métricas do tipo contador (incrementará o valor 1 a cada chamada).
     *
     * @param metricName defina em inglês o nome da métrica que será exposta.
     * @param duration tempo de execução em segundos.
     * @param tags tags complementares que podem ser utilizadas para filtro das métricas expostas.
     */
    fun withTimedMetric(metricName: String, duration: Duration, tags: Tags = Tags.empty()) =
        meterRegistry.timer(metricName, tags).record(duration.toJavaDuration())
}