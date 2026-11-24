# SPLab-PopaAntonia

Proiect de laborator la Șabloane de proiectare (UVT) – aplicație Spring Boot pentru gestionarea cărților.

## Șabloane implementate
- Composite – modelul cărții (Book, Section, Paragraph, Image, Table)
- Strategy – alinierea paragrafelor (AlignLeft / AlignCenter / AlignRight)
- Proxy – încărcarea amânată a imaginilor (ImageProxy)
- Visitor – randare, statistici, generarea cuprinsului
- Dependency Injection – componente Spring (singleton / prototype)
- Chain of Responsibility – RequestLoggingFilter
- Command – operațiile CRUD pe /books (executare sync / async)
- Adapter – JpaRepositoryAdapter peste Spring Data JPA
- Observer – notificări SSE la adăugarea unei cărți

## Rulare
Rulează `MySpringApplication`, apoi deschide:
- http://localhost:8080/books – API REST
- http://localhost:8080/index.html – pagina cu notificări SSE
- http://localhost:8080/h2-console – baza de date H2