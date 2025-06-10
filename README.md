# OpenNotify

OpenNotify is a modern, open-source notification microservice built with Java Spring Boot, Kafka, and PostgreSQL.  
It supports **Email, SMS, and Push notifications** via a single, easy-to-use REST API—perfect for rapid prototyping, production use, or as a learning tool for event-driven architecture, resilience, and secure APIs.

---

## 🚀 Features

- **Unified REST API:** Send Email, SMS, and Push notifications
- **Async Processing:** Kafka-backed, scalable event handling
- **Persistence:** Stores all notifications in PostgreSQL for history/auditing
- **Resilience:** Circuit breaker and retry logic with Resilience4j
- **Secure by Design:** JWT authentication (optional but recommended)
- **Extensible:** Easy integration with SMTP, Twilio, and Firebase Cloud Messaging (FCM)
- **Fully Dockerized:** One-command spin-up with Docker Compose
- **Swagger Docs:** Interactive API documentation out of the box

---

## 🛠️ Quick Start

### 1. **Clone the Repository**
```bash
git clone https://github.com/yourusername/open-notify.git
cd open-notify

### 2. **Configure Environment Variables**
Copy .env.sample to .env and fill in your secrets:

Database (PostgreSQL)
Mailtrap or SMTP credentials
Twilio API keys
Firebase service account path (for Push)
Alternatively, use src/main/resources/application.properties for local dev.

### 3. **Run the Stack**
docker-compose up --build
This will spin up:

PostgreSQL
Kafka + Zookeeper
OpenNotify service

### 4. **Access the API**
Notification endpoint: http://localhost:8080/api/notifications
Swagger UI: http://localhost:8080/swagger-ui.html
Health check: http://localhost:8080/api/health

## 📬 Example Notification Request

Send a `POST` request to `/api/notifications` with:

```json
{
  "recipient": "user@example.com",
  "type": "EMAIL",         // or "SMS" or "PUSH"
  "subject": "Hello from OpenNotify",
  "body": "This is a test notification.",
  "status": "PENDING",
  "scheduledTime": "2025-06-10T15:30:00"
}
```

---

## ⚙️ Configuration Reference

| Variable             | Description                        |
|----------------------|------------------------------------|
| `DB_USER`            | PostgreSQL username                |
| `DB_PASS`            | PostgreSQL password                |
| `MAIL_USER`          | SMTP/Mailtrap username             |
| `MAIL_PASS`          | SMTP/Mailtrap password             |
| `TWILIO_ACCOUNT_SID` | Twilio account SID                 |
| `TWILIO_AUTH_TOKEN`  | Twilio auth token                  |
| `TWILIO_FROM_NUMBER` | Twilio sender phone number         |
| `FIREBASE_CONFIG`    | Path to Firebase service account   |
| `JWT_SECRET`         | Secret for API authentication      |

---

## 🛡️ Security (To be implemented)

- Supports JWT authentication for API endpoints
- Rate limiting and API key security can be enabled
- Configure secrets via `.env` or environment variables (never commit real secrets)

---

## ♻️ Resilience (To be implemented)

- Resilience4j circuit breakers wrap all notification channel providers
- Automatic fallback/retry on channel/service failure
- Status updates in DB for failed/delayed notifications

---

## 📝 Contributing

We love PRs! To contribute:

1. Fork the repo  
2. Create a feature branch  
3. Commit your changes  
4. Open a pull request  

---

## 📄 License

This project is [MIT Licensed](LICENSE).

---

## 🙋 FAQ

**Q: How do I send notifications?**  
POST to `/api/notifications` with a valid payload.

**Q: Where can I find the docs?**  
Visit `/swagger-ui.html` after starting the server.

**Q: How do I add more providers?**  
Extend the service classes (e.g., add WhatsApp, Telegram, etc.)
