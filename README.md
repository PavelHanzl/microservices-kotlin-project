# Projekt: Systém pro Zpracování Objednávek s Mikroslužbami

## Přehled
Vytvořte systém pro zpracování objednávek, který se skládá ze dvou mikroslužeb a dalších podpůrných komponent:

- **Služba pro Vytváření Objednávek (Order Service)** - Vytvořena s použitím Spring Boot a Kotlinu.
- **Služba pro Zpracování Plateb (Payment Service)** - Vytvořena s použitím Micronautu a Kotlinu.
- **Kafka nebo RabbitMQ** - Pro asynchronní komunikaci mezi službami.
- **Databáze PostgreSQL** - Pro ukládání dat obou služeb.

## Funkce a Technologie

### Order Service (Spring Boot + Kotlin)
- Umožňuje vytváření a správu objednávek.
- Komunikuje s Payment Service prostřednictvím Kafka nebo RabbitMQ.
- Ukládá data do PostgreSQL databáze.

### Payment Service (Micronaut + Kotlin)
- Zpracovává platby pro objednávky.
- Přijímá a odesílá zprávy prostřednictvím Kafka nebo RabbitMQ.
- Ukládá transakční data do PostgreSQL databáze.

### Kafka/RabbitMQ
- Poskytuje asynchronní komunikaci mezi Order a Payment službami.

### PostgreSQL
- Ukládání dat pro obě služby, buď v samostatných databázích nebo v jedné databázi s oddělenými tabulkami.

### Docker
- Pro kontejnerizaci služeb a závislostí.

### API Gateway (volitelně)
- Jediný vstupní bod pro komunikaci s mikroslužbami. Realizace např. pomocí Kong.

### Autentizace a Autorizace (volitelně)
- Implementace zabezpečení pomocí OAuth2 nebo JWT.

### Konfigurační Server (volitelně)
- Pro centralizovanou správu konfigurací mikroslužeb.

### Monitoring a Logování (volitelně)
- Implementace pro sledování stavu služeb a zpracování logů (např. ELK stack).

## Dodatečné Požadavky
- **Asynchronní Komunikace:** Použití Kotlin coroutines pro asynchronní operace.
- **Testování:** Vytvoření jednotkových a integračních testů.
- **Dokumentace:** Vytvoření dokumentace API a instrukcí pro nastavení.
- **Klientská Aplikace (volitelně):** Vytvoření uživatelského rozhraní pro interakci s systémem.