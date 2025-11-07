import org.apache.camel.builder.RouteBuilder
import io.micrometer.prometheus.*
import io.micrometer.core.instrument.*

// In log để xác nhận file này đã được load
println "[METRICS-INIT] 🟢 Loading metrics-init.groovy..."
context.log.info("[METRICS-INIT] 🟢 Camel context detected: ${context.name}")

// Tạo và đăng ký bean PrometheusMeterRegistry
def registry = new PrometheusMeterRegistry(PrometheusConfig.DEFAULT)
context.registry.bind("prometheusRegistry", registry)

println "[METRICS-INIT] ✅ PrometheusMeterRegistry bean registered successfully"
context.log.info("[METRICS-INIT] ✅ Bean prometheusRegistry registered: ${registry.class.name}")
