# AI Self-Healing Selenium Framework

AI-powered Selenium automation framework with self-healing locator capability using LLM integration.  
Built using Selenium, Java, TestNG, Maven, Extent Reports, and AI-based XPath recovery architecture.

---

## Features

- Selenium WebDriver
- Java + Maven
- TestNG Framework
- Page Object Model (POM)
- Data-Driven Testing
- Config File Support
- Extent HTML Reports
- Screenshot Utility
- AI Self-Healing Locator Engine
- Dynamic XPath Recovery
- Reusable Framework Architecture

---

## AI Self-Healing Concept

If a Selenium locator fails:

1. Framework captures failed locator
2. Sends context to AI Engine
3. AI generates healed XPath
4. Framework retries execution automatically
5. Test continues without failure

This demonstrates the concept of intelligent locator recovery using AI integration.

---

## Tech Stack

- Java
- Selenium WebDriver
- TestNG
- Maven
- Apache POI
- Extent Reports
- REST API Integration
- LLM / AI Integration

---

## Project Structure

src/test/java

├── base  
├── pages  
├── tests  
├── utilities  
├── listeners  
├── testdataManagement

---

## Framework Components

### ConfigReader

Reads framework configuration dynamically.

### ExcelUtils

Supports data-driven testing from Excel.

### Extent Reports

Generates detailed HTML execution reports.

### SelfHealingDriver

Handles AI-powered locator recovery.

### AIEngine

Integrates with external AI APIs for XPath healing.

---

## AI Configuration

Update config file:

```properties
apikey=YOUR_API_KEY
apiurl=YOUR_API_URL
model=YOUR_MODEL
```
