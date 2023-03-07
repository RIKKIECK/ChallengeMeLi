# ⚡⚡ CHALLENGE-MeLi ⚡⚡
___
Este repositorio contiene una implementación simple de un acortador de URL. Hecho en  [Java](https://github.com/topics/java) con [Spring-Boot](https://spring.io/projects/spring-boot) y [Redis](https://redis.io/) como Cache.
___
### ¿Qué hace esta API?

Bueno, esta API es un servicio para convertir una URL larga en una clave corta, que se puede usar para acceder a la URL original.

El servicio tomará cualquier url (larga), recíbalo a través de http (`POST /shorten?url={url}`) y generar una clave basada en la url hash.
Esa clave se almacena en Redis-Cache durante una cantidad configurable de segundos.

Después de eso, el servidor responderá con datos json, que contienen el `HASH` en la `URL_ORIGINAL` valores.
Para recuperar la URL original, el servidor recibe su solicitud (`GET /u/{HASH}`) Y responde con la `URL_ORIGINAL`.

Si quieres ser redirigido usa (`GET /r/{HASH}`) que responde con `LA URL LARGA`-Encabezado que debería redirigir automáticamente a la URL original.
___
#### Ecución de contenedores

- Ejecute el comando `docker-compose up` para contenedores de Redis.
___
### Endpoints
- Acceso con el metodo con los siguientes resultados; 

##### 1. Acorta tu URL
POST http://localhost:8081/shorten?url= "Url para realizar el hash" 
- Request: `POST http://localhost:8081/shorten?url=https://github.com/RIKKIECK/ChallengeMeLi/tree/main/challenge`
- Response: `{"Hash": "08cef150","original_url": "https://github.com/RIKKIECK/ChallengeMeLi/tree/main/challenge"}`

##### 2. Recuperar la URL original
- GET http://localhost:8080/u/ "Hash" -> devuelve la url acortada.
- Request: `GET http://localhost:8081/u/08cef150`
- Response: `{"original_url": "https://github.com/RIKKIECK/ChallengeMeLi/tree/main/challenge"}`

##### 3. Redirigir a la URL original
- GET http://localhost:8080/r/ "Hash" -> Redirecciona a la URL de destino.
- Request: `GET http://localhost:8081/r/08cef150`
- Response: `Header { Location: 'https://github.com/RIKKIECK/ChallengeMeLi/tree/main/challenge' }`
___
