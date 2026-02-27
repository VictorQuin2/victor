INTEGRANTES:

Yiceth Cañas Montoya

Victor Manuel Bracamonte



\#  Sistema de Inscripción de Eventos

\##	  Drivers Arquitectónicos

Los drivers son las fuerzas que influyeron en el diseño del sistema.

\###  Driver 1: Simplicidad

El sistema debía ser entendible, mantenible y apropiado para un entorno académico.

\###  Driver 2: Separación de responsabilidades

Era necesario dividir claramente:

* Modelo del dominio
* Persistencia
* Lógica de negocio
* Punto de entrada

\### Driver 3: Escalabilidad futura

El diseño debía permitir:

* Cambiar el tipo de persistencia
* Agregar nuevas reglas de negocio
* Convertirlo en API REST más adelante

\###  Driver 4: Testabilidad

El sistema debía permitir pruebas unitarias independientes de la capa de presentación.

\---

\##  Decisiones de Diseño

Basado en los drivers anteriores, se tomaron las siguientes decisiones:

\### Decisión 1: Arquitectura en capas

Se estructuró el proyecto en:

* \*domain\* = Entidades del negocio
* \*repository\* = Persistencia en memoria
* \*service\* = Reglas de negocio
* \*test\* = Pruebas unitarias
* \*AppMain\* = Ejecución demostrativa

Esto permite desacoplamiento y mantenibilidad.

\---

\### Decisión 2: Repository en memoria

Se implementó 'EventoRepository' usando una lista interna.

* Razón:\*

Cumple el objetivo académico sin complejidad de base de datos.

Permite reemplazarlo fácilmente por:

* Base de datos
* Archivo
* API externa

\---

\###  Decisión 3: Service como capa de negocio

Toda la lógica de inscripción y validación de cupos se ubicó en 'EventoService'.

* Razón:\*

Aplicar el principio de responsabilidad única.

Las entidades no manejan reglas externas.

\---

\###  Decisión 4: Uso de Optional

Se utilizó 'Optional' en búsquedas.

* Razón:\*

Evitar 'NullPointerException' (referencia de objeto que apunta a null)

Forzar validaciones explícitas.

\---

\### Decisión 5: Programación funcional (Streams)

Se implementaron funciones declarativas como:

* Obtener eventos disponibles
* Calcular total de cupos

* Razón:\*

Aplicar estilo funcional moderno en Java y escribir código más limpio.

\---

\##  Relación con el Código

\###  domain

Contiene:

* 'Evento'
* 'Participante'

Responsabilidad:

Representar el modelo del negocio.

\---

\### repository

Contiene:

* 'EventoRepository'

Responsabilidad:

Simular almacenamiento y recuperación de eventos.

\---

\### service

Contiene:

* 'EventoService'

Responsabilidad:

* Validar existencia de eventos
* Controlar cupos
* Ejecutar inscripciones
* Aplicar lógica funcional

Ejemplo de decisión aplicada:

* Validación antes de disminuir cupo
* Logs estructurados ([WARN], [INFO], [SUCCESS])
* Uso de Stream API

\---

\### test

Contiene:

* 'EventoTest'

Responsabilidad:

Verificar:

* Creación correcta de eventos
* Reducción de cupos
* Control de cupos negativos

Esto garantiza confiabilidad del sistema.

\---

\### AppMain

Responsabilidad:

Demostrar funcionamiento completo del sistema:

* Crear eventos
* Inscribir participantes
* Mostrar estado inicial y final
* Ejecutar funciones funcionales

\---

\# Conclusión

El diseño del sistema responde directamente a los drivers arquitectónicos:

| Driver        | Decisión                | Impacto en el Código             |

\| ------------- | ----------------------- | -------------------------------- |

| Simplicidad   | Persistencia en memoria | Código claro y fácil de entender |

| Separación    | Arquitectura en capas   | Bajo acoplamiento                |

| Escalabilidad | Repository desacoplado  | Fácil migración a BD             |

| Testabilidad  | Service independiente   | Pruebas unitarias simples        |

| Modernidad    | Streams y Optional      | Código declarativo y seguro      |




CODIGO =>


/\*\*

* Representa un evento universitario con cupo limitado.

\*

* <p>Esta clase contiene la lógica de negocio encargada de gestionar
* los cupos disponibles y la lista de participantes inscritos.</p>

\*

* <p>Garantiza la consistencia del número de cupos durante
* las operaciones de inscripción y cancelación.</p>

\*/

public class Evento {

/\*\*

* Crea una instancia del evento.

\*

* @param nombre nombre del evento
* @param cupoMaximo número máximo de participantes permitidos

\*/

public Evento(String nombre, int cupoMaximo) {}

/\*\*

* Inscribe un participante si existen cupos disponibles.

\*

* @param p participante a inscribir
* @return true si la inscripción fue exitosa, false si no hay cupo

\*/

public boolean inscribir(Participante p) {}

/\*\*

* Cancela la inscripción de un participante.

\*

* @param idParticipante identificador del participante
* @return true si la cancelación fue exitosa, false en caso contrario

\*/

public boolean cancelar(String idParticipante) {}

/\*\*

* Disminuye el cupo disponible si hay disponibilidad.

\*

* @return true si se pudo disminuir el cupo, false en caso contrario

\*/

public boolean disminuirCupo() {}

/\*\*

* Aumenta el número de cupos disponibles.

\*/

public void aumentarCupo() {}

/\*\*

* Retorna el número actual de cupos disponibles.

\*

* @return cantidad de cupos disponibles

\*/

public int getCupoDisponible() {}

/\*\*

* Retorna la lista de participantes inscritos.

\*

* @return lista de participantes

\*/

public List<Participante> getInscritos() {}

/\*\*

* Retorna el nombre del evento.

\*

* @return nombre del evento

\*/

public String getNombre() {}

}

Retorna el nombre del evento.

