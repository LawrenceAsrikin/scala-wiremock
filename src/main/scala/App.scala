import com.github.tomakehurst.wiremock.WireMockServer
import com.github.tomakehurst.wiremock.common.ConsoleNotifier
import com.github.tomakehurst.wiremock.core.WireMockConfiguration
import org.wiremock.webhooks.Webhooks

object App {

  def main(args: Array[String]): Unit = {

    val config: WireMockConfiguration = new WireMockConfiguration()
      .port(8080)
      .extensions(new Webhooks) // Enable wiremock-webhooks-extension
      .disableRequestJournal // Do not record received requests to avoid JVM heap exhaustion.
      .usingFilesUnderClasspath("./") // Set a path within the classpath as the filesystem root
      .notifier(new ConsoleNotifier(true)) // Send logs to stdout

    new WireMockServer(config).start()
  }
}
