# Arquitectura-por-eventos

# Actividad 1. Analisis de la comunicación 
Para una tienda en línea, clasifique qué procesos deberían ser síncronos, asíncronos o híbridos: consultar 
productos, crear pedido, validar pago, enviar notificación, actualizar analítica y registrar auditoría. Justifique 
brevemente su decisión:

| **Asincronas** | **Sincronas**| **Hibridas**|
|------------|----------|---------|
|Actualizar analitica| consultar producto |Crear pedido|
|Enviar notificación| validar pago|registrar y auditoria|

# Actividad 2 — Riesgos de la configuración
 
**Configuración propuesta:** topic `orders`, 1 partición, factor de replicación 1, mensajes sin clave, retención de 24 horas.
 
| Problema | Riesgo | Mejora propuesta |
|---|---|---|
| 1 partición | No hay paralelismo; un solo consumidor procesa todo aunque haya más instancias en el grupo | Aumentar a 3-6 particiones según volumen esperado |
| Replicación = 1 | Si el broker falla, se pierde la partición completa (no hay tolerancia a fallos) | Replicación ≥ 3 en distintos brokers |
| Sin clave | No se garantiza orden entre eventos de un mismo pedido | Usar `orderId` como clave al publicar |
| Retención 24h | Eventos no recuperables para reprocesamiento o auditoría pasado ese plazo | Aumentar retención según necesidad de auditoría/recuperación |
 
**Conclusión:** esta configuración solo es aceptable para pruebas locales. Para producción afecta directamente escalabilidad, disponibilidad y consistencia del orden de eventos.

# Actividad 1. Publicaciòn y consulta de eventos.

<img width="1917" height="1016" alt="image" src="https://github.com/user-attachments/assets/a31d2a6d-db14-49d6-a17b-9faed47d31fe" />

 
