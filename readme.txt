curl -X POST http://localhost:8081/orders \
-H "Content-Type: application/json" \
-d '{"items":[{"itemId":"123", "quantity":1}]}'

