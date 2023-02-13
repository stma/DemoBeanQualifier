package com.example.demobeanqualyfier;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class PrintFactory {

    private final PrinterPrint printerPrint;
    private final ConsolePrint consolePrint;

    public PrintFactory(PrinterPrint pp, ConsolePrint cp) {
        this.printerPrint = pp;
        this.consolePrint = cp;
    }
    @Bean("printer")
    public Repres getPrinterRepres() {
        return this.printerPrint;
    }

    @Bean("console")
    @Primary
    public Repres getConsoleRepres() {
        return this.consolePrint;
    }

    @Bean("configured")
    public Repres getConfiguredRepres(@Value("${myprinter}") String type) {
        return switch (type) {
            case "console" -> this.consolePrint;
            case "printer" -> this.printerPrint;
            default -> this.consolePrint;
        };
    }
}
