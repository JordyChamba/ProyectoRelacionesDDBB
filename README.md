# Proyecto Relaciones en Base de Datos
Este proyecto es una implementación de ejemplos de cuatro tipos diferentes de relaciones en bases de datos utilizando Spring Boot y JPA (Java Persistence API).

# Descripción
En este proyecto se exploran las siguientes relaciones:

1. One-to-One
2. One-to-Many
3. Many-to-One
4. Many-to-Many
- Cada relación se implementa utilizando clases de modelo, repositorios, servicios y controladores (si es necesario). El proyecto se ha estructurado de acuerdo con las mejores prácticas de diseño de aplicaciones Spring Boot.

# Tecnologías Utilizadas
- Java
- Spring Boot
- Spring Data JPA
- Hibernate
- H2 Database (para simplificar la persistencia de datos)
- Base de Datos (MySQL)
# Estructura del Proyecto
- src/main/java/ec/edu/uce/ProyectoRelacionesDDBB: Contiene todos los paquetes y clases Java del proyecto.
1. ManytoOne: Implementación de la relación Many-to-One.
2. ManytoMany: Implementación de la relación Many-to-Many.
3. OnetoOne: Implementación de la relación One-to-One.
4. OnetoMany: Implementación de la relación One-to-Many.
   
# Detalles de Implementación
- One-to-One
1. Modelo: Las clases CourseOnetoOne y StudentOnetoOne representan las entidades de Curso y Estudiante, respectivamente.
2. Repositorio: CourseRepositoryOnetoOne y StudentRepositoryOnetoOne gestionan la persistencia de las entidades Course y Student.
3. Servicio: StudentServiceOneToOne maneja la lógica de negocio relacionada con los estudiantes.
4. Ejemplo: Muestra cómo un estudiante se asocia con un curso de forma uno a uno.
- One-to-Many
1. Modelo: Las clases StudentOnetoMany y GradeOnetoMany representan las entidades de Estudiante y Calificación, respectivamente.
2. Repositorio: StudentRepositoryOnetoMany y GradeRepositoryOnetoMany gestionan la persistencia de las entidades Student y Grade.
3. Servicio: StudentServiceOnetoMany maneja la lógica de negocio relacionada con los estudiantes.
4. Ejemplo: Muestra cómo un estudiante se asocia con varias calificaciones de forma uno a muchos.
- Many-to-One
1. Modelo: Las clases StudentManyToOne y GradeManyToOne representan las entidades de Estudiante y Calificación, respectivamente.
2. Repositorio: StudentRepositoryManyToOne y GradeRepositoryManyToOne gestionan la persistencia de las entidades Student y Grade.
3. Servicio: StudentManyToOneService maneja la lógica de negocio relacionada con los estudiantes.
4. Ejemplo: Muestra cómo varias calificaciones se asocian a un estudiante de forma muchos a uno.
- Many-to-Many
1. Modelo: Las clases StudentManyToMany y CourseManyToMany representan las entidades de Estudiante y Curso, respectivamente.
2. Repositorio: StudentManyToManyRepository y CourseManyToManyRepository gestionan la persistencia de las entidades Student y Course.
3. Servicio: StudentManyToManyService maneja la lógica de negocio relacionada con los estudiantes.
4. Ejemplo: Muestra cómo varios estudiantes se asocian con varios cursos de forma muchos a muchos.

# Ejecución del Proyecto
Para ejecutar el proyecto, sigue estos pasos:
1. Clona este repositorio en tu máquina local.
2. Abre el proyecto en tu IDE de preferencia.
3. Asegúrate de tener configuradas las dependencias de Spring Boot y Maven.
4. Ejecuta la aplicación como una aplicación Spring Boot.
# Contribución
Las contribuciones son bienvenidas. Si encuentras algún problema o tienes una idea para mejorar el proyecto, no dudes en abrir un issue o un pull request.

