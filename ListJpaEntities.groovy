#!/usr/bin/env groovy

import groovy.cli.commons.CliBuilder
import java.nio.file.Files
import java.nio.file.Paths
import java.util.regex.Pattern

@Grapes(
        @Grab(group = 'commons-cli', module = 'commons-cli', version = '1.5.0')
)

static void main(String[] args) {
    def cli = new CliBuilder()
    cli.with
            {
                h(longOpt: 'help', 'Help - Usage Information')
                s(longOpt: 'src', 'src/main/java', type: String, required: true)
            }
    def opt = cli.parse(args)
    if (!opt) return
    if (opt.h) cli.usage()
    def baseDir = opt.s;
    println "Listing entities from Java source code ${baseDir}"
    Long count = 0L;
    def javaFiles = Files.walk(Paths.get(baseDir))
            .filter { Files.isRegularFile(it) && it.toString().endsWith(".java") }
            .forEach {
                entityFile ->
                    Files.lines(entityFile).forEach { linha ->
                        def padrao = Pattern.compile("@Entity\\(name\\s*=\\s*\"(.+?)\"")
                        def matcher = padrao.matcher(linha)
                        if (matcher.find()) {
                            def tableName = matcher.group(1)
                            println("- ${tableName}")
                            count++;
                        }
                    }
            }
    println "Count ${count}"

}