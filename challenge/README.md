# ⚡ CHALLENGE-MeLi
___
Este repositorio contiene una implementación simple de un acortador de URL. Hecho en  [Java](https://github.com/topics/java) con [Spring-Boot](https://spring.io/projects/spring-boot) y [Redis](https://redis.io/) como Cache.
___
### ¿Qué hace esta API?

Bueno, esta API es un servicio para convertir una URL larga en una clave corta, que se puede usar para acceder a la URL original.

#### Solution

El servicio tomará cualquier url (larga), recíbalo a través de http (`POST /shorten?url={url}`) y generar una clave basada en la url hash.
Esa clave se almacena en Redis-Cache durante una cantidad configurable de segundos.

Después de eso, el servidor responderá con datos json, que contienen el `HASH` en la `URL_ORIGINAL` valores.
Para recuperar la URL original, el servidor recibe su solicitud (`GET /u/{HASH}`) Y responde con la `URL_ORIGINAL`.

If you want to be redirected use (`GET /r/{HASH}`) que responde con `LA URL LARGA`-Encabezado que debería redirigir automáticamente a la URL original.
___
